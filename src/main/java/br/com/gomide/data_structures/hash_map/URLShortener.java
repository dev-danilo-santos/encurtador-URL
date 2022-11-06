package br.com.gomide.data_structures.hash_map;

import java.util.Base64;

public class URLShortener implements IURLShortener {
	public boolean contains = false;
	
	@Override
	public String encode(String url) throws RuntimeException {
		if (url.contains("https://www."))  {
			contains = true;
			url = url.replace("https://www.", "");
		} 
		return getPrefix()+Base64.getEncoder().encodeToString(url.getBytes());
	}

	@Override
	public String decode(String encodedUrl) throws RuntimeException {
		if (encodedUrl.contains("brk.com/")) {
			encodedUrl = encodedUrl.replace("brk.com/","");
		}
		encodedUrl = new String(Base64.getDecoder().decode(encodedUrl)); 
		if(contains = true) {
			encodedUrl = "https://www."+encodedUrl;
		}
		
		return encodedUrl; 
	}
	//supondo que o próprio navegador insere o https:// estarei omitindo ele para compactar meu prefix
	@Override
	public String getPrefix() {
		return "brk.com/";
	}

}
