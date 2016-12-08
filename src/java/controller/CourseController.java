package controller;

import entity.Course;
import facade.CourseFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.annotation.PostConstruct;

@ManagedBean(name = "courseController")
@ViewScoped
public class CourseController extends AbstractController<Course> {

    @EJB
    private CourseFacade ejbFacade;

    /**
     * Initialize the concrete Course controller bean. The AbstractController
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

    public CourseController() {
        // Inform the Abstract parent controller of the concrete Course?cap_first Entity
        super(Course.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Prospect entities that
     * are retrieved from Course?cap_first and returns the navigation outcome.
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
