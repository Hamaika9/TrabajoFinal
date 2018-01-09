package ar.com.mateo.tpfinal.jdbc;


	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;

     

    import ar.com.mateo.tpfinal.model.Producto;
	import ar.com.mateo.tpfinal.model.Proveedor;
	import ar.com.mateo.tpfinal.model.Categoria;

	public class ProductoDAO implements GenericDAO<Producto, Integer> {

		@Override
		public List<Producto> list() throws PersistenciaException {
			List<Producto> r = new ArrayList<Producto>();
			try {
				ResultSet rs = Util.createStatement().executeQuery(
						"SELECT p.*,c.categoria,pr.proveedor FROM producto p INNER JOIN proveedor pr ON p.idProveedor=pr.idProveedor INNER JOIN categoria c ON c.idCategoria=p.idCategoria ORDER BY producto");
				while (rs.next()){
					Categoria categoria = new Categoria(rs.getInt("idCategoria"), rs.getString("categoria"));
					Proveedor proveedor = new Proveedor(rs.getInt("idProveedor"), rs.getString("proveedor"));
					r.add(new Producto(rs.getInt("idProducto"), rs.getString("producto"), rs.getDouble("precio"), categoria,
							proveedor));
				}
			} catch (ClassNotFoundException | SQLException e) {
				throw new PersistenciaException(e.getMessage(), e);
			}
			return r;
		}

		@Override
		public Producto insert(Producto entidad) throws PersistenciaException {
			try {
				PreparedStatement ps = Util.prepareStatement(
						"INSERT INTO productos (idProducto,producto,precio,idCategoria,idProveedor) VALUES (?,?,?,?,?)");
				ps.setInt(1, entidad.getIdProducto());
				ps.setString(2, entidad.getProducto());
				ps.setDouble(3, entidad.getPrecio());
				ps.setInt(4, entidad.getCategoria().getIdCategoria());
				ps.setInt(5, entidad.getProveedor().getIdProveedor());
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
						"UPDATE producto SET producto=?,precio=?,idCategoria=?,idProveedor=? WHERE idProducto=?");
				ps.setString(1, entidad.getProducto());
				ps.setDouble(2, entidad.getPrecio());
				ps.setInt(3, entidad.getCategoria().getIdCategoria());
				ps.setInt(4, entidad.getProveedor().getIdProveedor());
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
				PreparedStatement ps = Util.prepareStatement("DELETE FROM producto WHERE idProducto=?");
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
						"SELECT p.*,c.categoria,pr.proveedor FROM producto p INNER JOIN proveedor pr ON p.idProveedor=pr.idProveedor INNER JOIN categoria c ON c.idCategoria=p.idCategoria WHERE idProducto=? ORDER BY producto");
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					Categoria categoria = new Categoria(rs.getInt("idCategoria"), rs.getString("Categoria"));
					Proveedor proveedor = new Proveedor(rs.getInt("idProveedor"), rs.getString("proveedor"));
					r = new Producto(rs.getInt("idProducto"), rs.getString("producto"), rs.getDouble("precio"), categoria,
							proveedor);
				}
			} catch (ClassNotFoundException | SQLException e) {
				throw new PersistenciaException(e.getMessage(), e);
			}
			return r;
		}

}
