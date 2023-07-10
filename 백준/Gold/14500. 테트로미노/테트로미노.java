
import java.util.*;
import java.io.*;

public class Main {
    static int n, m, max = 0;
    static int[][] map;

    static int[][][] dx = {
            {       // 1번
                    {0, 0, 0, 0},
                    {0, 1, 2, 3}
            },
            {       // 2번
                    {0, 0, 0, -1},
                    {0, 0, 0, 1},
                    {0, 1, 2, 2},
                    {0, 1, 2, 2},
                    {0, 0, 0, 1},
                    {0, 0, 0, -1},
                    {0, -1, -2, -2},
                    {0, -1, -2, -2}
            },
            {       // 3번
                    {0, 0, -1, -1},
                    {0, 1, 1, 2},
                    {0, 1, 1, 2},
                    {0, 0, 1, 1}
            },
            {       // 4번
                    {0, 0, -1, 0},
                    {0, 0, 1, 0},
                    {0, 1, 1, 2},
                    {0, 1, 1, 2}
            },
            {       // 5번
                    {0, 0, 1, 1}
            }

    };

    static int[][][] dy = {
            {       // 1번
                    {0, 1, 2, 3},
                    {0, 0, 0, 0},
            },
            {       // 2번
                    {0, 1, 2, 2},
                    {0, 1, 2, 2},
                    {0, 0, 0, 1},
                    {0, 0, 0, -1},
                    {0, -1, -2, -2},
                    {0, -1, -2, -2},
                    {0, 0, 0, 1},
                    {0, 0, 0, -1}
            },
            {       // 3번
                    {0, 1, 1, 2},
                    {0, 0, 1, 1},
                    {0, 0, -1, -1},
                    {0, 1, 1, 2}
            },
            {       // 4번
                    {0, 1, 1, 2},
                    {0, 1, 1, 2},
                    {0, 0, 1, 0},
                    {0, 0, -1, 0}
            },
            {       // 5번
                    {0, 1, 0, 1}
            }
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i = 0; i < n; i++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                checkSum(i, j);
            }
        }

        System.out.println(max);
    }

    static void checkSum(int x, int y){
        int sum = 0;

        for(int k = 0; k < 5; k++){

            for(int i = 0; i < dx[k].length; i++){
                sum = 0;
                boolean check = true;

                for (int j = 0; j < 4; j++){
                    int nx = dx[k][i][j] + x;
                    int ny = dy[k][i][j] + y;

                    if(nx >= 0 && ny >= 0 && nx < n && ny < m){
                        sum += map[nx][ny];
                    }else{
                        check = false;
                        break;
                    }
                }
                if(!check) continue;
                max = Math.max(max, sum);
            }
        }
    }
}