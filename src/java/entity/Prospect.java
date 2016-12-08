/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kaled
 */
@Entity
@Table(name = "prospect")
@Cacheable(false)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prospect.findAll", query = "SELECT p FROM Prospect p ORDER BY p.applyDate DESC"),
    @NamedQuery(name = "Prospect.findById", query = "SELECT p FROM Prospect p WHERE p.id = :id"),
    @NamedQuery(name = "Prospect.findByName", query = "SELECT p FROM Prospect p WHERE p.name = :name"),
    @NamedQuery(name = "Prospect.findByLastname", query = "SELECT p FROM Prospect p WHERE p.lastname = :lastname"),
    @NamedQuery(name = "Prospect.findByEmail", query = "SELECT p FROM Prospect p WHERE p.email = :email"),
    @NamedQuery(name = "Prospect.findByPhone", query = "SELECT p FROM Prospect p WHERE p.phone = :phone"),
    @NamedQuery(name = "Prospect.findByProsecuted", query = "SELECT p FROM Prospect p WHERE p.prosecuted = :prosecuted AND p.deleteLogical = :deleteLogical ORDER BY p.applyDate DESC"),
    @NamedQuery(name = "Prospect.findBySendNotification", query = "SELECT p FROM Prospect p WHERE p.sendNotification = :sendNotification"),
    @NamedQuery(name = "Prospect.findByApplyDate", query = "SELECT p FROM Prospect p WHERE p.applyDate = :applyDate"),
    @NamedQuery(name = "Prospect.findByComment", query = "SELECT p FROM Prospect p WHERE p.comment = :comment"),
    @NamedQuery(name = "Prospect.findByCourse", query = "SELECT p FROM Prospect p WHERE p.course = :course"),
    @NamedQuery(name = "Prospect.findByDeleteLogical", query = "SELECT p FROM Prospect p WHERE p.deleteLogical = :deleteLogical ORDER BY p.applyDate DESC")})
public class Prospect implements Serializable, EntityIdUUID {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "id")
    private String id;
    @Size(max = 40)
    @Column(name = "name")
    private String name;
    @Size(max = 40)
    @Column(name = "lastname")
    private String lastname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 30)
    @Column(name = "email")
    private String email;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "phone")
    private String phone;
    @Column(name = "prosecuted")
    private Boolean prosecuted;
    @Column(name = "send_notification")
    private Boolean sendNotification;
    @Size(max = 30)
    @Column(name = "apply_date")
    private String applyDate;
    @Size(max = 30)
    @Column(name = "calendar_contact")
    private String calendarContact;
    @Size(max = 2000)
    @Column(name = "comment")
    private String comment;
    @Column(name = "delete_logical")
    private Boolean deleteLogical;
    @JoinColumn(name = "course", referencedColumnName = "id")
    @ManyToOne
    private Course course;
    @JoinColumn(name = "prospect_type", referencedColumnName = "id")
    @ManyToOne
    private ProspectType prospectType;
    
    public Prospect() {
    }

    public Prospect(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getProsecuted() {
        return prosecuted;
    }

    public void setProsecuted(Boolean prosecuted) {
        this.prosecuted = prosecuted;
    }

    public Boolean getSendNotification() {
        return sendNotification;
    }

    public void setSendNotification(Boolean sendNotification) {
        this.sendNotification = sendNotification;
    }

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Boolean getDeleteLogical() {
        return deleteLogical;
    }

    public void setDeleteLogical(Boolean deleteLogical) {
        this.deleteLogical = deleteLogical;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getCalendarContact() {
        return calendarContact;
    }

    public void setCalendarContact(String calendarContact) {
        this.calendarContact = calendarContact;
    }

    public ProspectType getProspectType() {
        return prospectType;
    }

    public void setProspectType(ProspectType prospectType) {
        this.prospectType = prospectType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prospect)) {
            return false;
        }
        Prospect other = (Prospect) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Prospect[ id=" + id + " ]";
    }
    
    public String getFullName() {
        return name + " " + lastname;
    }
    
    
}
