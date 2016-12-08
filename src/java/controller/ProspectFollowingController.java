package controller;

import entity.Prospect;
import entity.ProspectFollowing;
import facade.ProspectFollowingFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;

@ManagedBean(name = "prospectFollowingController")
@ViewScoped
public class ProspectFollowingController extends AbstractController<ProspectFollowing> {

    @EJB
    private ProspectFollowingFacade ejbFacade;
    private ProspectController prospectController;
    
    private String idProspect = "";

    /**
     * Initialize the concrete ProspectFollowing controller bean. The
     * AbstractController requires the EJB Facade object for most operations.
     * <p>
     * In addition, this controller also requires references to controllers for
     * parent entities in order to display their information from a context
     * menu.
     */
    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
        FacesContext context = FacesContext.getCurrentInstance();
        prospectController = context.getApplication().evaluateExpressionGet(context, "#{prospectController}", ProspectController.class);
        
//        String idProspect = (String) context.getAttributes().get("prospect");
//        context.get
//        System.out.println(idProspect);
        
//        Map<String, String> params =FacesContext.getCurrentInstance().
//                getExternalContext().getRequestParameterMap();
//        idProspect = params.get("prospect");
//        
//        this.setItems(null);
    }

    public ProspectFollowingController() {
        // Inform the Abstract parent controller of the concrete ProspectFollowing?cap_first Entity
        super(ProspectFollowing.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        prospectController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Prospect controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareProspect(ActionEvent event) {
        if (this.getSelected() != null && prospectController.getSelected() == null) {
            prospectController.setSelected(this.getSelected().getProspect());
        }
    }
    
//    @Override
//    public Collection<ProspectFollowing> getItems() {
//            FacesContext context = FacesContext.getCurrentInstance();
//            String idProspect = (String) context.getAttributes().get("prospect");
//            super.setItems(this.ejbFacade.findAllForProspect(idProspect));
//        return super.getItems();
//    }
    
//    public List<ProspectFollowing> findAll(){
//        if(idProspect.isEmpty()){
//            return ejbFacade.findAll();
//        }
//        else{
//            return ejbFacade.findAllForProspect(idProspect);
//        }
//    }
    
    
//    public void mySaveNew(Prospect prospect, ProspectFollowing prospectFollowing){
//        prospectFollowing.setProspect(prospect);
//        ejbFacade.edit(prospectFollowing);
//    }
    
    
//    public void mySaveNew(Prospect prospect){
//        System.out.println(prospect);
//    }
}
