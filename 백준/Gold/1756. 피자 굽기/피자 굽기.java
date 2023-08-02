
import java.util.*;
import java.io.*;

public class Main {
    static int d, n;
    static int[] dough;
    static boolean[] check;
    static int[] oven;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        d = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        oven = new int[d];
        check = new boolean[d];
        dough = new int[n];


        str = br.readLine();
        st = new StringTokenizer(str, " ");
        for(int i = 0; i < d; i++) {
            int o = Integer.parseInt(st.nextToken());
            if(i != 0 && oven[i-1] < o) o = oven[i-1];

            oven[i] = o;
        }

//        System.out.println(Arrays.toString(oven));

        str = br.readLine();
        st = new StringTokenizer(str, " ");
        for(int i = 0; i < n; i++) dough[i] = Integer.parseInt(st.nextToken());

        int pizza = 0;

        // 도착한 항아리 높이 구하기
        int cnt=1;
        int res =0;
        for(int i = oven.length-1; i>=0; i--) {

            if(dough[pizza] <= oven[i]) {

                pizza++;
                // 피자갯수만큼 했다면 값을 리턴하고 종료
                if(pizza >= n) {
                    res=i+1;
                    break;
                }

                // 피자갯수만큼 못했다면 0을 리턴
                if(i == 0) {
                    res=0;
                    break;
                }
            }
        }

        System.out.println(res);
    }
}