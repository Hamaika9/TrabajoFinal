package ar.com.mateo.tpfinal.jdbc;

import ar.com.mateo.tpfinal.model.Producto;
import ar.com.mateo.tpfinal.model.Proveedor;
import ar.com.mateo.tpfinal.model.Categoria;
import ar.com.mateo.tpfinal.model.Local;
import ar.com.mateo.tpfinal.model.Marca;
import ar.com.mateo.tpfinal.model.Cliente;

public class TestDAO {

	public static void main(String[] args) throws PersistenciaException {
		ProveedorDAO dao1 = new ProveedorDAO();
		CategoriaDAO dao2 = new CategoriaDAO();
		ProductoDAO dao3 = new ProductoDAO();
		LocalesDAO dao4 = new LocalesDAO();
		MarcaDAO dao5 = new MarcaDAO();
		ClienteDAO dao6 = new ClienteDAO();

		System.out.println("-------------------------------------");
		System.out.println("Proveedores");
		System.out.println("-------------------------------------");
		for (Proveedor t : dao1.list()) {
			System.out.println(t);
		}
		System.out.println("-------------------------------------");
		System.out.println("Categorias");
		System.out.println("-------------------------------------");
		for (Categoria t : dao2.list()) {
			System.out.println(t);
		}
		System.out.println("-------------------------------------");
		System.out.println("Locales");
		System.out.println("-------------------------------------");
		for (Local t : dao4.list()) {
			System.out.println(t);
		}
		System.out.println("-------------------------------------");
		System.out.println("Marcas");
		System.out.println("-------------------------------------");
		for (Marca t : dao5.list()) {
			System.out.println(t);
		}
		System.out.println("-------------------------------------");
		System.out.println("Clientes");
		System.out.println("-------------------------------------");
		for (Cliente t : dao6.list()) {
			System.out.println(t);
		}

		System.out.println("-------------------------------------");
		System.out.println("Productos");
		System.out.println("-------------------------------------");
		for (Producto t : dao3.list()) {
			System.out.println(t);
		}

	}
}