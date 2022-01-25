/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.utilities;

import java.util.Scanner;

/**
 *
 * @author islan
 */
public class ScannerUtils {

    private ScannerUtils() {
    }

    private static final char[] CONVERSION_TABLE = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};        

    public static String convertDecimal(int num, int base) {
        if (num <= 0 || base < 0 || base > CONVERSION_TABLE.length) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        while(num>0) {            
            result.insert(0, CONVERSION_TABLE[num % base]);   
            num /= base;
        }        
        return result.toString();
    }
    
    public static char readChar(String message, Scanner scanner) {
        return readString(message, scanner).charAt(0);
    }

    public static String readString(String message, Scanner scanner) {
        String line;
        do {
            System.out.print(message);
            line = scanner.nextLine().trim();
        } while (line.isEmpty());
        return line;
    }

    public static double readDouble(String message, Scanner scanner) {
        System.out.print(message);
        while (!scanner.hasNextDouble()) {
            System.out.println(message);
            scanner.nextLine();
        }
        double number = scanner.nextDouble();
        scanner.nextLine();
        return number;
    }

    public static int readInt(String message, Scanner scanner) {
        System.out.print(message);
        while (!scanner.hasNextInt()) {
            System.out.print(message);
            scanner.nextLine();
        }
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }
}
