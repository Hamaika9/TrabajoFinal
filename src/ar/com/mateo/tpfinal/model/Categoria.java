package ar.com.mateo.tpfinal.model;

public class Categoria {

	private int idCategoria;
	private String categoria;

	public int getIdCategoria() {
		return idCategoria
				;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public Categoria(int idCategoria, String categoria) {
		super();
		this.idCategoria = idCategoria;
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

