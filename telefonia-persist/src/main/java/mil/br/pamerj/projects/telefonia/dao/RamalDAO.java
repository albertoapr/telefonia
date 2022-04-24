/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mil.br.pamerj.projects.telefonia.dao;

import java.util.List;

import mil.br.pamerj.projects.telefonia.dto.RamalDTO;

/**
 *
 * @author fernandofot
 */
public interface RamalDAO {
    void create(RamalDTO ramal);
    void createAll(List<RamalDTO> ramais);
    RamalDTO find(Long id);

    List<RamalDTO> findAll();

    void remove(Long id);

    void update(RamalDTO ramal);

    RamalDTO findByNumero(String numero);

    List<RamalDTO> findByLogin(String login);
    
    List<RamalDTO> searchByLogin(String login);
    
    List<RamalDTO> searchByNumero(String numero);

    
}
