package controller;

import controller.util.JsfUtil;
import entity.MoneyBox;
import facade.MoneyBoxFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.annotation.PostConstruct;

@ManagedBean(name = "moneyBoxController")
@ViewScoped
public class MoneyBoxController extends AbstractController<MoneyBox> {
    
    @EJB
    private MoneyBoxFacade ejbFacade;
    
    /**
     * Initialize the concrete MoneyBox controller bean. The AbstractController
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
    }
    
    public MoneyBoxController() {
        // Inform the Abstract parent controller of the concrete MoneyBox?cap_first Entity
        super(MoneyBox.class);
    }
    
    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }
    
    /**
     * Sets the "items" attribute with a collection of LogMoneyFluid entities
     * that are retrieved from MoneyBox?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for LogMoneyFluid page
     */
    public String navigateLogMoneyFluidCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("LogMoneyFluid_items", this.getSelected().getLogMoneyFluidCollection());
        }
        return "/logMoneyFluid/index";
    }
    
    public void create(MoneyBox entity){
        ejbFacade.create(entity);
        JsfUtil.addSuccessMessage("Se creo el nuevo registro");
    }
    
}
