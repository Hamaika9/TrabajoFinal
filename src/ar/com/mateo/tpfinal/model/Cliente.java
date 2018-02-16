package ar.com.mateo.tpfinal.model;

public class Cliente {
	private String direccion;
	private int idClientes;
	
	private String Dni;
	private String Telefono;
	public Cliente(String direccion, int idClientes, String dni, String telefono, String nombre,
			String apellido) {
		super();
		this.direccion = direccion;
		this.idClientes = idClientes;
		
		Dni = dni;
		Telefono = telefono;
		Nombre = nombre;
		Apellido = apellido;
	}
	private String Nombre;
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getIdClientes() {
		return idClientes;
	}
	public void setIdClientes(int idClientes) {
		this.idClientes = idClientes;
	}
	
	public String getDni() {
		return Dni;
	}
	public void setDni(String dni) {
		Dni = dni;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String toString (){
		String mensaje= "Numero: "+Apellido+  "Direccion: "+Nombre+  "Nombre:  "+Dni+  "Apellido: "+direccion+  "DNI: "+Telefono;
		return mensaje;
	}
	private String Apellido;
}
