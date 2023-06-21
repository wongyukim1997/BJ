
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(str);

        for(int t = 0; t < T; t++){
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());
            str = br.readLine();

            str = str.replace("[", "");
            str = str.replace("]", "");

            StringTokenizer st = new StringTokenizer(str, ",");

            List<Integer> list = new ArrayList<>();
            Deque<Integer> deque = new ArrayDeque<>();
            int size = st.countTokens();

            for(int i = 0; i < size; i++) deque.add(Integer.parseInt(st.nextToken()));

            boolean check = true;
            boolean switching = true;

            for(int i = 0; i < command.length(); i++){
                if(command.charAt(i) == 'R') {
                    if(switching) switching = false;
                    else switching = true;
                }
                else{
                    if(deque.size() > 0) {
                        if(switching) deque.remove();
                        else deque.removeLast();
                    }
                    else{
                        check = false;
                        break;
                    }
                }
            }

            if(check) {
                String res = "[";
                sb.append("[");
                size = deque.size();

                for (int i = 0; i < size; i++) {
                    if (i == 0) {
                        if(switching) sb.append(deque.poll());
                        else sb.append(deque.pollLast());
                    }
                    else {
                        if(switching) sb.append("," + deque.poll());
                        else sb.append("," + deque.pollLast());
                    }
                }

                sb.append("]\n");
            }
            else sb.append("error\n");
        }

        System.out.println(sb);
    }
}