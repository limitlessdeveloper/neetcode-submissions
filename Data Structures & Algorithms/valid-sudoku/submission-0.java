class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> []column = new HashSet[9];
        Set<Character> []row = new HashSet[9];
        Set<Character> []boxes = new HashSet[9];
        for(int i=0; i<9; i++){
            column[i] = new HashSet<>();
            row[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(Character.isDigit(board[i][j])){
                    if(column[j].contains(board[i][j])){
                        return false;
                    }
                    if(row[i].contains(board[i][j])){
                        return false;
                    }
                    int box = i/3*3 + j/3;
                    if(boxes[box].contains(board[i][j])){
                        return false;
                    }
                    column[j].add(board[i][j]);
                    row[i].add(board[i][j]);
                    boxes[box].add(board[i][j]);
                }
            }
        }
        return true;          
    }
}

//0 1 2 3 4 5 6 7 8/3 == 0, 1, 2
//1
//2
//3 == 1
//4
//5
//6 == 2 
//7
//8 

// 0 1 2  j/3 ==> 0, 1, 2;
// 3 4 5  i/3*3 + j/3;  ==> 
// 6 7 8