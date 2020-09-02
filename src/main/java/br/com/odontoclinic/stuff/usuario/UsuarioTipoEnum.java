package br.com.odontoclinic.stuff.usuario;

public enum UsuarioTipoEnum {
	
	ADMINISTRADOR	("Administrador", "A"),
	USUARIO	("Usuário", "U");
	
	private String label;
	private String value;
	
	UsuarioTipoEnum(String label, String value){
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
