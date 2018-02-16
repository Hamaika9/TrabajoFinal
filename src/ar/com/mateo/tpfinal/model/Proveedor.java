package ar.com.mateo.tpfinal.model;

public class Proveedor {
	public Proveedor(int idProveedor, String Proveedor) {
		super();
		this.idProveedor = idProveedor;
		this.Proveedor = Proveedor;
	}

	private int idProveedor;
	private String Proveedor;

	public int getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getProveedor() {
		return Proveedor;
	}

	public void setProveedores(String Proveedor) {
		this.Proveedor = Proveedor;
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
