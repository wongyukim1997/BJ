import java.io.*;
import java.awt.*;
import java.util.*;
import java.util.List;
public class Main {
    static class Node{
        int x, y, c;
        public Node(int x, int y, int c){
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }
    static int n, m, p;
    static List<List<Node>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n+1; i++) list.add(new ArrayList<>());

        for(int i = 0; i < m; i++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(a).add(new Node(b, c, 0));
            list.get(b).add(new Node(a, c, 0));
        }

        int[] dist = new int[n+1];

        for(int i = 1; i < n+1; i++) dist[i] = Integer.MAX_VALUE;
        dist[1] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.y, o2.y));
        pq.add(new Node(1, 0, 0));

        boolean success = false;

        while(!pq.isEmpty()){
            Node temp = pq.poll();
            
            if(dist[temp.x] < temp.y) continue;

            if(temp.x == n) {
                if(temp.c == 1) success = true;
            }

            if(temp.x == p){
                temp.c = 1;
            }

            for(int i = 0; i < list.get(temp.x).size(); i++){
                Node next = list.get(temp.x).get(i);

                if(dist[temp.x] + next.y <= dist[next.x]){
                    dist[next.x] = dist[temp.x] + next.y;
//                    System.out.println(temp.x + " " + temp.c);
                    pq.add(new Node(next.x, dist[next.x], temp.c));
                }
            }
        }

//        System.out.println(Arrays.toString(dist));
        if(success)System.out.println("SAVE HIM");
        else System.out.println("GOOD BYE");
    }
}
