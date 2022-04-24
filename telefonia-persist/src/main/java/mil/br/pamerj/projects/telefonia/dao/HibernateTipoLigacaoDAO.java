/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.br.pamerj.projects.telefonia.dao;

import java.util.ArrayList;
import java.util.List;
import mil.br.pamerj.projects.telefonia.dto.TipoLigacaoDTO;
import mil.br.pamerj.projects.telefonia.model.TipoLigacao;
import mil.br.pamerj.projects.telefonia.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author fernandofot
 */
public class HibernateTipoLigacaoDAO implements TipoLigacaoDAO {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public HibernateTipoLigacaoDAO() {
        super();
    }

    @Override
    public void create(TipoLigacaoDTO tipoLigacao) {
        TipoLigacao _tipoLigacao = new TipoLigacao(tipoLigacao);
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(_tipoLigacao);
        tx.commit();
        session.close();

    }

    @Override
    public TipoLigacaoDTO find(Long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        TipoLigacao tipoLigacao = (TipoLigacao) session.get(TipoLigacao.class, id);
        tx.commit();
        session.close();
        return tipoLigacao.createDTO();
    }

    @Override
    public List<TipoLigacaoDTO> findAll() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<TipoLigacao> ramais = session.createQuery("from TipoLigacao tipoLigacao order by tipoLigacao.id").list();
        tx.commit();
        session.close();
        List<TipoLigacaoDTO> dto = new ArrayList<TipoLigacaoDTO>();
        for (TipoLigacao tipoLigacao : ramais) {
            dto.add(tipoLigacao.createDTO());
        }
        return dto;
    }

    @Override
    public void remove(Long id) {
        TipoLigacao tipoLigacao = new TipoLigacao(find(id));
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(tipoLigacao);
        tx.commit();
        session.close();

    }

    @Override
    public void update(TipoLigacaoDTO tipoLigacao) {
        TipoLigacao _tipoLigacao = new TipoLigacao();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(_tipoLigacao);
        tx.commit();
        session.close();

    }
}
