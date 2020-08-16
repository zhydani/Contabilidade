package model;

import java.util.ArrayList;
import java.util.List;

public enum TipoPoder {
	
	EXECUTIVO(1, "Executivo"), 
	LESGISLATIVO(2, "Legislativo"),
	JUDICIARIO(3, "Judiciario");
	
	private int id;
	private String label;
	
	private TipoPoder(int id, String label) {
		this.id = id;
		this.label = label;
	}
	
	public int getId() {
		return id;
	}
	
	public String getLabel() {
		return label;
	}
	
	public static TipoPoder valueOf(Integer valor) {
		for (TipoPoder tipoEsfera : TipoPoder.values()) {
			if (valor == tipoEsfera.getId())
				return tipoEsfera;
		} 
		return null;
	}
	
}
