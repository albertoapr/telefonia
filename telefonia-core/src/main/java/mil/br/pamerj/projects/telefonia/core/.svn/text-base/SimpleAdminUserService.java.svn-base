/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.br.pamerj.projects.telefonia.core;

import com.tomasio.projects.organization.webservices.NetworkUsersWS;
import com.tomasio.projects.organization.webservices.NetworkUsersWSService;
import java.util.List;
import mil.br.pamerj.projects.telefonia.api.AdminUserService;
import mil.br.pamerj.projects.telefonia.dao.AdminUserDAO;
import mil.br.pamerj.projects.telefonia.dao.DAOFactory;
import mil.br.pamerj.projects.telefonia.dao.PessoaDAO;
import mil.br.pamerj.projects.telefonia.dto.AdminUserDTO;
import mil.br.pamerj.projects.telefonia.dto.PessoaDTO;
import mil.br.pamerj.projects.telefonia.util.DAOUtil;

/**
 *
 * @author fernandofot
 */
public class SimpleAdminUserService implements AdminUserService{

    private static DAOFactory factory = DAOUtil.getDAOFactory();
    
    @Override
    public void createAdminUser(AdminUserDTO user) {
        AdminUserDAO dao = factory.getAdminUserDAO();
        dao.create(user);

    }

    @Override
    public void updateAdminUser(AdminUserDTO user) {
        AdminUserDAO dao = factory.getAdminUserDAO();
        dao.update(user);
    }

    @Override
    public void removeAdminUser(Long userId) {
        AdminUserDAO dao = factory.getAdminUserDAO();
        dao.remove(userId);
    }

    @Override
    public AdminUserDTO findAdminUser(Long userId) {
        AdminUserDAO dao = factory.getAdminUserDAO();
        return dao.find(userId);
    }
    

    @Override
    public List<AdminUserDTO> findAllAdminUsers() {
        AdminUserDAO dao = factory.getAdminUserDAO();
        return dao.findAll();
    }

    @Override
    public boolean login(String uid, String password) {
        NetworkUsersWSService service = new NetworkUsersWSService();
        NetworkUsersWS port = service.getNetworkUsersWSPort();
        return port.authenticate(uid, password);
    }

    @Override
    public List<String> findAllLogins() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public AdminUserDTO findAdminUser(String login) {
        AdminUserDAO dao = factory.getAdminUserDAO();
        return dao.find(login);
    }

    @Override
    public PessoaDTO findPessoa(String login) {
        PessoaDAO dao = factory.getPessoaDAO();
        return dao.find(login);
    }
    
}
