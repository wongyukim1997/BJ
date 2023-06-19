
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Stack<Integer> stack = new Stack();

        int n = Integer.parseInt(str);

        for(int i = 0; i < n; i++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");

            String command = st.nextToken();
            if(command.equals("push")){
                stack.push(Integer.parseInt(st.nextToken()));
            }
            else if(command.equals("pop")){
                if(stack.isEmpty()) sb.append(-1 + "\n");
                else sb.append(stack.pop() + "\n");
            }
            else if(command.equals("size")){
                sb.append(stack.size() + "\n");
            }
            else if(command.equals("empty")){
                if(stack.isEmpty()) sb.append(1 + "\n");
                else sb.append(0 + "\n");
            }
            else if(command.equals("top")){
                if(stack.isEmpty()) sb.append(-1 + "\n");
                else sb.append(stack.peek() + "\n");
            }
        }

        System.out.println(sb);
    }
}