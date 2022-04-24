/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.br.pamerj.projects.telefonia.dao;

import java.util.Date;
import java.util.List;

import mil.br.pamerj.projects.telefonia.dto.LigacaoDTO;
import mil.br.pamerj.projects.telefonia.dto.RamalDTO;

/**
 *
 * @author fernandofot
 */
public interface LigacaoDAO {
    
    void create(LigacaoDTO ligacao);

    
    LigacaoDTO find(Long id);

    List<LigacaoDTO> findAll();
    
    List<LigacaoDTO> findAll(Long ramalId, Date mes);
    
    List<LigacaoDTO> findAll(String login, Date mes);

    List<LigacaoDTO> findAll(Date dataInicio, Date dataTermino);
    
    List<LigacaoDTO> findAll(Date mes);
    
    void remove(Long id);

    void update(LigacaoDTO ligacao);

    List<LigacaoDTO> searchByLogin(String login);

    List<LigacaoDTO> searchByPeriodo(Date dataInicio, Date dateTermino);

    List<LigacaoDTO> searchByValor(double valor);

    void createAll(List<LigacaoDTO> ligacoes);

    

    

    
    
    
    
    
}
