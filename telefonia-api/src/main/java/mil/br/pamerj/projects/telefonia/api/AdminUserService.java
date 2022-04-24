package mil.br.pamerj.projects.telefonia.api;

import java.util.List;
import mil.br.pamerj.projects.telefonia.dto.AdminUserDTO;
import mil.br.pamerj.projects.telefonia.dto.PessoaDTO;

public interface AdminUserService {

    void createAdminUser(AdminUserDTO user);

    void updateAdminUser(AdminUserDTO user);

    void removeAdminUser(Long userId);

    AdminUserDTO findAdminUser(Long userId);
    
    AdminUserDTO findAdminUser(String login);

    List<AdminUserDTO> findAllAdminUsers();

    boolean login(String uid, String password);
    
    List<String> findAllLogins();
    
    PessoaDTO findPessoa(String login);

    
}
