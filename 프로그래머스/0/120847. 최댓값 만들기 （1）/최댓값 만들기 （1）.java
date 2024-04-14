class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        for(int i = 0; i < numbers.length-1; i++){
            for(int j = 0; j < numbers.length-1-i; j++){
                if(numbers[j]>numbers[j+1]){
                    int temp = numbers[j];
                    numbers[j]=numbers[j+1];
                    numbers[j+1]=temp;
                }
            }
        }
        answer = numbers[numbers.length-2]*numbers[numbers.length-1];
        return answer;
    }
}