package Implementation;

class Solution_77485_level2 {
    private static int row, col;
    private static int[][] board;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        row = rows;
        col = columns;
        board = new int[row][col];
        int value = 1;
        for(int i=0; i<rows; i++)
            for(int j=0; j<columns; j++)
                board[i][j] = value++;
        int index = 0;



        for (int[] query : queries) {
            answer[index++] = move(query);

        }


        return answer;
    }

    private int move(int[] query) {
        int r1 = query[0]-1;
        int c1 = query[1]-1;
        int r2 = query[2]-1;
        int c2 = query[3]-1;

        int r = r1;
        int c = c1;
        int minValue = Integer.MAX_VALUE;
        int original = board[r][c];

        minValue = Math.min(minValue, original);

        // 반시계 회전 진행
        for(;r<r2; r++) {
            board[r][c] = board[r+1][c];
            minValue = Math.min(minValue, board[r][c]);
        }

        for(;c<c2; c++) {
            board[r][c] = board[r][c+1];
            minValue = Math.min(minValue, board[r][c]);
        }

        for(;r>r1; r--) {
            board[r][c] = board[r-1][c];
            minValue = Math.min(minValue, board[r][c]);
        }

        for(;c>c1; c--) {
            board[r][c] = board[r][c-1];
            minValue = Math.min(minValue, board[r][c]);
        }
        board[r1][c1+1] = original;
        minValue = Math.min(minValue, original);

        return minValue;
    }
}