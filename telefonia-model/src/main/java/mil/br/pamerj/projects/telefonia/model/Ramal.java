/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.br.pamerj.projects.telefonia.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mil.br.pamerj.projects.telefonia.dto.FaturaDTO;
import mil.br.pamerj.projects.telefonia.dto.LigacaoDTO;

import mil.br.pamerj.projects.telefonia.dto.RamalDTO;

/**
 *
 * @author fernandofot
 */
public class Ramal {

    private Long id;
    private String numero;
    private String login;
    private String descricao;
    private Set<Fatura> faturas = new HashSet<Fatura>();

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    private Set<Ligacao> ligacoes = new HashSet<Ligacao>();

    public Ramal() {
        super();
    }

    public void addFatura(Fatura fatura) {
        faturas.add(fatura);
    }

    public Set<Fatura> getFaturas() {
        return faturas;
    }

    public void setFaturas(Set<Fatura> faturas) {
        this.faturas = faturas;
    }

    public Ramal(RamalDTO dto) {
        fill(dto);
    }

    private void fill(RamalDTO dto) {
        if (dto != null) {
            id = dto.getId();
            login = dto.getLogin();
            numero = dto.getNumero();
            descricao = dto.getDescricao();
            Set<Ligacao> _ligacoes = new HashSet<Ligacao>();
            for (LigacaoDTO ligacaoDTO : dto.getLigacoes()) {
                _ligacoes.add(new Ligacao());
            }
            ligacoes = _ligacoes;

            Set<Fatura> _faturas = new HashSet<Fatura>();
            for (FaturaDTO faturaDTO : dto.getFaturas()) {
                _faturas.add(new Fatura(faturaDTO));
            }
            faturas = _faturas;
        }
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    public Set<Ligacao> getLigacoes() {
        return ligacoes;
    }

    public void setLigacoes(Set<Ligacao> ligacoes) {
        this.ligacoes = ligacoes;
    }

    public void addLigacoes(Ligacao ligacao) {
        this.ligacoes.add(ligacao);
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ramal)) {
            return false;
        }
        Ramal other = (Ramal) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ramal[id=" + getId() + "]";
    }

    public RamalDTO createDTO() {
        RamalDTO dto = createDTOMinimal(this);
        Set<LigacaoDTO> ligacoesDTO = new HashSet<LigacaoDTO>();
        for (Ligacao ligacao : ligacoes) {
            ligacoesDTO.add(ligacao.createDTO());
        }
        Set<FaturaDTO> faturasDTO = new HashSet<FaturaDTO>();
        for (Fatura fatura : faturas) {
            faturasDTO.add(fatura.createDTOMinimal());
        }
        return dto;
    }

    public static List<RamalDTO> createDTO(List<Ramal> ramais) {
        List<RamalDTO> listDTO = new ArrayList<RamalDTO>();
        for (Ramal ramal : ramais) {
            listDTO.add(createDTOMinimal(ramal));
        }
        return listDTO;
    }

    private static RamalDTO createDTOMinimal(Ramal ramal) {
        RamalDTO dto = new RamalDTO();
        dto.setId(ramal.id);
        dto.setLogin(ramal.login);
        dto.setNumero(ramal.numero);
        dto.setDescricao(ramal.descricao);
        return dto;

    }
}
