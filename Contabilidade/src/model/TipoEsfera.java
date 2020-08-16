package model;

import java.util.ArrayList;
import java.util.List;

public enum TipoEsfera {
	
	MUNICIPAL(1, "Municipal"), 
	ESTADUAL(2, "Estadual");
	
	private int id;
	private String label;
	
	private TipoEsfera(int id, String label) {
		this.id = id;
		this.label = label;
	}
	
	public int getId() {
		return id;
	}
	
	public String getLabel() {
		return label;
	}
	
	public static TipoEsfera valueOf(Integer valor) {
		for (TipoEsfera tipoEsfera : TipoEsfera.values()) {
			if (valor == tipoEsfera.getId())
				return tipoEsfera;
		} 
		return null;
	}
	
}
