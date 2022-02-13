/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author kaohashi
 */
@Entity
@NamedQueries({
    @NamedQuery(name = Entity1.FIND_ALL, query = "SELECT e FROM Entity1 e"),
    @NamedQuery(name = Entity1.DELETE_ALL, query = "DELETE FROM Entity1 e")
})
public class Entity1 implements Serializable {

    public static final String FIND_ALL = "Entty1.FIND_ALL";
    public static final String DELETE_ALL = "Entty1.DELETE_ALL";
    private static final long serialVersionUID = 1L;
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String label;
    private transient boolean toBeRollbacked = false;

    public Entity1() {
    }

    public Entity1(long id, String label) {
        this.id = id;
        this.label = label;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Entity1)) {
            return false;
        }
        Entity1 other = (Entity1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sample.Entity1[ id=" + id + " ]";
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return the toBeRollbacked
     */
    public boolean isToBeRollbacked() {
        return toBeRollbacked;
    }

    /**
     * @param toBeRollbacked the toBeRollbacked to set
     */
    public void setToBeRollbacked(boolean toBeRollbacked) {
        this.toBeRollbacked = toBeRollbacked;
    }

    public Entity1 generateException() {
        this.setToBeRollbacked(true);
        return this;
    }
}
