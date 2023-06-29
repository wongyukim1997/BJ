

import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static List<Integer>[] list;
    static int[] parent;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new List[n+1];
        parent = new int[n+1];

        for(int i = 1; i <= n; i++) parent[i] = i;

        for(int i = 0; i <= n; i++) list[i] = new ArrayList<>();

        for(int i = 0; i < m; i++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
//            list[a].add(b);
//            list[b].add(a);
        }

        for(int i = 1; i <= n; i++) if(parent[i] == i) cnt++;

//        System.out.println(Arrays.toString(parent));
        System.out.println(cnt-1);
    }

    static int find(int x){
        if(parent[x] == x){
            return x;
        }
        else{
            return parent[x] = find(parent[x]);
        }
    }

    static void union(int x, int y){
        int a = find(x);
        int b = find(y);

        if(a == b) cnt++;

        if (find(a) <= find(b)) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
}