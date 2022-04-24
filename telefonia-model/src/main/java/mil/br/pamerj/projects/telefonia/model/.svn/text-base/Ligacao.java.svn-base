/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.br.pamerj.projects.telefonia.model;

import java.util.Date;

import mil.br.pamerj.projects.telefonia.dto.LigacaoDTO;
import mil.br.pamerj.projects.telefonia.dto.RamalDTO;

/**
 *
 * @author fernandofot
 */
public class Ligacao {

    private Long id;
    private String numero;
    private Date dataHora;
    private Date duracao;
    private double custo;
    private String local;
    private String tipo;
   
    private Ramal ramal;

    public Ligacao() {
        super();
    }

    public Ligacao(LigacaoDTO dto) {
         fill(dto);
    }

    private void fill(LigacaoDTO dto) {
        if (dto != null) {
            id = dto.getId();
            numero = dto.getNumero();
            dataHora = dto.getDataHora();
            duracao = dto.getDuracao();
            custo = dto.getCusto();
            local = dto.getLocal();
            tipo = dto.getTipo();
           
            ramal = new Ramal(dto.getRamal());
        }
    }

    public Ramal getRamal() {
        return ramal;
    }

    public void setRamal(Ramal ramal) {
        this.ramal = ramal;
    }

   

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the dataHora
     */
    public Date getDataHora() {
        return dataHora;
    }

    /**
     * @param dataHora the dataHora to set
     */
    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    /**
     * @return the duracao
     */
    public Date getDuracao() {
        return duracao;
    }

    /**
     * @param duracao the duracao to set
     */
    public void setDuracao(Date duracao) {
        this.duracao = duracao;
    }

    /**
     * @return the custo
     */
    public double getCusto() {
        return custo;
    }

    /**
     * @param custo the custo to set
     */
    public void setCusto(double custo) {
        this.custo = custo;
    }

    /**
     * @return the local
     */
    public String getLocal() {
        return local;
    }

    /**
     * @param local the local to set
     */
    public void setLocal(String local) {
        this.local = local;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ligacao)) {
            return false;
        }
        Ligacao other = (Ligacao) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ligacao[id=" + getId() + "]";
    }

    public LigacaoDTO createDTO() {

        LigacaoDTO dto = new LigacaoDTO();
        dto.setId(id);
        dto.setCusto(custo);
        dto.setDataHora(dataHora);
        dto.setDuracao(duracao);
        dto.setLocal(local);
       
        dto.setNumero(numero);
        if (ramal != null) {
            RamalDTO _ramal = new RamalDTO();
            _ramal.setDescricao(ramal.getDescricao());
            _ramal.setId(ramal.getId());
            _ramal.setLogin(ramal.getLogin());
            _ramal.setNumero(ramal.getNumero());
            dto.setRamal(_ramal);
        }
        dto.setTipo(tipo);
        return dto;
    }

}
