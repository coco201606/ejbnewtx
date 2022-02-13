/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author kaohashi
 */
@Stateless
public class MyEjb3A {

    @Inject
    private MyEjb3B ejbref;

    @Inject
    Entity1Dao dao1;

    public void create(Entity1 e1, Entity2 e2) {
        dao1.create(e1);
        try {
            ejbref.createEntity2(e2);
        } catch (RuntimeException ex) {
            System.out.println("Exception caught: " + ex.getClass().getSimpleName() + ", " + ex.getMessage());
        }
        if (e1.isToBeRollbacked()) {
            System.out.println("Exception at Entity1 processing.");
            throw new RuntimeException("Exception at Entity1 processing.");
        }
    }

    public List<Entity1> findAllEntity1() {
        return dao1.findAll();
    }

    public void deleteAllEntity1() {
        dao1.deleteAll();
    }

}
