
import java.util.*;
import java.io.*;

public class Main {

    static int n, s;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];

        str = br.readLine();
        st = new StringTokenizer(str, " ");

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;

        // 마지막 비교를 위해 n까지
        for(int right = 0; right <= n; right++){
            if(left > right) continue;

            if(sum >= s) {
                sum -= arr[left];
                left++;
                cnt = Math.min(cnt, right-left+1);

                right--;
            }
            else {
                if(right == n) break;
                sum += arr[right];
            }

//            System.out.println(sum);
        }

        if(cnt == Integer.MAX_VALUE) cnt = 0;
        System.out.println(cnt);
    }
}