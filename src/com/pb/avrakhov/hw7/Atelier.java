package com.pb.avrakhov.hw7;

/**
 * Создать класс Atelier с методом main, и еще двумя статическими методами:
 * dressMan(Clothes[] clothes)
 * dressWomen(Clothes[] clothes)
 * на вход которых будет поступать массив, содержащий все типы одежды. В методе main создать массив, содержащий все
 * типы одежды, и вызвать методы dressMan и dressWomen передав туда этот массив. Метод dressWomen выводит на консоль
 * всю информацию о женской одежде. Метод dressMan выводит на консоль всю информацию о мужской одежде. В методах
 * dressWomen и dressMan использовать оператор instanceof для определения мужская это одежда или женская.
 */
public class Atelier {
    private static Tshirt tshirt1 = new Tshirt(Size.XXS, 100.00f, "Blue");
    private static Tshirt tshirt2 = new Tshirt(Size.S, 105.99f, "Red");
    private static Pants pant = new Pants(Size.L, 201.74f, "Roze");
    private static Skirt skirt = new Skirt(Size.M, 15.39f, "Black");
    private static Tie tie = new Tie(Size.XS, 160.01f, "White");
    private static Clothes[] clothes = new Clothes[] {tshirt1, tshirt2, pant, skirt, tie};

    public static void main(String[] args) {
        dressMan(clothes);
        dressWomen(clothes);
    }

    public static void dressMan(Clothes[] clothes) {
        for (Clothes clothe: clothes) {
            if (clothe instanceof ManClothes) {
                System.out.print("Men: ");
                ((ManClothes) clothe).dressMan();
            }
        }
    }

    public static void dressWomen(Clothes[] clothes) {
        for (Clothes clothe: clothes) {
            if (clothe instanceof WomenClothes) {
                System.out.print("Women: ");
                ((WomenClothes) clothe).dressWomen();
            }
        }
    }
}
