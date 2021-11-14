package com.pb.avrakhov.hw7;

/**
 * Создать классы наследники Clothes: Pants (штаны) реализует интерфейсы ManClothes и WomenClothes.
 */
public class Pants extends Clothes implements ManClothes, WomenClothes {

    public Pants(Size size, Float price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Штаны, рамер: [" + getSize().getDescription(getSize()) + ": " + getSize() + "; " +
                getSize().getEuroSize(getSize()) + "]; price - " + getPrice() + "; color - " + getColor());
    }

    @Override
    public void dressWomen() {
        System.out.println("Штаны, рамер: [" + getSize().getDescription(getSize()) + ": " + getSize() + "; " +
                getSize().getEuroSize(getSize()) + "]; price - " + getPrice() + "; color - " + getColor());
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
