import java.util.Arrays;
import java.util.Scanner;

public class SortArray {

    public static void main(String[] args) {
        int[] result = getIntegers();
        System.out.println("array is ");
        printArray(result);
        var sortedResult = sortIntegers(result);
        System.out.println("result is ");
        printArray(sortedResult);

        
    }

    static int[] getIntegers() {
        System.out.println("Please provide the size of the array");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] result = new int[size];
        System.out.println("Please provide all the numbers");
        for(int n = 0; n < size; n++) {
            result[n] = scanner.nextInt();
        }
        return result;
    }

    static void printArray(int[] array) {
        Arrays.stream(array).forEach(System.out::println);
    }

    static int[] sortIntegers(int[] array) {
        int[] arrayCopy = Arrays.copyOf(array, array.length);
        for(int n = 0; n < arrayCopy.length; n++) {
            for (int m = n+1; m<arrayCopy.length; m++) {
                if (arrayCopy[n]<arrayCopy[m]) {
                    int temp = arrayCopy[n];
                    arrayCopy[n] = arrayCopy[m];
                    arrayCopy[m] = temp;
                }
            }
        }
        return arrayCopy;
    }
}
