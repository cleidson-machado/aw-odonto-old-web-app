package br.com.odontoclinic.stuff.endereco;

public enum EnderecoENum {
	
	AEROPORTO	("Aeroporto", "Aeroporto"),
	ALAMEDA		("Alameda","Alameda"),
	ÁREA  		("Área", "Area"),
	AVENIDA		("Avenida", "Avenida"),
	CAMPO  		("Campo", "Campo"),
	CHÁCARA  	("Chácara", "Chacara"),
	COLÔNIA 	("Colônia", "Colonia"),
	CONDOMÍNIO  ("Condomínio", "Condominio"),
	CONJUNTO  	("Conjunto", "Conjunto"),
	DISTRITO  	("Distrito", "Distrito"),
	ESPLANADA  	("Esplanada", "Esplanada"),
	ESTAÇÃO  	("Estação", "Estacao"),
	ESTRADA  	("Estrada", "Estrada"),
	FAVELA  	("Favela", "Favela"),
	FAZENDA  	("Fazenda", "Fazenda"),
	FEIRA  		("Feira", "Feira"),
	JARDIM  	("Jardim", "Jardim"),
	LADEIRA  	("Ladeira", "Ladeira"),
	LAGO  		("Lago", "Lago"),
	LAGOA  		("Lagoa", "Lagoa"),
	LARGO  		("Largo", "Largo"),
	LOTEAMENTO  ("Loteamento", "Loteamento"),
	MORRO  		("Morro", "Morro"),
	NÚCLEO  	("Núcleo", "Nucleo"),
	PARQUE  	("Parque", "Parque"),
	PASSARELA  	("Passarela", "Passarela"),
	PÁTIO  		("Pátio", "Patio"),
	PRAÇA  		("Praça", "Praca"),
	QUADRA  	("Quadra", "Quadra"),
	RECANTO  	("Recanto", "Recanto"),
	RESIDENCIAL ("Residencial", "Residencial"),
	RODOVIA  	("Rodovia", "Rodovia"),
	RUA			("Rua", "Rua"),
	SETOR  		("Setor", "Setor"),
	SÍTIO  		("Sítio", "Sitio"),
	TRAVESSA	("Travessa", "Travessa"),
	TRECHO  	("Trecho", "Trecho"),
	TREVO  		("Trevo", "Trevo"),
	VALE  		("Vale", "Vale"),
	VEREDA  	("Vereda", "Vereda"),
	VIA  		("Via", "Via"),
	VIADUTO  	("Viaduto", "Viaduto"),
	VIELA  		("Viela", "Viela"),
	VILA  		("Vila", "Vila");
	
	private String label;
	private String value;
	
	EnderecoENum(String label, String value){
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
