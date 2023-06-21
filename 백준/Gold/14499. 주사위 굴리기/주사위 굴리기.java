
import java.util.*;
import java.io.*;

public class Main {
    static class Dice{
        int x, y, up, down, top, bot, right, left;
        public Dice(int x, int y, int up, int down, int top, int bot, int right, int left){
            this.x = x;
            this.y = y;
            this.up = up;
            this.down = down;
            this.top = top;
            this.bot = bot;
            this.right = right;
            this.left = left;
        }
    }
    static Dice dice;
    static int n, m, k;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dice = new Dice(x, y, 0, 0, 0, 0, 0, 0);

        for(int i = 0; i < n; i++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        str = br.readLine();
        st = new StringTokenizer(str, " ");
        for(int i = 0; i < k; i++) {
            int command = Integer.parseInt(st.nextToken());

            int nx = dx[command-1] + dice.x;
            int ny = dy[command-1] + dice.y;

            if(nx >= 0 && ny >= 0 && nx < n && ny < m){
                move(command);
                dice.x = nx;
                dice.y = ny;

                if(map[dice.x][dice.y] == 0) map[dice.x][dice.y] = dice.down;
                else {
                    dice.down = map[dice.x][dice.y];
                    map[dice.x][dice.y] = 0;
                }

                sb.append(dice.up + "\n");
            }
        }

        System.out.println(sb);
    }

    static void move(int d){
        int temp = dice.up;

        if(d == 1){
            dice.up = dice.left;
            dice.left = dice.down;
            dice.down = dice.right;
            dice.right = temp;
        }else if(d == 2){
            dice.up = dice.right;
            dice.right = dice.down;
            dice.down = dice.left;
            dice.left = temp;
        }else if(d == 3){
            dice.up = dice.bot;
            dice.bot = dice.down;
            dice.down = dice.top;
            dice.top = temp;
        }else{
            dice.up = dice.top;
            dice.top = dice.down;
            dice.down = dice.bot;
            dice.bot = temp;
        }
    }
}