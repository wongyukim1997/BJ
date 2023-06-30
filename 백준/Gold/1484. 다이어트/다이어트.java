
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        List<Long> list = new ArrayList<>();

        int g = Integer.parseInt(str);

        long start = 1;
        long end = 2;


        while(end <= 100000){
            long now = end*end;
            long memory = start*start;
            long isG = now - memory;

            if(isG > g){
                start++;
            }else{
                if(isG == g) list.add(end);
                end++;
            }
        }

        if(list.size() == 0) list.add(-1L);
        for(long i : list) System.out.println(i);
    }
}