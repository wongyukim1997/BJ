
import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int [n];

        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        int left = 0;
        int right = 0;
        int max = Integer.MAX_VALUE;

        while(left <= right) {
            if(arr[right] - arr[left] >= m) {
                max = Math.min(max, arr[right]-arr[left]);
                left++;
            }
            else {
                right++;
                if(right >= n) break;
            }
        }

        System.out.println(max);
    }

}