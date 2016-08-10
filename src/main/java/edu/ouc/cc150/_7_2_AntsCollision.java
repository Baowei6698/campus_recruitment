package edu.ouc.cc150;

public class _7_2_AntsCollision {

	/**
	 * 1 - £¨double£©2 / (2 ^n) 
	 * 
	 * @param n
	 * @return
	 */
    public double antsCollision(int n) {
    	return (1.0-(1.0/(1<<(n-1))));
    }
    
	public static void main(String[] args) {
		System.out.println("" + (1<<-1));
	}

}
