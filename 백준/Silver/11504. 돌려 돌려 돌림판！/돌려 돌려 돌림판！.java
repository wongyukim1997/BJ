
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int T = Integer.parseInt(str);

        for(int t = 0; t < T; t++){
            str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];

            int x = 0;
            int y = 0;

            str = br.readLine();
            st = new StringTokenizer(str, " ");
            for(int i = m-1; i >= 0; i--){
                int num = Integer.parseInt(st.nextToken());
                x += Math.pow(10, i) * num;
            }

            str = br.readLine();
            st = new StringTokenizer(str, " ");
            for(int i = m-1; i >= 0; i--){
                int num = Integer.parseInt(st.nextToken());
                y += Math.pow(10, i) * num;
            }

            str = br.readLine();
            st = new StringTokenizer(str, " ");
            for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

            int cnt = 0;
            for(int i = 0; i < n; i++){
                int c = m-1;
                int res = 0;
                for(int j = i; j < i+m; j++){
                    int k = j;
                    if(k >= n) k -= n;
                    res += Math.pow(10, c) * arr[k];
                    c--;
                }

                if(x <= res && res <= y) cnt++;
            }

            System.out.println(cnt);
        }
    }

}