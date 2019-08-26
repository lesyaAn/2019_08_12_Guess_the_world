package de.telran;

import java.util.Scanner;

public class PlayerInteraction {
    final Scanner scanner;

    public PlayerInteraction() {
        this.scanner = new Scanner(System.in);
    }


    String askPlayerAWord() {
        System.out.print("Please input a word:");
        return scanner.nextLine().toLowerCase();
    }

    char askPlayerALetter() {
        System.out.print("Please input a letter:");
        return scanner.nextLine().toLowerCase().charAt(0);
    }

    boolean askPlayerLetterOrWord() {
        System.out.print("Word (w) or letter(l)?");
        return scanner.nextLine().toLowerCase().charAt(0) != 'w';
    }

    void informPlayerAboutSuccess(char letter) {
        System.out.println("Success! You've guessed the letter " + letter + "!");
    }

    void informPlayerAboutMistake(char letter) {
        System.out.println("There is no such a letter " + letter + "!");
    }

    void showMaskedWord(String wordWithStars) {
        System.out.println(wordWithStars);
    }

    void informPlayerAboutLose(String word, int points) {
        System.out.println("You lost the game! The word was \""
                + word.toUpperCase()
                + "\"");
        System.out.println("You won " + " points");
    }

    void  informPlayerAboutWin(String word, int points) {
        System.out.println("You guessed the word! You won!");
        System.out.println("You won " +  " points");
    }


}