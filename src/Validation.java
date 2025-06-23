
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Maxim
 */
public class Validation {
    public final Scanner in = new Scanner(System.in);
    //check integer to ensure positive value
    public int checkBaseInt(){
        while (true){
            try {
                int check = Integer.parseInt(in.nextLine().trim());
                if (check == 2 || check == 16 || check == 10){
                    return check;
                }
                System.err.println("Invalid base. Please enter base matching [2/10/16]");
            } catch (NumberFormatException e) {
                System.err.println("Invalid base. Please enter valid integer.");
            }
            System.out.println("Enter again:");
        }
    }
    
    //check if input value is matched format with input base
    public String checkValidatedValue(int base){
        String regex = "";
        switch (base) {
            case 2:
                regex = "[0-1]+";
                break;
            case 10:
                regex = "\\d+";
                break;
            case 16:
                regex = "[0-9A-Fa-f]+";
                break;
            default:
                
        }   
        while (true){
            System.out.println("Please enter the convert value:");
            String inputValue = in.nextLine().trim();
            
            if(inputValue.matches(regex)){
                return inputValue;
            }   else    {
            System.out.println("Error. Input value is not matching with input base.");
            }
        }
    }
}
