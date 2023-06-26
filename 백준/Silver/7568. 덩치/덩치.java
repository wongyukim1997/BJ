
import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(str);
        arr = new int[n][2];

        StringTokenizer st;
        for(int i = 0; i < n; i++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++){
            int cnt = 1;
            for(int j = 0; j < n; j++){
                if(arr[j][0] > arr[i][0] && arr[j][1] > arr[i][1]) cnt++;
            }
            sb.append(cnt + " ");
        }

        System.out.println(sb);
    }
}