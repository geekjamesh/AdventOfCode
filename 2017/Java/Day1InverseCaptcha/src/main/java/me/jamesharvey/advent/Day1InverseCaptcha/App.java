package me.jamesharvey.advent.Day1InverseCaptcha;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Inverse Captcha");
        System.out.println("Please Enter the code input : ");
        Scanner scanner = new Scanner(System.in);
    	try {
            String inputString = scanner.nextLine();
            InverseCaptcha captcha = new InverseCaptcha();
            captcha.setInput(inputString);
            captcha.calculateCodeNextCharacter();
            Integer result = captcha.getResult();
            System.out.println("Part 1 Result : " + result.toString());
            captcha.calculateCodeOppositeHalfCharacter();;
            result = captcha.getResult();
            System.out.println("Part 2 Result : " + result.toString());
    	} catch (Exception e) {
    		System.out.println("Error! : " + e.getMessage());
    		e.printStackTrace();
    	} finally {
    		scanner.close();
    	}
    }
    
    
}
