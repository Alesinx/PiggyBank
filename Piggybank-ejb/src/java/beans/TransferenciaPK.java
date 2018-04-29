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
public class TransferenciaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "IBAN_destino")
    private String iBANdestino;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Usuario_dni")
    private String usuariodni;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private int id;

    public TransferenciaPK() {
    }

    public TransferenciaPK(String iBANdestino, String usuariodni, int id) {
        this.iBANdestino = iBANdestino;
        this.usuariodni = usuariodni;
        this.id = id;
    }

    public String getIBANdestino() {
        return iBANdestino;
    }

    public void setIBANdestino(String iBANdestino) {
        this.iBANdestino = iBANdestino;
    }

    public String getUsuariodni() {
        return usuariodni;
    }

    public void setUsuariodni(String usuariodni) {
        this.usuariodni = usuariodni;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iBANdestino != null ? iBANdestino.hashCode() : 0);
        hash += (usuariodni != null ? usuariodni.hashCode() : 0);
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransferenciaPK)) {
            return false;
        }
        TransferenciaPK other = (TransferenciaPK) object;
        if ((this.iBANdestino == null && other.iBANdestino != null) || (this.iBANdestino != null && !this.iBANdestino.equals(other.iBANdestino))) {
            return false;
        }
        if ((this.usuariodni == null && other.usuariodni != null) || (this.usuariodni != null && !this.usuariodni.equals(other.usuariodni))) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.TransferenciaPK[ iBANdestino=" + iBANdestino + ", usuariodni=" + usuariodni + ", id=" + id + " ]";
    }
    
}
