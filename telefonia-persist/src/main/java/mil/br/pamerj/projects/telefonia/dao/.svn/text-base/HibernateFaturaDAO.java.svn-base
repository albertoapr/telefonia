/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.br.pamerj.projects.telefonia.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import mil.br.pamerj.projects.telefonia.util.HibernateUtil;
import mil.br.pamerj.projects.telefonia.dto.FaturaDTO;
import mil.br.pamerj.projects.telefonia.model.Fatura;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author fernandofot
 */
public class HibernateFaturaDAO implements FaturaDAO {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public HibernateFaturaDAO() {
        super();
    }

    @Override
    public void create(FaturaDTO fatura) {
        Fatura _fatura = new Fatura(fatura);
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(_fatura);
        tx.commit();
        session.close();


    }

    @Override
    public FaturaDTO find(Long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Fatura fatura = (Fatura) session.get(Fatura.class, id);
        if (fatura != null) {
            fatura.getItems().size();;
        }
        tx.commit();
        session.close();
        //Collections.sort(fatura.getItems(), new ItemFaturaSort());

        if (fatura != null) {
            return fatura.createDTO();
        } else {
            return null;
        }
    }

    @Override
    public List<FaturaDTO> findAll() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<Fatura> faturas = session.createQuery("from Fatura fatura order by fatura.faturamento.periodo").list();
        tx.commit();
        session.close();
        List<FaturaDTO> dto = Fatura.createDTO(faturas);
        return dto;
    }

    @Override
    public void remove(Long id) {
        Fatura fatura = new Fatura(find(id));
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(fatura);
        tx.commit();
        session.close();
    }

    @Override
    public void update(FaturaDTO fatura) {
        Fatura _fatura = new Fatura(fatura);
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(_fatura);
        tx.commit();
        session.close();

    }

    @Override
    public List<FaturaDTO> findAllByLogin(String login) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<Fatura> faturas = session.createQuery("from Fatura fatura where fatura.ramal.login = '"
                + login + "' order by fatura.faturamento.periodo").list();
        tx.commit();
        for (Fatura fatura : faturas) {
            fatura.getItems().size();
        }
        session.close();
        List<FaturaDTO> dto = Fatura.createDTOFull(faturas);

        return dto;
    }

    @Override
    public List<FaturaDTO> findAll(Date periodo) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(periodo);
        int ultimoDiaNumero = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-");
        String _mes = formatter.format(periodo);
        String primeiroDia = _mes + "01";
        String ultimoDia = _mes + Integer.toString(ultimoDiaNumero);


        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();


        List<Fatura> faturas = session.createQuery("from Fatura fatura where "
                + " fatura.faturamento.periodo BETWEEN '" + primeiroDia + "' AND '" + ultimoDia
                + "'").list();
        //List<Ligacao> ligacoes = session.createQuery("from Ligacao ligacao where ligacao.dataHora like '" + _mes + "%' and ligacao.ramal.id = " + Long.toString(ramalId)).list();
        tx.commit();
        for (Fatura fatura : faturas) {
            fatura.getItems().size();
        }
        session.close();
        return Fatura.createDTOFull(faturas);

    }

    @Override
    public List<FaturaDTO> findAll(Date periodo, boolean aberto) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(periodo);
        int ultimoDiaNumero = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-");
        String _mes = formatter.format(periodo);
        String primeiroDia = _mes + "01";
        String ultimoDia = _mes + Integer.toString(ultimoDiaNumero);


        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();


        List<Fatura> faturas = session.createQuery("from Fatura fatura where " 
                + " fatura.aberto = " + aberto + " AND "
                + " fatura.faturamento.periodo BETWEEN '" + primeiroDia + "' AND '" + ultimoDia
                + "'").list();
        //List<Ligacao> ligacoes = session.createQuery("from Ligacao ligacao where ligacao.dataHora like '" + _mes + "%' and ligacao.ramal.id = " + Long.toString(ramalId)).list();
        tx.commit();
        for (Fatura fatura : faturas) {
            fatura.getItems().size();
        }
        session.close();
        return Fatura.createDTOFull(faturas);
    }
}
