import java.util.Map;

public class RomanToInt {
    public int romanToInt(String s) {
        Map<Character, Integer> values = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);
        char[] chars = s.toCharArray();
        int totalNumber = 0;
        for(int i = 0; i < chars.length; i++) {
            var nextValue = values.get(chars[i]);
            var preValue = values.get(chars[i - 1]);
            totalNumber = totalNumber + nextValue;
            if (i > 0 && nextValue > preValue) {
                totalNumber = totalNumber - preValue - preValue;
            }
        }
        return totalNumber;
    }
}
