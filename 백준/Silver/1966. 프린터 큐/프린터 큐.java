import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int T = Integer.parseInt(str);

        for(int t = 0; t < T; t++){
            str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");

            int n = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            Queue<Point> q = new LinkedList<>();                // 순서, 중요도를 담은 큐
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());  // 중요도를 순서대로 넣어주는 큐

            str = br.readLine();
            st = new StringTokenizer(str, " ");
            for(int i = 0; i < n; i++){
                int num = Integer.parseInt(st.nextToken());
                q.add(new Point(i, num));
                pq.add(num);
            }

            int cnt = 0;
            while(true){

                Point temp = q.poll();

                if(temp.y == pq.peek()){
                    pq.poll();
                    cnt++;
                    if(temp.x == target){
                        break;
                    }
                }else{
                    q.add(temp);
                }
            }

            System.out.println(cnt);
        }
    }
}
