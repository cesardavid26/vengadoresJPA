package controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EstadoDao;
import dao.GeneroDao;
import dao.HeroeDao;
import dao.PeliculaDao;
import modelo.Estado;
import modelo.Genero;
import modelo.Heroe;
import modelo.Pelicula;

/**
 * Servlet implementation class HeroeController
 */
@WebServlet("/HeroeController")
public class HeroeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	HeroeDao dao = new HeroeDao();
	GeneroDao daoG = new GeneroDao();
	EstadoDao daoE = new EstadoDao();
	PeliculaDao daoP = new PeliculaDao();
    public HeroeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");

		switch(action) {
		case "registro":
			String nombre = request.getParameter("nombre");
			String heroe = request.getParameter("heroe");
			Genero genero = daoG.find(request.getParameter("generos"));
			Estado estado = daoE.find(request.getParameter("estados"));

			Heroe h = new Heroe();
			h.setNombre(nombre);
			h.setHeroe(heroe);
			h.setGeneroBean(genero);
			h.setEstadoBean(estado);
			
			dao.insert(h);
			request.getRequestDispatcher("index.jsp").forward(request, response);

			break;
			
		case "listar":
			List <Heroe> listaHeroes = dao.list();
			request.getSession().setAttribute("listaHeroes", listaHeroes);
			
			for(int i=0; i<listaHeroes.size(); i++) {
			System.out.print(listaHeroes.get(i).getNombre());
			}
			request.getRequestDispatcher("heroeView/listHeroes.jsp").forward(request, response);
			break;
			
		case "nuevo":
			List <Estado> estados = dao.listEstados();
			List <Genero> generos = dao.listGeneros();
	        RequestDispatcher dispatcher = request.getRequestDispatcher("heroeView/formHeroe.jsp");
	        request.setAttribute("estados", estados);
	        request.setAttribute("generos", generos);
	        dispatcher.forward(request, response);
			break;
			
		case "editar":
			
			List <Estado> estadoss = dao.listEstados();
			List <Genero> geneross = dao.listGeneros();
			 System.out.print("id");
	        int id = Integer.parseInt(request.getParameter("id"));
	        Heroe her = dao.find(id);
	       
	        RequestDispatcher dispatcher1 = request.getRequestDispatcher("heroeView/formHeroe.jsp");
	        request.setAttribute("heroe",her);
	        request.setAttribute("estados", estadoss);
	        request.setAttribute("generos", geneross);
	        
	        dispatcher1.forward(request, response);
	       
			break;
		
		case "actualizar":
			Genero generro = daoG.find(request.getParameter("generos"));
			Estado estaddo = daoE.find(request.getParameter("estados"));
			Heroe eroe = dao.find(Integer.parseInt(request.getParameter("id")));
		        eroe.setNombre(request.getParameter("nombre"));
		        eroe.setHeroe(request.getParameter("heroe"));
		        eroe.setEstadoBean(estaddo);
		        eroe.setGeneroBean(generro);
		        
		        dao.update(eroe);
		        response.sendRedirect("index.jsp");
			break;
		
		case "eliminar":
			 int ide = Integer.parseInt(request.getParameter("id"));
		     Heroe hero = dao.find(ide);
		     dao.delete(hero);
		     response.sendRedirect("index.jsp");
			
			break;
			
		case "participacion":
			List <Pelicula> peliculas = dao.listPeliculas();
			int idd = Integer.parseInt(request.getParameter("id"));
	        Heroe herooe = dao.find(idd);
			RequestDispatcher dispatcher2 = request.getRequestDispatcher("heroeView/participar.jsp");
			 request.setAttribute("heroe",herooe);
			request.setAttribute("peliculas", peliculas);
			 dispatcher2.forward(request, response);
			break;
		
		case "participar":
			
	       
	        Pelicula pelicula = daoP.find(Integer.parseInt(request.getParameter("peliculas")));
	        Heroe heroee = dao.find(Integer.parseInt(request.getParameter("id")));
	        List <Pelicula> lista = heroee.getPeliculas();
	        lista.add(pelicula);
	        heroee.setPeliculas(lista);
	        List <Heroe> hp = pelicula.getHeroes();
	        hp.add(heroee);
	        pelicula.setHeroes(hp);
	        dao.update(heroee);
	        response.sendRedirect("index.jsp");
	       
	        
			break;
		
		
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
}
}
