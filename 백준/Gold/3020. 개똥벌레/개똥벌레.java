
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] top = new int[m+2];
        int[] bot = new int[m+2];

        for(int i = 0; i < n; i++){
            if(i % 2 == 0) bot[Integer.parseInt(br.readLine())]++;
            else top[m - Integer.parseInt(br.readLine()) + 1]++;
        }

        for(int i = 1; i <= m; i++){
            bot[i] += bot[i-1];
        }
        for(int i = m; i > 0; i--){
            top[i] += top[i+1];
        }

//        System.out.print(Arrays.toString(bot));
//        System.out.println(Arrays.toString(top));

        int min = Integer.MAX_VALUE;
        int cnt = 0;
        for(int i = 1; i <= m; i++){
            int temp = (bot[m] - bot[i - 1]) + (top[1] - top[i + 1]);

            if (temp < min) {
                min = temp;
                cnt = 1;
            } else if (temp == min)
                cnt++;
        }

        System.out.println(min + " " + cnt);
    }

}