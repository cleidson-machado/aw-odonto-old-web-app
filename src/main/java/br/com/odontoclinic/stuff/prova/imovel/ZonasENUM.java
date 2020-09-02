package br.com.odontoclinic.stuff.prova.imovel;

public enum ZonasENUM {
	
	NORTE		("Norte", "NZ"),
	NORDESTE	("Nordeste", "NE"),
	NOROESTE	("Noroeste", "NO"),
	SUL			("Sul", "SZ"),
	SUDESTE		("Sudeste", "SE"),
	SUDOESTE	("Sudoeste", "SO"),
	LESTE		("Leste", "LZ"),
	OESTE		("Oeste", "OZ");
	
	private String label1;
	private String value1;
	
	private ZonasENUM(String label1, String value1) {
		this.label1 = label1;
		this.value1 = value1;
	}
	
	public String getLabel1() {
		return label1;
	}
	
	public String getValue1() {
		return value1;
	}
}
