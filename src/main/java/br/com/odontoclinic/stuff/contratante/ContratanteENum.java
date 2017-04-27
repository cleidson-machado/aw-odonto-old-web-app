package br.com.odontoclinic.stuff.contratante;

public enum ContratanteENum {

	FISICA("PF - Pessoa Física","PF"),
	JURIDICA("PJ - Pessoa Jurídica", "PJ");
	
	private String label;
	private String value;
	
	ContratanteENum(String label, String value){
		this.label = label;
		this.value = value;
	}
	
	public String getLabel(){
		return label;
	}
	
	public String getValue() {
		return value;
	}
	
}
