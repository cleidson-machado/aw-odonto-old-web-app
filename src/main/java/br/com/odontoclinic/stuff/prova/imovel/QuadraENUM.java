package br.com.odontoclinic.stuff.prova.imovel;

public enum QuadraENUM {
	
	Q1		("1-QDRA", "QD1"),
	Q2		("2-QDRA", "QD2"),
	Q3		("3-QDRA", "QD3"),
	Q4		("4-QDRA", "QD4"),
	Q5		("5-QDRA", "QD5");
	
	private String label3;
	private String value3;
	
	private QuadraENUM(String label3, String value3) {
		this.label3 = label3;
		this.value3 = value3;
	}
	
	public String getLabel3() {
		return label3;
	}
	
	public String getValue3() {
		return value3;
	}

}
