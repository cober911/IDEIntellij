package Exception_.dz2;

import java.util.Scanner;

public class task1 {
    /*
    Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение.
    Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных. */
    public static void main(String[] args) {
        float number = getFloatInput();
        System.out.println("Вы ввели: " + number);
    }

    public static float getFloatInput() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Введите дробное число: ");
                float value = Float.parseFloat(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введите корректное дробное число.");
            }
        }
    }
}
