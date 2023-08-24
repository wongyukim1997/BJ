
import java.util.*;
import java.io.*;

public class Main {

    static int n, max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st;

        n = Integer.parseInt(str);
        int[][] map = new int[n][n];

        for(int i = 0; i < n; i++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, map);
        System.out.println(max);
    }

    static void dfs(int num, int[][] map){
        if(num == 5){
            check(map);
            return;
        }

        int[][] temp = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) temp[i][j] = map[i][j];
        }
        
        for(int k = 0; k < 4; k++) {
            temp = move(k, temp);
            dfs(num+1, temp);
            
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++) temp[i][j] = map[i][j];
            }
        }

    }

    static int[][] move(int d, int[][] map){
        boolean[][] visit = new boolean[n][n];

        // 아래
        if(d == 0){
            for(int i = 0; i < n; i++){
                for(int j = n-1; j >= 0; j--){
                    if(map[j][i] != 0){
                        for(int k = j+1; k < n; k++){
                            if(map[k][i] != 0 && !visit[k][i] && map[k][i] == map[j][i]){
                                map[k][i] = map[k][i] * 2;
                                map[j][i] = 0;
                                visit[k][i] = true;
                                break;
                            }
                            else if(map[k][i] != 0 && visit[k][i]) {
                                int temp = map[j][i];
                                map[k-1][i] = temp;
                                map[j][i] = 0;
                                break;
                            }
                            else if(map[k][i] != 0 && map[k][i] != map[j][i]){
                                int temp = map[j][i];
                                map[j][i] = 0;
                                map[k-1][i] = temp;
                                break;
                            }
                            else if(k == n-1 && map[k][i] == 0){
                                map[k][i] = map[j][i];
                                map[j][i] = 0;
                                break;
                            }
                        }
                    }
                }
            }
        }
        // 위
        else if(d == 1){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(map[j][i] != 0){
                        for(int k = j-1; k >= 0; k--){
                            if(map[k][i] != 0 && !visit[k][i] && map[k][i] == map[j][i]){
//                            System.out.println(1);
                                map[k][i] = map[k][i] * 2;
                                map[j][i] = 0;
                                visit[k][i] = true;
                                break;
                            }
                            else if(map[k][i] != 0 && visit[k][i]) {
//                            System.out.println(2);
                                int temp = map[j][i];
                                map[k+1][i] = temp;
                                map[j][i] = 0;
                                break;
                            }
                            else if(map[k][i] != 0 && map[k][i] != map[j][i]){
//                            System.out.println(3);
                                int temp = map[j][i];
                                map[j][i] = 0;
                                map[k+1][i] = temp;
                                break;
                            }
                            else if(k == 0 && map[k][i] == 0){
//                            System.out.println(4);
                                map[k][i] = map[j][i];
                                map[j][i] = 0;
                                break;
                            }
                        }
                    }
                }
            }
        }
        // 오른쪽
        else if(d == 2){
            for(int i = 0; i < n; i++){
                for(int j = n-1; j >= 0; j--){
                    if(map[i][j] != 0){
                        for(int k = j+1; k < n; k++){
                            if(map[i][k] != 0 && !visit[i][k] && map[i][k] == map[i][j]){
//                            System.out.println(1);
                                map[i][k] = map[i][k] * 2;
                                map[i][j] = 0;
                                visit[i][k] = true;
                                break;
                            }
                            else if(map[i][k] != 0 && visit[i][k]) {
//                            System.out.println(2);
                                int temp = map[i][j];
                                map[i][k-1] = temp;
                                map[i][j] = 0;
                                break;
                            }
                            else if(map[i][k] != 0 && map[i][k] != map[i][j]){
//                            System.out.println(3);
                                int temp = map[i][j];
                                map[i][j] = 0;
                                map[i][k-1] = temp;
                                break;
                            }
                            else if(k == n-1 && map[i][k] == 0){
//                            System.out.println(4);
                                map[i][k] = map[i][j];
                                map[i][j] = 0;
                                break;
                            }
                        }
                    }
                }
            }
        }
        // 왼쪽
        else{
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(map[i][j] != 0){
                        for(int k = j-1; k >= 0; k--){
                            if(map[i][k] != 0 && !visit[i][k] && map[i][k] == map[i][j]){
//                            System.out.println(1);
                                map[i][k] = map[i][k] * 2;
                                map[i][j] = 0;
                                visit[i][k] = true;
                                break;
                            }
                            else if(map[i][k] != 0 && visit[i][k]) {
//                            System.out.println(2);
                                int temp = map[i][j];
                                map[i][k+1] = temp;
                                map[i][j] = 0;
                                break;
                            }
                            else if(map[i][k] != 0 && map[i][k] != map[i][j]){
//                            System.out.println(3);
                                int temp = map[i][j];
                                map[i][j] = 0;
                                map[i][k+1] = temp;
                                break;
                            }
                            else if(k == 0 && map[i][k] == 0){
//                            System.out.println(4);
                                map[i][k] = map[i][j];
                                map[i][j] = 0;
                                break;
                            }
                        }
                    }
                }
            }
        }
        
        return map;
    }

    static void check(int[][] map){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) max = Math.max(map[i][j], max);
        }
    }

}