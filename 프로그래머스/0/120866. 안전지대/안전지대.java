class Solution {
    
    static int[] dr = {-1,-1,0,1,1,1,0,-1};
    static int[] dc = {0,1,1,1,0,-1,-1,-1};    
    
    public int solution(int[][] board) {
        int answer = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j]==0||board[i][j]==2){
                    continue;
                } else {
                    for(int x = 0; x < 8; x++){
                        int nr = i + dr[x];
                        int nc = j + dc[x];
                        if(nr >=0 && nr < board.length && nc >=0 && nc < board.length){
                            if(board[nr][nc]==0){
                                board[nr][nc]=2;
                            }
                        }
                    }
                }
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j]==0){
                    answer++;
                }
            }
        }
        
        
        return answer;
    }
}