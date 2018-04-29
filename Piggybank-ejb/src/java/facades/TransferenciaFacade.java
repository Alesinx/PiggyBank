/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import beans.Transferencia;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author RetailAdmin
 */
@Stateless
public class TransferenciaFacade extends AbstractFacade<Transferencia> {

    @PersistenceContext(unitName = "Piggybank-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TransferenciaFacade() {
        super(Transferencia.class);
    }
    
}
