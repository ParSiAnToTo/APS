class Solution {
    public int solution(int[] numbers, int k) {
        int len = ((k-1)*2)%numbers.length;
        int answer = numbers[len];
        return answer;
    }
}