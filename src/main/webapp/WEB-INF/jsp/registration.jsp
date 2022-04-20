<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <link rel="stylesheet" href="/static/css/styleLogin.css">
    <title>Registration</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="/">TV Shows</a>
        <button class="navbar-toggler" type="button"
                data-toggle="collapse"
                data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent"
                aria-expanded="false"
                aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/login">
                        Login
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/registration">Registration</a>
                </li>
            </ul>
        </div>
    </nav>
 <div class="container">
        
        
        <!--Este es el formato original solicitado
		<h1>Register!</h1>
		<form:form method="POST" action="/registration" modelAttribute="user">
            <div class="form-group">
                <form:label path="username">Username:</form:label>
                <form:input path="username" type="text" class="form-control" placeholder="Username" />
            </div>
            <div class="form-group">
                <form:label path="email">Email:</form:label>
                <form:input path="email" class="form-control" placeholder="Email" />
                    <small id="emailHelp" class="form-text text-muted">
                        We'll never share your email with anyone else.
                    </small>
            </div>
            <div class="form-group">
                <form:label path="password">Password:</form:label>
                <form:password path="password" class="form-control" placeholder="Password" />
            </div>
            <div class="form-group">
                <form:label path="passwordConfirmation">Password Confirmation:</form:label>
                <form:password path="passwordConfirmation" class="form-control" placeholder="Password Confirmation" />
            </div>
            <input type="submit" class="btn btn-primary" value="Register" />
        </form:form>-->
	<div class="bg order-1 order-md-2"></div>
		<div class="contents order-2 order-md-1" id="formRegistro">
			<div class="container" >
				<div class="row align-items-center justify-content-center">
					<div class="col-md-7">
						<div class="mt-3 text-center">
							<form:errors path="user.*" />
						</div>
						<div class="mb-4">
							<h3>Registro</h3>
							<p class="mb-4">Completa los datos para gestionar tu registro.</p>
						</div>
						<form:form method="POST" action="/registration" modelAttribute="user">
							<div class="form-group first">
								<form:label path="username">Username (Nombre de usuario):</form:label>
								<form:input path="username" type="text" class="form-control" placeholder="Username" />
							</div>
							<div class="form-group">
								<form:label path="email">Email (Correo electrónico):</form:label>
								<form:input path="email" class="form-control" placeholder="Email" />
								<small id="emailHelp" class="form-text text-muted">
									Nunca compartiremos tu correo electrónico con nadie más.
								</small>
							</div>
							<div class="form-group">
								<form:label path="password">Password (Clave):</form:label>
								<form:password path="password" class="form-control" placeholder="Password" />
							</div>
							<div class="form-group last mb-3">
								<form:label path="passwordConfirmation">Confirma tu clave:</form:label>
								<form:password path="passwordConfirmation" class="form-control" placeholder="Password Confirmation" />
							</div>
							<div class="d-flex mb-5 align-items-center">
								<label class="control control--checkbox mb-3 mb-sm-0"><span class="caption">Acepta nuestros <a href="#">Terminos y condiciones</a></span>
									<input type="checkbox" checked="">
									<div class="control__indicator"></div>
								</label>
							</div>
							<input type="submit" value="Registro" class="btn btn-block btn-primary">
							<span class="d-block text-center my-4">— o —</span>
							<div class="social-login">
								<a href="https://www.facebook.com" class="facebook btn d-flex justify-content-center align-items-center">
									<span class="icon-facebook mr-3"></span> Registrate con Facebook
								</a></br>
								<a href="https://www.twitter.com" class="twitter btn d-flex justify-content-center align-items-center">
									<span class="icon-twitter mr-3"></span> Registrate con Twitter
								</a></br>
								<a href="https://www.google.com" class="google btn d-flex justify-content-center align-items-center">
									<span class="icon-google mr-3"></span> Registrate con Google
								</a></br>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
  </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
            integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
            integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
            crossorigin="anonymous"></script> 
</body>
</html>