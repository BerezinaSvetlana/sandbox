package ru.ssau.tk.abrosimovamargo.sandbox.dopysk;

import java.util.Date;

public class Person {

    public String name;
    public double height;
    public double weight;

    public Person(String name, double height, double weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public static void main(String[] args) {

        Person Berezina = new Person("Svetlana",172, 70);
        String Berezina_name = Berezina.getName();
        double Berezina_height = Berezina.getHeight();
        double Berezina_weight = Berezina.getWeight();

        Person Abrosimova = new Person("Margo",158, 44);
        String Abrosimova_name = Abrosimova.getName();
        double Abrosimova_height = Abrosimova.getHeight();
        double Abrosimova_weight = Abrosimova.getWeight();

        System.out.println("Name: " + Berezina_name + " " + "Height: " + Berezina_height + " " + "Weight: " + Berezina_weight);
        System.out.println("Name: " + Abrosimova_name + " " + "Height: " + Abrosimova_height + " " +"Weight: " + Abrosimova_weight);

    }

}