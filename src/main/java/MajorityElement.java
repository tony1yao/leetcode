import java.util.Arrays;

public class MajorityElement {


    static int majorityElement(int a[])
    {
        // your code here
        if (a == null || a.length == 0) {
            return -1;
        } else {
            Arrays.sort(a);
            int valueInMiddle = a[a.length/2];
            int occurence = 0;
            for(int value: a) {
                if (value == valueInMiddle) {
                    occurence++;
                }
            }
            if (occurence >= a.length / 2 + 1) {
                return valueInMiddle;
            } else {
                return -1;
            }
        }
    }
}
