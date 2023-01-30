import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {

    static int n, m;
    static List<Point>[] list;
    static List<Integer>[] arr;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new List[n+1];
        arr = new List[m];

        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < n-1; i++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[s].add(new Point(e, w));
            list[e].add(new Point(s, w));
        }

        for(int i = 0; i < m; i++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            visit = new boolean[n+1];
            System.out.println(BFS(a, b));
        }
    }

    static int BFS(int a, int b){
        Queue<Point> q = new LinkedList<>();

        q.add(new Point(a, 0));

        while (!q.isEmpty()){
            Point temp = q.poll();

            if(temp.x == b) return temp.y;

            for(int i = 0; i < list[temp.x].size(); i++){
                int s = list[temp.x].get(i).x;

                if(!visit[s]){
                    int w = temp.y + list[temp.x].get(i).y;
                    q.add(new Point(s, w));
                    visit[s] = true;
                }

            }
        }

        return 0;
    }
}