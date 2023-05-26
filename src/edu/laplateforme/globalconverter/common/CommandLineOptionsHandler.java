package edu.laplateforme.globalconverter.common;

import edu.laplateforme.globalconverter.common.util.NumberToTextConverter;
import edu.laplateforme.globalconverter.common.util.TextToNumberConverter;

public class CommandLineOptionsHandler {
    public static void optionArg(String option, String string) {
        NumberToTextConverter numberToTextConverter = new NumberToTextConverter();
        TextToNumberConverter textToNumberConverter = new TextToNumberConverter();

        switch (option) {
            case "-b":
            case "binary":
                System.out.println(numberToTextConverter.convertToBinary(string));
                break;
            case "-d":
            case "decimal":
                System.out.println(numberToTextConverter.convertToDecimal(string));
                break;
            case "-h":
            case "hexadecimal":
                System.out.println(numberToTextConverter.convertToHexadecimal(string));
                break;
            case "-o":
            case "octal":
                System.out.println(numberToTextConverter.convertToOctal(string));
                break;
            case "-t":
            case "text":
                System.out.println(textToNumberConverter.convertToText(string));
                break;
            default:
                System.out.println("Unknown option !");
                break;
        }
    }
}
