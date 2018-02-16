package ar.com.mateo.tpfinal.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ar.com.mateo.tpfinal.model.Categoria;

public class CategoriaDAO implements GenericDAO<Categoria, Integer> {
	

	@Override
	public List<Categoria> list() throws PersistenciaException {
		List<Categoria> r=new ArrayList<Categoria>();
		try {
			ResultSet rs=Util.createStatement().executeQuery("SELECT * FROM Categoria ORDER BY Categoria");
			while(rs.next()) {
				r.add(new Categoria(rs.getInt("idCategoria"),rs.getString("Categoria")));
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e.getMessage(),e);
		}
		return r;
	}

	@Override
	public Categoria insert(Categoria entidad) throws PersistenciaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categoria update(Categoria entidad) throws PersistenciaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Categoria entidad) throws PersistenciaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Categoria load(Integer id) throws PersistenciaException {
		// TODO Auto-generated method stub
		return null;
	}

}