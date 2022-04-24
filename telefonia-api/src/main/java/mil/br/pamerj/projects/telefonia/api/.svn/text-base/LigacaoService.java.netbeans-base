/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mil.br.pamerj.projects.telefonia.api;
import java.io.File;
import java.util.Date;
import java.util.List;

import mil.br.pamerj.projects.telefonia.api.exceptions.CoreException;
import mil.br.pamerj.projects.telefonia.dto.LigacaoDTO;
import mil.br.pamerj.projects.telefonia.dto.RamalDTO;

/**
 *
 * @author fernandofot
 */
public interface LigacaoService {
  void createAllLigacao(List<LigacaoDTO> ligacoes);
  void createLigacao(LigacaoDTO ligacao);
  void createAllRamal(List<RamalDTO> ramais);
  void createRamal(RamalDTO ramal);
  void updateRamal(RamalDTO ramal);
  void chargeDbLigacoes(File file, Date periodo) throws CoreException;
  RamalDTO findRamalByNumero(String numero);
  RamalDTO findRamal(Long id);
  List<RamalDTO> findAllRamais();
  List<RamalDTO> searchRamalByLogin(String login);
  List<RamalDTO> searchRamalByNumero(String numero);
  void removeRamal(Long ramalId);
  
  void updateLigacoes(List<LigacaoDTO> ligacoes);
  List<RamalDTO> findRamalByLogin(String login);
  List<LigacaoDTO> findAllLigacoes();
  List<LigacaoDTO> findAllLigacoes(Date mes);
  List<LigacaoDTO> findAllLigacoes(Long ramalId, Date mes);
  List<LigacaoDTO> findAllLigacoes(String login, Date mes);
  
 
  
 
  
  
  
  
  
}

