import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlusOne {
    public static void main(String[] args) {
        PlusOneSolution plusOneSolution = new PlusOneSolution();
        int[] inputs = {9};
        System.out.println(Arrays.toString(plusOneSolution.plusOne(inputs)));
    }
}


class PlusOneSolution {
    public int[] plusOne(int[] digits) {
        int[] copy = Arrays.copyOf(digits, digits.length);
        boolean makeTen = false;
        for(int i = copy.length - 1; i >= 0; i--) {
            if (copy[i] == 9) {
                copy[i] = 0;
                makeTen = true;
            } else {
                copy[i]++;
                makeTen = false;
                break;
            }
        }
        if (!makeTen) {
            return copy;
        } else {
            int[] result = new int[copy.length + 1];
            result[0] = 1;
            for (int i= 0 ; i < copy.length; i++) {
                result[i+1] = copy[i];
            }
            return result;
        }
    }
}