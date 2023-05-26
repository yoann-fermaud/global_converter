package edu.laplateforme.globalconverter.common.util;

public class TextToNumberConverter {
    private final StringBuilder STRING_BUILDER = new StringBuilder();

    public StringBuilder convertToText(String string) {
        // Regular expression to check which base 2, 8, 10, 16
        String binaryRegex = "^([0-1]{8}| )+$";
        String octalRegex = "^([0-7]{3}| )+$";
        String decimalRegex = "^([1-9][0-9]{1,2}| )+$";
        String hexadecimalRegex = "^([A-Z0-9]{2}| )+$";

        if (string.matches(binaryRegex)) {
            // Array indexed by a string at each space
            String[] stringArray = string.split(" ");

            for (String binaryValue : stringArray) {
                int binary = binaryToInt(binaryValue);
                char character = (char) binary;
                this.STRING_BUILDER.append(character);
            }

        } else if (string.matches(octalRegex)) {
            // Array indexed by a string at each space
            String[] stringArray = string.split(" ");

            for (String octalValue : stringArray) {
                int octal = octalToInt(octalValue);
                char character = (char) octal;
                this.STRING_BUILDER.append(character);
            }

        } else if (string.matches(hexadecimalRegex)) {
            // Array indexed by a string at each space
            String[] stringArray = string.split(" ");

            for (String hexadecimalValue : stringArray) {
                int hexadecimal = hexadecimalToInt(hexadecimalValue);
                char character = (char) hexadecimal;
                this.STRING_BUILDER.append(character);
            }

        } else if (string.matches(decimalRegex)) {
            // Array indexed by a string at each space
            String[] stringArray = string.split(" ");

            for (String decimalValue : stringArray) {
                int decimal = decimalToInt(decimalValue);
                char character = (char) decimal;
                this.STRING_BUILDER.append(character);
            }

        } else {
            System.out.println("Invalid character !");
        }
        return this.STRING_BUILDER;
    }

    private static int binaryToInt(String string) {
        int binary = 0;
        // Loop running through the string
        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);
            if (character >= '0' && character <= '1') {
                // Character value '0' = 48
                binary = binary * 2 + (character - '0');
            } else {
                throw new IllegalArgumentException("Invalid binary character: " + character);
            }
        }
        return binary;
    }

    private static int octalToInt(String string) {
        int octal = 0;
        // Loop running through the string
        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);
            if (character >= '0' && character <= '7') {
                // Character value '0' = 48
                octal = octal * 8 + (character - '0');
            } else {
                throw new IllegalArgumentException("Invalid octal character: " + character);
            }
        }
        return octal;
    }

    private static int decimalToInt(String string) {
        int decimal = 0;
        // Loop running through the string
        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);
            if (character >= '0' && character <= '9') {
                // Character value '0' = 48
                decimal = decimal * 10 + (character - '0');
            } else {
                throw new IllegalArgumentException("Invalid decimal character: " + character);
            }
        }
        return decimal;
    }

    private static int hexadecimalToInt(String string) {
        int hexadecimal = 0;
        // Loop running through the string
        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);
            if (character >= '0' && character <= '9') {
                // Character value '0' = 48
                hexadecimal = hexadecimal * 16 + (character - '0');
            } else if (character >= 'A' && character <= 'F') {
                // Character value 'A' = 65
                hexadecimal = hexadecimal * 16 + (character - 'A' + 10);
            } else {
                throw new IllegalArgumentException("Invalid hexadecimal character: " + character);
            }
        }
        return hexadecimal;
    }
}
