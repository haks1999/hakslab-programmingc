package prog._110105_graphicaleditor;

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
    	
    	while(true){
    		String line = readLine( 100 );
    		if( line== null || line.trim().length() < 1) break;
    		
    	}
    	
    }
   
}
