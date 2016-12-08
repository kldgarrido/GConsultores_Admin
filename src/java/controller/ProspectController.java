package controller;

import entity.Prospect;
import entity.ProspectFollowing;
import facade.ProspectFacade;
import facade.ProspectFollowingFacade;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

@ManagedBean(name = "prospectController")
@ViewScoped
public class ProspectController extends AbstractController<Prospect> {
    
    @EJB
    private ProspectFacade ejbFacade;
    
    @EJB
    private ProspectFollowingFacade ejbProspectFollowingFacade;
    
    List<Prospect> newProspects;
    
    
    
    private Date fechaNewProspectFollowings;
    private String descripcionNewProspectFollowings;
    
    
    //New
    private Prospect detail;
    private List<ProspectFollowing> prospectFollowings;
    
    /**
     * Initialize the concrete Prospect controller bean. The AbstractController
     * requires the EJB Facade object for most operations.
     */
    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
        newProspects = ejbFacade.findAllNew();
        
        FacesContext fc = FacesContext.getCurrentInstance();
	getIdParam(fc);
        
    }
    
    public ProspectController() {
        // Inform the Abstract parent controller of the concrete Prospect?cap_first Entity
        super(Prospect.class);
    }
    
    public List<Prospect> getNewProspects() {
        return newProspects;
    }
    
    public void prosecutedAction(Prospect select){
        select.setProsecuted(!select.getProsecuted());
        ejbFacade.edit(select);
    }
    
    public List<ProspectFollowing> findProspectFollowing(Prospect select){
        if(select!=null){
            return ejbProspectFollowingFacade.
                    findAllForProspect(select.getId());
        }
        return new ArrayList<ProspectFollowing>();
    }
    
    public List<ProspectFollowing> getProspectFollowings() {
        return prospectFollowings;
    }
    
    public void createProspectFollowing(Prospect prospect){
        ProspectFollowing prospectFollowing = new ProspectFollowing();
        prospectFollowing.setId(UUID.randomUUID().toString());
        prospectFollowing.setFecha(fechaNewProspectFollowings);
        prospectFollowing.setDescripcion(descripcionNewProspectFollowings);
        prospectFollowing.setProspect(prospect);
        ejbProspectFollowingFacade.edit(prospectFollowing);
    }
    
    public void setFechaNewProspectFollowings(Date fechaNewProspectFollowings) {
        this.fechaNewProspectFollowings = fechaNewProspectFollowings;
    }
    
    public void setDescripcionNewProspectFollowings(String descripcionNewProspectFollowings) {
        this.descripcionNewProspectFollowings = descripcionNewProspectFollowings;
    }
    
    public Date getFechaNewProspectFollowings() {
        return fechaNewProspectFollowings;
    }
    
    public String getDescripcionNewProspectFollowings() {
        return descripcionNewProspectFollowings;
    }
    
    public void resetParents() {
    }
    
    public Prospect prepareCreate() {
        Prospect newItem = new Prospect();
        super.setSelected(newItem);
        initializeEmbeddableKey();
        return newItem;
    }
    
      public void getIdParam(FacesContext fc){
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
        if(params.containsKey("id")){
            String id = params.get("id");
            detail = ejbFacade.find(id);
            prospectFollowings = ejbProspectFollowingFacade.findForProspect(detail);
        }
    }
    
}
