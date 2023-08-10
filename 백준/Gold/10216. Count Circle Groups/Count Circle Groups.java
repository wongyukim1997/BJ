
import java.util.*;
import java.io.*;

public class Main {
    static int n;

    static class Net{
        int x, y, r;
        public Net(int x, int y, int r){
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }
    static List<Net> list;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int T = Integer.parseInt(str);

        for(int t = 0; t < T; t++){
            n = Integer.parseInt(br.readLine());
            parent = new int[n+1];
            list = new ArrayList<>();

            for(int i = 1; i <= n; i++) parent[i] = i;

            for(int i = 0; i < n; i++){
                str = br.readLine();
                StringTokenizer st = new StringTokenizer(str, " ");

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                list.add(new Net(x, y, r));
            }

            int cnt = 0;
            for(int i = 0; i < n; i++){
                for(int j = i+1; j < n; j++){
                    int dx = list.get(i).x - list.get(j).x;
                    int dy = list.get(i).y - list.get(j).y;
                    int r = list.get(i).r + list.get(j).r;

                    if(dx * dx + dy * dy <= r * r){
                        if(find(i) != find(j)){
                            union(i, j);
                            cnt++;
                        }
                    }
                }
            }

            cnt = n - cnt;
            System.out.println(cnt);
        }
    }

    static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y){
        int a = find(x);
        int b = find(y);

        if(a != b) parent[b] = a;
    }

}