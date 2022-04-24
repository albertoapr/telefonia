/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.br.pamerj.projects.telefonia.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mil.br.pamerj.projects.telefonia.dto.FaturaDTO;
import mil.br.pamerj.projects.telefonia.dto.FaturamentoDTO;

/**
 *
 * @author Fernando Tomasio
 */
public class Faturamento {

    private Long id;
    private Date periodo;
    private Date dataFechamento;
    private Set<Fatura> faturas = new HashSet<Fatura>();
    private boolean aberto = true;

    public boolean isAberto() {
        return aberto;
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }
    
    
    
    public Faturamento() {
    }

    public Faturamento(FaturamentoDTO dto) {
        fill(dto);
    }

    private void fill(FaturamentoDTO dto) {
        if (dto != null) {
            id = dto.getId();
            aberto = dto.isAberto();
            periodo = dto.getPeriodo();
            dataFechamento = dto.getDataFechamento();
            Set<Fatura> _faturas = new HashSet<Fatura>();
            for (FaturaDTO faturaDTO : dto.getFaturas()) {
                _faturas.add(new Fatura(faturaDTO));
            }
            faturas = _faturas;
        }
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public Set<Fatura> getFaturas() {
        return faturas;
    }

    public void setFaturas(Set<Fatura> faturas) {
        this.faturas = faturas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Date periodo) {
        this.periodo = periodo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Faturamento other = (Faturamento) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Faturamento{" + "id=" + id + ", periodo=" + periodo + ", dataFechamento=" + dataFechamento + '}';
    }

    public FaturamentoDTO createDTO() {
        FaturamentoDTO dto = createDTOMinimal(this);
        Set<FaturaDTO> faturasDTO = new HashSet<FaturaDTO>();
        for (Fatura fatura : faturas) {
            faturasDTO.add(fatura.createDTO());
        }
        dto.setFaturas(faturasDTO);
        return dto;
    }
    

    public static List<FaturamentoDTO> createDTO(List<Faturamento> faturamentos){
        List<FaturamentoDTO> listDTO = new ArrayList<FaturamentoDTO>();
        for (Faturamento faturamento : faturamentos) {
            listDTO.add(Faturamento.createDTOMinimal(faturamento));
        }
        return listDTO;
    }
    
    private static FaturamentoDTO createDTOMinimal(Faturamento faturamento) {
        FaturamentoDTO dto = new FaturamentoDTO();
        dto.setAberto(faturamento.aberto);
        dto.setId(faturamento.id);
        dto.setPeriodo(faturamento.periodo);
        dto.setDataFechamento(faturamento.dataFechamento);

        return dto;
    }
}
