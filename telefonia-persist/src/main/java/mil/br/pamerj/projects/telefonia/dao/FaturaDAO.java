package mil.br.pamerj.projects.telefonia.dao;

import java.util.Date;
import java.util.List;
import mil.br.pamerj.projects.telefonia.dto.FaturaDTO;

public interface FaturaDAO {

    void create(FaturaDTO ramal);

    FaturaDTO find(Long id);

    List<FaturaDTO> findAll();
    List<FaturaDTO> findAll(Date periodo);
    List<FaturaDTO> findAll(Date periodo, boolean aberto);
    
    List<FaturaDTO> findAllByLogin(String login);

    
    
    void remove(Long id);

    void update(FaturaDTO ramal);

 
}
