
import java.util.*;
import java.awt.Point;
import java.io.*;

public class Main {
    static int n, min;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        n = Integer.parseInt(str);
        arr = new int[n];

        str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int left = 0;
        int right = n-1;
        min = arr[right] + arr[right-1];

        while(left < right){
            int sum = arr[left] + arr[right];

            if(sum == 0){
                min = 0;
                break;
            }

            if(Math.abs(sum) < Math.abs(min)) min = sum;

            if(sum > 0) right--;
            else left++;

        }

        System.out.println(min);
    }

}