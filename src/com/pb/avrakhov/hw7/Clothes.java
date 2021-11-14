package com.pb.avrakhov.hw7;

/**
 * Создать абстрактный класс Clothes (одежда) содержащий переменные размер (типа Size), стоимость, цвет.
 */
public abstract class Clothes {
    private Size size;
    private Float price;
    private String color;

    public Clothes(Size size, Float price, String color) {
        this.size = size;
        this.price = price;
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public Float getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
