import java.util.Scanner;

public class WhileClass {

    public static void main(String[] args) {

        // task: loop number
        // System.out.println("Input max count number: ");
        // Scanner keyboard = new Scanner(System.in);

        // int count = keyboard.nextInt();
        // int i = 1;
        // System.out.println("------\n");

        // while(i <= count) {
        //     System.out.println(i + "\n");
        //     i++;
        // }
        // System.out.println("stop");

        // task2: stop when input data is stop
        // Scanner keyboard;
        // String input;

        // while(true) {
        //     System.out.println("Input a string: ");
        //     keyboard = new Scanner(System.in);
        //     input = keyboard.nextLine();
        //     if (input.toLowerCase().equals("stop")) {
        //         break;
        //     }
        // }
        // System.out.println("stop");

        // task3: guess a number 
        Scanner keyboard;
        int input;

        int begin = 0;
        int end = 10;
        int random = (int)(Math.random() * 10);
        int count = 0;
        while(true) {
            System.out.println("Input a number between " + begin + " and " + end);
            keyboard = new Scanner(System.in);
            input = keyboard.nextInt();
            count++;
            if (input == random) {
                System.out.println("You are clever, number: " + random + ", times: " + count);
                break;
            }
            if (input < random) {
                System.out.println("Number is too low");
            }
            if (input > random) {
                System.out.println("Number is too high");
            }
        }
        System.out.println("stop");
    }
}