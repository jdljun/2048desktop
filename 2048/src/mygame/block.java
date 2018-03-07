package mygame;

public class block {
	
	public boolean iscomputed;
	private int value;
	
	public block(){
		value=0;
	}
	
	public block(int value){
		this.value=value;
	}
	
	public void changevalue(int value) {
		this.value=value;
	}
	
	public int getvalue() {
		return value;
	}

}
