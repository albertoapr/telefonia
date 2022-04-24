/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.br.pamerj.projects.telefonia.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import mil.br.pamerj.projects.telefonia.dto.RamalDTO;
import org.hibernate.Transaction;

import mil.br.pamerj.projects.telefonia.dto.LigacaoDTO;
import mil.br.pamerj.projects.telefonia.model.Ligacao;
import mil.br.pamerj.projects.telefonia.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author fernandofot
 */
public class HibernateLigacaoDAO implements LigacaoDAO {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public HibernateLigacaoDAO() {
        super();
    }
 
    /* inclusão de novo create para salvar uma lista de ligações*/
    @Override
    public void createAll(List<LigacaoDTO> ligacoes) {
        
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        for (LigacaoDTO ligacao : ligacoes) {
            
            //Ligacao _Ligacao = new Ligacao(ligacao);
            //session.save(_Ligacao);
            //session.save(new Ligacao(ligacao));
            //Alterado em 06/05/2013 por cv Dacta 1306 Alberto
            session.merge(new Ligacao(ligacao));
        }
        
        
        tx.commit();
        session.close();


    }
    
    @Override
    public void create(LigacaoDTO Ligacao) {
        Ligacao _Ligacao = new Ligacao(Ligacao);
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        
        session.save(_Ligacao);
        
        tx.commit();
        session.close();


    }

    @Override
    public LigacaoDTO find(Long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Ligacao ligacao = (Ligacao) session.get(Ligacao.class, id);
        tx.commit();
        session.close();
        return ligacao.createDTO();
    }

    @Override
    public List<LigacaoDTO> findAll() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        //Alterado por Cv Alberto em 10/10/12 
        // List<Ligacao> ligacoes = session.createQuery("from Ligacao ligacao order by ligacao.dataHora").list();
        List<Ligacao> ligacoes = session.createQuery("from Ligacao ligacao order by ligacao.id").list();
        tx.commit();
        session.close();
        List<LigacaoDTO> dto = new ArrayList<LigacaoDTO>();
        for (Ligacao ligacao : ligacoes) {
            dto.add(ligacao.createDTO());
        }
        return dto;
    }

    @Override
    public void remove(Long id) {
        Ligacao ligacao = new Ligacao(find(id));
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(ligacao);
        tx.commit();
        session.close();
    }

    @Override
    public void update(LigacaoDTO Ligacaol) {
        Ligacao _ligacao = new Ligacao();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(_ligacao);
        tx.commit();
        session.close();

    }

    @Override
    public List<LigacaoDTO> searchByLogin(String login) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<LigacaoDTO> searchByPeriodo(Date dataInicio, Date dateTermino) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<LigacaoDTO> searchByValor(double valor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<LigacaoDTO> findAll(Long ramalId, Date mes) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(mes);
        int ultimoDiaNumero = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-");
        String _mes = formatter.format(mes);
        String primeiroDia = _mes + "01";
        String ultimoDia = _mes + Integer.toString(ultimoDiaNumero);


        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();


        List<Ligacao> ligacoes = session.createQuery("from Ligacao ligacao"
                + " where ligacao.dataHora >= '" + primeiroDia + " 00:00:00' and ligacao.dataHora <='" + ultimoDia + " 23:59:59'"
                
                // + " ligacao.dataHora BETWEEN '" + primeiroDia + "' AND '" + ultimoDia "
              // + " ligacao.dataHora BETWEEN to_date('" + primeiroDia + " 00:00:00', 'DD/MM/YYYY hh:mm:ss') and to_date('" + ultimoDia + " 23:59:59', 'DD/MM/YYYY hh:mm:ss')"
                 
               + "  and ligacao.ramal.id = " + Long.toString(ramalId) + " order by ligacao.dataHora").list();
       // List<Ligacao> ligacoes = session.createQuery("from Ligacao ligacao where ligacao.dataHora like '" + _mes + "%' and ligacao.ramal.id = " + Long.toString(ramalId)).list();
        tx.commit();
        session.close();
        List<LigacaoDTO> dto = new ArrayList<LigacaoDTO>();
        for (Ligacao ligacao : ligacoes) {
            dto.add(ligacao.createDTO());
        }
        return dto;
    }

    @Override
    public List<LigacaoDTO> findAll(String login, Date mes) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(mes);
        int ultimoDiaNumero = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-");
        String _mes = formatter.format(mes);
        String primeiroDia = _mes + "01";
        String ultimoDia = _mes + Integer.toString(ultimoDiaNumero);


        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();


        List<Ligacao> ligacoes = session.createQuery("from Ligacao ligacao where "
                + " ligacao.dataHora BETWEEN '" + primeiroDia + "' AND '" + ultimoDia
                + "'  and ligacao.ramal.login = '" + login + "'").list();
        //List<Ligacao> ligacoes = session.createQuery("from Ligacao ligacao where ligacao.dataHora like '" + _mes + "%' and ligacao.ramal.id = " + Long.toString(ramalId)).list();
        tx.commit();
        session.close();
        List<LigacaoDTO> dto = new ArrayList<LigacaoDTO>();
        for (Ligacao ligacao : ligacoes) {
            dto.add(ligacao.createDTO());
        }
        return dto;
    }

    @Override
    public List<LigacaoDTO> findAll(Date dataInicio, Date dataTermino) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<LigacaoDTO> findAll(Date mes) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
        String _mes = formatter.format(mes);
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<Ligacao> ligacoes = session.createQuery("from Ligacao ligacao where ligacao.dataHora like '" + _mes + "%'").list();
        tx.commit();
        session.close();
        List<LigacaoDTO> dto = new ArrayList<LigacaoDTO>();
        for (Ligacao ligacao : ligacoes) {
            dto.add(ligacao.createDTO());
        }
        return dto;


    }

   
}
