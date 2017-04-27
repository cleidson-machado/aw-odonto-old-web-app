package br.com.odontoclinic.stuff.endereco;

public enum TipoEnderecoENum {
	
	//CRIADO APENAS PARA DIFERENCIAR ENDEREÇOS COMERCIAIS DE RESIDENCIAIS
	
	COMERCIAL ("Comercial", "Comercial"),
	RESIDENCIAL("Residêncial", "Residencial");
	
	private String label2;
	private String value2;
	
	private TipoEnderecoENum(String label2, String value2) {
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
