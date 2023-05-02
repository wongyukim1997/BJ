import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        n = Integer.parseInt(str);
        int[][] arr = new int[2][n];

        int sumL = 0;
        int sumR = 0;

        str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());

            if(num == 1) {
                sumL++;

                sumR--;
                if(sumR < 0) sumR = 0;
            }
            else{
                sumR++;

                sumL--;
                if(sumL < 0) sumL = 0;
            }

            arr[0][i] = sumL;
            arr[1][i] = sumR;
        }
//
//        System.out.println(Arrays.toString(arr[0]));
//        System.out.println(Arrays.toString(arr[1]));
        Arrays.sort(arr[0]);
        Arrays.sort(arr[1]);
//        System.out.println(Arrays.toString(arr));
        System.out.println(Math.max(arr[0][n-1], arr[1][n-1]));
    }
}
