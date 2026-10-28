package com.pluralsight;

import java.util.Scanner;
public class Console{
    private static final Scanner sc = new Scanner(System.in);

    public static int displayHomeScreen() {
        System.out.println("\nWelcome to Neighborhood Library");
        System.out.println("1- Show Available Books");
        System.out.println("2- Show Checked Out Books");
        System.out.println("3- Exit");

        return promptForInt("Select an option: ");
    }

    public static int promptForInt(String prompt) {
        System.out.print(prompt);
        return Integer.parseInt(sc.nextLine());
    }

    public static String promptForString(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    public static double promptForDouble(String prompt){
        System.out.print(prompt);
        return Double.parseDouble(sc.nextLine());
    }

    public static long promptForLong(String prompt){
        System.out.println(prompt);
        return Long.parseLong(sc.nextLine());





    }

}