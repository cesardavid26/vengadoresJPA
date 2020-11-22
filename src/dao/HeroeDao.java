package dao;

import java.util.List;


import modelo.Estado;
import modelo.Genero;
import modelo.Heroe;
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
}
