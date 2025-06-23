
import java.math.BigInteger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Maxim
 */
public class Converter {

    //convert from hexa to dec
    public BigInteger convertHexaToDec(String hex) {
        BigInteger decimal = BigInteger.ZERO;
        BigInteger base = BigInteger.ONE;
        BigInteger sixteen = new BigInteger("16");
        int number = 0;
        for (int i = hex.length() - 1; i >= 0; i--) {
            char hexChar = hex.charAt(i);
            if ('0' <= hexChar && hexChar <= '9') {
                number = hexChar - '0';
            } else if ('a' <= hexChar && hexChar <= 'f') {
                number = hexChar - 'a' + 10;
            } else if ('A' <= hexChar && hexChar <= 'F') {
                number = hexChar - 'A' + 10;
            }
            BigInteger added = BigInteger.valueOf(number);
            decimal = decimal.add(base.multiply(added));
            base = base.multiply(sixteen);
        }
        return decimal;
    }
    
    //convert from bin to dec
    public BigInteger convertBinToDec(String binary) {
        BigInteger decimal = BigInteger.ZERO;
        BigInteger base = BigInteger.ONE;
        BigInteger two = new BigInteger("2");
        for (int i = binary.length() - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                decimal = decimal.add(two);
            }
            base = base.multiply(two);
        }
        return decimal;
    }

    //convert from dec to hexa
    public String convertDecToHexa(BigInteger decimal) {
    char[] hexDigits = new char[100]; 
    int index = 0;
    if (decimal.equals(BigInteger.ZERO)) {
        return "0";
    }
    while ((decimal.compareTo(BigInteger.ZERO)) > 0) {
        BigInteger remainder = decimal.mod(BigInteger.valueOf(16)); 
        int rem = remainder.intValue();
        if (rem > 0) {
            hexDigits[index++] = (char)(rem + '0'); // Lưu chữ số '0' đến '9'
        } else {
            hexDigits[index++] = (char)(rem - 10 + 'A'); // Lưu ký tự 'A' đến 'F'
        }
        decimal = decimal.divide(BigInteger.valueOf(16)); // Chia tiếp cho 16
    }

    // Đọc chuỗi thập lục phân từ phải sang trái
    String result = "";
    for (int i = index - 1; i >= 0; i--) {
        result += hexDigits[i];
    }

    return result.trim(); // Trả về kết quả thập lục phân
}

    //convert from dec to bin
    public String convertDecToBin(BigInteger decimal) {
    if (decimal.equals(BigInteger.ZERO)) {
        return "0";
    }

    int[] binary = new int[100];
    int index = 0;
    
    while ((decimal.compareTo(BigInteger.ZERO)) > 0) {
        BigInteger remainder = decimal.mod(BigInteger.valueOf(2));
        int rem = remainder.intValue();
        binary[index++] = rem; 
        decimal = decimal.divide(BigInte);  
    }

    
    String result = "";
    for (int i = index - 1; i >= 0; i--) {
        result += binary[i]; 
    }

    return result; 
}

}
