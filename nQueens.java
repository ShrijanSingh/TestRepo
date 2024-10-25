public class nQueens {
    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'X';
            }
        }
        nQueen(board, 0);
        System.out.println("function  ended");
    }

    public static void nQueen(char board[][], int row) {
        int n = board.length;
        if (row == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();

            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isSafe(board, row, i)) {
                board[row][i] = 'Q';
                nQueen(board, row + 1);
                board[row][i] = 'X';
            }
    }
    }
    public static boolean isSafe(char board[][], int row, int col) {
        int n = board.length;
        // check row
        for (int j = 0; j < n; j++) {
            if (board[row][j] == 'Q')
                return false;
        }
        // check col
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q')
                return false;
        }
        // check north-east
        int i = row;
        int j = col;
        while (i >= 0 && j < n) {
            if (board[i][j] == 'Q')
                return false;
            i--;
            j++;
        }
        // check south-east
         i = row;
         j = col;
        while (i < n && j < n) {
            if (board[i][j] == 'Q')
            return false;
            i++;j++;
        }
        // check south-west
        i=row;
        j=col;
        while (i<n && j>=0)
        {
            if (board[i][j]=='Q')
            {
                return false;
            }
            i++;
            j--;
        }
        //check nort-west
        i=row;
        j=col;
        while(i>=0 && j>=0)
        {
            if (board[i][j]=='Q')
            return false;
            i--;
            j--;
        }
        return true;
    }
}
