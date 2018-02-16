package ar.com.mateo.tpfinal.model;

public class Local {

	private int idLocal;
	private String Local;

	public int getIdLocal() {
		return idLocal
				;
	}

	public void setIdLocal(int idLocal) {
		this.idLocal = idLocal;
	}

	public Local(int idLocal, String Local) {
		super();
		this.idLocal = idLocal;
		this.Local = Local;
	}

	public String getLocal() {
		return Local;
	}

	public void setLocal(String Local) {
		this.Local = Local;
	}
	public Local() {
	}
	@Override
	public boolean equals(Object obj) {
		Local o=(Local)obj;
		return getIdLocal()==o.getIdLocal();
	}
	@Override
	public String toString() {
		return getLocal();
		//return String.format("Rubro: %s - %s", getIdRubro(), getRubro());
	}
}