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
   <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                       
                            <form action="HeroeController?action=participar" method="post">
                       

                        <caption>
                            <h2>
                                Agregar Participación
                            </h2>
                        </caption>

                       <c:if test="${heroe != null}">
                            <input type="hidden" name="id" value="<c:out value='${heroe.id}' />" />
                       </c:if>

                        

				<fieldset class="form-group">
					<label for="peliculas">Pelicula</label> <select class="form-control"
						id="peliculas" name="peliculas">
						<c:forEach var="pelicula" items="${peliculas}">
							<option value="${pelicula.id}"><c:out
									value="${pelicula.nombre}" /></option>
						</c:forEach>
					</select>
				</fieldset>

				

				<button type="submit" class="btn btn-success">Guardar</button>
                        </form>
                    </div>
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
</body>
</html>