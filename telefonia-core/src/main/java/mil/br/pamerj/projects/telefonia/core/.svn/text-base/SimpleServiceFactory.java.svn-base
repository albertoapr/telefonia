/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mil.br.pamerj.projects.telefonia.core;

import mil.br.pamerj.projects.telefonia.api.AdminUserService;
import mil.br.pamerj.projects.telefonia.api.LigacaoService;
import mil.br.pamerj.projects.telefonia.api.ServiceFactory;



/**
 *
 * @author fernandofot
 */
public class SimpleServiceFactory implements ServiceFactory{

    @Override
    public LigacaoService getLigacaoService() {
       return new SimpleLigacaoService();
    }

    @Override
    public AdminUserService getAdminUserService() {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
