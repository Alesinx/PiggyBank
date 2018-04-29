/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import beans.Movimientos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author RetailAdmin
 */
@Stateless
public class MovimientosFacade extends AbstractFacade<Movimientos> {

    @PersistenceContext(unitName = "Piggybank-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MovimientosFacade() {
        super(Movimientos.class);
    }
    
}
