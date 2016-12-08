package controller;

import entity.ProspectType;
import facade.ProspectTypeFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;

@ManagedBean(name = "prospectTypeController")
@ViewScoped
public class ProspectTypeController extends AbstractController<ProspectType> {

    @EJB
    private ProspectTypeFacade ejbFacade;

    /**
     * Initialize the concrete ProspectType controller bean. The
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
    }

    public ProspectTypeController() {
        // Inform the Abstract parent controller of the concrete ProspectType?cap_first Entity
        super(ProspectType.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Prospect entities that
     * are retrieved from ProspectType?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Prospect page
     */
    public String navigateProspectCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Prospect_items", this.getSelected().getProspectCollection());
        }
        return "/prospect/index";
    }

}
