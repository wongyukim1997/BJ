import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(str);
        arr = new int[n];

        str = br.readLine();
        st = new StringTokenizer(str, " ");
        for(int i = 0; i < n; i++){
            if(i == 0) arr[i] = Integer.parseInt(st.nextToken());
            else arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }

//        System.out.println(Arrays.toString(arr));
        str = br.readLine();
        m = Integer.parseInt(str);

        for(int i = 0; i < m; i++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a == 1) sb.append(arr[b-1] + "\n");
            else sb.append(arr[b-1] - arr[a-2] + "\n");
        }

        System.out.println(sb);
    }
}
