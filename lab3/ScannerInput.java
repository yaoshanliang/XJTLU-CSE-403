import java.util.Scanner;

public class ScannerInput {

    public static void main(String[] args) {
        System.out.println("Input your name: ");
        Scanner keyboard = new Scanner(System.in);

        String input = keyboard.next();// only reads up to the first space
        // String input = keyboard.nextLine();// read one line
        // String input = keyboard.nextDouble();// read double
        // String input = keyboard.nextInt();// read int

        System.out.println("Your input is: " + input);


        double number1 = Math.random();
        System.out.println("random data is " + number1);
        keyboard.close();
    }

}