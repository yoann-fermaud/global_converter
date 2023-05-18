package edu.laplateforme.globalconverter;
// com, edu, gov, mil, net, org or both letters identifying a country

import edu.laplateforme.globalconverter.common.CommandLineOptionsHandler;

public class GlobalConverter {
    public static void main(String[] args) {
        if (1 < args.length) {
            CommandLineOptionsHandler.optionArg(args[0], args[1]);
        } else {
            System.out.println("Invalid command line !");
            System.out.println("$ java GlobalConverter [OPTION] YOUR_STRING");
        }
    }
}
