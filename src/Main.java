
import java.math.BigInteger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Maxim
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Validation check = new Validation();
        Converter convert = new Converter();
        String result = "";
        BigInteger decimalValue = BigInteger.ZERO;
        
        while (true) {
        System.out.println("Choose base number system for input:");
        System.out.println("Binary - Base 2");
        System.out.println("Decimal - Base 10");
        System.out.println("Hexadecimal - Base 16");
        System.out.print("Base: ");

        int inputBase = check.checkBaseInt();
        
                
        System.out.println("Choose base number system for output:");
        System.out.println("Binary - Base 2");
        System.out.println("Decimal - Base 10");
        System.out.println("Hexadecimal - Base 16");
        System.out.print("Base: ");

        int outputBase = check.checkBaseInt();
        
        String inValue = check.checkValidatedValue(inputBase);

        //convert hec, dec, bin to dec
        switch (inputBase) {
            case 2 -> {
                decimalValue = convert.convertBinToDec(inValue);
            }
            case 10 -> {
                decimalValue = new BigInteger(inValue);
            }
            case 16 -> {
                decimalValue = convert.convertHexaToDec(inValue);

            }
            default ->
                throw new AssertionError();
        }
        switch (outputBase) {
            case 2 -> {
                result = convert.convertDecToBin(decimalValue);
            }
            case 10 -> {
                result = decimalValue.toString();
            }
            case 16 -> {
                result = convert.convertDecToHexa(decimalValue);
            }
            default ->
                throw new AssertionError();
        }
        System.out.println("Base " + inputBase + " -> " + "base " + outputBase + 
                            " of " + inValue + " is " + result);
        }
    }

}
