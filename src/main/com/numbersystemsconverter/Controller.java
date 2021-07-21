package main.com.numbersystemsconverter;

import java.util.Arrays;

public class Controller {

    public static String decimalToBinary(int input) {

        String output = "";

        for (int i = input; i >= 1; i /= 2) {

            if (i % 2 == 1) {

                output += 1;

            } else {

                output += 0;

            }

            if (i == 1) {

                output += 0;

            }

        }

        return new StringBuilder(output).reverse().toString();

    }

    public static String decimalToOctal(int input) {

        String output = "";

        for (int i = input; i > 0; i /= 8) {

            output += i % 8;

        }

        return new StringBuilder(output).reverse().toString();

    }

    public static String decimalToHexadecimal(int input) {

        String output = "";

        for (int i = input; i > 0; i /= 16) {

            output += i % 16;

            if (output.contains("10")) {

                output = output.replace("10", "A");

            }

            if (output.contains("11")) {

                output = output.replace("11", "B");

            }

            if (output.contains("12")) {

                output = output.replace("12", "C");

            }

            if (output.contains("13")) {

                output = output.replace("13", "D");

            }

            if (output.contains("14")) {

                output = output.replace("14", "E");

            }

            if (output.contains("15")) {

                output = output.replace("15", "F");

            }

        }

        return new StringBuilder(output).reverse().toString();

    }

    public static int binaryToDecimal(String input) {

        char[] array = input.toCharArray();
        String result = "";
        int pitch = 0;
        int output = 0;

        for (int i = array.length - 1; i >= 0; i--) {

            result = result + array[i];

        }

        // Creating array of string length
        char[] ch = new char[result.length()];

        // Copy character by character into array
        for (int i = 0; i < result.length(); i++) {

            ch[i] = result.charAt(i);

        }

        // Printing content of array
        for (char c : ch) {

            output += (int) (Math.pow(2, pitch)) * Integer.parseInt(String.valueOf(c));
            pitch++;

        }

        return output;

    }

    public static String binaryToOctal(String input) {

        int pitch = 2;
        int amount = 0;
        String digit = "";
        String output = "";
        input = reflect(input);
        input = multiplicityChecker(input, 3);
        input = reflect(input);

        char[] arrayReversed = input.toCharArray();

        for (int i = 0; i <= arrayReversed.length - 1; i++) {

            if (pitch < 0) {

                pitch = 2;

            }

            digit += (int) (Math.pow(2, pitch)) * Integer.parseInt(String.valueOf(arrayReversed[i]));
            pitch--;

            if ((i + 1) % 3 == 0) {

                for (int k = 0; k <= digit.length() - 1; k++) {

                    amount += Integer.parseInt(String.valueOf(digit.charAt(k)));

                }

                output += amount;
                amount = 0;
                digit = "";

            }

        }

        return output;

    }

    public static String binaryToHexadecimal(String input) {

        int pitch = 3;
        int amount = 0;
        String digit = "";
        String output = "";
        input = reflect(input);
        input = multiplicityChecker(input, 4);
        input = reflect(input);

        char[] arrayReversed = input.toCharArray();

        for (int i = 0; i <= arrayReversed.length - 1; i++) {

            if (pitch < 0) {

                pitch = 3;

            }

            digit += (int) (Math.pow(2, pitch)) * Integer.parseInt(String.valueOf(arrayReversed[i]));
            pitch--;

            if ((i + 1) % 4 == 0) {

                for (int k = 0; k <= digit.length() - 1; k++) {

                    amount += Integer.parseInt(String.valueOf(digit.charAt(k)));

                }

                output += amount;
                amount = 0;
                digit = "";

            }

        }

        if (output.contains("10")) {

            output = output.replace("10", "A");

        }

        if (output.contains("11")) {

            output = output.replace("11", "B");

        }

        if (output.contains("12")) {

            output = output.replace("12", "C");

        }

        if (output.contains("13")) {

            output = output.replace("13", "D");

        }

        if (output.contains("14")) {

            output = output.replace("14", "E");

        }

        if (output.contains("15")) {

            output = output.replace("15", "F");

        }

        return output;

    }

    public static int octalToDecimal(String input) {

        int pitch = 0;
        int output = 0;
        char[] arrayReversed = input.toCharArray();

        for (int i = arrayReversed.length - 1; i >= 0; i--) {

            output += (int) (Math.pow(8, pitch)) * Integer.parseInt(String.valueOf(arrayReversed[i]));
            pitch++;

        }

        return output;

    }

    public static String octalToBinary(String input) {

        int pitch;
        String output = "";
        char[] arrayReversed = input.toCharArray();

        for (int i = 0; i <= arrayReversed.length - 1; i++) {

            pitch = input.charAt(i);

            if (pitch == '0') {

                output += "000";

            }

            if (pitch == '1') {

                output += "001";

            }

            if (pitch == '2') {

                output += "010";

            }

            if (pitch == '3') {

                output += "011";

            }

            if (pitch == '4') {

                output += "100";

            }

            if (pitch == '5') {

                output += "101";

            }

            if (pitch == '6') {

                output += "110";

            }

            if (pitch == '7') {

                output += "111";

            }

        }

        return output;

    }

    public static String octalToHexadecimal(String input) {

        input = octalToBinary(input);
        String output = binaryToHexadecimal(input);

        return output;

    }

    public static String oneZeroChecker(String input) {

        char a = input.charAt(0);
        char b = input.charAt(1);

        String withoutZero = "";

        if (a == '0') {

            if (a != b) {

                for (int i = 1; i <= input.length() - 1; i++) {

                    withoutZero += String.valueOf(input.charAt(i));

                }

                input = withoutZero;

            }

        }

        return input;

    }

    public static String reflect(String input) {

        char[] array = input.toCharArray();
        String result = "";

        for (int i = array.length - 1; i >= 0; i--) {

            result = result + array[i];

        }

        return result;

    }

    public static String multiplicityChecker(String input, int number) {

        while (input.length() % number != 0) {

            input = input + "0";

        }

        return input;

    }

}
