
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        Stack<Integer> calculate = new Stack<>();

        int sum = 0;
        int value = 1;

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);

            if(c == '(') {
                stack.push(c);
                value *= 2;
            }
            else if(c == '['){
                stack.push(c);
                value *= 3;
            }
            else if(c == ')'){
                if(stack.isEmpty() || stack.peek() != '('){
                    sum = 0;
                    break;
                }

                if(str.charAt(i-1) == '(') sum += value;

                stack.pop();
                value /= 2;
            }
            else if(c == ']'){
                if(stack.isEmpty() || stack.peek() != '['){
                    sum = 0;
                    break;
                }

                if(str.charAt(i-1) == '[') sum += value;

                stack.pop();
                value /= 3;
            }

//            System.out.println(c + " : " + sum);
        }

        if(stack.size() > 0) sum =  0;

        System.out.println(sum);
    }
}