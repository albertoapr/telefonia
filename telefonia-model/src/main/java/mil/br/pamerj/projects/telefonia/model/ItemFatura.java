package mil.br.pamerj.projects.telefonia.model;

import mil.br.pamerj.projects.telefonia.dto.ItemFaturaDTO;
import mil.br.pamerj.projects.telefonia.dto.LigacaoDTO;

public class ItemFatura {

    private Ligacao ligacao;
    private String natureza = "PARTICULAR";

    public String getNatureza() {
        return natureza;
    }

    public void setNatureza(String natureza) {
        this.natureza = natureza;
    }

    public ItemFatura() {
        super();
    }

    public ItemFatura(ItemFaturaDTO dto) {
        fill(dto);
    }

    private void fill(ItemFaturaDTO dto) {
        
        if (dto != null) {
            natureza = dto.getNatureza();
            ligacao = new Ligacao(dto.getLigacao());
        }
    }

    public Ligacao getLigacao() {
        return ligacao;
    }

    public void setLigacao(Ligacao ligacao) {
        this.ligacao = ligacao;
    }

    public ItemFaturaDTO createDTO() {
        ItemFaturaDTO dto = new ItemFaturaDTO();
        dto.setNatureza(natureza);
        if (ligacao != null) {
            LigacaoDTO _ligacao = new LigacaoDTO();
            _ligacao.setCusto(ligacao.getCusto());
            _ligacao.setDataHora(ligacao.getDataHora());
            _ligacao.setDuracao(ligacao.getDuracao());
            _ligacao.setId(ligacao.getId());
            _ligacao.setLocal(ligacao.getLocal());
           
            _ligacao.setNumero(ligacao.getNumero());
            dto.setLigacao(_ligacao);
        }
        return dto;
    }
}
