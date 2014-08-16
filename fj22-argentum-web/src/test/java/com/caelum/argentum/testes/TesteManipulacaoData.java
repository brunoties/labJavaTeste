package com.caelum.argentum.testes;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TesteManipulacaoData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		String hora = "HH:mm:ss";
		
		String data = "dd/MM/yyyy";
		
		String dataHora = data + " " + hora;
		
		Calendar dataAtual = Calendar.getInstance();
		
		SimpleDateFormat dataFormatada = new SimpleDateFormat(dataHora);
		
		//System.out.println(dataFormatada.format(dataAtual.getTime()));
		
		//System.out.println(dataAtual.getTime());
		
		//System.out.println(DataUtil.getTxtDataHora(dataAtual.getTime()));
		
	}

}
