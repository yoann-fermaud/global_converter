package edu.laplateforme.globalconverter;
// com, edu, gov, mil, net, org or both letters identifying a country

import edu.laplateforme.globalconverter.common.CommandLineOptionsHandler;

public class GlobalConverter {
    public static void main(String[] args) {
        if (1 < args.length && validChar(args[1])) {
            CommandLineOptionsHandler.optionArg(args[0], args[1]);
        } else {
            System.out.println("Invalid command line and/or alphanumeric character only !");
            System.out.println("""
                    NAME
                    \t$ java GlobalConverter [OPTION] YOUR_STRING
                    
                    SYNOPSIS
                    \t$ java GlobalConverter -b|binary [OPTION OF GlobalConverter]
                    \t$ java GlobalConverter -d|decimal [OPTION OF GlobalConverter]
                    \t$ java GlobalConverter -h|hexadecimal [OPTION OF GlobalConverter]
                    \t$ java GlobalConverter -o|octal [OPTION OF GlobalConverter]
                    \t$ java GlobalConverter -t|text [OPTION OF GlobalConverter]
                    """);
        }
    }

    private static boolean validChar(String string) {
        // Regular expression to check alphanumeric characters with spaces
        String regex = "^[a-zA-Z0-9 ]+$";
        // Check if the string matches the regular expression
        return string.matches(regex);
    }
}
