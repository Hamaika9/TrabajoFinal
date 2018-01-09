package ar.com.mateo.tpfinal.model;

public class Proveedor {
	public Proveedor(int idProveedor, String proveedor) {
		super();
		this.idProveedor = idProveedor;
		this.proveedor = proveedor;
	}

	private int idProveedor;
	private String proveedor;

	public int getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public Proveedor() {
	}
	@Override
	public boolean equals(Object obj) {
		Proveedor o=(Proveedor)obj;
		return getIdProveedor()==o.getIdProveedor();
	}
	@Override
	public String toString() {
		return getProveedor();
		//return String.format("Proveedor: %s - %s", getIdProveedor(), getProveedor());
	}

}
