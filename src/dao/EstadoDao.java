package dao;

import modelo.Estado;
import util.Conexion;

public class EstadoDao extends Conexion<Estado>
	implements GenericDao<Estado>{
	public EstadoDao() {
		super(Estado.class);
	}
}
