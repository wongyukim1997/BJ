import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer;
        int n = arr.length;
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            if(arr[i] % divisor == 0) {
                list.add(arr[i]);
            }
        }
        
        answer = new int[list.size()];
        Collections.sort(list);
        
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