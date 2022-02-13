/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.util.stream.Collectors;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author kaohashi
 */
@Named
@RequestScoped
public class MyBean {

    @Inject
    MyEjb1 ejb1;
    @Inject
    MyEjb2 ejb2;
    @Inject
    MyEjb3A ejb3a;
    @Inject
    MyEjb3B ejb3b;
    @Inject
    MyEjb4A ejb4a;
    @Inject
    MyCDIBean4B cdibean4b;
    @Inject
    MyCDIBean4A cdibean4a;

    public void doTestWithEjb1() {

        ejb1.deleteAllEntity1();
        ejb1.deleteAllEntity2();

        System.out.println("### Test1 (Entity1=Success, Entity2=Success)");
        try {
            ejb1.create(new Entity1(1L, "Test1"), new Entity2(1L, "Test1"));
        } catch (Exception ex) {
            System.out.println("Exception caught: " + ex.getMessage());
        }

        System.out.println("### Test2 (Entity1=Error, Entity2=Success)");
        try {
            ejb1.create((new Entity1(2L, "Test2")).generateException(), new Entity2(2L, "Test2"));
        } catch (Exception ex) {
            System.out.println("Exception caught: " + ex.getMessage());
        }

        System.out.println("### Test3 (Entity1=Success, Entity2=Error)");
        try {
            ejb1.create(new Entity1(3L, "Test3"), (new Entity2(3L, "Test3")).generateException());
        } catch (Exception ex) {
            System.out.println("Exception caught: " + ex.getMessage());
        }

        System.out.println("### Test4 (Entity1=Error, Entity2=Error)");
        try {
            ejb1.create(new Entity1(4L, "Test4").generateException(), (new Entity2(4L, "Test4")).generateException());
        } catch (Exception ex) {
            System.out.println("Exception caught: " + ex.getMessage());
        }

        System.out.println("### Results (EJB1)");
        System.out.println("Registered Entity1 -> " + ejb1.findAllEntity1().stream().map(e -> e.getLabel()).collect(Collectors.joining(",")));
        System.out.println("Registered Entity2 -> " + ejb1.findAllEntity2().stream().map(e -> e.getLabel()).collect(Collectors.joining(",")));
    }

    public void doTestWithEjb2() {

        ejb2.deleteAllEntity1();
        ejb2.deleteAllEntity2();

        System.out.println("### Test1 (Entity1=Success, Entity2=Success)");
        try {
            ejb2.create(new Entity1(1L, "Test1"), new Entity2(1L, "Test1"));
        } catch (Exception ex) {
            System.out.println("Exception caught: " + ex.getMessage());
        }

        System.out.println("### Test2 (Entity1=Error, Entity2=Success)");
        try {
            ejb2.create((new Entity1(2L, "Test2")).generateException(), new Entity2(2L, "Test2"));
        } catch (Exception ex) {
            System.out.println("Exception caught: " + ex.getMessage());
        }

        System.out.println("### Test3 (Entity1=Success, Entity2=Error)");
        try {
            ejb2.create(new Entity1(3L, "Test3"), (new Entity2(3L, "Test3")).generateException());
        } catch (Exception ex) {
            System.out.println("Exception caught: " + ex.getMessage());
        }

        System.out.println("### Test4 (Entity1=Error, Entity2=Error)");
        try {
            ejb2.create(new Entity1(4L, "Test4").generateException(), (new Entity2(4L, "Test4")).generateException());
        } catch (Exception ex) {
            System.out.println("Exception caught: " + ex.getMessage());
        }

        System.out.println("### Results (EJB2)");
        System.out.println("Registered Entity1 -> " + ejb2.findAllEntity1().stream().map(e -> e.getLabel()).collect(Collectors.joining(",")));
        System.out.println("Registered Entity2 -> " + ejb2.findAllEntity2().stream().map(e -> e.getLabel()).collect(Collectors.joining(",")));
    }

    public void doTestWithEjb3() {

        ejb3a.deleteAllEntity1();
        ejb3b.deleteAllEntity2();

        System.out.println("### Test1 (Entity1=Success, Entity2=Success)");
        try {
            ejb3a.create(new Entity1(1L, "Test1"), new Entity2(1L, "Test1"));
        } catch (Exception ex) {
            System.out.println("Exception caught: " + ex.getMessage());
        }

        System.out.println("### Test2 (Entity1=Error, Entity2=Success)");
        try {
            ejb3a.create((new Entity1(2L, "Test2")).generateException(), new Entity2(2L, "Test2"));
        } catch (Exception ex) {
            System.out.println("Exception caught: " + ex.getMessage());
        }

        System.out.println("### Test3 (Entity1=Success, Entity2=Error)");
        try {
            ejb3a.create(new Entity1(3L, "Test3"), (new Entity2(3L, "Test3")).generateException());
        } catch (Exception ex) {
            System.out.println("Exception caught: " + ex.getMessage());
        }

        System.out.println("### Test4 (Entity1=Error, Entity2=Error)");
        try {
            ejb3a.create(new Entity1(4L, "Test4").generateException(), (new Entity2(4L, "Test4")).generateException());
        } catch (Exception ex) {
            System.out.println("Exception caught: " + ex.getMessage());
        }

        System.out.println("### Results (EJB3)");
        System.out.println("Registered Entity1 -> " + ejb3a.findAllEntity1().stream().map(e -> e.getLabel()).collect(Collectors.joining(",")));
        System.out.println("Registered Entity2 -> " + ejb3b.findAllEntity2().stream().map(e -> e.getLabel()).collect(Collectors.joining(",")));
    }

    public void doTestWithEjb4() {

        ejb4a.deleteAllEntity1();
        cdibean4b.deleteAllEntity2();

        System.out.println("### Test1 (Entity1=Success, Entity2=Success)");
        try {
            ejb4a.create(new Entity1(1L, "Test1"), new Entity2(1L, "Test1"));
        } catch (Exception ex) {
            System.out.println("Exception caught: " + ex.getMessage());
        }

        System.out.println("### Test2 (Entity1=Error, Entity2=Success)");
        try {
            ejb4a.create((new Entity1(2L, "Test2")).generateException(), new Entity2(2L, "Test2"));
        } catch (Exception ex) {
            System.out.println("Exception caught: " + ex.getMessage());
        }

        System.out.println("### Test3 (Entity1=Success, Entity2=Error)");
        try {
            ejb4a.create(new Entity1(3L, "Test3"), (new Entity2(3L, "Test3")).generateException());
        } catch (Exception ex) {
            System.out.println("Exception caught: " + ex.getMessage());
        }

        System.out.println("### Test4 (Entity1=Error, Entity2=Error)");
        try {
            ejb4a.create(new Entity1(4L, "Test4").generateException(), (new Entity2(4L, "Test4")).generateException());
        } catch (Exception ex) {
            System.out.println("Exception caught: " + ex.getMessage());
        }

        System.out.println("### Results (EJB4)");
        System.out.println("Registered Entity1 -> " + ejb4a.findAllEntity1().stream().map(e -> e.getLabel()).collect(Collectors.joining(",")));
        System.out.println("Registered Entity2 -> " + cdibean4b.findAllEntity2().stream().map(e -> e.getLabel()).collect(Collectors.joining(",")));
    }
    
        public void doTestWithCDI1() {

        cdibean4a.deleteAllEntity1();
        cdibean4b.deleteAllEntity2();

        System.out.println("### Test1 (Entity1=Success, Entity2=Success)");
        try {
            cdibean4a.create(new Entity1(1L, "Test1"), new Entity2(1L, "Test1"));
        } catch (Exception ex) {
            System.out.println("Exception caught: " + ex.getMessage());
        }

        System.out.println("### Test2 (Entity1=Error, Entity2=Success)");
        try {
            cdibean4a.create((new Entity1(2L, "Test2")).generateException(), new Entity2(2L, "Test2"));
        } catch (Exception ex) {
            System.out.println("Exception caught: " + ex.getMessage());
        }

        System.out.println("### Test3 (Entity1=Success, Entity2=Error)");
        try {
            cdibean4a.create(new Entity1(3L, "Test3"), (new Entity2(3L, "Test3")).generateException());
        } catch (Exception ex) {
            System.out.println("Exception caught: " + ex.getMessage());
        }

        System.out.println("### Test4 (Entity1=Error, Entity2=Error)");
        try {
            cdibean4a.create(new Entity1(4L, "Test4").generateException(), (new Entity2(4L, "Test4")).generateException());
        } catch (Exception ex) {
            System.out.println("Exception caught: " + ex.getMessage());
        }

        System.out.println("### Results (CDI1)");
        System.out.println("Registered Entity1 -> " + cdibean4a.findAllEntity1().stream().map(e -> e.getLabel()).collect(Collectors.joining(",")));
        System.out.println("Registered Entity2 -> " + cdibean4b.findAllEntity2().stream().map(e -> e.getLabel()).collect(Collectors.joining(",")));
    }
}
