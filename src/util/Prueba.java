package util;

import dao.EstadoDao;
import dao.GeneroDao;
import dao.HeroeDao;
import modelo.Estado;
import modelo.Genero;
import modelo.Heroe;

public class Prueba {

	public static void main(String[] args) {
	
		
		
		Genero g = new Genero();
		g.setDescripcion("XDD");
		g.setId("X");
		GeneroDao gdao = new GeneroDao();
		gdao.insert(g);
		
		Estado e = new Estado();
		e.setDescripcion("LOOL");
		e.setId("L");
		EstadoDao edao = new EstadoDao();
		edao.insert(e);
		
		Heroe h = new Heroe();
		h.setNombre("prueba");
		h.setHeroe("Super prueba");
		h.setEstadoBean(e);
		h.setGeneroBean(g);
		HeroeDao cdao = new HeroeDao();
		cdao.insert(h);

	}

}
