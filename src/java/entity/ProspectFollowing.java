/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kaled
 */
@Entity
@Table(name = "prospect_following")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProspectFollowing.findAll", query = "SELECT p FROM ProspectFollowing p"),
    @NamedQuery(name = "ProspectFollowing.findById", query = "SELECT p FROM ProspectFollowing p WHERE p.id = :id"),
    @NamedQuery(name = "ProspectFollowing.findByProspect", query = "SELECT p FROM ProspectFollowing p WHERE p.prospect.id = :id ORDER BY p.fecha"),
    @NamedQuery(name = "ProspectFollowing.findByFecha", query = "SELECT p FROM ProspectFollowing p WHERE p.fecha = :fecha"),
    @NamedQuery(name = "ProspectFollowing.findByDescripcion", query = "SELECT p FROM ProspectFollowing p WHERE p.descripcion = :descripcion")})

public class ProspectFollowing implements Serializable, EntityIdUUID  {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "prospect", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Prospect prospect;

    public ProspectFollowing() {
    }

    public ProspectFollowing(String id) {
        this.id = id;
    }

    public ProspectFollowing(String id, Date fecha, String descripcion) {
        this.id = id;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public ProspectFollowing(String id, Date fecha, String descripcion, Prospect prospect) {
        this.id = id;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.prospect = prospect;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Prospect getProspect() {
        return prospect;
    }

    public void setProspect(Prospect prospect) {
        this.prospect = prospect;
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
        if (!(object instanceof ProspectFollowing)) {
            return false;
        }
        ProspectFollowing other = (ProspectFollowing) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ProspectFollowing[ id=" + id + " ]";
    }
    
}
