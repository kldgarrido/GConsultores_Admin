package controller;

import entity.Groups;
import facade.GroupsFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;

@ManagedBean(name = "groupsController")
@ViewScoped
public class GroupsController extends AbstractController<Groups> {

    @EJB
    private GroupsFacade ejbFacade;
    private CredentialsController usernameController;

    /**
     * Initialize the concrete Groups controller bean. The AbstractController
     * requires the EJB Facade object for most operations.
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
        usernameController = context.getApplication().evaluateExpressionGet(context, "#{credentialsController}", CredentialsController.class);
    }

    public GroupsController() {
        // Inform the Abstract parent controller of the concrete Groups?cap_first Entity
        super(Groups.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        usernameController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Credentials controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareUsername(ActionEvent event) {
        if (this.getSelected() != null && usernameController.getSelected() == null) {
            usernameController.setSelected(this.getSelected().getUsername());
        }
    }
}
