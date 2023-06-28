
import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

    static int n;
    static char[][] map;
    static List<Point> list = new ArrayList<>();
    static boolean success = false;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st;

        n = Integer.parseInt(str);
        map = new char[n][n];

        for(int i = 0; i < n; i++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            for(int j = 0; j < n; j++){
                map[i][j] = st.nextToken().charAt(0);
                if(map[i][j] == 'T') list.add(new Point(i, j));
            }
        }

        dfs(0);

        if(success) System.out.println("YES");
        else System.out.println("NO");
    }

    static void dfs(int cnt){
        if(success) return;

        if(cnt == 3){
            success = check();
            return;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == 'X') {
                    map[i][j] = 'O';
                    dfs(cnt+1);
                    map[i][j] = 'X';
                }
            }
        }
    }

    static boolean check(){
        boolean isSuccess = true;

        for(Point t : list){
            for(int i = t.x; i < n; i++){
                if(map[i][t.y] == 'O') break;
                else if(map[i][t.y] == 'S'){
                    isSuccess = false;
                    break;
                }
            }
            for(int i = t.x; i >= 0; i--){
                if(map[i][t.y] == 'O') break;
                else if(map[i][t.y] == 'S'){
                    isSuccess = false;
                    break;
                }
            }
            for(int i = t.y; i < n; i++){
                if(map[t.x][i] == 'O') break;
                else if(map[t.x][i] == 'S'){
                    isSuccess = false;
                    break;
                }
            }
            for(int i = t.y; i >= 0; i--){
                if(map[t.x][i] == 'O') break;
                else if(map[t.x][i] == 'S'){
                    isSuccess = false;
                    break;
                }
            }
            if(!isSuccess) break;
        }

//        System.out.println(isSuccess);
        return isSuccess;
    }
}