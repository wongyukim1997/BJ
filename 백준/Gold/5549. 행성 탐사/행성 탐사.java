
import java.io.*;
import java.util.*;

public class Main {
    static int n, m, K;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        str = br.readLine();

        K = Integer.parseInt(str);

        map = new char[n+1][m+1];
        int[][] sumJ = new int[n+1][m+1];
        int[][] sumO = new int[n+1][m+1];
        int[][] sumI = new int[n+1][m+1];

        for(int i = 1; i <= n; i++){
            str = br.readLine();
            for(int j = 1; j <= m; j++){
                map[i][j] = str.charAt(j-1);

                sumJ[i][j] = sumJ[i-1][j] + sumJ[i][j-1] - sumJ[i-1][j-1];
                sumO[i][j] = sumO[i-1][j] + sumO[i][j-1] - sumO[i-1][j-1];
                sumI[i][j] = sumI[i-1][j] + sumI[i][j-1] - sumI[i-1][j-1];

                if(map[i][j] == 'J') sumJ[i][j]++;
                else if(map[i][j] == 'O') sumO[i][j]++;
                else if(map[i][j] == 'I') sumI[i][j]++;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int k = 0; k < K; k++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");

            int ax = Integer.parseInt(st.nextToken());
            int ay = Integer.parseInt(st.nextToken());
            int bx = Integer.parseInt(st.nextToken());
            int by = Integer.parseInt(st.nextToken());

            int thisJ = sumJ[bx][by] - sumJ[bx][ay-1] - sumJ[ax-1][by] + sumJ[ax-1][ay-1];
            int thisO = sumO[bx][by] - sumO[bx][ay-1] - sumO[ax-1][by] + sumO[ax-1][ay-1];
            int thisI = sumI[bx][by] - sumI[bx][ay-1] - sumI[ax-1][by] + sumI[ax-1][ay-1];

            sb.append(thisJ + " " + thisO + " " + thisI + "\n");
        }

        System.out.println(sb);
    }
}