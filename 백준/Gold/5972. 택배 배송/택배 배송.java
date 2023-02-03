import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {

    static int n, m;
    static int min = Integer.MAX_VALUE;
    static List<Point>[] list;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new List[n+1];
        visit = new boolean[n+1];

        for(int i = 1; i <= n; i++) list[i] = new ArrayList<>();

        for(int i = 0; i < m; i++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Point(b, c));
            list[b].add(new Point(a, c));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Point> q = new PriorityQueue<Point>((o1, o2) -> Integer.compare(o1.x, o2.x));

        q.add(new Point(1, 0));

        dist[1] = 0;

        while (!q.isEmpty()){
            Point temp = q.poll();

            if(dist[temp.x] < temp.y){
                continue;
            }

            for(int i = 0; i < list[temp.x].size(); i++){
                Point next = list[temp.x].get(i);

                if(dist[next.x] > temp.y + next.y){
                    dist[next.x] = temp.y + next.y;
                    q.add(new Point(next.x, dist[next.x]));
                }
            }
        }

        System.out.println(dist[n]);

//        DFS(1, 0);
//        System.out.println(min);
    }

//    static void DFS(int num, int sum){
//        if(min < sum) return;
//        if(num == n){
//            min = Math.min(sum, min);
//            return;
//        }
//
//        for(Point p : list[num]){
//            if(!visit[p.x]){
//                visit[p.x] = true;
//                DFS(p.x, sum+p.y);
//                visit[p.x] = false;
//            }
//        }
//
//    }
}