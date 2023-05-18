package edu.laplateforme.globalconverter.common;

public class CommandLineOptionsHandler {
    public static void optionArg(String option, String string) {
        ConversionsHandler conversionsHandler = new ConversionsHandler();
        switch (option){
            case "-b":
            case "binary":
                System.out.println(conversionsHandler.convertToBinary(string));
                break;
            case "-d":
            case "decimal":
                System.out.println(conversionsHandler.convertToDecimal(string));
                break;
            case "-h":
            case "hexadecimal":
                System.out.println(conversionsHandler.convertToHexadecimal(string));
                break;
            case "-o":
            case "octal":
                System.out.println("OPTION octal");
                break;
            case "-t":
            case "text":
                System.out.println("OPTION text");
                break;
            default:
                System.out.println("Unknown option !");
                break;
        }
    }
}
