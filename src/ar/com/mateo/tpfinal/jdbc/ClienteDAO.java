package ar.com.mateo.tpfinal.jdbc;

	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;

	import ar.com.mateo.tpfinal.model.Cliente;
	
	public class ClienteDAO implements GenericDAO<Cliente, Integer> {
		

		@Override
		public List<Cliente> list() throws PersistenciaException {
			List<Cliente> r=new ArrayList<Cliente>();
			try {
				ResultSet rs=Util.createStatement().executeQuery("SELECT * FROM Cliente ORDER BY Apellido;");
				while(rs.next()) {
					
					r.add(new Cliente(rs.getString("Apellido"),rs.getInt("idClientes"),rs.getString("Nombre"),rs.getString("Dni"),rs.getString("direccion"),rs.getString("Telefono")));
					
					
				}
			} catch (ClassNotFoundException | SQLException e) {
				throw new PersistenciaException(e.getMessage(),e);
			}
			return r;
		}

		@Override
		public Cliente insert(Cliente entidad) throws PersistenciaException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Cliente update(Cliente entidad) throws PersistenciaException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void delete(Cliente entidad) throws PersistenciaException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Cliente load(Integer id) throws PersistenciaException {
			// TODO Auto-generated method stub
			return null;
		}

	}
	
	
	
	
	
	

