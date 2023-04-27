import java.io.*;
import java.util.*;
import java.awt.Point;
import java.lang.*;

public class Main {
    static int n, m, r, max = 0;
    static int[] item;
    static List<List<Point>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        item = new int[n+1];

        str = br.readLine();
        st = new StringTokenizer(str, " ");

        for(int i = 1; i <= n; i++) item[i] = Integer.parseInt(st.nextToken());
        for(int i = 0; i <= n; i++) list.add(new ArrayList<>());

        for(int i = 0; i < r; i++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(a).add(new Point(b, c));
            list.get(b).add(new Point(a, c));
        }

        for(int i = 1; i <= n; i++) dst(i);
        System.out.println(max);
    }

    static void dst(int start){
        int[] dist = new int[n+1];
        for(int i = 1; i <= n; i++) dist[i] = Integer.MAX_VALUE;

        PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> o1.y-o2.y);
        pq.add(new Point(start, 0));
        dist[start] = 0;

        int sum = 0;

        while(!pq.isEmpty()){
            Point temp = pq.poll();

            if(dist[temp.x] < temp.y) continue;

            for(int i = 0; i < list.get(temp.x).size(); i++){
                Point next = list.get(temp.x).get(i);

                if(temp.y + next.y < dist[next.x]){
                    dist[next.x] = temp.y + next.y;
                    pq.add(new Point(next.x, dist[next.x]));
                }
            }
        }

        for(int i = 1; i <= n; i++){
            if(dist[i] <= m) sum += item[i];
        }

        max = Math.max(max, sum);
//        System.out.println(Arrays.toString(dist) + " " + sum);
    }
}
