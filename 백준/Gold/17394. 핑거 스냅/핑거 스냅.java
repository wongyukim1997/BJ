import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, a, b;
    static boolean[] visit;
    public static boolean[] prime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st;

        int T = Integer.parseInt(str);
        check();

        for(int t = 0; t< T; t++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");

            n = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            visit = new boolean[1000001];


            System.out.println(BFS());
        }

    }

    static int BFS(){
        Queue<Integer> q = new LinkedList<>();

        q.add(n);
        visit[n] = true;

        int cnt = 0;

        while(!q.isEmpty()){
            int len = q.size();

            for(int l = 0; l < len; l++) {
                int temp = q.poll();
//                System.out.println(temp);

                // 원하는 수
                if (a <= temp && temp <= b && !prime[temp]) {
                    return cnt;
                }

                int temp1 = temp / 2;
                if (!visit[temp1]) {
                    visit[temp1] = true;
                    q.add(temp1);
                }

                int temp2 = temp / 3;
                if (!visit[temp2]) {
                    visit[temp2] = true;
                    q.add(temp2);
                }

                int temp3 = temp + 1;
                if (temp3 <= 1000000 && !visit[temp3]) {
                    visit[temp3] = true;
                    q.add(temp3);
                }

                int temp4 = temp - 1;
                if (temp4 > 0 && !visit[temp4]) {
                    visit[temp4] = true;
                    q.add(temp4);
                }
            }
            cnt++;
        }

        return -1;
    }

    static void check() {
        prime = new boolean[1000001];    // 0 ~ N

		/*
		소수가 아닌 index = true
		소수인 index = false
		*/

        prime[0] = prime[1] = true;

        // 제곱근 함수 : Math.sqrt()
        for (int i = 2; i <= Math.sqrt(1000001); i++) {

            // 이미 체크된 배열이면 다음 반복문으로 skip
            if (prime[i] == true) {
                continue;
            }

            // i 의 배수들을 걸러주기 위한 반복문
            for (int j = i * i; j < prime.length; j = j + i) {
                prime[j] = true;
            }
        }
    }
}