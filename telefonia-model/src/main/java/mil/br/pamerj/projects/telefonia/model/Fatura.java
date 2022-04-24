package mil.br.pamerj.projects.telefonia.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import mil.br.pamerj.projects.telefonia.dto.FaturaDTO;
import mil.br.pamerj.projects.telefonia.dto.FaturamentoDTO;
import mil.br.pamerj.projects.telefonia.dto.ItemFaturaDTO;
import mil.br.pamerj.projects.telefonia.dto.RamalDTO;

public class Fatura {

    private Long id;
    private Set<ItemFatura> items = new HashSet<ItemFatura>();
    private Faturamento faturamento;
    private Ramal ramal;
    private boolean aberto = true;
    private boolean pago;

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }
    
    

    public Ramal getRamal() {
        return ramal;
    }

    public void setRamal(Ramal ramal) {
        this.ramal = ramal;
    }

    public boolean isAberto() {
        return aberto;
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    public Fatura() {
        super();
    }

    public Fatura(FaturaDTO dto) {
        fill(dto);
    }

    private void fill(FaturaDTO dto) {
        if (dto != null) {
            id = dto.getId();
            aberto = dto.isAberto();
            pago = dto.isPago();
            Set<ItemFatura> _items = new HashSet<ItemFatura>();

            for (ItemFaturaDTO itemDTO : dto.getItems()) {
                _items.add(new ItemFatura(itemDTO));
            }
            faturamento = new Faturamento(dto.getFaturamento());
            ramal = new Ramal(dto.getRamal());
            items = _items;
        }
    }

    public Faturamento getFaturamento() {
        return faturamento;
    }

    public void setFaturamento(Faturamento faturamento) {
        this.faturamento = faturamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<ItemFatura> getItems() {
        return items;
    }

    public void setItems(Set<ItemFatura> items) {
        this.items = items;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are
        // not set
        if (!(object instanceof Fatura)) {
            return false;
        }
        Fatura other = (Fatura) object;
        if ((this.getId() == null && other.getId() != null)
                || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fatura[id=" + getId() + "]";
    }

    public FaturaDTO createDTO() {
        FaturaDTO dto = createDTOMinimal(this);



        Set<ItemFaturaDTO> itemsDTO = new HashSet<ItemFaturaDTO>();

        double totalParticular = 0.00;
        double totalServico = 0.00;
        double total = 0.00;

        for (ItemFatura item : items) {
            if(item.getNatureza().equalsIgnoreCase("PARTICULAR")){
                totalParticular += item.getLigacao().getCusto();
            }else{
                totalServico += item.getLigacao().getCusto();
            }
            total += item.getLigacao().getCusto();
            itemsDTO.add(item.createDTO());
        }
        dto.setTotalParticular(totalParticular);
        dto.setTotalServico(totalServico);
        dto.setTotal(total);
        dto.setItems(itemsDTO);
        return dto;
    }

    public FaturaDTO createDTOMinimal() {
        FaturaDTO dto = createDTOMinimal(this);
        return dto;
    }

    public static List<FaturaDTO> createDTO(List<Fatura> faturas) {
        List<FaturaDTO> listDTO = new ArrayList<FaturaDTO>();
        for (Fatura fatura : faturas) {
            listDTO.add(Fatura.createDTOMinimal(fatura));
        }
        return listDTO;

    }
    public static List<FaturaDTO> createDTOFull(List<Fatura> faturas) {
        List<FaturaDTO> listDTO = new ArrayList<FaturaDTO>();
        for (Fatura fatura : faturas) {
            listDTO.add(fatura.createDTO());
        }
        return listDTO;

    }

    private static FaturaDTO createDTOMinimal(Fatura fatura) {
        FaturaDTO dto = new FaturaDTO();
        dto.setId(fatura.getId());
        dto.setAberto(fatura.isAberto());
        dto.setPago(fatura.isPago());
        if (fatura.getRamal() != null) {
            RamalDTO _ramal = new RamalDTO();
            _ramal.setDescricao(fatura.getRamal().getDescricao());
            _ramal.setId(fatura.getRamal().getId());
            _ramal.setLogin(fatura.getRamal().getLogin());
            _ramal.setNumero(fatura.getRamal().getNumero());
            dto.setRamal(_ramal);
        }
        if (fatura.getFaturamento() != null) {
            FaturamentoDTO _faturamento = new FaturamentoDTO();
            _faturamento.setDataFechamento(fatura.getFaturamento().getDataFechamento());
            _faturamento.setId(fatura.getFaturamento().getId());
            _faturamento.setPeriodo(fatura.getFaturamento().getPeriodo());
            dto.setFaturamento(_faturamento);
        }
        return dto;
    }
}
