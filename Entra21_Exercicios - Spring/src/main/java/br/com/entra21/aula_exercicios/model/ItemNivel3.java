package br.com.entra21.aula_exercicios.model;

public class ItemNivel3 {
	private String rel;
	private String url;
	
	public ItemNivel3() {
		
	}

	public ItemNivel3(String rel, String url) {
		super();
		this.rel = rel;
		this.url = url;
	}

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
