import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {

    static int n, m;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();
//        StringTokenizer st = new StringTokenizer(str, " ");

        String str1 = br.readLine();
        String str2 = br.readLine();

        int[] arr = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < str1.length(); i++){
            int a = arr[str1.charAt(i)-65];
            int b = arr[str2.charAt(i)-65];
            q.add(a);
            q.add(b);
        }
//        q.add(6);
//        q.add(2);
//        q.add(5);
//        q.add(4);
//        q.add(5);
//        System.out.println(q);

        for(int i = 0; i < str1.length()*2 - 2; i++){
            int size = q.size();
            for(int j = 0; j < size; j++) {
                if(j == size-1) q.poll();
                else q.add((q.poll() + q.peek()) % 10);
            }
//            System.out.println(q);
        }


        System.out.println(q.poll() + "" + q.poll());
    }
}