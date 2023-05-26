package edu.laplateforme.globalconverter.common;

public class ConversionsHandler {
    private final StringBuilder STRING_BUILDER = new StringBuilder();

    public StringBuilder convertToBinary(String string) {
        /* 128 64 32 16 8 4 2 1
         * 72 -> 0b01001000
         * 72 % 2 = 0 36
         * 36 % 2 = 0 18
         * 18 % 2 = 0 9
         * 9 % 2  = 1 4
         * 4 % 2  = 0 2
         * 2 % 2  = 0 1
         * 1 % 2  = 1
         *
         * 1 2 4 8 16 32 64 128
         * 72 -> 00010010
         * 72 >> 7 = 0 0
         * 72 >> 6 = 1 01
         * 72 >> 5 = 0 010
         * 72 >> 4 = 0 0100
         * 72 >> 3 = 1 01001
         * 72 >> 2 = 0 010010
         * 72 >> 1 = 0 0100100
         * 72 >> 0 = 0 01001000
         * */
        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);

            for (int j = 7; j >= 0; j--) {
                int bit = ((int) character >> j) & 1;
                this.STRING_BUILDER.append(bit);
            }

            if (i < string.length() - 1) {
                this.STRING_BUILDER.append(" ");
            }
        }
        return this.STRING_BUILDER;
    }

    public StringBuilder convertToDecimal(String string) {
        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);
            this.STRING_BUILDER.append((int) character);

            if (i < string.length() - 1) {
                this.STRING_BUILDER.append(" ");
            }
        }
        return this.STRING_BUILDER;
    }

    public StringBuilder convertToHexadecimal(String string) {
        /* 128 64 32 16 8 4 2 1
         * 72 -> 0b01001000
         * 0100 1000 -> 0x48
         *
         * 72 >> 4 = 0000 0100 & 0xF = 0100 = 4
         * 72 = 0100 1000 & 0xF = 1000 = 8
         * */
        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);

            char[] hexadecimalSymbols = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            char hexadecimal0xF0 = hexadecimalSymbols[((int) character >> 4) & 0xF];
            char hexadecimal0x0F = hexadecimalSymbols[(int) character & 0xF];

            this.STRING_BUILDER.append(hexadecimal0xF0);
            this.STRING_BUILDER.append(hexadecimal0x0F);

            if (i < string.length() - 1) {
                this.STRING_BUILDER.append(" ");
            }
        }
        return this.STRING_BUILDER;
    }

    public StringBuilder convertToOctal(String string) {
        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);

            char[] octalSymbols = {'0', '1', '2', '3', '4', '5', '6', '7'};
            char octal0xE0 = octalSymbols[((int) character >> 6) & 0x7];
            char octal0x1C = octalSymbols[((int) character >> 3) & 0x7];
            char octal0x07 = octalSymbols[(int) character & 0x7];

            this.STRING_BUILDER.append(octal0xE0);
            this.STRING_BUILDER.append(octal0x1C);
            this.STRING_BUILDER.append(octal0x07);

            if (i < string.length() - 1) {
                this.STRING_BUILDER.append(" ");
            }
        }
        return this.STRING_BUILDER;
    }

    public StringBuilder convertToText(String string) {
        String binaryRegex = "^([0-1]{8}| )+$";
        String octalRegex = "^([0-7]{3}| )+$";
        String decimalRegex = "^([1-9][0-9]{1,2}| )+$";
        String hexadecimalRegex = "^([A-Z0-9]{2}| )+$";

        if (string.matches(binaryRegex)) {
            String[] stringArray = string.split(" ");

            for (String binaryValue : stringArray) {
                int binary = binaryToInt(binaryValue);
                char character = (char) binary;
                this.STRING_BUILDER.append(character);
            }

        } else if (string.matches(octalRegex)) {
            String[] stringArray = string.split(" ");

            for (String octalValue : stringArray) {
                int octal = octalToInt(octalValue);
                char character = (char) octal;
                this.STRING_BUILDER.append(character);
            }

        } else if (string.matches(hexadecimalRegex)) {
            String[] stringArray = string.split(" ");

            for (String hexadecimalValue : stringArray) {
                int hexadecimal = hexadecimalToInt(hexadecimalValue);
                char character = (char) hexadecimal;
                this.STRING_BUILDER.append(character);
            }

        } else if (string.matches(decimalRegex)) {
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
        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);
            if (character >= '0' && character <= '1') {
                binary = binary * 2 + (character - '0');
            } else {
                throw new IllegalArgumentException("Invalid binary character: " + character);
            }
        }
        return binary;
    }

    private static int octalToInt(String string) {
        int octal = 0;
        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);
            if (character >= '0' && character <= '7') {
                octal = octal * 8 + (character - '0');
            } else {
                throw new IllegalArgumentException("Invalid octal character: " + character);
            }
        }
        return octal;
    }

    private static int decimalToInt(String string) {
        int decimal = 0;
        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);
            if (character >= '0' && character <= '9') {
                decimal = decimal * 10 + (character - '0');
            } else {
                throw new IllegalArgumentException("Invalid decimal character: " + character);
            }
        }
        return decimal;
    }

    private static int hexadecimalToInt(String string) {
        int hexadecimal = 0;
        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);
            if (character >= '0' && character <= '9') {
                hexadecimal = hexadecimal * 16 + (character - '0');
            } else if (character >= 'A' && character <= 'F') {
                hexadecimal = hexadecimal * 16 + (character - 'A' + 10);
            } else {
                throw new IllegalArgumentException("Invalid hexadecimal character: " + character);
            }
        }
        return hexadecimal;
    }
}
