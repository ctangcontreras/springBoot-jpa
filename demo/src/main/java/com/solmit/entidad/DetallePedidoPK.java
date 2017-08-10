/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solmit.entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author DESARROLLO34
 */
@Embeddable
public class DetallePedidoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_detalle_pedido")
    private int idDetallePedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pedido")
    private int idPedido;

    public DetallePedidoPK() {
    }

    public DetallePedidoPK(int idDetallePedido, int idPedido) {
        this.idDetallePedido = idDetallePedido;
        this.idPedido = idPedido;
    }

    public int getIdDetallePedido() {
        return idDetallePedido;
    }

    public void setIdDetallePedido(int idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idDetallePedido;
        hash += (int) idPedido;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallePedidoPK)) {
            return false;
        }
        DetallePedidoPK other = (DetallePedidoPK) object;
        if (this.idDetallePedido != other.idDetallePedido) {
            return false;
        }
        if (this.idPedido != other.idPedido) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.solmit.entidad.DetallePedidoPK[ idDetallePedido=" + idDetallePedido + ", idPedido=" + idPedido + " ]";
    }
    
}
