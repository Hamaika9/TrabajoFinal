package ar.com.mateo.tpfinal.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ar.com.mateo.tpfinal.model.Producto;
import ar.com.mateo.tpfinal.model.Proveedor;
import ar.com.mateo.tpfinal.model.Categoria;
import ar.com.mateo.tpfinal.model.Marca;

public class ProductoDAO implements GenericDAO<Producto, Integer> {
	private ProveedorDAO proveedorDAO;

	public ProductoDAO() {
		proveedorDAO = new ProveedorDAO();
	}

	@Override
	public List<Producto> list() throws PersistenciaException {

		List<Producto> r = new ArrayList<Producto>();
		try {
			ResultSet rs = Util.createStatement().executeQuery(
					"SELECT p.*,c.Categoria,m.Marca FROM Producto p INNER JOIN Categoria c ON c.idCategoria=p.idCategoria  INNER JOIN Marca m ON m.idMarca=p.idMarca");
			while (rs.next()) {
				// TODO Crear logica de proveedores (resultSet, list, etc)
				Categoria Categoria = new Categoria(rs.getInt("idCategoria"), rs.getString("Categoria"));
				Marca Marca = new Marca(rs.getInt("idMarca"), rs.getString("Marca"));
				Producto p = new Producto(rs.getInt("idProducto"), rs.getString("Producto"), rs.getDouble("Precio"),
						Categoria, Marca);

				
				p.setProveedores(proveedorDAO.listPorProducto(p.getIdProducto()));
				r.add(p);
			}

			// TODO Añadir la lista de proveedores al prducto

		} catch (ClassNotFoundException |

				SQLException e) {
			throw new PersistenciaException(e.getMessage(), e);
		}
		return r;
	}

	@Override
	public Producto insert(Producto entidad) throws PersistenciaException {
		try {
			PreparedStatement ps = Util.prepareStatement(
					"INSERT INTO Producto (idProducto,Producto,Precio,idCategoria) VALUES (?,?,?,?,?)");
			ps.setInt(1, entidad.getIdProducto());
			ps.setString(2, entidad.getProducto());
			ps.setDouble(3, entidad.getPrecio());
			ps.setInt(4, entidad.getCategoria().getIdCategoria());
			ps.execute();
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e.getMessage(), e);
		}
		return entidad;
	}

	@Override
	public Producto update(Producto entidad) throws PersistenciaException {
		try {
			PreparedStatement ps = Util.prepareStatement(
					"UPDATE Producto SET Producto=?,Precio=?,idCategoria=?,idProveedor=? WHERE idProducto=?");
			ps.setString(1, entidad.getProducto());
			ps.setDouble(2, entidad.getPrecio());
			ps.setInt(3, entidad.getCategoria().getIdCategoria());
			ps.setInt(4, ((Proveedor) entidad.getProveedores()).getIdProveedor());
			ps.setInt(5, entidad.getIdProducto());
			ps.execute();
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e.getMessage(), e);
		}
		return entidad;
	}

	@Override
	public void delete(Producto entidad) throws PersistenciaException {
		try {
			PreparedStatement ps = Util.prepareStatement("DELETE FROM Producto WHERE idProducto=?");
			ps.setInt(1, entidad.getIdProducto());
			ps.execute();
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e.getMessage(), e);
		}
	}

	@Override
	public Producto load(Integer id) throws PersistenciaException {
		Producto r = null;
		try {
			PreparedStatement ps = Util.prepareStatement(
					"SELECT p.*,c.Categoria,pr.Proveedor FROM Producto p INNER JOIN Proveedor pr ON p.idProveedor=pr.idProveedor INNER JOIN Categoria c ON c.idCategoria=p.idCategoria WHERE idProducto=? ORDER BY Producto");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Categoria categoria = new Categoria(rs.getInt("idCategoria"), rs.getString("Categoria"));
				r = new Producto(rs.getInt("idProducto"), rs.getString("Producto"), rs.getDouble("Precio"), categoria, null);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e.getMessage(), e);
		}
		return r;
	}

}
