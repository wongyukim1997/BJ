import java.util.*;
import java.io.*;

public class Main {
    static class Fireball{
        int x, y, m, d, s, p;
        public Fireball(int x, int y, int m, int d, int s, int p){
            this.x = x;
            this.y = y;
            this.m = m;
            this.d = d;
            this.s = s;
            this.p = p;
        }
    }
    static int n, m, k;
    static List<Fireball>[][] list;
    static int[][] fDir = {
            {0, 2, 4, 6},
            {1, 3 ,5, 7}
    };
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        list = new List[n+1][n+1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                list[i][j] = new ArrayList<>();
            }
        }

        for(int i = 0; i < m; i++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int mm = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            list[x][y].add(new Fireball(x, y, mm, s, d, 0));
        }

        for(int l = 0; l < k; l++){

            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(!list[i][j].isEmpty()){
                        for(Fireball f : list[i][j]) f.p = 0;
                    }
                }
            }

//            for(int i = 1; i <= n; i++){
//                for(int j = 1; j <= n; j++){
//                    if(!list[i][j].isEmpty()){
//                        int mm = 0;
//                        for(Fireball f : list[i][j]) System.out.println(f.m);;
//                        System.out.print("s " + mm + " ");
//                    }
//                    else System.out.print(0 + " ");
//                }
//                System.out.println();
//            }

            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(!list[i][j].isEmpty()) move(i, j);
                }
            }

//            System.out.println();
//            for(int i = 1; i <= n; i++){
//                for(int j = 1; j <= n; j++){
//                    if(!list[i][j].isEmpty()){
//                        int mm = 0;
//                        for(Fireball f : list[i][j]) mm += f.m;
//                        System.out.print(mm + " ");
//                    }
//                    else System.out.print(0 + " ");
//                }
//                System.out.println();
//            }

            check();
//            System.out.println();
//            for(int i = 1; i <= n; i++){
//                for(int j = 1; j <= n; j++){
//                    if(!list[i][j].isEmpty()){
//                        int mm = 0;
//                        for(Fireball f : list[i][j]) mm += f.m;
//                        System.out.print(mm + " ");
//                    }
//                    else System.out.print(0 + " ");
//                }
//                System.out.println();
//            }
        }

        int sum = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(!list[i][j].isEmpty()){
                    for(Fireball f : list[i][j]) sum += f.m;
                }
            }
        }

        System.out.println(sum);
    }

    static void move(int x, int y){
        int size = list[x][y].size();

        for(int i = size-1; i >= 0; i--){
            if(list[x][y].get(i).p == 0) {
                Fireball f = list[x][y].get(i);

                int mx = (f.s * dx[f.d]) % n;
                int my = (f.s * dy[f.d]) % n;

                int nx = mx + f.x;
                int ny = my + f.y;

//                System.out.println(f.x + " " + f.y + " : " + nx + " " + ny);

                if (nx > n) nx -= n;
                else if (nx < 1) nx += n;

                if (ny > n) ny -= n;
                else if (ny < 1) ny += n;

//                System.out.println(f.x + " " + f.y + " : " + nx + " " + ny);

                list[nx][ny].add(new Fireball(nx, ny, f.m, f.d, f.s, 1));
                list[x][y].remove(i);
            }
        }
    }

    static void check(){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                int m = 0;
                int s = 0;

                if(list[i][j].size() > 1){
                    int isOdd = 0;
                    boolean dir = true;
                    int size = list[i][j].size();

                    for(int f = size-1; f >= 0; f--){
                        m += list[i][j].get(f).m;
                        s += list[i][j].get(f).s;

                        if(list[i][j].get(f).d % 2 == 0) {
                            if(isOdd == 0) isOdd = 2;
                            else if(isOdd == 1) dir = false;
                        }
                        else {
                            if(isOdd == 0) isOdd = 1;
                            else if(isOdd == 2) dir = false;
                        }

                        list[i][j].remove(f);
                    }

                    m = m / 5;
                    s = s / size;

                    if(m != 0) {
                        for(int f = 0; f < 4; f++){
                            list[i][j].add(new Fireball(i, j, m, dir ? fDir[0][f] : fDir[1][f], s, 0));
                        }
                    }
                }
            }
        }
    }
}