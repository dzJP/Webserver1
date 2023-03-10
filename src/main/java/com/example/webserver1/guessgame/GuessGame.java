package com.example.webserver1.guessgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GuessGame {

    private int secret;
    private List<String> replies;
    Random random = new Random();

    public GuessGame() {
       init();
    }

    private void init() {
        secret = random.nextInt(1,11);
        replies = new ArrayList<>();
    }

    public String makeGuess(int guess) {
        String answer;
        if (guess < secret) {
            answer =  "Too small";
            replies.add(guess + ": " + answer);
        } else if (guess > secret) {
            answer =  "Too large";
            replies.add(guess + ": " + answer);
        } else {
            init();
            answer = "Correct";
        }
        return answer;
    }

    public List<String> getReplies() {
        return replies; 
    }
}
