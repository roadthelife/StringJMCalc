package ru.company;

public class ExtractData {
    public static String[] getValues(String str) {
        String[] operands = str.split("[+/*-]");
        return operands;
    }

    public static String getOperator(String str) {
        return str.replaceAll("[\"a-zA-Z0-9!@#$%^&()?]", "").trim();
    }

    public static String[] getAnyValues(String str) {
        String[] operands2 = str.split("[\"]");
        return operands2;
    }
}
