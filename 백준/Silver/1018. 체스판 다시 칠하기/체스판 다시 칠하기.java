import java.io.*;
import java.util.*;

public class Main {

    static char[][] A = {
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'}
    };

    static char[][] B = {
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m];

        for(int i = 0; i < n; i++){
            str = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = str.charAt(j);
            }
        }

        int maxN = n - 8;
        int maxM = m - 8;
        int min = 51;

        // 시작 index 설정
        for(int i = 0; i <= maxN; i++){
            for(int j = 0; j <= maxM; j++){
                // 시작 index 부터 8칸씩 돌기
                char index = map[i][j];
                int cntA = 0;
                int cntB = 0;

                for(int h = i; h < i+8; h++){
                    for(int k = j; k < j+8; k++) {
                        if(map[h][k] != A[h-i][k-j]) cntA++;
                        if(map[h][k] != B[h-i][k-j]) cntB++;
                    }
                }
                min = Math.min(min, cntA);
                min = Math.min(min, cntB);
            }
        }

        System.out.println(min);
    }
}