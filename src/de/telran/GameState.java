package de.telran;

public class GameState {
    private int points;

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    private int numberOfTries = 3;

    public int getNumberOfTries() {
        return numberOfTries;
    }

    public void setNumberOfTries(int numberOfTries) {
        this.numberOfTries = numberOfTries;
    }

    private boolean playerWon = false;

    public boolean isPlayerWon() {
        return playerWon;
    }

    public void setPlayerWon(boolean playerWon) {
        this.playerWon = playerWon;
    }

    public GameState() {
    }

    public void playerGuessWordAndWon() {
        setPoints(getPoints() + 300);
        setPlayerWon(true);
    }

    public void playerHasAMistakeandLose() {
        setNumberOfTries(0);
        setPoints(0);
    }

    public void guessedLetter() {
        setPoints(getPoints() + 100);
    }

    public void guessedLetterWrong() {
        setNumberOfTries(getNumberOfTries() - 1);
    }

    public boolean isGameOn() {
        return getNumberOfTries() > 0 && !isPlayerWon();
    }

    public void printNumberOfTriesAndPoints(int numberOfTries) {
        System.out.println("Your number of tries is " + numberOfTries);
        System.out.println("Your number of points is " + getPoints());
    }
}