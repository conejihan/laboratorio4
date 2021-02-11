/***************************************************************
* file: GameModel.java
* author:   Christopher Santos
*           Omar Rodriguez
* class: CS 245 - Programming Graphical User Interfaces
*
* assignment: Swing Project v1.0
* date last modified: 10/11/2016
*
* purpose: This is the model component for the game screen
*
****************************************************************/ 
package hangman.model;

import hangman.model.dictionary.HangmanDictionary;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import GameScore;

public class GameModel {
    private int incorrectCount;
    private int correctCount;
    private LocalDateTime dateTime;
    private int gameScore;
    private int[] lettersUsed;
	private GameScore Gs;
	
    
    
    private HangmanDictionary dictionary;
    
    private Scanner scan;
    private String randomWord;
    private char[] randomWordCharArray;
	private int incorrectCount_C;
	private int correctCount_C;
	
    
    
    @Inject
    public GameModel(HangmanDictionary dictionary,GameScore Gs){
        //this.dictionary = new EnglishDictionaryDataSource();
        this.dictionary=dictionary;
        randomWord = selectRandomWord();
        randomWordCharArray = randomWord.toCharArray();
        incorrectCount = 0;
		incorrectCount_C = 0;
        correctCount = 0;
		correctCount_C = 0;
        gameScore = 100;
		this.Gs=Gs;
        
    }
	
    
    //method: reset
    //purpose: reset this game model for a new game
    public void reset(){
        randomWord = selectRandomWord();
        randomWordCharArray = randomWord.toCharArray();
        incorrectCount = 0;
        correctCount = 0;
        gameScore = 100;
    }
	public void reset_C(){
		incorrectCount_C = 0;
		correctCount_C = 0;
		
	}
	public int longitudPalabra(){
		int logitud = randomWordCharArray.length;
		return logitud;
	}

    //setDateTime
    //purpose: sets game date/time to system date/time
    public void setDateTime() {
        this.dateTime = LocalDateTime.now();
    }
    
    //method: makeGuess
    //purpose: check if user guess is in string. Return a
    // list of positions if character is found in string
    public ArrayList<Integer> makeGuess(String guess){
        char guessChar = guess.charAt(0);
        ArrayList<Integer> positions = new ArrayList<>();
        for(int i = 0; i < randomWordCharArray.length; i++){
            if(randomWordCharArray[i] == guessChar){
                positions.add(i);
            }
        }
        if(positions.size() == 0){
			reset_C();
			incorrectCount++;
            gameScore = Gs.calculateScore(correctCount_C,incorrectCount_C,longitudPalabra());
        } else {
			reset_C();
            correctCount += positions.size();
			gameScore = Gs.calculateScore(correctCount_C,incorrectCount_C,longitudPalabra);
        }  
		
		
        return positions;
        
    }
    
    //getDateTime
    //purpose: returns current displayed date/time
    public String getDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM-dd-uuuu hh:mm:ss a");
        return dtf.format(dateTime);
    }

    //setScore
    //purpose: sets score value to points
    public void setScore(int score) {
        this.gameScore = score;
    }
    
    //getScore
    //purpose: returns current score value
    public int getScore() {
        return gameScore;
    }

    //name: selectRandomWord()
    //purpose: selects random word from dictionary
    private String selectRandomWord() {
        Random rand = new Random();
        List<String> words = dictionary.getAvailableWords();
        return words.get(rand.nextInt(words.size()));
    }

    //method: getIncorrectCount
    //purpose: return number of incorrect guesses made so far
    public int getIncorrectCount() {
        return incorrectCount;
    }

    //method: getCorrectCount
    //purpose: return number of correct guesses made so far
    public int getCorrectCount() {
        return correctCount;
    }

    //method: getGameScore
    //purpose: return current score
    public int getGameScore() {
        return gameScore;
    }

    //method: setGameScore
    //purpose: set current game score
    public void setGameScore(int gameScore) {
        this.gameScore = gameScore;
    }
    
    //method: getWordLength
    //purpose: return length of current word
    public int getWordLength(){
        return randomWord.length();
    }

    public List<Character> getCharacterSet() {
        return new ArrayList<>(dictionary.getCharacterSet());
    }
}
