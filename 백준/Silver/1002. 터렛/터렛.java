import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, a, b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st;

        int T = Integer.parseInt(str);

        for(int t = 0; t< T; t++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int z1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int z2 = Integer.parseInt(st.nextToken());


            int disPow = (int)(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));

            if(x1 == x2 && y1 == y2 && z1 == z2) {
                System.out.println(-1);
            }
            else if(disPow > Math.pow(z1+z2, 2)) {
                System.out.println(0);
            }
            else if(disPow < Math.pow(z2-z1, 2)) {
                System.out.println(0);
            }
            else if(disPow == Math.pow(z2-z1, 2)) {
                System.out.println(1);
            }
            else if(disPow == Math.pow(z1+z2, 2)) {
                System.out.println(1);
            }
            else {
                System.out.println(2);
            }
        }

    }
}