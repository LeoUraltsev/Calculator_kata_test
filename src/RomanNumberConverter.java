import java.util.TreeMap;

class RomanNumberConverter {

    TreeMap<Character, Integer> roman = new TreeMap<>();

    public RomanNumberConverter(){
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
    }

    public boolean isRomanNumber(String input){
        return roman.containsKey(input.charAt(0));
    }

}
