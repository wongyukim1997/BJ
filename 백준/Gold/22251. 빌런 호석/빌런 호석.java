import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] arr;
    static int n, k, p, x;
    static List<Integer> list, list2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        list = new ArrayList<>();
        arr = new int[10][10];

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        String[] map = new String[10];

        map[0] = "1111110";
        map[1] = "0011000";
        map[2] = "0110111";
        map[3] = "0111101";
        map[4] = "1011001";
        map[5] = "1101101";
        map[6] = "1101111";
        map[7] = "0111000";
        map[8] = "1111111";
        map[9] = "1111101";

        for(int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int cnt = 0;

                for (int h = 0; h < 7; h++) {
                    if (map[i].charAt(h) != map[j].charAt(h)) cnt++;
                }
                arr[i][j] = cnt;
            }
        }

        int res = x;
        int len = (int)(Math.log10(x)+1);

        while(res > 0){
            list.add(res % 10);
            res = res / 10;
        }

        if(k > len){
            for(int i = 0; i < k-len; i++) list.add(0);
        }

        Collections.reverse(list);

//        System.out.println(list);

        int cnt = 0;
        for(int i = 1; i <= n; i++){
            if(i == x) continue;
            if(!check(i)) continue;
//            System.out.println("ㅇㅇ: " + i);
            cnt++;
        }

        System.out.println(cnt);
    }

    static boolean check(int num){
        int res = num;
        int len = (int)(Math.log10(num)+1);

        list2 = new ArrayList<>();

        while(res > 0){
            list2.add(res % 10);
            res = res / 10;
        }

        if(k > len){
            for(int i = 0; i < k-len; i++) list2.add(0);
        }

        Collections.reverse(list2);
//        System.out.println(list2);

        int sum = 0;
        for(int i = 0; i < k; i++){
            sum += arr[list.get(i)][list2.get(i)];
        }

        if(sum > p) return false;
//        System.out.println("이만큼: " + sum);
        return true;
    }
}