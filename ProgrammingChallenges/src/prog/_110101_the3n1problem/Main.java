package prog._110101_the3n1problem;

import java.io.IOException;
import java.util.StringTokenizer;


class Main {
	    
    static String readLine (int maxLg) {
    	
        char lin[] = new char [maxLg];
        int lg = 0, car = -1;

        try {
            while (lg < maxLg) {
                car = System.in.read();
                if(car == '\r') continue;
                if ((car < 0) || (car == '\n') ) break;
                lin [lg++] += car;
            }
        }
        catch (IOException e) {
            return (null);
        }

        if (lg == 0) return null;  // eof
        return (new String (lin, 0, lg));
    }    
    
    static StringTokenizer readTokens(int buff) {
    	
    	String line = readLine(buff);
    	if( line == null ) {
    		return null;
    	}
    	
    	return new StringTokenizer(line);
    }

    public static void main (String args[]) {
    	
    	Main myWork = new Main();  
        myWork.begin();                    
    }
    
    
    public void begin() {
    	
    	while( true ){
    		String line = readLine( 100 );
    		if( line== null || line.equals("")) break;
    		StringTokenizer st = new StringTokenizer( line );
    		int start = Integer.parseInt( st.nextToken() );
    		int end = Integer.parseInt( st.nextToken() );
    		boolean reverse = false;
    		if( start > end ){
    			int temp = start;
    			start = end;
    			end = temp;
    			reverse = true;
    		}
    		int maxCycle = 1;
    		for ( int inx = end, len = start - 1 ; inx > len ; inx--  ){
    			int current = inx;
    			int cycle = 1;
    			while( current != 1){
    				if( current%2 != 0 ){
    					current *= 3;
    					current++;
    				}else{
    					/*
    					if( current < ( end / 2 + 1 ) ){
    						break;
    					}
    					*/
    					current /= 2;
    				}
    				cycle++;
    			}
    			if( cycle > maxCycle ) maxCycle = cycle;
    		}
    		if( reverse ){
    			System.out.println( end + " "  + start + " "  + maxCycle );
    		}else{
    			System.out.println( start + " " + end + " " + maxCycle );
    		}
    		
    	}
    }
    
    
    
    
   
}