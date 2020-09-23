package ru.ssau.tk.abrosimovamargo.sandbox.dopysk;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PersonTest {

    Person Berezina = new Person("Svetlana",172, 70);
    Person Abrosimova = new Person("Margo",158, 44);

    @Test
    public void testGetName() {
        assertEquals(Berezina.name, "Svetlana");
        assertEquals(Abrosimova.name, "Margo");
    }

    @Test
    public void testGetHeight() {
        assertEquals(Berezina.height, 172.0);
        assertEquals(Abrosimova.height, 158.0);
    }

    @Test
    public void testGetWeight() {
        assertEquals(Berezina.weight, 70.0);
        assertEquals(Abrosimova.weight, 44.0);
    }

    @Test
    public void testSetName() {
        assertEquals(Berezina.name, "Svetlana");
        assertEquals(Abrosimova.name, "Margo");
    }

    @Test
    public void testSetHeight() {
        assertEquals(Berezina.name, "Svetlana");
        assertEquals(Abrosimova.name, "Margo");
    }

    @Test
    public void testSetWeight() {
        assertEquals(Berezina.name, "Svetlana");
        assertEquals(Abrosimova.name, "Margo");
    }
}