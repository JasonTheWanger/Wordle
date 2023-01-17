import java.util.*;
public class WordleMain {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Wordle puz = new Wordle();
		Grid grid = new Grid();
		System.out.println("Welcome to Wordle Game");
		System.out.println("C for correct letter at correct position\nH for correct letter at incorrect position\nI for incorrect letter");
		while (puz.getGrid().solved()==false && puz.alive()) {
			System.out.println(puz.getWord());
            System.out.print("\nMake a guess: ");
            String guess = scan.nextLine();
            if(puz.isWord(guess)){
            puz.check(guess);
            puz.getGrid().show();
            }
            else
            	System.out.println("This is not a word that I know");
            clearScreen();
        }
		if(puz.getGrid().solved()) {
			System.out.println("You win");
		}
		else {
			System.out.println("You lose the word is " + puz.getWord());
		}
	}
	public static void clearScreen() {
        System.out.println("\f");
    }
}
