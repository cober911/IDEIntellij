package Exception_.sem3;

import java.util.Scanner;

public class metanit  {
    public static void getNumber() throws RuntimeException{
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        if (x >= 30) throw new RuntimeException("Число больше 30");
        System.out.println("close");
    }
    public static void main(String[] args) {
        try {
            getNumber();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }
}
