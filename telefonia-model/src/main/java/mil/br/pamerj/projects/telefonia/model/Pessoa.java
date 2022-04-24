package mil.br.pamerj.projects.telefonia.model;

import mil.br.pamerj.projects.telefonia.dto.PessoaDTO;

public class Pessoa {
	private String posto;
	private String nome;
	private String nomeGuerra;
	public String getPosto() {
		return posto;
	}
	public void setPosto(String posto) {
		this.posto = posto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeGuerra() {
		return nomeGuerra;
	}
	public void setNomeGuerra(String nomeGuerra) {
		this.nomeGuerra = nomeGuerra;
	}
	
	 public PessoaDTO createDTO() {
		 PessoaDTO dto = new PessoaDTO();
		 dto.setNome(nome);
		 dto.setNomeGuerra(nomeGuerra);
		 dto.setPosto(posto);
		 return dto;
	 }
}
