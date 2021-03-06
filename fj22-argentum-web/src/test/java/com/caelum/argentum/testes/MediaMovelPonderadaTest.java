package com.caelum.argentum.testes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.caelum.argentum.indicadores.Indicador;
import com.caelum.argentum.modelo.MediaMovelSimples;
import com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelPonderadaTest {

	@Test
	public void sequenciaSimplesdeCandles() {

		SerieTemporal serie = GeradorDeSerie.criaSerie(1, 2, 3, 4, 3, 4, 5, 4, 3);
		
		Indicador mms = new MediaMovelSimples();
		
		assertEquals(2.0, mms.calcula(2, serie), 0.00001);
		assertEquals(3.0, mms.calcula(3, serie), 0.00001);
		assertEquals(10.0 / 3, mms.calcula(4, serie), 0.00001);
		assertEquals(11.0 / 3, mms.calcula(5, serie), 0.00001);
		assertEquals(4.0, mms.calcula(6, serie), 0.00001);
		assertEquals(13.0 / 3, mms.calcula(7, serie), 0.00001);
		assertEquals(4.0, mms.calcula(8, serie), 0.00001);

	
	}

}
