
import java.io.*;
import java.util.*;

public class Main {
    static int[] check;
    static int[] check2;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int n = Integer.parseInt(str);
        int[] arr = new int[n];
        check = new int[4001];
        check2 = new int[4001];

        int sum = 0;
        for(int i = 0; i < n; i++){
            str = br.readLine();
            int num = Integer.parseInt(str);
            arr[i] = num;
            sum += num;

            if(num >= 0) check[num]++;
            else check2[-1*num]++;
        }

        int ans1 = (int)Math.round(sum/(n*1.0));
        int ans3 = getAns3();

        Arrays.sort(arr);
        int ans2 = arr[n/2];
        int ans4 = arr[n-1] - arr[0];

        System.out.println(ans1);
        System.out.println(ans2);
        System.out.println(ans3);
        System.out.println(ans4);
    }

    static int getAns3(){
        int max = 0;

        for(int i = 0; i < 4001; i++){
            max = Math.max(max, check[i]);
        }
        for(int i = 0; i < 4001; i++){
            max = Math.max(max, check2[i]);
        }

        for(int i = 0; i < 4001; i++){
            if(check[i] == max) list.add(i);
        }
        for(int i = 0; i < 4001; i++){
            if(check2[i] == max) list.add(-1*i);
        }

        int ans3 = 0;
        Collections.sort(list);

        if(list.size() >= 2) ans3 = list.get(1);
        else ans3 = list.get(0);

        return ans3;
    }
}