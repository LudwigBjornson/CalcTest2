import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение (например, 2 + 2):");
        String input = scanner.nextLine();
        String result = calc(input);
        System.out.println("Результат: " + result);
    }

    static String calc(String input) {
        String[] parts = input.split(" ");
        String num1 = parts[0].trim();
        String operator = parts[1].trim();
        String num2 = parts[2].trim();

        if (!isValidInput(num1) || !isValidInput(num2)) {
            throw new IllegalArgumentException("Неподходящие числа");
        }


        int number1 = convertToNumber(num1);
        int number2 = convertToNumber(num2);

        int result = 0;
        if (number1 < 1 || number1 > 10 || number2 < 1 || number2 > 10) {
            return "Числа должны быть от 1 до 10.";
        }

        switch (operator) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                if (number2 == 0) {
                    throw new ArithmeticException("Деление на ноль");
                }
                result = number1 / number2;
                break;
            default:
                throw new IllegalArgumentException("Неверный оператор");
        }

        if (isRomanNumeral(num1) && isRomanNumeral(num2)) {
            if (result <= 0) {
                throw new IllegalArgumentException("Результат меньше единицы");
            }
            return convertToRomanNumeral(result);
        } else {
            return String.valueOf(result);
        }
    }

    static boolean isValidInput(String input) {
        return input.matches("[IVXLCDM]+") || input.matches("[0-9]+");
    }

    static boolean isRomanNumeral(String input) {
        return input.matches("[IVXLCDM]+");
    }

    static int convertToNumber(String input) {
        if (isRomanNumeral(input)) {
            return RomanNumeralConverter.romanToArabic(input);
        } else {
            return Integer.parseInt(input);
        }
    }

    static String convertToRomanNumeral(int number) {
        return RomanNumeralConverter.arabicToRoman(number);
    }
}


