package com.pb.avrakhov.hw7;

/**
 * Создать пакет hw7 и в нем создать перечисление (enum) Size со значениями XXS, XS, S, M, L. Перечисление содержит
 * метод getDescription(), возвращающий строку для XXS "Детский размер", для остальных "Взрослый размер". Так же
 * перечисление должно иметь метод getEuroSize() возвращающий числовое значение (32, 34, 36, 38, 40) соответствующее
 * каждому размеру. Создать конструктор принимающий на вход description и euroSize.
 */
public enum Size {
    XXS, XS, S, M, L;
    private String description;
    private int euroSize;

    //...Создать конструктор принимающий на вход description и euroSize??? Зачем если эти данные я должен вычеслить и вернуть?
    //Или я не понял задания...

    public String getDescription(Size size) {
        switch (size) {
            case XXS:
                description = "Детский";
                break;
            case XS:
            case S:
            case M:
            case L:
                description = "Взрослый";
                break;
            default:
                description = "Унисекс";
                break;
        }

        return description;
    }

    public int getEuroSize(Size size) {
        switch (size) {
            case XXS:
                euroSize = 32;
                break;
            case XS:
                euroSize = 34;
                break;
            case S:
                euroSize = 36;
                break;
            case M:
                euroSize = 38;
                break;
            case L:
                euroSize = 40;
                break;
            default:
                euroSize = 0;
                break;
        }

        return euroSize;
    }
}
