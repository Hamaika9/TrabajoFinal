package ar.com.mateo.tpfinal.model;


import java.util.List;



public class Producto {

	private int idProducto;
	private String Producto;
	private Marca Marca;
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getProducto() {
		return Producto;
	}
	public Producto() {
	}
	public Producto(int idProducto, String Producto, double precio, Categoria categoria,Marca marca) {
		super();
		this.idProducto = idProducto;
		this.Producto = Producto;
		this.precio = precio;
		this.categoria = categoria;
		this.Marca=marca;
		
	}
	public void setProducto(String Producto) {
		this.Producto = Producto;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double Precio) {
		this.precio = Precio;
	}
	
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	

	private double precio;
	private Categoria categoria;
	
	
	
	public List<Proveedor> getProveedores() {
		return proveedores;
	}
	public void setProveedores(List<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}


	private List<Proveedor> proveedores;
	
	
			
	
	
	
	public Marca getMarca() {
		return Marca;
	}
	public void setMarca(Marca marca) {
		Marca = marca;
	}
	@Override
	public String toString() {
		return String.format("Producto: %s - %s precio=%s [%s] [%s] [%s]", getIdProducto(), getProducto(), getPrecio(), getCategoria(), getProveedores(),getMarca());
	}
}

