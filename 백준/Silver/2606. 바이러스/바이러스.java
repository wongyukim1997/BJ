import java.io.*;
import java.util.*;

public class Main {

    static int n, m, cnt = 0;
    static int[][] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        n = Integer.parseInt(str);
        str = br.readLine();
        m = Integer.parseInt(str);

        arr = new int[n+1][n+1];
        visited = new boolean[n+1];

        for(int i = 0; i < m; i++){
            str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        visited[1] = true;
        dfs(1);
        System.out.println(cnt);
    }

    public static void dfs(int num){
        for(int i = 1; i <= n; i++){
            if(arr[num][i] == 1 && !visited[i]){
                visited[i] = true;
                cnt++;
//                System.out.println(i);
                dfs(i);
            }
        }
    }
}
