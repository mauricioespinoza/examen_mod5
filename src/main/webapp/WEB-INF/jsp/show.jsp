<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <link rel="stylesheet" href="/static/css/styleGeneral.css">
    <title>Detalles y Ranking de show</title>
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
                <li class="nav-item mr-5">
                    <a class="nav-link" href="/shows/new">Agrega un show</a>
                </li>
                <li class="nav-item">
                    <form id="logoutForm" method="POST" action="/logout">
                        
                        <input type="submit" value="Logout" class="btn btn-link text-secondary" />
                    </form>
                </li>
            </ul>
        </div>
    </nav>
    <div class="container mt-3">
        <h1>Titulo: ${show.showTitle}</h1>
        <h2>Canal que lo emite: ${show.showNetwork}</h2>
        <h6 class="font-weight-bold text-end">Clasifica el show para que puedas ver sus clasificaciones:</h2>
        <table class="table table-dark">
            <thead>
                <tr>
                    <th scope="col">Usuario</th>
                    <th scope="col">Rating</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="row" items="${showRatings}">
                    <tr>
                        <td scope="row">${row.user.username}</td>
                        <td>${row.rating}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <c:if test="${currentUser.getId() == creatorShow.getId() }">
            <a href="/shows/${show.id}/edit" class="btn btn-info">Editar</a>
        </c:if>
        <br /> <br />
        <form:form method="POST" action="/shows/${show.id}/add" modelAttribute="addRating">
            <form:hidden path="user" value="${currentUser.getId()}"/>
            <form:hidden path="shows" value="${show.id}" />
            <div class="form-inline">
                <form:label path="rating">Indica su valor (Rating): </form:label>
                <div class="mx-1">
                    <form:input type="number" min="1" max="5" path="rating" class="form-control" style="width: 15%"/>
                    <form:errors path="rating" />
                </div>
                <div class="">
                    <input type="submit" value="Rankear!" class="btn btn-primary" style="margin: 1rem"/>
                    <a href="/shows" class="btn btn-dark">Retornar</a>
                </div>
            </div>
        </form:form>
        <div class="mt-5 pb-5">
            
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