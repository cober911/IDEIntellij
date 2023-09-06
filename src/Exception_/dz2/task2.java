package Exception_.dz2;

/*
Если необходимо, исправьте данный код (задание 2 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit) */
public class task2 {
    public static void main(String[] args) {
        try {
            int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
            int d = 1; // Изменено значение d, чтобы избежать деления на ноль
            double catchedRes1 = (double) intArray[8] / d; // Приведение к double для точного деления
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArrayIndexOutOfBoundsException e) { // Исправлен тип исключения
            System.out.println("Catching exception: " + e);
        }
    }
}
