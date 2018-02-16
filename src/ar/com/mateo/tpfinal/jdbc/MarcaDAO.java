package ar.com.mateo.tpfinal.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ar.com.mateo.tpfinal.model.Marca;

public class MarcaDAO implements GenericDAO<Marca, Integer> {
	

	@Override
	public List<Marca> list() throws PersistenciaException {
		List<Marca> r=new ArrayList<Marca>();
		try {
			ResultSet rs=Util.createStatement().executeQuery("SELECT * FROM Marca ORDER BY Marca");
			while(rs.next()) {
				r.add(new Marca(rs.getInt("idMarca"),rs.getString("Marca")));
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e.getMessage(),e);
		}
		return r;
	}

	@Override
	public Marca insert(Marca entidad) throws PersistenciaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Marca update(Marca entidad) throws PersistenciaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Marca entidad) throws PersistenciaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Marca load(Integer id) throws PersistenciaException {
		// TODO Auto-generated method stub
		return null;
	}

}
