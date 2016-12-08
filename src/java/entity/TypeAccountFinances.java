/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kaled
 */
@Entity
@Table(name = "type_account_finances")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypeAccountFinances.findAll", query = "SELECT t FROM TypeAccountFinances t"),
    @NamedQuery(name = "TypeAccountFinances.findById", query = "SELECT t FROM TypeAccountFinances t WHERE t.id = :id"),
    @NamedQuery(name = "TypeAccountFinances.findByNameAccount", query = "SELECT t FROM TypeAccountFinances t WHERE t.nameAccount = :nameAccount"),
    @NamedQuery(name = "TypeAccountFinances.findByPolarity", query = "SELECT t FROM TypeAccountFinances t WHERE t.polarity = :polarity")})
public class TypeAccountFinances implements Serializable, EntityIdUUID {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name_account")
    private String nameAccount;
    @Column(name = "polarity")
    private Integer polarity;

    public TypeAccountFinances() {
    }

    public TypeAccountFinances(String id) {
        this.id = id;
    }

    public TypeAccountFinances(String id, String nameAccount) {
        this.id = id;
        this.nameAccount = nameAccount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameAccount() {
        return nameAccount;
    }

    public void setNameAccount(String nameAccount) {
        this.nameAccount = nameAccount;
    }

    public Integer getPolarity() {
        return polarity;
    }

    public void setPolarity(Integer polarity) {
        this.polarity = polarity;
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
        if (!(object instanceof TypeAccountFinances)) {
            return false;
        }
        TypeAccountFinances other = (TypeAccountFinances) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TypeAccountFinances[ id=" + id + " ]";
    }
    
}
