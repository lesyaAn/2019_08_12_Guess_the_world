package de.telran;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private final Scanner scanner = new Scanner(System.in);
    private WordToGuess wordToGuess;
    private WordRepository wordRepository;

    private int points;



    public Game() {
        wordRepository = new WordRepository();
    }

    public void startNewGame(){

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
                //System.out.println(wordToGuess.getWord());
                if (wordToGuess.hasChar(letterFromPlayer)) {
                    wordToGuess.openLetter(letterFromPlayer);
                    informPlayerAboutSuccess(letterFromPlayer);
                    printNumberOfTriesandPoints(numberOfTries, points);
                    if (wordToGuess.checkIfGuessed()) {
                        points += 100;
                        informPlayerAboutWin();
                        playerWon = true;
                    } else{
                       String wordWithStars = wordToGuess.getWordWithStars();
                       System.out.println(wordWithStars);
                    }
                } else {
                    numberOfTries--;
                    informPlayerAboutMistake(letterFromPlayer);
                    printNumberOfTriesandPoints(numberOfTries,points);
                    showMaskeWord(wordToGuess.getWordWithStars());
                    if(numberOfTries == 0)
                        informPlayerAboutLoose(wordToGuess.getWord());
                }
            }else{
                //word
                break;
            }
        }
    }

    private void informPlayerAboutLoose(String word) {
        System.out.println("You lost the game! The word was \""
                + word.toUpperCase()
                + "\"");
    }

    private void showMaskeWord(String wordWithStars) {
        System.out.println(wordWithStars);
    }

    private void informPlayerAboutMistake(char letter) {

        System.out.println("Oops, you made a mistake, try again! There is no such a letter " + letter + "!");

    }

    private void informPlayerAboutWin() {

        String wordWithStars = wordToGuess.getWordWithStars();
        System.out.println("The word is " + wordWithStars);

        System.out.println("Hooray! You won!");
        System.out.println("You won " + points + "points");

    }

    private void informPlayerAboutSuccess(char letter) {

        System.out.println("Great! Keep up the good work!  You've guessed the letter " + letter + "!");

    }

    private void printNumberOfTriesandPoints(int numberOfTries,int points){

        System.out.println("Your number of tries is " + numberOfTries + " Your points are " + points);
    }

    private char askPlayerALetter() {

        System.out.println("Please enter a letter: ");
        Scanner scanner = new Scanner(System.in);
        String letterFromPlayer = scanner.nextLine();
        //System.out.println("Your letter:  " + letterFromPlayer);

        return letterFromPlayer.charAt(0);
    }

    private boolean askPlayerLetterOrWord() {

        System.out.println("What do you want to enter a letter or a word? ");
        Scanner scanner = new Scanner(System.in);
        String inputFromUser = scanner.nextLine();
        return inputFromUser.equals("letter");
    }



}
