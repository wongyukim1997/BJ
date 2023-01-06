import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int T = Integer.parseInt(str);
        dp = new long[65][10];

        for(int i = 0; i < 10; i++) dp[1][i] = 1;

        make();

        for(int t = 0; t < T; t++){
            str = br.readLine();
            int num = Integer.parseInt(str);

            long sum = 0;
            for(int i = 0; i < 10; i++) {
                sum += dp[num][i];
            }

            System.out.println(sum);
        }
    }

//    99
//    999
//
//    88 89
//    888 889 899
//
//    77 78 79
//    777 778 779 788 789 799
//
//    66 67 68 69
//    666 667 668 669 677 678 679 688 689 699

    static void make(){
        for (int k = 2; k <= 64; k++) {
            for (int i = 0; i <= 9; i++) {
                for (int j = i; j <= 9; j++) {
                    dp[k][i] += dp[k-1][j];
                }
            }
        }
    }
}