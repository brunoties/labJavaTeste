package com.caelum.argentum.modelo;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.caelum.argentum.util.LeitorXML;

public class ClienteWebService {

	private static final String URL_WEBSERVICE = "http://argentumws.caelum.com.br/negociacoes";
	
	public List<Negociacao> getNegociacoes() throws IOException {

		HttpURLConnection con = null;
		
		try {
			URL url = new URL(URL_WEBSERVICE);

			con = (HttpURLConnection) url.openConnection();

			InputStream is = con.getInputStream();

			return new LeitorXML().carregar(is);
			
		}catch(IOException e) {
			throw new RuntimeException(e);
		} finally {
			con.disconnect();
		}

	}

}
