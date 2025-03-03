import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer;
        List<Integer> list = new ArrayList<>();
        int min = arr[0];
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < min) {
                min = arr[i];
            }
        }
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != min) list.add(arr[i]);
        }
        
        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
         if(list.size() == 0) {
            answer = new int[1];
            answer[0] = -1;
        }
        
        return answer;
    }
}