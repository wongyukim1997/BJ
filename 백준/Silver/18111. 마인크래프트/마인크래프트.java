
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int block = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        int max = 0;
        int min = 256;

        for(int i = 0; i < n; i++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
                min = Math.min(min, map[i][j]);
            }
        }

        long totalTimeMin = 999999999;
        int totalHighMax = 0;

        for(int k = min; k <= max; k++) {
            long timeSum = 0;
            int totalBlock = block;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int timeAndBlock = calculate(map[i][j], k);

                    timeSum += timeAndBlock;
                    if(map[i][j] < k) totalBlock -= timeAndBlock;
                    else totalBlock += timeAndBlock/2;
                }
            }

            if(totalBlock < 0) continue;

            if(timeSum <= totalTimeMin){
                totalTimeMin = timeSum;
                totalHighMax = k;
            }
        }

        System.out.println(totalTimeMin + " " + totalHighMax);
    }

    static int calculate(int num, int target){
        int timeAndBlock = 0;

        if(num > target){
            timeAndBlock = (num - target) * 2;
        }else{
            timeAndBlock = target - num;
        }

        return timeAndBlock;
    }
}