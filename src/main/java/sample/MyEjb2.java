/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.util.List;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

/**
 *
 * @author kaohashi
 */
@Stateless
public class MyEjb2 {

    @Resource
    private SessionContext ctx;

    @Inject
    Entity1Dao dao1;

    @Inject
    Entity2Dao dao2;

    public void create(Entity1 e1, Entity2 e2) {
        dao1.create(e1);
        try {
            ctx.getBusinessObject(getClass()).createEntity2(e2);
        } catch (RuntimeException ex) {
            System.out.println("Exception caught: " + ex.getClass().getSimpleName() + ", " + ex.getMessage());
        }
        if (e1.isToBeRollbacked()) {
            System.out.println("Exception at Entity1 processing.");
            throw new RuntimeException("Exception at Entity1 processing.");
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void createEntity2(Entity2 e) {
        dao2.create(e);
        if (e.isToBeRollbacked()) {
            System.out.println("Exception at Entity2 processing.");
            throw new RuntimeException("Exception at Entity2 processing.");
        }
    }

    public List<Entity1> findAllEntity1() {
        return dao1.findAll();
    }

    public List<Entity2> findAllEntity2() {
        return dao2.findAll();
    }

    public void deleteAllEntity1() {
        dao1.deleteAll();
    }

    public void deleteAllEntity2() {
        dao2.deleteAll();
    }
}
