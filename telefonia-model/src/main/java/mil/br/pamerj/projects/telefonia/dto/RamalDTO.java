package mil.br.pamerj.projects.telefonia.dto;

import java.util.HashSet;
import java.util.Set;

public class RamalDTO {

    private Long id;
    private String numero;
    private String login;
    private String descricao;
    private Set<LigacaoDTO> ligacoes = new HashSet<LigacaoDTO>();
    private Set<FaturaDTO> faturas = new HashSet<FaturaDTO>();

    
    public void addFatura(FaturaDTO fatura){
        faturas.add(fatura);
    }
    
    public Set<FaturaDTO> getFaturas() {
        return faturas;
    }

    public void setFaturas(Set<FaturaDTO> faturas) {
        this.faturas = faturas;
    }
    
    
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<LigacaoDTO> getLigacoes() {
        return ligacoes;
    }

    public void setLigacoes(Set<LigacaoDTO> ligacoes) {
        this.ligacoes = ligacoes;
    }
    
    public void addLigacao(LigacaoDTO ligacao){
        ligacoes.add(ligacao);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "RamalDTO{" + "id=" + id + ", numero=" + numero + ", login=" + login + ", descricao=" + descricao + ", ligacoes=" + ligacoes + '}';
    }

   
    
}
