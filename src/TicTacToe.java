import java.util.Scanner;
public class TicTacToe {
    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static char[][] gameBoard = new char[ROWS][COLS];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean done = false;


        do {
            clearBoard();
            char crossNought = 'X';
            int rowInt;
            int colInt;
            boolean gameOver = false;
            boolean isValidMove = false;
            do {
                do {
                    isValidMove = false;
                    display(gameBoard);
                    rowInt = SafeInput.getRangedInt(in, "Player 1, enter a row. (0, 1, or 2)", 0, 2);
                    colInt = SafeInput.getRangedInt(in, "Player 1, enter a column. (0, 1, or 2)", 0, 2);
                    if (gameBoard[rowInt][colInt] != '_') {
                        System.out.println("The space you chose is already occupied.");
                    } else {
                        gameBoard[rowInt][colInt] = crossNought;
                        crossNought = 'O';
                        isValidMove = true;
                    }
                } while (!isValidMove);

                if (isWin(gameBoard) == 'X') {
                    System.out.println("Player 1 wins!");
                    display(gameBoard);
                    in.nextLine();
                    break;

                } else if (isWin(gameBoard) == 'O') {
                    System.out.println("Player 2 wins!");
                    display(gameBoard);
                    in.nextLine();
                    break;

                } else {
                    if (isTie(gameBoard)) {
                        System.out.println("It's a tie!");
                        display(gameBoard);
                        in.nextLine();
                        break;

                    }
                }

                do {
                    isValidMove = false;
                    display(gameBoard);
                    rowInt = SafeInput.getRangedInt(in, "Player 2, enter a row. (0, 1, or 2)", 0, 2);
                    colInt = SafeInput.getRangedInt(in, "Player 2, enter a column. (0, 1, or 2)", 0, 2);
                    if (gameBoard[rowInt][colInt] != '_') {
                        System.out.println("The space you chose is already occupied.");
                    } else {
                        gameBoard[rowInt][colInt] = crossNought;
                        crossNought = 'X';
                        isValidMove = true;
                    }
                } while (!isValidMove);

                if (isWin(gameBoard) == 'X') {
                    System.out.println("Player 1 wins!");
                    display(gameBoard);
                    in.nextLine();
                    break;

                } else if (isWin(gameBoard) == 'O') {
                    System.out.println("Player 2 wins!");
                    display(gameBoard);
                    in.nextLine();
                    break;

                } else {
                    if (isTie(gameBoard)) {
                        System.out.println("It's a tie!");
                        display(gameBoard);
                        in.nextLine();
                        break;
                    }
                }
            } while (!gameOver);
            done = SafeInput.getYNConfirm(in, "Would you like to play again? (Y/N)");
        } while(!done);
    }

    //METHODS

    private static void clearBoard(){
        for(int x = 0; x < 3; x++) {
            for(int y = 0; y < 3; y++){
                gameBoard[x][y] = '_';
            }
        }

    } // Set all board elements to an underscore character

    private static void display(char[][] gameBoard){
        for(int x = 0; x < 3; x++) {
            for(int y = 0; y < 3; y++) {
                System.out.print(gameBoard[x][y]);
            }
            System.out.println();
        }
    } // Shows the Tic Tac Toe game used as part of the prompt for the user's move choice

private static char isWin(char[][] gameBoard)
{
    for(int x = 0; x < 3; x++)
    {
        if(gameBoard[x][0] == gameBoard[x][1] && gameBoard[x][1] == gameBoard[x][2] && gameBoard[x][0] != '_')
        {
            return gameBoard[x][0];
        }
    }

    for(int y = 0; y < 3; y++)
    {
        if(gameBoard[0][y] == gameBoard[1][y] && gameBoard[1][y] == gameBoard[2][y] && gameBoard[0][y] != '_')
        {
            return gameBoard[0][y];
        }

    }

    if (gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2] && gameBoard[0][0] != '_')
    {
        return gameBoard [0][0];
    }

    if (gameBoard[2][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[0][2] && gameBoard[0][0] != '_')
    {
        return gameBoard [2][0];
    }

    return '-';

} // Checks for wins vertically, horizontally, or diagonally.

private static boolean isTie(char[][] gameBoard)
    {
        for(int x = 0; x < 3; x++)
        {
            for(int y = 0; y < 3; y++)
            {
                if(gameBoard[x][y] == '_')
                {
                    return false;
                }
            }
        }
        return true;
    } // Checks to see if the board is full.
}