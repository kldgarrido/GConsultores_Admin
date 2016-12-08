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
@Table(name = "prospect_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProspectType.findAll", query = "SELECT p FROM ProspectType p"),
    @NamedQuery(name = "ProspectType.findById", query = "SELECT p FROM ProspectType p WHERE p.id = :id"),
    @NamedQuery(name = "ProspectType.findByName", query = "SELECT p FROM ProspectType p WHERE p.name = :name")})
public class ProspectType implements Serializable, EntityIdUUID
{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "prospectType")
    private Collection<Prospect> prospectCollection;

    public ProspectType() {
    }

    public ProspectType(String id) {
        this.id = id;
    }

    public ProspectType(String id, String name) {
        this.id = id;
        this.name = name;
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

    @XmlTransient
    public Collection<Prospect> getProspectCollection() {
        return prospectCollection;
    }

    public void setProspectCollection(Collection<Prospect> prospectCollection) {
        this.prospectCollection = prospectCollection;
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
        if (!(object instanceof ProspectType)) {
            return false;
        }
        ProspectType other = (ProspectType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ProspectType[ id=" + id + " ]";
    }
    
}
