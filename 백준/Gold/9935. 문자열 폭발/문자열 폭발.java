
import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String boom = br.readLine();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);

            stack.push(c);

            if(stack.size() >= boom.length()){
                boolean check = true;
                int n = stack.size()-boom.length();

                for(int j = n; j < stack.size(); j++){
                    if(stack.get(j) != boom.charAt(j-n)){
                        check = false;
                        break;
                    }
                }

                if(check){
                    for(int j = 0; j < boom.length(); j++) stack.pop();
                }
            }
        }

        StringBuilder res = new StringBuilder();

        for(char c : stack){
            res.append(c);
        }

        if(res.length() == 0) System.out.println("FRULA");
        else System.out.println(res);
    }

}