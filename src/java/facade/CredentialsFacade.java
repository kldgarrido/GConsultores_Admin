/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Credentials;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author kaled
 */
@Stateless
public class CredentialsFacade extends AbstractFacade<Credentials> {
    @PersistenceContext(unitName = "GConsultoresAdminPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CredentialsFacade() {
        super(Credentials.class);
    }
    
}
