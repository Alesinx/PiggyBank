/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author RetailAdmin
 */
@Embeddable
public class MovimientosPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Usuario_dni")
    private String usuariodni;

    public MovimientosPK() {
    }

    public MovimientosPK(int id, String usuariodni) {
        this.id = id;
        this.usuariodni = usuariodni;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuariodni() {
        return usuariodni;
    }

    public void setUsuariodni(String usuariodni) {
        this.usuariodni = usuariodni;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (usuariodni != null ? usuariodni.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovimientosPK)) {
            return false;
        }
        MovimientosPK other = (MovimientosPK) object;
        if (this.id != other.id) {
            return false;
        }
        if ((this.usuariodni == null && other.usuariodni != null) || (this.usuariodni != null && !this.usuariodni.equals(other.usuariodni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.MovimientosPK[ id=" + id + ", usuariodni=" + usuariodni + " ]";
    }
    
}
