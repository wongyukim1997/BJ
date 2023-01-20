
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1];

        str = br.readLine();
        st = new StringTokenizer(str, " ");
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
//        System.out.println(Arrays.toString(arr));

        int start = 0;
        int end = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        while(end <= n) {
            if(sum >= m) {
                sum -= arr[start++];
                int cnt = end - start + 1;
                min = Math.min(min, cnt);
            }else if(sum < m) {
                sum += arr[end++];
            }
        }

        if(min == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(min);
    }
}