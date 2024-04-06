class Solution {
    public int solution(int[] array) {
        int[] tempList = new int[array.length];
        for(int i=0; i<array.length; i++){
            tempList[i]=array[i];
        }
        
        int n = tempList.length;
        for(int i =0; i<n-1; i++){
            for(int j = 0; j <n-1-i; j++){
                if(tempList[j]>tempList[j+1]){
                    int temp = tempList[j];
                    tempList[j]=tempList[j+1];
                    tempList[j+1]=temp;
                }
            }
        }        
        
        int answer;
        if(n%2==0){
            answer = (tempList[n/2]+tempList[(n/2)-1])/2;
        }else {
            answer = tempList[n/2];
        }        
        return answer;
    }
}