class Solution {
    public int solution(int n) {
        int answer = 0;
        int people = n;
        int nums = 6;
        while(people!=0){
            int temp = people;
            people = nums % people;
            nums = temp;            
        }
        answer =  n / nums;
        return answer;
    }
}