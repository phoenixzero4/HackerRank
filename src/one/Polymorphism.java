package one;

import java.util.Scanner;

public class Polymorphism {
	static class Parent{
        public int startElement;
        public int endElement;
        
        public Parent(int start, int end) {
        	this.startElement = start;
        	this.endElement = end;
        }
        
        public String filter(int s, int e) {
        	return null;
        }
    }
    
   static class ChildOne extends Parent{
    	public int startElement;
    	public int endElement;
    	public ChildOne(int start, int end) {
    		super(start, end);
    	}
    	
    	@Override
    	public String filter(int s, int e) {
    		String ans = "";
    		
    		for(int i = s; i <= e; i++) {
    			boolean isPrime = true;
    			for(int j = i-1; j > 1; j--) {
    				if(i % j == 0) {
    					isPrime = false;
    				}
    			}if(isPrime && i > 1) {
    			//	System.out.println(i + " is prime");
    				
    				ans += String.valueOf(i) + " ";
    			}
    		}
    		return ans;
    	}
    
    }
    static class ChildTwo extends Parent{
    	public int startElement;
    	public int endElement;
    	public ChildTwo(int s, int e) {
    		super(s, e);
    	}
    	
    	public boolean isHappy(int x) {
    		int sum = 0;
    		while(x > 0) {
    			int mod = x % 10;
    			sum += (mod * mod);
    			x /= 10;
    		}
    		if(sum == 1) {
    			return true;
    		}else if(sum < 10) {
    			return false;
    		}else {
    	//		System.err.println("recursively testing " + sum);
    			return isHappy(sum);
    		}
    	}
    
       	@Override
    	public String filter(int s, int e) {
    		String ans = "";
    		
    		for(int i = s; i <= e; i++) {
    //			System.out.println("Testing " + i + " for happiness");
    			if(isHappy(i)) {
    				ans += String.valueOf(i) + " ";
    			}
    		}
    		return ans;
    	}
        
    }
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
    //    int start = in.nextInt();
    //    int end = in.nextInt();
        int start = 1;
        int end = 150;
        
    
        ChildOne one = new ChildOne(start, end);
        ChildTwo two = new ChildTwo(start, end);
        System.out.println(one.filter(start,  end));
     //   System.out.println(two.filter(start,  end));
     
    }  
        
    
}
