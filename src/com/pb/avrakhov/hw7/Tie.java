package com.pb.avrakhov.hw7;

/**
 * Создать классы наследники Clothes: Tie (галстук) реализует интерфейс ManClothes.
 */
public class Tie extends Clothes implements ManClothes {

    public Tie(Size size, Float price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Галстук, рамер: [" + getSize().getDescription(getSize()) + ": " + getSize() + "; " +
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
