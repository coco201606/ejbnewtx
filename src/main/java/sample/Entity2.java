/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author kaohashi
 */
@Entity
@NamedQueries({
    @NamedQuery(name = Entity2.FIND_ALL, query = "SELECT e FROM Entity2 e"),
    @NamedQuery(name = Entity2.DELETE_ALL, query = "DELETE FROM Entity2 e")
})
public class Entity2 implements Serializable {

    public static final String FIND_ALL = "Entty2.FIND_ALL";
    public static final String DELETE_ALL = "Entty2.DELETE_ALL";
    private static final long serialVersionUID = 1L;
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String label;
    private transient boolean toBeRollbacked = false;

    public Entity2() {
    }

    public Entity2(long id, String label) {
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
        if (!(object instanceof Entity2)) {
            return false;
        }
        Entity2 other = (Entity2) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sample.Entity2[ id=" + id + " ]";
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

    public Entity2 generateException() {
        this.setToBeRollbacked(true);
        return this;
    }
}
