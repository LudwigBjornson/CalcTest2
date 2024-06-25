class RomanNumeralConverter {
    public static int romanToArabic(String input) {
        int result = 0;
        int prevValue = 0;

        for (int i = input.length() - 1; i >= 0; i--) {
            char romanChar = input.charAt(i);
            int arabicValue = romanCharToArabic(romanChar);

            if (arabicValue < prevValue) {
                result -= arabicValue;
            } else {
                result += arabicValue;
            }

            prevValue = arabicValue;
        }

        return result;
    }

    public static String arabicToRoman(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Число должно быть положительным");
        }

        String[] romanNumerals = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] arabicValues = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

        StringBuilder romanNumeral = new StringBuilder();

        int i = arabicValues.length - 1;
        while (number > 0) {
            if (number >= arabicValues[i]) {
                romanNumeral.append(romanNumerals[i]);
                number -= arabicValues[i];
            } else {
                i--;
            }
        }

        return romanNumeral.toString();
    }

    private static int romanCharToArabic(char romanChar) {
        switch (romanChar) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                throw new IllegalArgumentException("Некорректный символ римской цифры");
        }
    }
}
