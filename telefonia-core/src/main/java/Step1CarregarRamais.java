
import java.io.File;
import java.util.Date;

import mil.br.pamerj.projects.telefonia.api.LigacaoService;
import mil.br.pamerj.projects.telefonia.api.exceptions.CoreException;
import mil.br.pamerj.projects.telefonia.core.SimpleLigacaoService;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernandofot
 */

public class Step1CarregarRamais {
    // FAZ A CARGA DE LIGAÇÕES E RAMAIS PARA O BANCO DE DADOS
    public static void main(String[] args) throws CoreException {
        LigacaoService service = new SimpleLigacaoService();
        service.chargeDbLigacoes(new File("/home/alberto/Desenvolvimento/Java/PAME/telefonia/arquivos/Mai13.txt"), new Date());
    }

}
