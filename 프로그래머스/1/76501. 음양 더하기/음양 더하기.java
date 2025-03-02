class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        int abs = absolutes.length;
        
        for(int i = 0; i < abs; i++){
            if(signs[i]) {
                answer += absolutes[i];
            }
            else {
                answer -= absolutes[i];
            }
        }
        
        return answer;
    }
}