package com.caelum.argentum.util;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.junit.Test;

import com.caelum.argentum.modelo.Negociacao;

public class LeitorXMLTest {

	@Test
	public void carregarXmlComUmaNegociacaoEmListaUnitaria() {

		String xmlDeTeste = "<list>" + 
								"<negociacao>" + 
									"<preco>39.5</preco>" +
									"<quantidade>1824</quantidade>" + 
									"<data>" +
										"<time>1244232789330</time>" + 
									"</data>" + 
								"</negociacao>" +
							"</list>";
		
		LeitorXML leitorXML = new LeitorXML();
		
		InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());
		
		List<Negociacao> negociacoes = leitorXML.carregar(xml);
		
		assertEquals(1, negociacoes.size(), 0.000001);
		
		assertEquals(39.5, negociacoes.get(0).getPreco(), 0.000001);
		
		assertEquals(1824, negociacoes.get(0).getQuantidade(), 0.000001);

	}
}
