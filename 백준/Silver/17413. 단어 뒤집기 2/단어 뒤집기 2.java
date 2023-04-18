import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        boolean check = false;

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);

            if(c == '<'){           // < 가 시작되면 큐에 쌓아야 하고, 그동안에 쌓인 스택을 풀어준다
                check = true;

                int size = stack.size();
                for(int j = 0; j < size; j++){
                    System.out.print(stack.pop());
                }
                queue.add(c);
            }else if(c == '>'){     // > 도 닫으면 그동안 쌓인 큐를 풀어준다
                check = false;

                int size = queue.size();
                for(int j = 0; j < size; j++){
                    System.out.print(queue.poll());
                }
                System.out.print(">");
            }else if(c == ' '){     // 빈 공간이 나오면
                if(check){          // 만약 <> 안에 있다면 큐에 쌓아주고
                   queue.add(c);
                }else{              // 아니라면 그동안 쌓인 스택을 풀어준다
                    int size = stack.size();
                    for(int j = 0; j < size; j++){
                        System.out.print(stack.pop());
                    }
                    System.out.print(" ");
                }
            }else{                  // 빈공간도, < > 도 아니라면
                if(check) {         // <> 안에 있다면 큐에 그 쌓아주고
                    queue.add(c);
                }else{              // 밖이라면 스택에 쌓아준다
                    stack.add(c);
                }
            }
        }

        int size = stack.size();
        if(size != 0){
            for(int i = 0; i < size; i++){
                System.out.print(stack.pop());
            }
        }
    }
}
