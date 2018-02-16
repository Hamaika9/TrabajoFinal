package ar.com.mateo.tpfinal.model;

public class Categoria {

	private int idcategoria;
	private String categoria;

	public int getIdCategoria() {
		return idcategoria
				;
	}

	public void setIdCategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}

	public Categoria(int idcategoria, String categoria) {
		super();
		this.idcategoria = idcategoria;
		this.categoria = categoria;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Categoria() {
	}
	@Override
	public boolean equals(Object obj) {
		Categoria o=(Categoria)obj;
		return getIdCategoria()==o.getIdCategoria();
	}
	@Override
	public String toString() {
		return getCategoria();
		//return String.format("Rubro: %s - %s", getIdRubro(), getRubro());
	}

	
}

