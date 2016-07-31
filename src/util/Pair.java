package util;
/*
 * A class that is substituted for a tuple.
 */
public class Pair {
	
	final int Val1;
	
	final int Val2;
	
	
	public Pair(int Val1,  int Val2){
		
		this.Val1 = Val1;
		this.Val2 = Val2;
		
		
	}
	
	public int getVal1(){
		
		return this.Val1;
	}
	
	public int getVal2(){
		
		return this.Val2;
	}

}
