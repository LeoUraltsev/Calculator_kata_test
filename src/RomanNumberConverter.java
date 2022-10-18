import java.io.IOException;
import java.util.TreeMap;

class RomanNumberConverter {

    TreeMap<Character, Integer> roman = new TreeMap<>();
    TreeMap<Integer, String> arabic = new TreeMap<>();

    public RomanNumberConverter() {
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);

        arabic.put(100, "C");
        arabic.put(90, "XC");
        arabic.put(50, "L");
        arabic.put(40, "XL");
        arabic.put(10, "X");
        arabic.put(9, "IX");
        arabic.put(5, "V");
        arabic.put(4, "IV");
        arabic.put(1, "I");
    }

    public boolean isRomanNumber(String value) {
        return roman.containsKey(value.charAt(0));
    }

    public int romanToArabic(String value) throws IOException {
        if (checkValidRoman(value)) {
            char[] romanNumberList = value.toCharArray();
            int arabicNumber;
            int result = roman.get(romanNumberList[value.length() - 1]);
            for (int i = value.length() - 2; i >= 0; i--) {
                arabicNumber = roman.get(romanNumberList[i]);
                if (arabicNumber < roman.get(romanNumberList[i + 1])) {
                    result -= arabicNumber;
                } else {
                    result += arabicNumber;
                }
            }
            return result;
        } else {
            throw new IOException("Введено не корректное римское число");
        }

    }

    public String arabicToRoman(int value) throws IOException {
        if(value > 0){
            String roman = "";
            int arabicNumber;
            do {
                arabicNumber = arabic.floorKey(value);
                roman += arabic.get(arabicNumber);
                value -= arabicNumber;
            } while (value != 0);
            return roman;
        }else {
            throw new IOException("в римской системе нет отрицательных чисел");
        }

    }

    private boolean checkValidRoman(String value) {
        char[] romanNumberList = value.toCharArray();

        if (romanNumberList.length > 3) {
            int numberOfDuplicateElements = 1;
            for (int i = 0; i < romanNumberList.length - 1; i++) {
                if (romanNumberList[i] == romanNumberList[i + 1]) {
                    numberOfDuplicateElements++;
                    if (numberOfDuplicateElements > 3) {
                        return false;
                    }
                } else {
                    numberOfDuplicateElements = 0;
                }
            }
        }
        return true;
    }
}
