package ar.com.mateo.tpfinal.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ar.com.mateo.tpfinal.model.Local;

public class LocalesDAO implements GenericDAO<Local, Integer> {
	

	@Override
	public List<Local> list() throws PersistenciaException {
		List<Local> r=new ArrayList<Local>();
		try {
			ResultSet rs=Util.createStatement().executeQuery("SELECT * FROM Local ORDER BY Local");
			while(rs.next()) {
				r.add(new Local(rs.getInt("idLocales"),rs.getString("local")));
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e.getMessage(),e);
		}
		return r;
	}

	@Override
	public Local insert(Local entidad) throws PersistenciaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Local update(Local entidad) throws PersistenciaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Local entidad) throws PersistenciaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Local load(Integer id) throws PersistenciaException {
		// TODO Auto-generated method stub
		return null;
	}

}