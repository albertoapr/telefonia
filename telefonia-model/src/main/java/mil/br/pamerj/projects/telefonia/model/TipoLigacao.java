/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.br.pamerj.projects.telefonia.model;

import mil.br.pamerj.projects.telefonia.dto.TipoLigacaoDTO;

/**
 *
 * @author fernandofot
 */
public class TipoLigacao {

    private Long id;
    private String descricao;
    private String sigla;

    public TipoLigacao(TipoLigacaoDTO dto) {
        fill(dto);
    }

    private void fill(TipoLigacaoDTO dto) {
        if (dto != null) {
            id = dto.getId();
            descricao = dto.getDescricao();
            sigla = dto.getSigla();

        }
    }

    public TipoLigacao() {
        super();
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
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the sigla
     */
    public String getSigla() {
        return sigla;
    }

    /**
     * @param sigla the sigla to set
     */
    public void setSigla(String sigla) {
        this.sigla = sigla;
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
        if (!(object instanceof TipoLigacao)) {
            return false;
        }
        TipoLigacao other = (TipoLigacao) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipoLigacao[id=" + getId() + "]";
    }

    public TipoLigacaoDTO createDTO() {
        TipoLigacaoDTO dto = new TipoLigacaoDTO();
        dto.setDescricao(descricao);
        dto.setSigla(sigla);
        dto.setId(id);
        return dto;
    }
}
