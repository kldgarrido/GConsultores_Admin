package controller;

import controller.util.JsfUtil;
import entity.LogMoneyFluid;
import facade.LogMoneyFluidFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;

@ManagedBean(name = "logMoneyFluidController")
@ViewScoped
public class LogMoneyFluidController extends AbstractController<LogMoneyFluid> {
    
    @EJB
    private LogMoneyFluidFacade ejbFacade;
    private MoneyBoxController moneyBoxController;
    
    /**
     * Initialize the concrete LogMoneyFluid controller bean. The
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
        moneyBoxController = context.getApplication().evaluateExpressionGet(context, "#{moneyBoxController}", MoneyBoxController.class);
    }
    
    public LogMoneyFluidController() {
        // Inform the Abstract parent controller of the concrete LogMoneyFluid?cap_first Entity
        super(LogMoneyFluid.class);
    }
    
    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        moneyBoxController.setSelected(null);
    }
    
    /**
     * Sets the "selected" attribute of the MoneyBox controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareMoneyBox(ActionEvent event) {
        if (this.getSelected() != null && moneyBoxController.getSelected() == null) {
            moneyBoxController.setSelected(this.getSelected().getMoneyBox());
        }
    }
    
    public void create(LogMoneyFluid entity){
        ejbFacade.create(entity);
        JsfUtil.addSuccessMessage("Se creo el nuevo registro");
    }
}
