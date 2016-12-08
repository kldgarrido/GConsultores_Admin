package controller;

import controller.util.JsfUtil;
import entity.TrasactionFinances;
import entity.TypeAccountFinances;
import facade.TrasactionFinancesFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;

@ManagedBean(name = "trasactionFinancesController")
@ViewScoped
public class TrasactionFinancesController extends AbstractController<TrasactionFinances> {

    @EJB
    private TrasactionFinancesFacade ejbFacade;
    private AccountFinancesController accountController;

    /**
     * Initialize the concrete TrasactionFinances controller bean. The
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
        accountController = context.getApplication().evaluateExpressionGet(context, "#{accountFinancesController}", AccountFinancesController.class);
    }

    public TrasactionFinancesController() {
        // Inform the Abstract parent controller of the concrete TrasactionFinances?cap_first Entity
        super(TrasactionFinances.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        accountController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the AccountFinances controller in order
     * to display its data in a dialog. This is reusing existing the existing
     * View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareAccount(ActionEvent event) {
        if (this.getSelected() != null && accountController.getSelected() == null) {
            accountController.setSelected(this.getSelected().getAccount());
        }
    }
    
    public void create(TrasactionFinances entity){
        ejbFacade.create(entity);
        JsfUtil.addSuccessMessage("Se creo el nuevo registro");
    }

    void mySaveNew(TrasactionFinances trasactionFinances) {
        ejbFacade.create(trasactionFinances);
    }
}
