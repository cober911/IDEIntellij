package Exception_.sem3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class dz3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("������� ������ � �������: ������� ��� �������� �������������");

        try {
            String input = scanner.nextLine();
            String[] data = input.split(" ");

            if (data.length != 4) {
                throw new InvalidDataFormatException("�������� ���������� ������. ��������� ������� ��� �������� �������������.");
            }

            String lastName = data[0];
            String firstName = data[1];
            String middleName = data[2];

            // ��������, ��� ������� � ��� �� �������� ����
            if (containsDigits(lastName) || containsDigits(firstName) || containsDigits(middleName)) {
                throw new InvalidDataFormatException("��� �� ������ ��������� ����.");
            }

            long phoneNumber;
            try {
                phoneNumber = Long.parseLong(data[3]);
            } catch (NumberFormatException e) {
                throw new InvalidDataFormatException("�������� ������ ������ ��������. ����� ������ ���� ����� ������.");
            }

            try (FileWriter writer = new FileWriter(lastName + ".txt", true)) {
                writer.write(lastName + " " + firstName + " " + middleName + " " + phoneNumber + "\n");
                System.out.println("������ ������� �������� � ����.");
            } catch (IOException e) {
                System.err.println("��������� ������ ��� ������ � ����: " + e.getMessage());
            }

        } catch (InvalidDataFormatException e) {
            System.err.println("������: " + e.getMessage());
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
