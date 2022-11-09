import java.util.Scanner;

public class TicTacToe {
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board [][] = new String[ROW][COL];

    private static void clearBoard()
    {
        for(int i=0;i<ROW;i++)
        {
            for(int j=0;j<COL;j++)
                board[i][j] = " ";
        }
    }

    private static void display()
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.print(board[i][j]) ;
                if(j != 2)
                    System.out.print(" |");
            }
            if(i != 2)
                System.out.print("\n------------");
            System.out.println();
        }
        System.out.println();
    }

    private static boolean isValidMove(int row, int col)
    {
        return(board[row][col].equals(" "));
    }

    private static boolean isWin(String player)
    {
        return(isColWin(player) || isRowWin(player) || isDiagonalWin(player));
    }

    private static boolean isColWin(String player)
    {
        for(int i=0;i<COL;i++)
        {
            if(board[0][i].equals(player) && board[1][i].equals(player)&& board[2][i].equals(player))
                return true;
        }
        return false;
    }

    private static boolean isRowWin(String player)
    {
        for(int i=0;i<ROW;i++)
        {
            if(board[i][0].equals(player) && board[i][1].equals(player)&& board[i][2].equals(player))
                return true;
        }
        return false;
    }

    private static boolean isDiagonalWin(String player)
    {
        if(board[0][0].equals(player)&& board[1][1].equals(player) && board[2][2].equals(player))
            return true;
        if(board[0][2].equals(player)&& board[1][1].equals(player) && board[2][0].equals(player))
            return true;
        return false;
    }

    private static boolean isTie()
    {
        for(int i=0;i<ROW;i++)
        {
            for(int j=0;j<COL;j++)
            {
                if(board[i][j].equals(" "))
                    return false;
            }
        }
        return true;
    }

    private static String togglePlayer(String player)
    {
        if(player.equals("X"))
            return "O";
        else
            return "X";
    }

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        String player;
        int row, col;

        do
        {
            clearBoard();
            player = "X";

            while(!isWin("X") && !isWin("O") && !isTie())
            {
                display();

                row = SafeInput.getRangedInt(console, "Player "+ player +", enter row number: ", 1, ROW);
                col = SafeInput.getRangedInt(console, "Player "+ player +", enter column number: ", 1, COL);

                while(!isValidMove(row-1,col-1))
                {
                    System.out.println("The position is already occupied. Please re-enter");
                    row = SafeInput.getRangedInt(console, "Player "+ player +", enter row number: ", 1, ROW);
                    col = SafeInput.getRangedInt(console, "Player "+ player +", enter column number: ", 1, COL);
                }

                board[row-1][col-1] = player;

                if(isWin(player))
                    break;
                player = togglePlayer(player);
            }

            display();

            if(!isTie())
                System.out.println("Player "+ player +" wins!");
            else
                System.out.println("Its a tie!");
            System.out.println();

        }while(SafeInput.getYNConfirm(console, "Do you want to play another game (Y/N)? "));

    }

}