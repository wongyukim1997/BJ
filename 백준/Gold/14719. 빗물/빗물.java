
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] arr = new int[w];
        boolean[] check = new boolean[w];

        str = br.readLine();
        st = new StringTokenizer(str, " ");

        for(int i = 0; i < w; i++) arr[i] = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack();

        int max = arr[0];
        int maxIdx = 0;
        int sum = 0;

        stack.push(arr[0]);
        for(int i = 1; i < w; i++){
            if(arr[i] < max) stack.push(arr[i]);
            else{
                while(!stack.isEmpty()) {
                    int temp = max - stack.pop();
                    sum += temp;
                }

                check[i] = true;
                check[maxIdx] = true;

                stack.push(arr[i]);
                max = arr[i];
                maxIdx = i;
            }
        }
        stack.clear();

        max = arr[w-1];
        maxIdx = w-1;

        stack.push(arr[w-1]);
        for(int i = w-2; i >= 0; i--){
            if(arr[i] < max) stack.push(arr[i]);

            else{
                if(check[i] && check[maxIdx]) continue;

                while(!stack.isEmpty()) {
                    sum += max-stack.pop();
                }

                stack.push(arr[i]);
                max = arr[i];
                maxIdx = i;
            }
//            System.out.println(max + " : " + sum);
        }

        if(sum < 0) sum = 0;
        System.out.println(sum);
    }
}