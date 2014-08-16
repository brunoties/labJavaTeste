package com.caelum.argentum.modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

//implementando imutabilidade do objeto
public final class Negociacao {
	
	private final int quantidade;
	private final double preco;
	private final Calendar data;
	
	public Negociacao(int quantidade, double preco, Calendar data) {
		
		if(data == null) {
			throw new IllegalArgumentException();
		}
		
		this.quantidade = quantidade;
		this.preco = preco;
		this.data = data;
	}
	
//	public Negociacao() {
//	}
	
	public double getVolume() {
		return this.preco * this.quantidade;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public Calendar getData() {
		//data.add(Calendar.DAY_OF_MONTH, 1);
		return (Calendar) this.data.clone();
	}

	@Override
	public String toString() {
		return "Negociacao [quantidade=" + quantidade + ", preco=" + preco
				+ ", data=" + 
					new SimpleDateFormat(" dd/MM/yyyy HH:mm:ss")
					.format(this.data.getTime()) + "]";
	}

	public boolean isMesmoDia(Calendar data) {
		return this.data.get(Calendar.DAY_OF_YEAR) == (data.get(Calendar.DAY_OF_YEAR))
				&& this.data.get(Calendar.YEAR) == data.get(Calendar.YEAR);
	}

}
