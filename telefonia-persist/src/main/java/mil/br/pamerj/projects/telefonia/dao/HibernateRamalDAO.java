/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.br.pamerj.projects.telefonia.dao;

import java.util.ArrayList;
import java.util.List;

import mil.br.pamerj.projects.telefonia.dto.RamalDTO;

import mil.br.pamerj.projects.telefonia.model.Ramal;
import mil.br.pamerj.projects.telefonia.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author fernandofot
 */
public class HibernateRamalDAO implements RamalDAO {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public HibernateRamalDAO() {
        super();
    }

    @Override
    public void create(RamalDTO ramal) {
        Ramal _ramal = new Ramal(ramal);
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(_ramal);
        tx.commit();
        session.close();

    }
     @Override
    public void createAll(List<RamalDTO> ramais) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
       
        for (RamalDTO ramal : ramais) {

            session.save(ramal);
        }
        
        
        tx.commit();
        session.close();

    }

    @Override
    public RamalDTO find(Long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Ramal ramal = (Ramal) session.get(Ramal.class, id);
        tx.commit();
        if (ramal != null) {
            ramal.getLigacoes().size();
            ramal.getFaturas().size();
        }
        session.close();
        return ramal.createDTO();
    }

    @Override
    public List<RamalDTO> findAll() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<Ramal> ramais = session.createQuery("from Ramal ramal order by ramal.numero").list();
        tx.commit();
        session.close();
        List<RamalDTO> dto = Ramal.createDTO(ramais);
 
        return dto;
    }

    @Override
    public void remove(Long id) {
        Ramal ramal = new Ramal(find(id));
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(ramal);
        tx.commit();
        session.close();

    }

    @Override
    public void update(RamalDTO ramal) {
        Ramal _ramal = new Ramal(ramal);
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(_ramal);
        tx.commit();
        session.close();

    }

    @Override
    public RamalDTO findByNumero(String numero) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Ramal ramal = (Ramal) session.createQuery("from Ramal as ramal where ramal.numero='" + numero + "'").uniqueResult();
        if (ramal != null) {
            ramal.getLigacoes().size();
            ramal.getFaturas().size();
        }
        tx.commit();
        session.close();

        if (ramal != null) {
            return ramal.createDTO();
        } else {
            return null;
        }

    }

    @Override
    public List<RamalDTO> findByLogin(String login) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<Ramal> ramais = session.createQuery("from Ramal ramal where ramal.login ='"
                + login + "' order by ramal.id").list();
        tx.commit();
        session.close();
        List<RamalDTO> dto = Ramal.createDTO(ramais);
        return dto;
    }

    @Override
    public List<RamalDTO> searchByLogin(String login) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<Ramal> ramais = session.createQuery("from Ramal ramal where ramal.login like '%"
                + login + "%' order by ramal.id").list();
        tx.commit();
        session.close();
        List<RamalDTO> dto = Ramal.createDTO(ramais);
        return dto;
    }

    @Override
    public List<RamalDTO> searchByNumero(String numero) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<Ramal> ramais = session.createQuery("from Ramal ramal where ramal.numero like '%"
                + numero + "%' order by ramal.id").list();
        tx.commit();
        session.close();
        List<RamalDTO> dto = Ramal.createDTO(ramais);
        return dto;
    }
}
