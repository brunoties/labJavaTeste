package com.caelum.argentum.testes;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import com.caelum.argentum.modelo.Negociacao;
import com.caelum.argentum.modelo.NegociacaoBuilder;

public class NegociacaoTest {
	
	@Test
	public void mesmoMilissegundosEhMesmoDia() {
		
		Calendar agora = Calendar.getInstance();
		
		Calendar mesmoInstante = (Calendar) agora.clone();
		
		Negociacao negociacao = new NegociacaoBuilder().comData(agora).comPreco(40.5)
				.comQuantidade(100).negociacaoBuilder();
		
		assertTrue(negociacao.isMesmoDia(mesmoInstante));
		
	}
	
	@Test
	public void comHoraDIferenteEhMesmoDia() {
		
		Calendar agora = Calendar.getInstance();
		
		Calendar outroMomento = (Calendar) agora.clone();
		
		outroMomento.set(Calendar.HOUR, 9,15);
		
		Negociacao negociacao = new NegociacaoBuilder().comData(agora).comPreco(40.5)
				.comQuantidade(100).negociacaoBuilder();
		
		assertTrue(negociacao.isMesmoDia(outroMomento));
		
	}

}
