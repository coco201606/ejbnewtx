/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

/**
 *
 * @author kaohashi
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class MyEjb3B {

    @Inject
    Entity2Dao dao2;

    public void createEntity2(Entity2 e) {
        dao2.create(e);
        if (e.isToBeRollbacked()) {
            System.out.println("Exception at Entity2 processing.");
            throw new RuntimeException("Exception at Entity2 processing.");
        }
    }

    public List<Entity2> findAllEntity2() {
        return dao2.findAll();
    }

    public void deleteAllEntity2() {
        dao2.deleteAll();
    }
}
