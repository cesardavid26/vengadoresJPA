package dao;

import java.util.List;


import modelo.Estado;
import modelo.Genero;
import modelo.Heroe;
import modelo.Pelicula;
import util.Conexion;

public class HeroeDao extends Conexion<Heroe> 
	implements GenericDao<Heroe>{
	public HeroeDao() {
		super(Heroe.class);
	}
	public List<Estado> listEstados() {
		List<Estado> estados = this.getEm().createQuery("SELECT e FROM Estado e").getResultList();
		return estados;
	}
	
	public List<Genero> listGeneros() {
		List<Genero> generos = this.getEm().createQuery("SELECT g FROM Genero g").getResultList();
		return generos;
	}
	public List<Pelicula> listPeliculas() {
		List<Pelicula> peliculas = this.getEm().createQuery("SELECT p FROM Pelicula p").getResultList();
		return peliculas;
	}
	public Heroe findHeroe(int id) {
		Heroe heroes = (Heroe)this.getEm().createQuery("SELECT p FROM Pelicula p where id="+id).getSingleResult();
		return heroes;
	}
}
