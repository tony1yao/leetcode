import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountPrimes {
    public static void main(String[] args) {
        CountPrimes countPrimes = new CountPrimes();
        System.out.println(countPrimes.countPrimes(499979));
    }
    public int countPrimes(int n) {
//        int result = 0;
//        for(int i = 0; i < n; i++) {
//            if (isPrime(i)) {
//                result++;
//            }
//        }
//        return result;

        if(n <= 2) {
            return 0;
        }
        //Set<Integer> nonPrimes = new HashSet<>();
        boolean[] nonPrimes = new boolean[n];
        Arrays.fill(nonPrimes, false);
        for (int i = 2 ; i * i < n; i++) {
            if (!nonPrimes[i]) {
                for (int j = i; j <= n/i + 1; j++) {
                    if (i * j < n) {
                        nonPrimes[i*j] = true;
                    } else {
                        break;
                    }
                }
            }
        }

        int result = 0;
        for (int i = 2 ; i < n; i++) {
            if (!nonPrimes[i]) {
                result++;
            }
        }
        return result;
    }

    private boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        return false;



//
//        if (n < 2) {
//            return false;
//        }
//        if (n == 2) {
//            return true;
//        }
//        for(int i = 2; i*i <= n; i++) {
//            if (n % i == 0) {
//                return false;
//            }
//        }
//        return true;
    }
}
