package Excetion_.dz2;

import java.io.*;

/*
Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. Пользователю должно показаться сообщение, что пустые строки вводить нельзя. */
public class task4 {
    public static void main(String[] args) {
        String userVal = getVal();
        System.out.println();
        System.out.println("Вы ввели следующую строку:");
        System.out.println(userVal);
    }

    static String getVal() {
        String val = "";
        System.out.println("Введите свою строку:");
        InputStream UserInput = System.in;
        Reader inputReader = new InputStreamReader(UserInput);
        BufferedReader bufferedReader = new BufferedReader(inputReader);
        try {
            val = bufferedReader.readLine();
            if (val.isBlank()) {
                throw new IllegalArgumentException("Пустые строки запрещены!");
            }
        } catch (IOException exception) {
            System.out.println("Проблемы с вводом/выводом.");
            //exception.printStackTrace();
        }
        return val;
    }
}
