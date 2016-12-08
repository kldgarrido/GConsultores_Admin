/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Prospect;
import helper.JodaTimeHelper;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Kaled
 */
@Stateless
public class ProspectFacade extends AbstractFacade<Prospect> {
    @PersistenceContext(unitName = "GConsultoresAdminPU")
    private EntityManager em;
    
    private JodaTimeHelper jodaTimeHelper = new JodaTimeHelper();

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProspectFacade() {
        super(Prospect.class);
    }
    
    @Override
    public List<Prospect> findAll(){
        Query query  = em.createNamedQuery("Prospect.findByDeleteLogical");
        query.setParameter("deleteLogical", false);
        return query.getResultList();
    }
    
    public List<Prospect> findAllNew(){
       Query query  = em.createNamedQuery("Prospect.findByProsecuted");
       query.setParameter("deleteLogical", false);
       query.setParameter("prosecuted", false);
       return query.getResultList();
    }
    
    @Override
    public void edit(Prospect entity) {
        entity.setProsecuted(false);
        entity.setSendNotification(true);
        entity.setDeleteLogical(false);
        entity.setApplyDate(jodaTimeHelper.calculateDateTime());
        super.edit(entity);
    }
    
}
