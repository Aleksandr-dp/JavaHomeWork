package com.pb.avrakhov.hw7;

/**
 * Создать классы наследники Clothes: Skirt (юбка) реализует интерфейс WomenClothes.
 */
public class Skirt extends Clothes implements WomenClothes {

    public Skirt(Size size, Float price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressWomen() {
        System.out.println("Юбка, рамер: [" + getSize().getDescription(getSize()) + ": " + getSize() + "; " +
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
