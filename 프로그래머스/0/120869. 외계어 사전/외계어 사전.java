class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        boolean[] check = new boolean[spell.length];
        outer: for(int i = 0; i < dic.length; i++){
                            check = new boolean[spell.length];
            for(int j = 0; j < dic[i].length(); j++){

                boolean flag = false;
                
                for(int k = 0; k < spell.length; k++){
                    if(dic[i].substring(j, j+1).equals(spell[k])){
                        if(!check[k]){
                            check[k]=true;
                        } else {
                            flag = true;
                            break;
                        }
                    }
                }
                if(!flag){
                    int count = 0;
                    for(int x = 0; x < check.length; x++){
                        if(check[x]){
                            count++;
                        }
                    }
                    if(count == check.length){
                        answer=1;
                        break outer;
                    }
                }

                }                
            }
        
        return answer;
    }
}