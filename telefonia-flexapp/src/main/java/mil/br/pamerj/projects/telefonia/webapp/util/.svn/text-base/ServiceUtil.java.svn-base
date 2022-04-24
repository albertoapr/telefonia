/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mil.br.pamerj.projects.telefonia.webapp.util;

import mil.br.pamerj.projects.telefonia.api.ServiceFactory;
import mil.br.pamerj.projects.telefonia.core.SimpleServiceFactory;

/**
 *
 * @author fernandofot
 */
public class ServiceUtil {
    private static final ServiceFactory serviceFactory = buildServiceFactory();
    private static ServiceFactory buildServiceFactory(){
        return new SimpleServiceFactory();
    }
    public static ServiceFactory getServiceFactory() {
        return serviceFactory;
    }
}
