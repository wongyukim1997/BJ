
import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static class Beer implements Comparable<Beer>{
        int a, p;
        public Beer(int a, int p){
            this.a = a;
            this.p = p;
        }

        @Override
        public int compareTo(Beer o){
            if(this.a == o.a) return this.p - o.p;
            return this.a - o.a;
        }
    }

    static List<Beer> beers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i = 0; i < k; i++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");

            int p = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            beers.add(new Beer(a, p));
        }

        Collections.sort(beers);

//        for(Beer b : beers) System.out.println(b.p + " " + b.a);

        int preSum = 0;
        int min = -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < k; i++){
            pq.add(beers.get(i).p);
            preSum += beers.get(i).p;

            if(pq.size() > n){
                preSum -= pq.poll();
//                System.out.println(preSum);
            }

            if(pq.size() == n && preSum >= m){
                min = beers.get(i).a;
                break;
            }
        }

        System.out.println(min);
    }
}