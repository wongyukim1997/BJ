
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {

    static int n, t, g;
    static boolean[] visit = new boolean[100000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());

        int res = bfs();

        if(res != -1 && res <= t) System.out.println(res);
        else System.out.println("ANG");
    }

    static int bfs(){
        Queue<Integer> q = new LinkedList<>();

        q.add(n);

        int cnt = 0;
        while (!q.isEmpty()){
            int len = q.size();

            for(int l = 0; l < len; l++){
                int temp = q.poll();
                if(temp == g) return cnt;

                int a = temp + 1;
                if(a <= 99999 && !visit[a]){
                    visit[a] = true;
                    q.add(a);
                }

                int b = temp * 2;

                if(b <= 99999){
                    b = getButtonB(b);

                    if(!visit[b]){
                       visit[b] = true;
                       q.add(b);
                    }
                }
            }

            cnt++;
        }

        return -1;
    }

    static int getButtonB(int num){
        int b = num;

        int c = 0;
        while (true){
            if(num / 10 > 0){
                num = num / 10;
                c++;
            }
            else break;
        }

        int t = num;
        for(int i = 0; i < c; i++) t *= 10;

        int t2 = num-1;
        for(int i = 0; i < c; i++) t2 *= 10;

        b = b - t + t2;
        if(b < 0) b = 0;

        return b;
    }

}