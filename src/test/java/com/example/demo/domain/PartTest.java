package com.example.demo.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Project: demoDarbyFrameworks2-master
 * Package: com.example.demo.domain
 * <p>
 * User: carolyn.sher
 * Date: 6/24/2022
 * Time: 3:44 PM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */




class PartTest {
    static Validator validator;
    Part partIn;
    Part partOut;
    @BeforeEach
    void setUp() {
        partIn=new InhousePart();
        partOut=new OutsourcedPart();
    }
    @BeforeEach
    void initValidator() {
        if (validator == null) {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            validator = factory.getValidator();
        }
    }

    @Test
    void getId() {
        Long idValue=4L;
        partIn.setId(idValue);
        assertEquals(partIn.getId(), idValue);
        partOut.setId(idValue);
        assertEquals(partOut.getId(), idValue);
    }

    @Test
    void setId() {
        Long idValue=4L;
        partIn.setId(idValue);
        assertEquals(partIn.getId(), idValue);
        partOut.setId(idValue);
        assertEquals(partOut.getId(), idValue);
    }

    @Test
    void getName() {
        String name="test inhouse part";
        partIn.setName(name);
        assertEquals(name,partIn.getName());
        name="test outsourced part";
        partOut.setName(name);
        assertEquals(name,partOut.getName());
    }

    @Test
    void setName() {
        String name="test inhouse part";
        partIn.setName(name);
        assertEquals(name,partIn.getName());
        name="test outsourced part";
        partOut.setName(name);
        assertEquals(name,partOut.getName());
    }

    @Test
    void getPrice() {
        double price=1.0;
        partIn.setPrice(price);
        assertEquals(price,partIn.getPrice());
        partOut.setPrice(price);
        assertEquals(price,partOut.getPrice());
    }

    @Test
    void setPrice() {
        double price=1.0;
        partIn.setPrice(price);
        assertEquals(price,partIn.getPrice());
        partOut.setPrice(price);
        assertEquals(price,partOut.getPrice());
    }

    @Test
    void getInv() {
        int inv=5;
        partIn.setInv(inv);
        assertEquals(inv,partIn.getInv());
        partOut.setInv(inv);
        assertEquals(inv,partOut.getInv());
    }

    @Test
    void setInv() {
        int inv=5;
        partIn.setInv(inv);
        assertEquals(inv,partIn.getInv());
        partOut.setInv(inv);
        assertEquals(inv,partOut.getInv());
    }

    @Test
    void getProducts() {
        Product product1= new Product();
        Product product2= new Product();
        Set<Product> myProducts= new HashSet<>();
        myProducts.add(product1);
        myProducts.add(product2);
        partIn.setProducts(myProducts);
        assertEquals(myProducts,partIn.getProducts());
        partOut.setProducts(myProducts);
        assertEquals(myProducts,partOut.getProducts());
    }

    @Test
    void setProducts() {
        Product product1= new Product();
        Product product2= new Product();
        Set<Product> myProducts= new HashSet<>();
        myProducts.add(product1);
        myProducts.add(product2);
        partIn.setProducts(myProducts);
        assertEquals(myProducts,partIn.getProducts());
        partOut.setProducts(myProducts);
        assertEquals(myProducts,partOut.getProducts());
    }

    @Test
    void testToString() {
        String name="test inhouse part";
        partIn.setName(name);
        assertEquals(name,partIn.toString());
        name="test outsourced part";
        partOut.setName(name);
        assertEquals(name,partOut.toString());
    }

    @Test
    void testEquals() {
        partIn.setId(1l);
        Part newPartIn=new InhousePart();
        newPartIn.setId(1l);
        assertEquals(partIn,newPartIn);
        partOut.setId(1l);
        Part newPartOut=new OutsourcedPart();
        newPartOut.setId(1l);
        assertEquals(partOut,newPartOut);

    }

    @Test
    void testHashCode() {
        partIn.setId(1l);
        partOut.setId(1l);
        assertEquals(partIn.hashCode(),partOut.hashCode());
    }
    @Test
    void inventoryBelowMin_shouldFailValidation() {
        InhousePart p = new InhousePart();
        p.setName("Test Part");
        p.setPrice(10.0);
        p.setMinInv(5);
        p.setMaxInv(10);
        p.setInv(4); // below min
        p.setPartId(111);

        Set<ConstraintViolation<InhousePart>> violations = validator.validate(p);

        assertFalse(violations.isEmpty(), "Expected validation errors when inv < minInv");

        // Optional: prove the error is related to inventory/min
        String messages = violations.stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(" | "));
        assertTrue(messages.toLowerCase().contains("minimum") || messages.toLowerCase().contains("min"),
                "Expected a message mentioning minimum/min. Actual: " + messages);
    }

    @Test
    void inventoryAboveMax_shouldFailValidation() {
        OutsourcedPart p = new OutsourcedPart();
        p.setName("Test Part");
        p.setPrice(10.0);
        p.setMinInv(1);
        p.setMaxInv(5);
        p.setInv(6); // above max
        p.setCompanyName("TestCo");

        Set<ConstraintViolation<OutsourcedPart>> violations = validator.validate(p);

        assertFalse(violations.isEmpty(), "Expected validation errors when inv > maxInv");

        // Optional: prove the error is related to inventory/max
        String messages = violations.stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(" | "));
        assertTrue(messages.toLowerCase().contains("maximum") || messages.toLowerCase().contains("max"),
                "Expected a message mentioning maximum/max. Actual: " + messages);
    }


}