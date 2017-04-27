package br.com.odontoclinic.regras.validacao;

public class ValidateCpfCnpj {

	public static Boolean validarCNPJ(String cnpj) {
		
		if (cnpj.length() != 18)
			return false;
		
		cnpj = cnpj.replace(".", "");
		cnpj = cnpj.replace("-", "");
		cnpj = cnpj.replace("/", "");

		if (cnpj.equals("00000000000000")) {
			return false;
		}

		int soma = 0, dig;
		String cnpjCalc = cnpj.substring(0, 12);

		char[] chrCnpj = cnpj.toCharArray();

		/* Primeira parte */
		for (int i = 0; i < 4; i++)
			if (chrCnpj[i] - 48 >= 0 && chrCnpj[i] - 48 <= 9)
				soma += (chrCnpj[i] - 48) * (6 - (i + 1));
		for (int i = 0; i < 8; i++)
			if (chrCnpj[i + 4] - 48 >= 0 && chrCnpj[i + 4] - 48 <= 9)
				soma += (chrCnpj[i + 4] - 48) * (10 - (i + 1));
		dig = 11 - (soma % 11);

		cnpjCalc += (dig == 10 || dig == 11) ? "0" : Integer.toString(dig);

		/* Segunda parte */
		soma = 0;
		for (int i = 0; i < 5; i++)
			if (chrCnpj[i] - 48 >= 0 && chrCnpj[i] - 48 <= 9)
				soma += (chrCnpj[i] - 48) * (7 - (i + 1));
		for (int i = 0; i < 8; i++)
			if (chrCnpj[i + 5] - 48 >= 0 && chrCnpj[i + 5] - 48 <= 9)
				soma += (chrCnpj[i + 5] - 48) * (10 - (i + 1));
		dig = 11 - (soma % 11);
		cnpjCalc += (dig == 10 || dig == 11) ? "0" : Integer.toString(dig);

		return cnpj.equals(cnpjCalc);
	}
	
			//segundo método incluso..
		public static Boolean validarCPF(String cpf) {
			cpf = cpf.replace(".", "");
			cpf = cpf.replace("-", "");

			int d1, d2;
			int digito1, digito2, resto;
			int digitoCPF;
			String nDigResult;

			// inicializando as vari�veis
			d1 = 0;
			d2 = 0;
			digito1 = 0;
			digito2 = 0;
			resto = 0;

			if (cpf.length() < 11 || cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222")
					|| cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555")
					|| cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888")
					|| cpf.equals("99999999999")) {
				return false;
			}

			for (int nCount = 1; nCount < cpf.length() - 1; nCount++) {
				digitoCPF = Integer.valueOf(cpf.substring(nCount - 1, nCount)).intValue();

				// multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4
				// e assim por diante.
				d1 = d1 + (11 - nCount) * digitoCPF;

				// para o segundo digito repita o procedimento incluindo o primeiro
				// digito calculado no passo anterior.
				d2 = d2 + (12 - nCount) * digitoCPF;
			}
			;

			// Primeiro resto da divis�o por 11.
			resto = (d1 % 11);

			// Se o resultado for 0 ou 1 o digito � 0 caso contr�rio o digito � 11
			// menos o resultado anterior.
			if (resto < 2)
				digito1 = 0;
			else
				digito1 = 11 - resto;

			d2 += 2 * digito1;

			// Segundo resto da divis�o por 11.
			resto = (d2 % 11);

			// Se o resultado for 0 ou 1 o digito � 0 caso contr�rio o digito � 11
			// menos o resultado anterior.
			if (resto < 2)
				digito2 = 0;
			else
				digito2 = 11 - resto;

			// Digito verificador do CPF que está sendo validado.
			String nDigVerific = cpf.substring(cpf.length() - 2, cpf.length());

			// Concatenando o primeiro resto com o segundo.
			nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

			// comparar o digito verificador do cpf com o primeiro resto + o segundo
			// resto.
			return nDigVerific.equals(nDigResult);

		}
	
}
