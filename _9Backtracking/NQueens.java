public class NQueens {

    public static boolean isSafe(char[][] board,int row,int col){
        //vertical top
        for(int i=row-1;i>=0;i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }

        //left diagonal
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        //right diagonal
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        return true;
    }

    public static void nQueens(char[][] board,int row){

        //base case 
        if(row==board.length){
            printBoard(board);
            count++;
            return;
        }

        //initialising queen in board 
        for(int j=0;j<board.length;j++){
            //checkig that initialised space in board is safe
           if(isSafe(board,row,j)){
            board[row][j]='Q';
            nQueens(board,  row+1);
            board[row][j]='x';
           }
        }
    }

    /*
    //check if problem can be solved and print only one solution to N queens problem
    
     public static boolean nQueens(char[][] board,int row){

        //base case 
        if(row==board.length){
            //printBoard(board);
            count++;
            return true;
        }

        //initialising queen in board 
        for(int j=0;j<board.length;j++){
            //checkig that initialised space in board is safe
           if(isSafe(board,row,j)){
            board[row][j]='Q';
            if(nQueens(board,  row+1)){
                return true;
            }
            board[row][j]='x';
           }
        }
        return false;
    }

     */

    //Print function for chess board 
    public static void printBoard(char[][]board){
        System.out.println("---------chess board---------");

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
               System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        
    }

    static int count=0;
    
    public static void main(String args[]){
        int n=4;

        char board[][]=new char[n][n]; 
        //initialising board with x
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                board[i][j]='x';
            }
        }

        nQueens(board,0);
        System.out.println("Total ways to solve n queens: "+count);
    }
}


