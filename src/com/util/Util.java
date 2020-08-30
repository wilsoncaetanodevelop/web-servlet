package com.util;

import java.util.InputMismatchException;

public class Util {


	public static String inicialMaiuscula(String value) {
		String result = "";

		/* Pega a String e separa por espa�o e coloca no vetor por posi��o */
		String[] nomes = value.split(" ");

		for (String palavra : nomes) {
			// converte para caixa alta o primeiro caracter
			result = result + " "
					+ palavra.replaceFirst(palavra.substring(0, 1), palavra.substring(0, 1).toUpperCase());
		}
		return result.trim();
	}
	
	
	public static boolean validarCPF(String CPF) {
		// considera-se erro CPF's formados por uma sequencia de numeros iguais
		
		if (CPF.equals("00000000000") || 
			CPF.equals("11111111111") || 
			CPF.equals("22222222222") || 
			CPF.equals("33333333333") ||
			CPF.equals("44444444444") || 
			CPF.equals("55555555555") ||
			CPF.equals("66666666666") || 
			CPF.equals("77777777777") || 
			CPF.equals("88888888888") || 
			CPF.equals("99999999999") || 
			(CPF.length() != 11))
			return (false);

		char dig10, dig11;
		int soma, i, r, numero, peso;

		// "try" - protege o codigo para eventuais erros de conversao de tipo (int)
		try {
			// Calculo do 1�. Digito Verificador
			soma = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				// converte o i-esimo caractere do CPF em um numero:
				// por exemplo, transforma o caractere '0' no inteiro 0
				// (48 eh a posicao de '0' na tabela ASCII)
				numero = (int) (CPF.charAt(i) - 48);
				soma = soma + (numero * peso);
				peso = peso - 1;
			}

			r = 11 - (soma % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48); // converte no respectivo caractere numerico

			// Calculo do 2�. Digito Verificador
			soma = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				numero = (int) (CPF.charAt(i) - 48);
				soma = soma + (numero * peso);
				peso = peso - 1;
			}

			r = 11 - (soma % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);

			// Verifica se os digitos calculados conferem com os digitos informados.
			if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
				return (true);
			else
				return (false);
		} catch (InputMismatchException erro) {
			return (false);
		}
	}

	public static String imprimeCPF(String CPF) {
		return (CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." + CPF.substring(6, 9) + "-"
				+ CPF.substring(9, 11));
	}
}
