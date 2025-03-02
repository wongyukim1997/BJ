class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int len = numbers.length;
        boolean[] chk = new boolean[10];
        
        for(int i = 0; i < len; i++) {
            chk[numbers[i]] = true;
        }
        
        for(int i = 0; i < 10; i++) {
            if(!chk[i]) {
                answer += i;
            }
        }
        
        return answer;
    }
}