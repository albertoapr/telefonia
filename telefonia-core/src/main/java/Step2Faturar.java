
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mil.br.pamerj.projects.telefonia.core.SimpleFaturaService;
import mil.br.pamerj.projects.telefonia.core.SimpleLigacaoService;
import mil.br.pamerj.projects.telefonia.dto.FaturaDTO;
import mil.br.pamerj.projects.telefonia.dto.FaturamentoDTO;
import mil.br.pamerj.projects.telefonia.dto.ItemFaturaDTO;
import mil.br.pamerj.projects.telefonia.dto.LigacaoDTO;
import mil.br.pamerj.projects.telefonia.dto.RamalDTO;
import mil.br.pamerj.projects.telefonia.model.Fatura;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Fernando Tomasio
 */
public class Step2Faturar {

    public static void main(String[] args) {


        SimpleLigacaoService ligacaoService = new SimpleLigacaoService();
        SimpleFaturaService faturaService = new SimpleFaturaService();

        SimpleDateFormat formatter = new SimpleDateFormat("MM/yyyy");
        List<RamalDTO> ramais = ligacaoService.findAllRamais();
        //System.out.println(ramal.getFaturas().size());

        Date mes = null;
        try {
            mes = formatter.parse("05/2013");
        } catch (ParseException ex) {
            Logger.getLogger(Step2Faturar.class.getName()).log(Level.SEVERE, null, ex);
        }
        FaturamentoDTO faturamento = new FaturamentoDTO();
        faturamento.setPeriodo(mes);
        faturaService.createFaturamento(faturamento);
        //faturamento = faturaService.findFaturamentoByPeriodo(mes);
        
        
        for (RamalDTO ramal : ramais) {
               
            List<LigacaoDTO> ligacoes = ligacaoService.findAllLigacoes(ramal.getId(), mes);

            FaturaDTO fatura = new FaturaDTO();
            fatura.setAberto(true);
            
            
            fatura.setFaturamento(faturamento);
            fatura.setRamal(ramal);


            for (LigacaoDTO ligacaoDTO : ligacoes) {
                System.out.println(ligacaoDTO);
                ItemFaturaDTO itemFatura = new ItemFaturaDTO(ligacaoDTO);
                itemFatura.setNatureza("PARTICULAR");
                fatura.addItem(itemFatura);

            }
            for (ItemFaturaDTO itemFatura : fatura.getItems()) {
                System.out.println(itemFatura.getLigacao().getNumero());
            }
            faturaService.createFatura(fatura);
          System.out.println(ramal.getNumero());
        }


        //System.exit(0);


        //FaturamentoDTO faturamento = service.findFaturamento(1L);
        //System.out.println(faturamento.getPeriodo());
        //service.faturarPeriodo(faturamento);

    }
}
