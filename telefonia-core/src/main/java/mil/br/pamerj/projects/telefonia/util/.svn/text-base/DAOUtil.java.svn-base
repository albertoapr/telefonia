/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.br.pamerj.projects.telefonia.util;

import mil.br.pamerj.projects.telefonia.dao.DAOFactory;
import mil.br.pamerj.projects.telefonia.dao.HibernateDAOFactory;



/**
 *
 * @author fernandofot
 */
public class DAOUtil {

    private static final DAOFactory daoFactory = buildDAOFactory();

    private static DAOFactory buildDAOFactory() {
        return new HibernateDAOFactory();
    }

    public static DAOFactory getDAOFactory() {
        return daoFactory;
    }
}
