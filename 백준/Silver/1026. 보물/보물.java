import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main{

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        StringTokenizer st;

        n = Integer.parseInt(str);

        int[] arr1 = new int[n];
        Integer[] arr2 = new Integer[n];

        str = bf.readLine();
        st = new StringTokenizer(str, " ");
        for(int i = 0; i < n; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr1);

        str = bf.readLine();
        st = new StringTokenizer(str, " ");
        for(int i = 0; i < n; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr2, Collections.reverseOrder());

        int res = 0;
        for(int i = 0; i < n; i++){
            res += arr1[i] * arr2[i];
        }

        System.out.println(res);
    }

}
