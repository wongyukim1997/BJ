import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] arr;
    static int[] order;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        order = new int[n+1];

        str = br.readLine();
        st = new StringTokenizer(str, " ");
        for(int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());

        for(int i = 0; i < m; i++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            order[a] += c;
            if(b+1 <= n) order[b+1] += -c;
        }

        int pre = 0;
        for(int i = 1; i <= n; i++){
            pre += order[i];
//            System.out.print(pre + " ");
            arr[i] += pre;
            sb.append(arr[i] + " ");
        }
//        System.out.println();
        System.out.println(sb);
    }
}
