package games;

import java.util.Scanner;

public class BrickBreakerGame {

    private static final int ROWS = 25;
    private static final int COLS = 25;
    private static final char EMPTY_CELL = ' ';
    private static final char BRICK = '#';
    private static final char PADDLE = '_';
    private static final char BALL = 'o';

    private char[][] grid;
    private int barPosition;
    private int ballX;
    private int ballY;
    private int dx;
    private int dy;

    public BrickBreakerGame(){
        grid = new char[ROWS][COLS];
        initializeGrid();
        barPosition = COLS / 2;
        ballX = ROWS - 2;
        ballY = barPosition;
        dx = 1;
        dy = -1;
    }

    private void initializeGrid() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                grid[i][j] = EMPTY_CELL;
            }
        }
    }

    private void displayGrid() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    private void updateGrid(){
        grid[ROWS - 1] = new char[COLS];
        for (int i = 0; i < COLS; i++) {
            if (i >= barPosition && i < barPosition + 4) {
                grid[ROWS - 1][i] = PADDLE;
            } else {
                grid[ROWS - 1][i] = EMPTY_CELL;
            }
        }
    }

    private void moveBarLeft() {
        barPosition = Math.max(0, barPosition - 1);
    }

    private void moveBarRight() {
        barPosition = Math.min(COLS - 1, barPosition + 1);
    }

    private void play() {
        Scanner sc = new Scanner(System.in);

        while(true){
            displayGrid();
            updateGrid();

            System.out.println("Move paddle (A:left, D:right): ");
            String move = sc.nextLine();
            if (move.equalsIgnoreCase("A")) {
                moveBarLeft();
            } else if (move.equalsIgnoreCase("D")) {
                moveBarRight();
            }

            ballMovement();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void ballMovement() {
        if (ballX == ROWS - 1) {
            if (ballY >= barPosition && ballY < barPosition + 4) {
                dy = -1;
            } else {
                System.out.println("Game Over!");
                System.exit(0);
            }
        }

        grid[ballX][ballY] = EMPTY_CELL;

        if (ballX == 0 || ballX == ROWS - 1) {
            dy *= -1;
        }
        if (ballY == 0 || ballY == COLS - 1) {
            dx *= -1;
        }

        ballX += dy;
        ballY += dx;

        grid[ballX][ballY] = BALL;
    }


    public static void main(String[] args) {
        BrickBreakerGame game = new BrickBreakerGame();
        game.play();
    }


}
