package ar.com.mateo.tpfinal.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ar.com.mateo.tpfinal.model.Proveedor;

public class ProveedorDAO implements GenericDAO<Proveedor, Integer> {

	public List<Proveedor> listPorProducto(int idProducto) throws PersistenciaException {
		List<Proveedor> proveedores = new ArrayList<Proveedor>();
		try {
			ResultSet rs1 = Util.createStatement().executeQuery(
					"SELECT pp.idProveedor,pr.Proveedor FROM ProductoProveedor pp  INNER JOIN Proveedor pr ON pr.idProveedor=pp.idProveedor WHERE pp.idProducto=?");
			while (rs1.next()) {

				proveedores.add(new Proveedor(rs1.getInt("idProveedor"), rs1.getString("Proveedor")));

			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e.getMessage(), e);
		}
		return proveedores;
	}

	@Override
	public List<Proveedor> list() throws PersistenciaException {
		List<Proveedor> r = new ArrayList<Proveedor>();
		try {
			ResultSet rs = Util.createStatement().executeQuery("SELECT * FROM Proveedor ORDER BY Proveedor");
			while (rs.next()) {
				r.add(new Proveedor(rs.getInt("idProveedor"), rs.getString("Proveedor")));
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e.getMessage(), e);
		}
		return r;
	}

	@Override
	public Proveedor insert(Proveedor entidad) throws PersistenciaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Proveedor update(Proveedor entidad) throws PersistenciaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Proveedor entidad) throws PersistenciaException {
		// TODO Auto-generated method stub

	}

	@Override
	public Proveedor load(Integer id) throws PersistenciaException {
		// TODO Auto-generated method stub
		return null;
	}

}
