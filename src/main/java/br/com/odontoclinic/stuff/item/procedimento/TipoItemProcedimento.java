package br.com.odontoclinic.stuff.item.procedimento;

public enum TipoItemProcedimento {

	//PRIMEIRO QUADRANTE SUPERIOR DIREITO
	NAODETALHADO ( "Não Detalhado", "NAODETALHADO" ),
	ARCADA ( "Procedimento na Arcada", "ARCADA" ),
	
	//PRIMEIRO QUADRANTE SUPERIOR DIREITO
	DENTE11 ( "11 - Incisivo Central Superior Direito", "11" ),
	DENTE12 ( "12 - Incisivo Lateral Superior Direito", "12" ),
	DENTE13 ( "13 - Canino Superior Direito", "13" ),
	DENTE14 ( "14 - Primeiro Premolar Superior Direito", "14" ),
	DENTE15 ( "15 - Segundo Premolar Superior Direito", "15" ),
	DENTE16 ( "16 - Primeiro Molar Superior Direito","16" ),
	DENTE17 ( "17 - Segundo Molar Superior Direito", "17" ),
	DENTE18 ( "18 - Terceiro Molar Superior Direito", "18" ),
	
	//SEGUNDO QUADRANTE SUPERIOR ESQUERDO
	DENTE21	( "21 - Incisivo Central Superior Esquerdo","21"),
	DENTE22 ( "22 - Incisivo Lateral Superior Esquerdo", "22" ),
	DENTE23 ( "23 - Canino Superior Esquerdo", "23" ),
	DENTE24 ( "24 - Primeiro Premolar Superior Esquerdo", "24" ),
	DENTE25 ( "25 - Segundo Premolar Superior Esquerdo", "25" ),
	DENTE26 ( "26 - Primeiro Molar Superior Esquerdo","26" ),
	DENTE27 ( "27 - Segundo Molar Superior Esquerdo", "27" ),
	DENTE28 ( "28 - Terceiro Molar Superior Esquerdo", "28" ),
	
	//TERCEIRO QUADRANTE INFERIOR ESQUERDO
	DENTE31 ( "31 - Incisivo Central Inferior Esquerdo", "31"),
	DENTE32 ( "32 - Incisivo Lateral Inferior Esquerdo", "32"),
	DENTE33 ( "33 - Canino Inferior Esquerdo", "33"),
	DENTE34 ( "34 - Primeiro Premolar Inferior Esquerdo", "34"),
	DENTE35 ( "35 - Segundo Premolar Inferior Esquerdo", "35"),
	DENTE36 ( "36 - Primeiro Molar Inferior Esquerdo", "36"),
	DENTE37 ( "37 - Segundo Molar Inferior Esquerdo", "37"),
	DENTE38 ( "38 - Terceiro Molar Inferior Esquerdo", "38"),
	
	//QUARTO QUADRANTE INFERIOR DIREITO
	DENTE41 ( "41 - Incisivo Central Inferior Direito", "41"),
	DENTE42 ( "42 - Incisivo Lateral Inferior Direito", "42"),
	DENTE43 ( "43 - Canino Inferior Direito", "43"),
	DENTE44 ( "44 - Primeiro Premolar Inferior Direito", "44"),
	DENTE45 ( "45 - Segundo Premolar Inferior Direito", "45"),
	DENTE46 ( "46 - Primeiro Molar Inferior Direito", "46"),
	DENTE47 ( "47 - Segundo Molar Inferior Direito", "47"),
	DENTE48 ( "48 - Terceiro Molar Inferior Direito", "48");
	
	//OBS: AINDA FALTAM AS NOTAÇÕES PARA OS DENTES DE LEITE...
	
	private String label;
	private String value;
	
	TipoItemProcedimento(String label, String value){
		this.label = label;
		this.value = value;
	}
	
	public String getLabel() {
		return label;
	}
	
	public String getValue() {
		return value;
	}
	
}
