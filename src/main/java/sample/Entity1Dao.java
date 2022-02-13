/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author kaohashi
 */
@RequestScoped
@Transactional(Transactional.TxType.MANDATORY)
public class Entity1Dao {

    @PersistenceContext(name = "samplePU")
    private transient EntityManager em;

    public void create(Entity1 e) {
        em.persist(e);
    }

    public List<Entity1> findAll() {
        return em.createNamedQuery(Entity1.FIND_ALL).getResultList();
    }

    public void deleteAll() {
        em.createNamedQuery(Entity1.DELETE_ALL).executeUpdate();
    }
}
