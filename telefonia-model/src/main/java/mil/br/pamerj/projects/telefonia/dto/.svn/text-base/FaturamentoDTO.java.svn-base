/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.br.pamerj.projects.telefonia.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Fernando Tomasio
 */
public class FaturamentoDTO {

    private Long id;
    private Date periodo;
    private Date dataFechamento;
    private Set<FaturaDTO> faturas = new HashSet<FaturaDTO>();
    private boolean aberto;

    public boolean isAberto() {
        return aberto;
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }
    

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public void addFatura(FaturaDTO fatura){
        faturas.add(fatura);
    }
    public Set<FaturaDTO> getFaturas() {
        return faturas;
    }

    public void setFaturas(Set<FaturaDTO> faturas) {
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
    
    
    
}
