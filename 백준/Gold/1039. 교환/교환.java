
import java.util.*;
import java.io.*;

public class Main {
    static int n, k;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visit = new boolean[k][1000001];

        bfs();
    }

    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(n);

        int cnt = 0;
        while(!q.isEmpty()){
            int len = q.size();

            if(cnt >= k) break;

            for(int l = 0; l < len; l++){
                String temp = q.poll().toString();

                for(int i = 0 ; i < temp.length()-1; i++){
                    char c1 = temp.charAt(i);
                    for(int j = i+1; j < temp.length(); j++){
                        String s = temp;
                        char c2 = temp.charAt(j);

                        s = s.substring(0, i) + c2 + s.substring(i+1);
                        s = s.substring(0, j) + c1 + s.substring(j+1);

                        int swapInt = Integer.parseInt(s);

                        if(s.charAt(0) != '0' && !visit[cnt][swapInt]){
//                            System.out.println(cnt + " : " + swapInt);
                            visit[cnt][swapInt] = true;
                            q.add(swapInt);
                        }
                    }
                }
            }

            cnt++;
        }

        int len = q.size();
        int max = 0;

        if(len == 0) System.out.println(-1);
        else{
            for(int i = 0; i < len; i++) max = Math.max(max, q.poll());
            System.out.println(max);
        }
    }
}