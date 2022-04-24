/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.br.pamerj.projects.telefonia.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author fernandofot
 */
public class HibernateDAOFactory extends DAOFactory {

    ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

    @Override
    public LigacaoDAO getLigacaoDAO() {
        return (LigacaoDAO) context.getBean("ligacaoDAO");
    }

    @Override
    public TipoLigacaoDAO getTipoLigacaoDAO() {
        return (TipoLigacaoDAO) context.getBean("tipoLigacaoDAO");
    }
    @Override
    public RamalDAO getRamalDAO() {
        return (RamalDAO) context.getBean("ramalDAO");
    }

    @Override
    public PessoaDAO getPessoaDAO() {
        return (PessoaDAO) context.getBean("pessoaDAO");
    }

   
    @Override
    public ConfigDAO getConfigDAO() {
        return (ConfigDAO) context.getBean("configDAO");
    }

    @Override
    public FaturaDAO getFaturaDAO() {
        return (FaturaDAO) context.getBean("faturaDAO");
    }

    @Override
    public AdminUserDAO getAdminUserDAO() {
        return (AdminUserDAO) context.getBean("adminUserDAO");
    }

    @Override
    public FaturamentoDAO getFaturamentoDAO() {
         return (FaturamentoDAO) context.getBean("faturamentoDAO");
    }

    
}
