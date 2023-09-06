package Exception_.sem3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class dz3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите данные в формате: Фамилия Имя Отчество НомерТелефона");

        try {
            String input = scanner.nextLine();
            String[] data = input.split(" ");

            if (data.length != 4) {
                throw new InvalidDataFormatException("Неверное количество данных. Ожидается Фамилия Имя Отчество НомерТелефона.");
            }

            String lastName = data[0];
            String firstName = data[1];
            String middleName = data[2];

            // Проверка, что фамилия и имя не содержат цифр
            if (containsDigits(lastName) || containsDigits(firstName) || containsDigits(middleName)) {
                throw new InvalidDataFormatException("ФИО не должны содержать цифр.");
            }

            long phoneNumber;
            try {
                phoneNumber = Long.parseLong(data[3]);
            } catch (NumberFormatException e) {
                throw new InvalidDataFormatException("Неверный формат номера телефона. Номер должен быть целым числом.");
            }

            try (FileWriter writer = new FileWriter(lastName + ".txt", true)) {
                writer.write(lastName + " " + firstName + " " + middleName + " " + phoneNumber + "\n");
                System.out.println("Данные успешно записаны в файл.");
            } catch (IOException e) {
                System.err.println("Произошла ошибка при записи в файл: " + e.getMessage());
            }

        } catch (InvalidDataFormatException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }

    }
        private static boolean containsDigits(String str) {
            return str.matches(".*\\d.*");
        }
}

class InvalidDataFormatException extends Exception {
    public InvalidDataFormatException(String message) {
        super(message);
    }
}
