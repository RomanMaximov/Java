package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws CalculatorException {
        boolean arab = true;
        boolean roman1 = false;
        boolean roman2 = false;
        int value1 = 0;
        int value2 = 0;
        String valueStr1 = null;
        String valueStr2 = null;
        String operation = null;
        int result;

        RomanNums num = new RomanNums();

        System.out.println("Enter 2 integers(1 - 10): ");
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        in.close();

        Scanner scanner = new Scanner(text);

        if(scanner.hasNextInt())
            value1 = scanner.nextInt();
        else
        {
            roman1 = true;
            arab = false;
            valueStr1 = scanner.next();
        }

        if(!scanner.hasNext())
            throw new CalculatorException("Error: String is not math operation.");

        operation = scanner.next();

        if(scanner.hasNextInt())
            value2 = scanner.nextInt();
        else
        {
            roman2 = true;
            arab = false;
            valueStr2 = scanner.next();
        }

        if(scanner.hasNextLine())
            throw new CalculatorException("Error: Math expression format does not answer the task - two operands and one operator");

        if(!arab) {
            if (roman1 && roman2 && !arab) {
                value1 = num.toArabic(valueStr1);
                value2 = num.toArabic(valueStr2);
                arab = false;
            } else
                throw new CalculatorException("Error: Different number systems are used.");
        }

        if((value1 <= 0 || value1 > 10) || (value2 <= 0 || value2 > 10))
            //System.out.println("Error: Incorrect input.\nEnter 2 integers(1 - 10): ");
            throw new CalculatorException("Invalid input: Operand is out of range 1 - 10.");

        scanner.close();

        MathOperations oper = new MathOperations();

        if(arab)
        {
            switch (operation)
            {
                case "+":
                    System.out.println(oper.plus(value1, value2));
                    break;

                case "-":
                    System.out.println(oper.minus(value1, value2));
                    break;

                case "*":
                    System.out.println(oper.multiply(value1, value2));
                    break;

                case "/":
                    System.out.println(oper.devide(value1, value2));
                    break;

                default:
                    System.out.println("Error: invalid operation.");
                    break;
            }
        }
        else
        {
            switch (operation)
            {
                case "+":
                    result = Integer.parseInt(oper.plus(value1, value2));
                    System.out.println(num.toRoman(result));
                    break;

                case "-":
                    result = Integer.parseInt(oper.minus(value1, value2));
                    if(result < 0)
                        throw new CalculatorException("Error: Roman number system has no negative numbers.");
                    if(result == 0)
                        System.out.println(Integer.toString(result));
                    else
                        System.out.println(num.toRoman(result));
                    break;

                case "*":
                    result = Integer.parseInt(oper.multiply(value1, value2));
                    System.out.println(num.toRoman(result));
                    break;

                case "/":
                    result = Integer.parseInt(oper.devide(value1, value2));
                    if(result == 0)
                        System.out.println(Integer.toString(result));
                    else
                        System.out.println(num.toRoman(result));
                    break;

                default:
                    System.out.println("Error: invalid operation.");
                    break;
            }
        }
    }
}
