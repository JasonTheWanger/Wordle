import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class Wordle {
	
	private String word; //represents the random word the user is supposed to guess
	//stored as all uppercase letters
	
	private int MAX_WORDS = 45402; //represents how many words are in words.txt
		
	private ArrayList<String> list = new ArrayList<String>();
	
	private ArrayList<Character> l=new ArrayList<Character>();
	
	private int lives;

	private Grid g= new Grid();
	public Wordle() {
		word = pickRandomWord("/Users/junran.wang/eclipse-workspace/APCS/src/words.txt");
	    lives=6;
	}
	
	private String pickRandomWord(String filename) {
	    try {
	      File file = new File(filename);
	      Scanner scanner = new Scanner(file);
	      int i = 0;
	      int n = MAX_WORDS;
	      String line = "";
	      while (i < n) {
	        line = scanner.next();
	        if(line.length()==5)
	        list.add(line.toLowerCase());
	        i++;
	      }
	      scanner.close();
	      int rnd = (int)(Math.random()*list.size());
	      return list.get(rnd);
	    } catch (FileNotFoundException e) {
	      e.printStackTrace();
	    }
	    return null;
	  }
	public String getWord() {
		return word;
	}
	
	public boolean alive() {
		return (lives>0);
	}
	
	private void dmg() {
		lives--;
	}
	public void check(String str) {
		g.resetList();
		l = new ArrayList<Character>();
		char [] list = str.toCharArray();
		char [] ans=word.toCharArray();
		for(char c:list) {
			l.add(c);
		}
		for(int i =0; i<list.length; i++) {
			if(list[i]==(word.charAt(i))) {
				g.drawGrid(0,i);
				ans[i]=' ';
				l.set(i,'@');
			}
		}
		String s=new String(ans);
		for(int i=0; i<l.size(); i++) {
			if(l.get(i)!='@')
			if(s.indexOf(l.get(i))>=0) {
				g.drawGrid(1,i);
				ans=s.toCharArray();
				ans[s.indexOf(l.get(i))]=' ';
				s=new String(ans);
			}
			else {
				g.drawGrid(2,i);
			}
		}
		
		dmg();
		System.out.println("\n");
	}
	public Grid getGrid() {
		return g;
	}
}
