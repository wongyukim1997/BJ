import java.io.*;
import java.util.*;

public class Main {

    static int[] arr = new int[100001];
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr[n] = 1;
        BFS();
        System.out.println(arr[k]-1);

//        for(int i = 0; i < 30; i++) System.out.print(arr[i] + " ");
    }

    static void BFS() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);

        while(!q.isEmpty()) {
            int temp = q.poll();

            if( temp == k ) break;

            if( temp - 1 >= 0 && arr[temp-1] == 0 ) {
                arr[temp-1] = arr[temp] + 1;
                q.offer(temp-1);
            }
            if( temp + 1 <= 100000 && arr[temp+1] == 0 ) {
                arr[temp+1] = arr[temp] + 1;
                q.offer(temp+1);
            }
            if( temp * 2 <= 100000 && arr[temp*2] == 0 ) {
                arr[temp*2] = arr[temp] + 1;
                q.offer(temp*2);
            }
        }
    }

}
