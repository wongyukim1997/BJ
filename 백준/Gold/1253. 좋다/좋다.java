
import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        n = Integer.parseInt(str);
        arr = new int[n];

        str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int cnt = 0;

        for(int i = 0; i < n; i++){
            int left = 0;
            int right = n-1;

            while(left < right){
                if(left == i) left++;
                else if(right == i) right--;

                if(left == right) break;

                if(arr[left] + arr[right] == arr[i]){
//                    System.out.println(arr[left] + " " + arr[right] + " = " + arr[i]);
                    cnt++;
                    break;
                }
                else if(arr[left] + arr[right] < arr[i]) left++;
                else if(arr[left] + arr[right] > arr[i]) right--;
            }
        }

        System.out.println(cnt);
    }
}