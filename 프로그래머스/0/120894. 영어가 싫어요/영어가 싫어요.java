class Solution {
    public long solution(String numbers) {
        String[] nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        int index = 0;
        String line = "";
        for(int i = 0; i <= numbers.length(); i++){
            String spell = numbers.substring(index, i);
            for(int j = 0; j < nums.length; j++){
                if(spell.equals(nums[j])){
                    line = line.concat(String.valueOf(j));
                    index = i;
                }
            }
        }
        long answer = Long.parseLong(line);
        return answer;
    }
}