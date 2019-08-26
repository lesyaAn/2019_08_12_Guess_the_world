package de.telran;

import java.util.Scanner;

public class Game {

    private final Scanner scanner = new Scanner(System.in);

    private WordRepository wordRepository;
    private WordToGuess wordToGuess;

    private int points;


    public Game() {
        wordRepository = new WordRepository();
    }

    public void startNewGame() {

        Word word = wordRepository.getRandomWord();
        wordToGuess = new WordToGuess(word.getWord(), word.getDescription());
        System.out.println("Guess the word with following meaning");
        System.out.println(wordToGuess.getDescription());
        System.out.println(wordToGuess.getWordWithStars());

        int numberOfTries = 3;
        boolean playerWon = false;

        while (numberOfTries > 0 && !playerWon) {
            if (askPlayerLetterOrWord()) {
                //letter
                char letterFromPlayer = askPlayerALetter();
                if (wordToGuess.hasChar(letterFromPlayer)) {
                    points += 100;
                    wordToGuess.openLetter(letterFromPlayer);
                    informPlayerAboutSuccess(letterFromPlayer);
                    printNumberOfTriesAndPoints(numberOfTries);
                    showMaskedWord(wordToGuess.getWordWithStars());
                    if (wordToGuess.checkIfGuessed()) {
                        informPlayerAboutWin();
                        playerWon = true;
                    }
                } else {
                    numberOfTries--;
                    informPlayerAboutMistake(letterFromPlayer);
                    printNumberOfTriesAndPoints(numberOfTries);
                    showMaskedWord(wordToGuess.getWordWithStars());
                    if (numberOfTries == 0) {
                        points = 0;
                        informPlayerAboutLose(wordToGuess.getWord());
                    }
                }
            } else {
                //word
                String wordFromPlayer = askPlayerAWord();
                if (wordToGuess.getWord().equals(wordFromPlayer)) {
                    points +=300;
                    informPlayerAboutWin();
                    playerWon = true;
                } else {
                    numberOfTries = 0;
                    points = 0;
                    informPlayerAboutLose(wordToGuess.getWord());
                }
            }
        }
    }

    private String askPlayerAWord() {
        System.out.print("Please input a word:");
        return scanner.nextLine().toLowerCase();
    }

    private void informPlayerAboutLose(String word) {
        System.out.println("You lost the game! The word was \""
                + word.toUpperCase()
                + "\"");
        System.out.println("You won " + points + " points");
    }

    private void showMaskedWord(String wordWithStars) {
        System.out.println(wordWithStars);
    }

    private void informPlayerAboutMistake(char letter) {
        System.out.println("There is no such a letter " + letter + "!");
    }

    private void informPlayerAboutWin() {
        System.out.println("You guessed the word! You won!");
        System.out.println("You won " + points + " points");
    }

    private void informPlayerAboutSuccess(char letter) {
        System.out.println("Success! You've guessed the letter " + letter + "!");
    }

    private void printNumberOfTriesAndPoints(int numberOfTries) {
        System.out.println("Your number of tries is " + numberOfTries);
        System.out.println("Your number of points is " + points);
    }

    private char askPlayerALetter() {
        System.out.print("Please input a letter:");
        return scanner.nextLine().toLowerCase().charAt(0);
    }

    private boolean askPlayerLetterOrWord() {
        System.out.print("Word (w) or letter(l)?");
        return scanner.nextLine().toLowerCase().charAt(0) != 'w';
    }
}
