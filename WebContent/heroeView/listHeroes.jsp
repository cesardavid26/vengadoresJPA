<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>Vengadores</title>
</head>
<body>
<header>
 <nav class="navbar navbar-expand-md navbar-dark bg-primary">
       <a class="navbar-brand" href="../index.jsp"><img id="logo" width=60 height=60 class="ml-2" src="https://img.icons8.com/color/452/avengers.png" class="d-inline-block align-top" alt="" loading="lazy"></a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
         
          <li class="nav-item">
            <a class="nav-link" href="HeroeController?action=listar">Heroes</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Peliculas</a>
          </li>
        </ul>
    </div>
    </nav>
   </header> 
   <br>
   <div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container">
                    <h3 class="text-center">Listado de Heroes</h3>
                    <hr>
                    <div class="container text-left">

                        <a href="HeroeController?action=nuevo" class="btn btn-success">Agregar Nuevo Heroe</a>
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Nombre</th>
                                <th>Heroe</th>
                                <th>Estado</th>
                                <th>Genero</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="heroe" items="${listaHeroes}">

                                <tr>
                                    <td>
                                        <c:out value="${heroe.id}" />
                                    </td>
                                    <td>
                                        <c:out value="${heroe.nombre}" />
                                    </td>
                                    <td>
                                        <c:out value="${heroe.heroe}" />
                                    </td>
                                    <td>
                                        <c:out value="${heroe.estadoBean.getId()}" />
                                    </td>
                                    <td>
                                        <c:out value="${heroe.generoBean.getId()}" />
                                    </td>
                                    <td><a href="HeroeController?action=editar&id=${heroe.id}">Editar</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="HeroeController?action=eliminar&id=${heroe.id}">Elimnar</a></td>
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                    </div>
                    </div>
                    <!--FOOTER-->
       <footer id="footer" class="navbar navbar-dark bg-primary ">
        <div class="container">
          <div class="row pt-3 col-12">
            <div class="col-12 text-center">
              <p>© 2020 All Rihts Reserved. Desarrollado por Cesar Carvajal</p>
            </div>     
          </div>
        </div>
      </footer>
    <!--/FOOTER-->

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</body>
</html>