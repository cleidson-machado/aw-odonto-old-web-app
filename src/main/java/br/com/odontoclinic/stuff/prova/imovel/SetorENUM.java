package br.com.odontoclinic.stuff.prova.imovel;

public enum SetorENUM {
	
	A			("UM", 	   "1A"),
	AA			("DOIS",   "2A"),
	AAA			("TRÊS",   "3A"),
	AAAA		("QUATRO", "4A"),
	AAAAA		("CINCO",  "5A");
	
	private String label2;
	private String value2;
	
	private SetorENUM(String label2, String value2) {
		this.label2 = label2;
		this.value2 = value2;
	}
	
	public String getLabel2() {
		return label2;
	}
	
	public String getValue2() {
		return value2;
	}

}
