/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.br.pamerj.projects.telefonia.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mil.br.pamerj.projects.telefonia.dto.FaturamentoDTO;
import mil.br.pamerj.projects.telefonia.model.Faturamento;
import mil.br.pamerj.projects.telefonia.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Fernando Tomasio
 */
public class HibernateFaturamentoDAO implements FaturamentoDAO {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public HibernateFaturamentoDAO() {
        super();
    }

    @Override
    public void create(FaturamentoDTO faturamento) {
        Faturamento _faturamento = new Faturamento(faturamento);
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(_faturamento);
        tx.commit();
        session.close();
        faturamento.setId(_faturamento.getId());


    }

    @Override
    public FaturamentoDTO find(Long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Faturamento faturamento = (Faturamento) session.get(Faturamento.class, id);
        tx.commit();
        if(faturamento != null){
            faturamento.getFaturas().size();
        }
        session.close();
        return faturamento.createDTO();
    }

    @Override
    public List<FaturamentoDTO> findAll() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<Faturamento> faturamentos = session.createQuery("from Faturamento faturamento order by faturamento.periodo DESC").list();
        tx.commit();
        session.close();
        List<FaturamentoDTO> dto = Faturamento.createDTO(faturamentos);
        return dto;
    }

    @Override
    public void remove(Long id) {
        Faturamento faturamento = new Faturamento(find(id));
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(faturamento);
        tx.commit();
        session.close();
    }

    @Override
    public void update(FaturamentoDTO faturamentol) {
        Faturamento _faturamento = new Faturamento();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(_faturamento);
        tx.commit();
        session.close();

    }

    @Override
    public FaturamentoDTO findFaturamentoByPeriodo(Date mes) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-");

        String _periodo = formatter.format(mes);

        Faturamento faturamento = (Faturamento) session.createQuery("from Faturamento faturamento where faturamento.periodo like '"
                + _periodo + "%'").uniqueResult();
        tx.commit();
        if(faturamento != null){
            faturamento.getFaturas().size();
        }
        session.close();
        if (faturamento != null) {
            return faturamento.createDTO();
        } else {
            return null;
        }
    }
}
