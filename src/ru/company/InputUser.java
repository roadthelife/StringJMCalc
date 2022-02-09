package ru.company;

import java.io.IOException;
import java.util.Scanner;

public class InputUser {
    public static String input() throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input: ");
        String result = scan.nextLine();
        String[] value = ExtractData.getValues(result);
        String[] value2 = ExtractData.getAnyValues(result);

        if (value.length < 2) {
            throw new IOException("Не является арифмитической операцией.");
        }

        if (value[0].length() - 2 > 11 || value[1].length() > 10) {
            throw new IOException("Вводимая строка не должна быть больше 10 символов.");
        }

        scan.close();
        return result;


    }
}
