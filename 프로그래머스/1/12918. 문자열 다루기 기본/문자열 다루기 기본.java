class Solution {
    public boolean solution(String s) {
        boolean answer = false;
        
        if(s.length() == 6 || s.length() == 4) {

            try {
                int n = Integer.parseInt(s);
                return true;
            } catch(Exception e) {
                return answer;
            }
        }
        
        return answer;
    }
}