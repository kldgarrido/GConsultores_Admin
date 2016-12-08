/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package controller;

import entity.Prospect;
import entity.ProspectFollowing;
import facade.ProspectFacade;
import facade.ProspectFollowingFacade;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author kld
 */
@ManagedBean(name = "prospectDetailController")
@ViewScoped
public class ProspectDetailController extends AbstractController<Prospect> {
    
    @EJB
    private ProspectFacade ejbFacade;
    
    @EJB
    private ProspectFollowingFacade ejbProspectFollowingFacade;
    
    //New
    private Prospect detail;
    private List<ProspectFollowing> prospectFollowings;
    
    private Date newDate;
    private String newComent;
    
    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
        
        FacesContext fc = FacesContext.getCurrentInstance();
        getIdParam(fc);
        
        newDate= new Date();
        newComent = "";
    }
    
    public ProspectDetailController() {
        // Inform the Abstract parent controller of the concrete Prospect?cap_first Entity
        super(Prospect.class);
    }
    
    
    public void getIdParam(FacesContext fc){
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
        if(params.containsKey("id")){
            String id = params.get("id");
            detail = ejbFacade.find(id);
            updateProspectFollowings();
        }
    }
    
    private void updateProspectFollowings(){
        prospectFollowings = ejbProspectFollowingFacade.findForProspect(detail);
    }

    public Prospect getDetail() {
        return detail;
    }

    public List<ProspectFollowing> getProspectFollowings() {
        return prospectFollowings;
    }
    
    public void saveProspectFollowing(){
        ejbProspectFollowingFacade.create(newDate, newComent, detail);
        updateProspectFollowings();
        newDate= new Date();
        newComent = "";
    }

    public Date getNewDate() {
        return newDate;
    }

    public void setNewDate(Date newDate) {
        this.newDate = newDate;
    }

    public String getNewComent() {
        return newComent;
    }

    public void setNewComent(String newComent) {
        this.newComent = newComent;
    }
    
    
    
}
