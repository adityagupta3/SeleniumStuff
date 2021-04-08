import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution1 {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
       
    	System.out.println(a.length);
    	int[] arr = new int[a.length];
        for(int i = a.length ; i>0 ; i--){
            if(i<d){
                arr[i+a.length-d] = a[i];
                System.out.println(arr[i+a.length-d]);
            } else {
            	arr[i-d] = a[i];
                System.out.println(arr[i-d]);
            }
            
            
        }
        return arr;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
      //  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
            System.out.println(aItem);
        }

        int[] result = rotLeft(a, d);

//        for (int i = 0; i < result.length; i++) {
//            bufferedWriter.write(String.valueOf(result[i]));
//
//            if (i != result.length - 1) {
//                bufferedWriter.write(" ");
//            }
//        }
//
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
        for (int element: result) {
            System.out.print(element);
        }

        scanner.close();
    }
}
