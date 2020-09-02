package br.com.odontoclinic.stuff.prova.imovel;

public enum LoteENUM {
	
	LOTE1		("1-LTE", "LT1"),
	LOTE2		("2-LTE", "LT2"),
	LOTE3		("3-LTE", "LT3"),
	LOTE4		("4-LTE", "LT4"),
	LOTE5		("5-LTE", "LT5");
	
	private String label4;
	private String value4;
	
	private LoteENUM(String label4, String value4) {
		this.label4 = label4;
		this.value4 = value4;
	}
	
	public String getLabel4() {
		return label4;
	}
	
	public String getValue4() {
		return value4;
	}

}
