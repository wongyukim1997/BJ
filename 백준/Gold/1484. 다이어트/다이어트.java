
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        List<Integer> list = new ArrayList<>();

        int g = Integer.parseInt(str);

        int start = 1;
        int end = 2;


        while(end <= 100000){
            int isG = end*end - start*start;

            if(isG > g){
                start++;
            }else{
                if(isG == g) list.add(end);
                end++;
            }
        }

        if(list.size() == 0) list.add(-1);
        for(int i : list) System.out.println(i);
    }
}