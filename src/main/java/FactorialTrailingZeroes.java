public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        FactorialTrailingZeroes factorialTrailingZeroes = new FactorialTrailingZeroes();
        for (int i = 1; i <= 20; i++) {
            System.out.println(factorialTrailingZeroes.factorial(i));
        }
    }

    private int factorial(int n) {
        int result = 0;
        int total = 1;
        for(int i = 1; i <= n; i++) {
            total = total * i;
            if (total % 10 == 0) {
                result++;
                total = total/10;
            }
        }

        System.out.print("Total of "+n+" is " + total + "    ");
        return result;
    }
}


