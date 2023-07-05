import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String [] args) throws Exception{
        System.out.println("Hey wsg");
    File dict = new File("C:\\Users\\Benjamin Dulcio\\engmix.txt");
    Scanner myScan = new Scanner(dict);
    Scanner input = new Scanner(System.in);
        ArrayList<String> words = new ArrayList<>();
        while(myScan.hasNext()){
            words.add(myScan.nextLine());
        }
        String hidden = words.get((int)(Math.random() * words.size()));
        char [] textArray = hidden.toCharArray();
        char [] myAnswer = new char[textArray.length];
        for(int i =0; i< textArray.length; i++){
        myAnswer[i] = '?';
        }
        boolean finished = false;
        int lives = 6;
        while(finished == false){
            System.out.println("*************");
             String letter = input.next();
             ///check for valid input
            while(letter.length() != 1 || Character.isDigit(letter.charAt(0))){
                System.out.print("Error input try again");
                letter = input.next();
            }
            //check if letter is inside the loop
            boolean found = false;
            for(int i = 0; i < textArray.length; i++){
                if(letter.charAt(0) == textArray[i]){
                    myAnswer[i] = textArray[i];
                    found = true;
                }
            }
            if(!found){
            lives--;
            System.out.println("Wrong letter");
            }
            boolean done = true;
            for(int i =0; i < myAnswer.length; i++){
                if(myAnswer[i] == '?'){
                    System.out.print('_');
                    done = false;
                }else {
                    System.out.print(" " + myAnswer[i]);
                }
            }
            System.out.println("\n" + "Lives left:  " + lives);
            drawHangman(lives);
            if(done){
                System.out.println("Congrats you found the word");
                finished = true;
            }
            if(lives <= 0){
                System.out.println("You are dead better luck next time");
                finished = true;
            }
        }
    }
    public static void drawHangman(int l) {
        if(l == 6) {
            System.out.println("|----------");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(l == 5) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(l == 4) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|    |");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(l == 3) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(l == 2) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(l == 1) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|   /");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else{
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|   /|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
    }
}
