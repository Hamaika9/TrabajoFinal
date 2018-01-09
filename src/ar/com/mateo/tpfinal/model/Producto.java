package ar.com.mateo.tpfinal.model;

public class Producto {

	private int idProducto;
	private String producto;
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getProducto() {
		return producto;
	}
	public Producto() {
	}
	public Producto(int idProducto, String producto, double precio, Categoria categoria, Proveedor proveedor) {
		super();
		this.idProducto = idProducto;
		this.producto = producto;
		this.precio = precio;
		this.categoria = categoria;
		this.proveedor = proveedor;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	private double precio;
	private Categoria categoria;
	private Proveedor proveedor;
	@Override
	public String toString() {
		return String.format("Producto: %s - %s precio=%s [%s] [%s]", getIdProducto(), getProducto(), getPrecio(), getCategoria(), getProveedor());
	}
}

