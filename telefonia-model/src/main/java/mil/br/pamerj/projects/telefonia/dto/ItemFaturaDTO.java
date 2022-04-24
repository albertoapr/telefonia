package mil.br.pamerj.projects.telefonia.dto;

public class ItemFaturaDTO {

    private LigacaoDTO ligacao;
    private String natureza;

    public String getNatureza() {
        return natureza;
    }

    public void setNatureza(String natureza) {
        this.natureza = natureza;
    }

    public ItemFaturaDTO() {
    }

    public ItemFaturaDTO(LigacaoDTO ligacao) {
        this.ligacao = ligacao;
    }

    public LigacaoDTO getLigacao() {
        return ligacao;
    }

    public void setLigacao(LigacaoDTO ligacao) {
        this.ligacao = ligacao;
    }
}
