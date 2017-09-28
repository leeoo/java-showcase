package com.lex.showcase.class_loader;

/**
 * @author Lex Li
 */
public class PrivateCar {
    private String name;
    private String brand;
    private Double speed;

    public PrivateCar() {

    }

    public PrivateCar(String name, String brand, Double speed) {
        this.name = name;
        this.brand = brand;
        this.speed = speed;
    }

    public void introduce() {
        System.out.println(String.format("name: %s, brand: %s, speed: %s", name, brand, speed));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

}
