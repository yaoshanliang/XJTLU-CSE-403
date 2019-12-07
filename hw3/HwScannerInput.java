package hw3;

import java.util.Scanner;

public class HwScannerInput {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Input your name: ");
        String name = keyboard.nextLine();

        System.out.println("Input your age: ");
        String age = keyboard.nextLine();

        System.out.println("Input your student number: ");
        String studentNumber = keyboard.nextLine();

        System.out.println("Input your hometown: ");
        String hometown = keyboard.nextLine();

        System.out.println("Input your school: ");
        String school = keyboard.nextLine();

        System.out.println("Input your gender: ");
        String gender = keyboard.nextLine();

        System.out.println("Your info is as follows: \n");
        System.out.println("Your name: " + name + "\n");
        System.out.println("Your age: " + age + "\n");
        System.out.println("Your student number: " + studentNumber + "\n");
        System.out.println("Your hometown: " + hometown + "\n");
        System.out.println("Your school: " + school + "\n");
        System.out.println("Your gender: " + gender + "\n");

        keyboard.close();
    }

}