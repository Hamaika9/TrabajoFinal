package ar.com.mateo.tpfinal.model;

public class Marca {

	private int idMarca;
	private String Marca;

	public int getIdMarca() {
		return idMarca
				;
	}

	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}

	public Marca(int idMarca, String Marca) {
		super();
		this.idMarca = idMarca;
		this.Marca = Marca;
	}

	public String getMarca() {
		return Marca;
	}

	public void setMarca(String Marca) {
		this.Marca = Marca;
	}
	public Marca() {
	}
	@Override
	public boolean equals(Object obj) {
		Marca o=(Marca)obj;
		return getIdMarca()==o.getIdMarca();
	}
	@Override
	public String toString() {
		return getMarca();
		//return String.format("Rubro: %s - %s", getIdRubro(), getRubro());
	}
}