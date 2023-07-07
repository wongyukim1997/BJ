
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int n = Integer.parseInt(str);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++){
            str = br.readLine();
            pq.add(Integer.parseInt(str));
        }

        int sum = 0;
        int comp = 0;

        if(n > 1) {
            while (pq.size() > 1) {
                sum = pq.poll() + pq.poll();
                comp += sum;

                pq.add(sum);
            }
        }

        System.out.println(comp);
    }
}