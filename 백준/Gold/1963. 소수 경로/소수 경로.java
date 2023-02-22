    import java.awt.*;
    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.*;
    import java.util.List;

public class Main {

    static int n;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st;

         n = Integer.parseInt(str);

         for(int i = 0; i < n; i++){
             str = br.readLine();
             st = new StringTokenizer(str, " ");

             visit = new boolean[10001];

             int a = Integer.parseInt(st.nextToken());
             int b = Integer.parseInt(st.nextToken());

//             System.out.println(get1(a) + " " + get10(a) + " " + get100(a) + " " + get1000(a));

             int res = bfs(a, b);

             if(res != -1) System.out.println(res);
             else System.out.println("Impossible");

         }
    }


    static int bfs(int a, int b){
        Queue<Integer> q = new LinkedList<>();

        q.add(a);
        visit[a] = true;

        int cnt = 0;
        while (!q.isEmpty()){
            int len = q.size();

            for(int l = 0; l < len; l++){
                int temp = q.poll();

                if(temp == b){
                    return cnt;
                }

                for(int i = 0; i < 10; i++){
                    int g1 = get1000(temp) + get100(temp) + get10(temp) + i;
                    int g2 = get1000(temp) + get100(temp) + i*10 + get1(temp);
                    int g3 = get1000(temp) + i*100 + get10(temp) + get1(temp);
                    int g4 = i*1000 + get100(temp) + get10(temp) + get1(temp);

                    if(checkPri(g1) && !visit[g1]){
                        visit[g1] = true;
                        q.add(g1);
                    }
                    if(checkPri(g2) && !visit[g2]){
                        visit[g2] = true;
                        q.add(g2);
                    }
                    if(checkPri(g3) && !visit[g3]){
                        visit[g3] = true;
                        q.add(g3);
                    }
                    if(i != 0 && checkPri(g4) && !visit[g4]){
                        visit[g4] = true;
                        q.add(g4);
                    }
                }
            }

            cnt++;
        }

        return -1;
    }

    static int get1(int num){
        return num%10;
    }

    static int get10(int num){
        return (num%100)/10 * 10;
    }

    static int get100(int num){
        return (num%1000)/100 * 100;
    }

    static int get1000(int num){
        return num/1000 * 1000;
    }

    static boolean checkPri(int num){
        // 제곱근 함수 : Math.sqrt()
        for(int i = 2; i <= Math.sqrt(num); i++) {
            // 소수가 아닐경우 종료
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}