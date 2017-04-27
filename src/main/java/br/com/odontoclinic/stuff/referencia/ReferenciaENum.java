package br.com.odontoclinic.stuff.referencia;

public enum ReferenciaENum {

	PESSOAL("PE - PESSOAL","PE"),
	PROFISSIONAL("PR - PROFISSIONAL", "PR"),
	CONJUGAL("CO - CONJUGAL", "CO");
	
	private String label;
	private String value;
	
	ReferenciaENum(String label, String value){
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
