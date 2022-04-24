package mil.br.pamerj.projects.telefonia.dto;

import java.util.HashSet;
import java.util.Set;

public class FaturaDTO {

    private Long id;
    private Set<ItemFaturaDTO> items = new HashSet<ItemFaturaDTO>();
    private FaturamentoDTO faturamento;
    private RamalDTO ramal;
    private double totalParticular;
    private double totalServico;
    private double total;
    private boolean aberto;
    private boolean pago;

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }
    

    public boolean isAberto() {
        return aberto;
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    
    public double getTotalParticular() {
        return totalParticular;
    }

    public void setTotalParticular(double totalParticular) {
        this.totalParticular = totalParticular;
    }

    public double getTotalServico() {
        return totalServico;
    }

    public void setTotalServico(double totalServico) {
        this.totalServico = totalServico;
    }
    
    

    public RamalDTO getRamal() {
        return ramal;
    }

    public void setRamal(RamalDTO ramal) {
        this.ramal = ramal;
    }

    public FaturamentoDTO getFaturamento() {
        return faturamento;
    }

    public void setFaturamento(FaturamentoDTO faturamento) {
        this.faturamento = faturamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addItem(ItemFaturaDTO item) {
        items.add(item);
    }

    public Set<ItemFaturaDTO> getItems() {
        return items;
    }

    public void setItems(Set<ItemFaturaDTO> items) {
        this.items = items;
    }

}
