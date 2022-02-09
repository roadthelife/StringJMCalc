package ru.company;


import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String result = InputUser.input();
        String[] value = ExtractData.getValues(result);
        String symbol = ExtractData.getOperator(result);
        String[] value2 = ExtractData.getAnyValues(result);
        Operation proc = new Operation(value, value2, symbol);
        System.out.println(proc.InResult());
    }
}


