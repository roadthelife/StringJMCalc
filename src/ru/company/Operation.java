package ru.company;

import java.io.IOException;

public class Operation {

    public final String[] value;
    public final String[] value2;
    public final String symbol;
    public String result;

    public Operation(String[] value, String[] value2, String symbol) {
        this.value = value;
        this.value2 = value2;
        this.symbol = symbol;
    }

    public String getValues() throws IOException {
        String first = value[0];
        String second = value[1];

        switch (symbol) {
            case "+": {
                result = add(first, second);
                break;
            }
            case "-": {
                result = (sub(value2[1], value2[3]));
                break;
            }
            case "*": {
                result = mult(first, second);
                if (Integer.parseInt(value[1].trim()) > 10 || Integer.parseInt(value[1].trim()) <= 0) {
                    throw new IOException("Числа на ввод в диапазоне от 1 до 10 включительно, не более.");
                }
                break;
            }
            case "/": {
                result = div(first, second);
                if (Integer.parseInt(value[1].trim()) > 10 || Integer.parseInt(value[1].trim()) <= 0) {
                    throw new IOException("Числа на ввод в диапазоне от 1 до 10 включительно, не более.");
                }

                break;
            }
        }
        if (value2[2].trim().equals("-")) {
            result = (sub(value2[1], value2[3]));
        }
        if (value2[2].isEmpty()) {
            throw new IOException("Первый операнд не является строкой");
        }
        if (result == null) {
            throw new IOException("Не соответствует условиям");
        }

        if (result.length() > 40) {
            return result.substring(0, 40) + "..." + "\"";
        } else {
            return result;
        }

    }


    private String add(String first, String second) {
        var array = params(first, second);
        return ("\"" + array[0].trim() + array[1].trim() + "\"");
    }

    private String sub(String first, String second) {
        var array = params(first, second);
        return ("\"" + array[0].replaceAll(array[1], "") + "\"");
    }

    private String mult(String first, String second) {
        var array = params(first, second);
        return ("\"" + array[0].trim().repeat(Integer.parseInt(array[1].trim())) + "\"");
    }

    private String div(String first, String second) {
        var array = params(first, second);
        return ("\"" + array[0].substring(0, (first.length() / Integer.parseInt(array[1].trim()) - 1)) + "\"");
    }


    private String[] params(String first, String second) {
        first = first.replaceAll("[\"]", "");
        second = second.replaceAll("[\"]", "");
        String[] array = {first, second};
        return array;
    }

    public String InResult() throws IOException {
        return getValues();
    }
}

