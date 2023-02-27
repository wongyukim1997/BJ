
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {

    static class Pnt implements Comparable<Pnt>{
        int x, y;

        public Pnt(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pnt o) {
            if(this.x != o.x) return this.x - o.x;
            else return this.y - o.y;
        }
    }

    static int n, cnt = 0;
    static int[][] arr;
    static boolean[] visit;
    static List<Pnt> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st;

        n = Integer.parseInt(str);

        arr = new int[52][52];

        for(int i = 0; i < n; i++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");


            char t = st.nextToken().charAt(0);
            int a = t;

            st.nextToken();

            char t2 = st.nextToken().charAt(0);
            int b = t2;

//            System.out.println(t + " : " + a + " | " + t2 + " : " + b);

            if(65 <= a && a <= 90) a -= 65;
            else a = a - 97 + 26;

            if(65 <= b && b <= 90) b -= 65;
            else b = b - 97 + 26;

//            System.out.println(t + " : " + a + " | " + t2 + " : " + b);
            arr[a][b] = 1;
        }

        for(int i = 0; i < 52; i++){
            visit = new boolean[52];
            dfs(i, i);
        }

        Collections.sort(list);
//        for(int i = 0; i < list.size(); i++) System.out.println(list.get(i).x + " " + list.get(i).y);

        for(int i = 0; i < list.size(); i++){
            sb.append((char)list.get(i).x + " => " + (char)list.get(i).y + "\n");
        }

        System.out.println(cnt + "\n" + sb.toString());
    }

    static void dfs(int from, int num){
        for(int i = 0; i < 52; i++){
            if(from != i && num != i && !visit[i] && arr[num][i] == 1){
                visit[i] = true;
                cnt++;

                int fr = from;
                int as = i;

                if(0 <= fr && fr <= 25) fr += 65;
                else fr = fr + 97 - 26;

                if(0 <= as && as <= 25) as += 65;
                else as = as + 97 - 26;

                list.add(new Pnt(fr, as));

                dfs(from, i);
            }
        }
    }

}