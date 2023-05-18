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

            //System.out.println(((int) character >> 4) & 0xF);
            //System.out.println((int) character & 0xF);

            STRING_BUILDER.append(hexadecimal0xF0);
            STRING_BUILDER.append(hexadecimal0x0F);

            if (i < string.length() - 1) {
                this.STRING_BUILDER.append(" ");
            }
        }
        return this.STRING_BUILDER;
    }
}
