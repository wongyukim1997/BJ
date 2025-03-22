import java.util.*;
import java.io.*;
import java.awt.*;
import java.util.List;

public class Main {
    static int[][] map;
    static boolean[][] check;
    static int n;
    static int[][] idx = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        n = Integer.parseInt(str);
        map = new int[n][n];
        check = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            str = br.readLine();

            for(int j = 0; j < n; j++) {
                map[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        int c = 1;
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!check[i][j] && map[i][j] == 1) {
                    check[i][j] = true;
                    list.add( BFS(new Point(i, j)) );
                }
            }
        }

        Collections.sort(list);

        System.out.println(list.size());

        for(int i : list) {
            System.out.println(i);
        }
    }

    public static int BFS(Point start) {
        Queue<Point> q = new LinkedList<>();
        q.offer(start);

        int cnt = 1;

        while(!q.isEmpty()) {
            Point temp = q.poll();

            for(int i = 0; i < 4; i++) {
                int tx = temp.x + idx[i][0];
                int ty = temp.y + idx[i][1];

                if(tx >= 0 && ty >= 0 && tx < n && ty < n && map[tx][ty] == 1 && !check[tx][ty]) {
                    cnt++;
                    check[tx][ty] = true;
                    q.offer(new Point(tx, ty));
                }
            }
        }

        return cnt;
    }



}
