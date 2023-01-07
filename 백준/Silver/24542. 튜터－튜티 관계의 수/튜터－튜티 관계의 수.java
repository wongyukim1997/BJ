
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static long cnt = 0;
//    static int[][] arr;
    static int[] graph;
    static List<Integer>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new List[n+1];
        graph = new int[n+1];

        for(int i = 1; i <= n; i++) arr[i] = new ArrayList<>();

        for(int i = 0; i < m; i++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        long res = 1;
        long mod = 1000000007;
        for(int i = 1; i <= n; i++){
            if(graph[i] == 0){
                graph[i] = 1;
                cnt = 1;
                DFS(i);

                res = (res * cnt) % mod;
            }
        }

//        System.out.println(Arrays.toString(graph));
        System.out.println(res);
    }

    static void DFS(int num){
        for(int i : arr[num]){
            if(graph[i] == 0){
                graph[i] = 1;
                cnt++;
                DFS(i);
            }
        }
    }
}