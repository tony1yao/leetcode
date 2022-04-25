public class Numberof1Bits {
    public static void main(String[] args) {
        Numberof1BitsSolution numberof1BitsSolution = new Numberof1BitsSolution();
        int result = numberof1BitsSolution.hammingWeight(-3);
        System.out.println(result);
    }
}


class Numberof1BitsSolution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        long temp = Integer.toUnsignedLong(n);
        int result = 0;
        while (temp > 0) {
            if (temp % 2 == 1) {
                result ++;
                temp--;
            }
            temp = temp/2;
        }

        return result;
    }
}