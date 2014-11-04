package spoj._3_sbstr1_substringcheck;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

    	
    	//int[] inputs = new int[109];	// 마이너스 9 + 0 +  플러스 99까지 
    	while(true){
    		String line = readLine( 5 );
    		if( line== null || line.trim().length() < 1) break;
    		int input = Integer.parseInt(line);
    		if( input == 42 ){
    			break;
    		}else{
    			System.out.println(input);
    		}
    		//inputs[input+9]++;
    	}
    	/*
    	for( int inx = 0 ; inx < inputs.length ; inx++ ){
    		if( inputs[inx] == 0 ) continue;
    		for( int jnx = 0 ; jnx < inputs[inx] ; jnx++ ){
    			System.out.println(inx - 9);
    		}
    	}
    	inputs = null;
    	*/
    }
    
    
   
   
}
