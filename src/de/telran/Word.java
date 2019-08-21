package de.telran;

import java.util.Objects;

public class Word {
    private String word;
    private String description;

    public Word(String word, String description) {
        this.word = word;
        this.description = description;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word)) return false;
        Word word1 = (Word) o;
        return getWord().equals(word1.getWord()) &&
                getDescription().equals(word1.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWord(), getDescription());
    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
