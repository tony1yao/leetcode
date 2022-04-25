public class ReverseInteger {

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(2137383648));
    }

    public int reverse(int x) {
        int num = x;
        long result = 0;
        while (num != 0) {
            int lastDigit = num % 10;
            num = num / 10;
            result = result * 10 + lastDigit;
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return (int)result;
    }
}
