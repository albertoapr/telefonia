package mil.br.pamerj.projects.telefonia.dao;

import java.util.List;
import mil.br.pamerj.projects.telefonia.dto.AdminUserDTO;

public interface AdminUserDAO {

    void create(AdminUserDTO ramal);

    AdminUserDTO find(Long id);
    
    AdminUserDTO find(String login);

    List<AdminUserDTO> findAll();

    void remove(Long id);

    void update(AdminUserDTO ramal);
}
