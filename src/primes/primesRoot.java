package primes;

public class primesRoot {
	
	public static void main(String[] args) {
		int x = 1000;
		for(int i=2;i<x;i++) {
			PC(i);
		}
	}
	
	public static void PC(int i) {
		boolean p = true;
		for(int j = 2; j<1000; j++) {
			p = true;
			if(i%j==0&&j<i/2) {
				p = false;
				break;
			}
		}
		if (p=true){
			System.out.println(i + ", ");
		}
	}
}
