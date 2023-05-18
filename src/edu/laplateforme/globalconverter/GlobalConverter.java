package edu.laplateforme.globalconverter;
// com, edu, gov, mil, net, org or both letters identifying a country

import edu.laplateforme.globalconverter.common.CommandLineOptionsHandler;

public class Main {
    public static void main(String[] args) {
        if (1 < args.length) {
            CommandLineOptionsHandler.optionArg(args[0], args[1]);
        } else {
            System.out.println("");
        }

        /*    1 2 4 8 16 32
        * 24 - > 11000
        * 0 / 12
        * 0 / 6
        * 0 / 3
        * 1 / 2
        * 1 / 1
        * */
    }
}
