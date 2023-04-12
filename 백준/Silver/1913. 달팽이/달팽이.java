import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] map;
    static int[][] dic = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        n = Integer.parseInt(str);
        str = br.readLine();
        m = Integer.parseInt(str);

        map = new int[n][n];

        int last = n*n;
        int d = 0;
        int x = 0;
        int y = 0;

        int targetX = 0;
        int targetY = 0;

        for(int i = last; i > 0; i--){
            map[x][y] = i;

            int nx = x + dic[d][0];
            int ny = y + dic[d][1];

            if(nx >= 0 && ny >= 0 && nx < n && ny < n && map[nx][ny] == 0){
                x = nx;
                y = ny;
            }else {
                if (d == 0) d = 1;
                else if (d == 1) d = 2;
                else if (d == 2) d = 3;
                else d = 0;

                x = x + dic[d][0];
                y = y + dic[d][1];
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sb.append(map[i][j] + " ");
                if(map[i][j] == m){
                    targetX = i+1;
                    targetY = j+1;
                }
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
        System.out.println(targetX + " " + targetY);
    }
}
