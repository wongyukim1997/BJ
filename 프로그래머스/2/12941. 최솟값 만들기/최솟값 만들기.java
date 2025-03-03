import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        
        for(int i = 0; i < A.length; i++) {
            list.add(A[i]);
            list2.add(B[i]);
        }
        
        Collections.sort(list);
        Collections.sort(list2, Collections.reverseOrder());
        
        for(int i = 0; i < list.size(); i++) {
            answer += list.get(i) * list2.get(i);
        }
        
        return answer;
    }
}