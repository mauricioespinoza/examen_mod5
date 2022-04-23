package cl.desafiolatam.examen.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;

	//Encriptación de password
	@Autowired
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	//Aca se configuran las instancias de acceso a los datos, como securitización
	//Se ha dejado el manejo de API sin instancias de seguridad
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests() 
		.antMatchers("/static/**", "/css/**", "/js/**", "/registration", "/api/v1/roles").permitAll() //Se ingresa la pagina de post del REST como permitida pra todos
		.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/show/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.permitAll()
		.failureUrl("/login?error=true")
		.usernameParameter("username")
		.passwordParameter("password")
		.defaultSuccessUrl("/home")
		.and()
		.logout().permitAll()
		.logoutSuccessUrl("/login");
		
	}

	//desencriptación respecto al login
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}
}