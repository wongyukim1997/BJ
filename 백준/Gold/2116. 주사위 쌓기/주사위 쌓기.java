
import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int max = 0;
    static int[][] dice;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        n = Integer.parseInt(str);
        dice = new int[n][6];

        for(int i = 0; i < n; i++){
            str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");

            for(int j = 0; j < 6; j++) dice[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int k = 0; k < 6; k++){
            int sum = 0;
            int diceNum = k;

            for(int i = 0; i < n; i++) {
                int maxNum = 0;
                int partner = 0;

                if(diceNum == 0) partner = 5;
                else if(diceNum == 1) partner = 3;
                else if(diceNum == 2) partner = 4;
                else if(diceNum == 3) partner = 1;
                else if(diceNum == 4) partner = 2;
                else partner = 0;

                for (int j = 0; j < 6; j++) {
                    if (j == diceNum || j == partner) continue;
                    maxNum = Math.max(maxNum, dice[i][j]);
                }

                sum += maxNum;
                if(i < n-1) {
                    for (int j = 0; j < 6; j++) {
                        if (dice[i + 1][j] == dice[i][partner]) diceNum = j;
                    }
                }
            }

            max = Math.max(sum, max);
        }

        System.out.println(max);
    }

}