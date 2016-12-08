/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.ProspectType;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Kaled
 */
@Stateless
public class ProspectTypeFacade extends AbstractFacade<ProspectType> {
    @PersistenceContext(unitName = "GConsultoresAdminPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProspectTypeFacade() {
        super(ProspectType.class);
    }
    
}
