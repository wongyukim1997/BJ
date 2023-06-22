
import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] map = new int[101][101];
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1 ,0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        n = Integer.parseInt(str);

        for(int t = 0; t < n; t++){
            str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");

            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            map[x][y] = 1;
            List<Integer> list = new ArrayList<>();
            list.add(d);

            for(int i = 1; i <= g; i++){
                int size = list.size();

                for(int j = size-1; j >= 0; j--){
                    int next = list.get(j);
                    next++;

                    if(next == 4) next = 0;
                    list.add(next);
                }
            }

            for(int i = 0; i < list.size(); i++){
                x += dx[list.get(i)];
                y += dy[list.get(i)];

                map[x][y] = 1;
            }

        }

        int cnt = 0;
        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
                if(map[i][j] == 1 && map[i+1][j] == 1 && map[i][j+1] == 1 && map[i+1][j+1] == 1) cnt++;
            }
        }

        System.out.println(cnt);
    }

}