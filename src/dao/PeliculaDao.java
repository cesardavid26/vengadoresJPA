package dao;

import modelo.Pelicula;
import util.Conexion;

public class PeliculaDao extends Conexion<Pelicula>
	implements GenericDao<Pelicula>{
	
	public PeliculaDao() {
		super(Pelicula.class);
	}

}
