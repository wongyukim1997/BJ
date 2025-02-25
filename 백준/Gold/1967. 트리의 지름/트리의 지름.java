

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, max_idx;
    static int max = Integer.MIN_VALUE;
    static List<Point>[] arr;
    static boolean[] visit;
    static List<Integer> list = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        StringTokenizer st;

        n = Integer.parseInt(str);

        arr = new List[n+1];
        for(int i = 1; i <= n; i++) arr[i] = new ArrayList<>();

        for(int i = 1; i < n; i++) {
            str = bf.readLine();
            st = new StringTokenizer(str, " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[a].add(new Point(b, c));
            arr[b].add(new Point(a, c));
        }

        // 리프노드 골라내기

        visit = new boolean[n+1];
        visit[1] = true;
        dfs(1,0,0);

        visit = new boolean[n+1];
        visit[max_idx] = true;
        dfs(max_idx,0,0);

//		for(int i = 1; i <= n; i++) {
//			visit = new boolean[n+1];
//			visit[i] = true;
//			dfs(i, 0, 0);
//		}

        System.out.println(max);
    }

    static void dfs(int start, int from, int sum) {
        if(max < sum) {
            max = sum;
            max_idx = start;
        }

        for(Point p : arr[start]){
            if(p.x != from && !visit[p.x]){
                visit[p.x] = true;
                dfs(p.x, start, sum+p.y);
            }
        }

//        for(int i = 1; i <= n; i++) {
//            if(i != from && !visit[i] && arr[start][i] > 0) {
//                visit[i] = true;
//                dfs(i, start, sum + arr[start][i]);
//            }
//        }
    }

}
