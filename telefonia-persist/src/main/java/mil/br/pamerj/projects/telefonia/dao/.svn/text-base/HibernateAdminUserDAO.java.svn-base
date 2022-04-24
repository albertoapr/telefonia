/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.br.pamerj.projects.telefonia.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Transaction;
import mil.br.pamerj.projects.telefonia.dto.AdminUserDTO;
import mil.br.pamerj.projects.telefonia.model.AdminUser;
import mil.br.pamerj.projects.telefonia.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author fernandofot
 */
public class HibernateAdminUserDAO implements AdminUserDAO {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public HibernateAdminUserDAO() {
        super();
    }

    @Override
    public void create(AdminUserDTO adminUser) {
        AdminUser _adminUser = new AdminUser(adminUser);
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(_adminUser);
        tx.commit();
        session.close();
    }

    @Override
    public AdminUserDTO find(Long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        AdminUser adminUser = (AdminUser) session.get(AdminUser.class, id);
        tx.commit();
        session.close();
        return adminUser.createDTO();
    }

    @Override
    public List<AdminUserDTO> findAll() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<AdminUser> adminUsers = session.createQuery("from AdminUser adminUser order by adminUser.id").list();
        tx.commit();
        session.close();
        List<AdminUserDTO> dto = new ArrayList<AdminUserDTO>();
        for (AdminUser adminUser : adminUsers) {
            dto.add(adminUser.createDTO());
        }
        return dto;
    }

    @Override
    public void remove(Long id) {
        AdminUser adminUser = new AdminUser(find(id));
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(adminUser);
        tx.commit();
        session.close();
    }

    @Override
    public void update(AdminUserDTO user) {
        AdminUser _adminUser = new AdminUser(user);
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(_adminUser);
        tx.commit();
        session.close();
    }

    @Override
    public AdminUserDTO find(String login) {
       Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        AdminUser adminUser = (AdminUser) session.createQuery(
                "from AdminUser adminUser where adminUser.login = '" + login + "'").uniqueResult();
        tx.commit();
        session.close();
        if(adminUser != null){
            return adminUser.createDTO();
                    
        }else{
            return null;
        }

    }
}
