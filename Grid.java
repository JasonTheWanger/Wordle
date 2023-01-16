import java.util.ArrayList;
public class Grid {
	private ArrayList <Boolean>grid=new ArrayList <Boolean>();
	private String[] ans= new String[5];
	private boolean flag;
	public Grid() {
		for(int i=0; i<5; i++)
			grid.add(false);
		flag=true;
	}
	
	public void drawGrid(int n, int i) {
		if(n==0) {
			//correct
			//System.out.print("\uD83D\uDFE9");
			ans[i]=("C");
			grid.set(i, true);
		}
		else if(n==1) {
			//half correct
			//System.out.print("\uD83D\uDFE8");
			ans[i]="H";
			grid.set(i,false);
		}
		else if(n==2) {
			//incorrect
//			System.out.print("\uD83D\uDFEB");
			ans[i]="I";
			grid.set(i,false);
		}
	}
	public void resetList() {
		grid=new ArrayList<Boolean>();
		for(int i=0; i<5; i++)
			grid.add(false);
		ans =new String[5];
	}
	public boolean solved() {
		flag=true;
		for(Boolean bool: grid) {
			if(!bool)
				flag=false;
		}
		return flag;
	}
	public void show() {
		for(String str:ans)
		System.out.print(str);
	}
}
