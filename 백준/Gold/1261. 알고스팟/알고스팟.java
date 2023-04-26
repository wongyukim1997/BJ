import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
    static int n, m;
    static int[][] map;
    static List<List<Point>> list = new ArrayList<>();
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n+1][m+1];

        for(int i = 1; i <= n; i++){
            str = br.readLine();
            for(int j = 1; j <= m; j++){
                map[i][j] = Character.getNumericValue(str.charAt(j-1));
            }
        }

        for(int i = 0; i <= n*m; i++) list.add(new ArrayList<>());

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                for(int k = 0; k < 4; k++){
                    int nx = dx[k] + i;
                    int ny = dy[k] + j;

                    if(nx >= 1 && ny >= 1 && nx <= n && ny <= m){
                        if(map[nx][ny] == 1) list.get(i*m - (m-j)).add(new Point(nx*m - (m-ny), 1));
                        else list.get(i*m - (m-j)).add(new Point(nx*m - (m-ny), 0));
                    }
                }
            }
        }

        int[] dist = new int[n*m + 1];
        for(int i = 2; i < dist.length; i++) dist[i] = Integer.MAX_VALUE;

        PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> o1.y - o2.y);
        pq.add(new Point(1, 0));

        while(!pq.isEmpty()){
            Point temp = pq.poll();

            if(temp.y > dist[temp.x]) continue;

            for(int i = 0; i < list.get(temp.x).size(); i++){
                Point next = list.get(temp.x).get(i);

                if(next.y + dist[temp.x] < dist[next.x]){
                    dist[next.x] = next.y + dist[temp.x];
                    pq.add(new Point(next.x, dist[next.x]));
                }
            }
        }

        System.out.print(dist[n*m]);
    }
}
