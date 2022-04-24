/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.br.pamerj.projects.telefonia.api;

import java.util.Date;
import java.util.List;
import mil.br.pamerj.projects.telefonia.api.exceptions.CoreException;
import mil.br.pamerj.projects.telefonia.dto.FaturaDTO;
import mil.br.pamerj.projects.telefonia.dto.FaturamentoDTO;

/**
 *
 * @author Fernando Tomasio
 */
public interface FaturaService {

    void createFatura(FaturaDTO fatura);

    void updateFatura(FaturaDTO fatura);

    void removeFatura(Long faturaId);

    FaturaDTO findFatura(Long faturaId);

    void createFaturamento(FaturamentoDTO faturamento);

    void createFaturamento(FaturamentoDTO faturamento, byte[] file) throws CoreException;

    void updateFaturamento(FaturamentoDTO fatura);

    void removeFaturamento(Long faturamentoId);

    FaturamentoDTO findFaturamento(Long faturamentoId);

    FaturamentoDTO findFaturamentoByPeriodo(Date periodo);

    List<FaturamentoDTO> findAllFaturamentos();
    
    List<FaturaDTO> findAllFaturas();
    
    List<FaturaDTO> findAllFaturas(Date periodo);
    
    List<FaturaDTO> findAllFaturas(Date periodo, boolean aberto);
    
    List<FaturaDTO> findFaturasByLogin(String login);
    
    
}
