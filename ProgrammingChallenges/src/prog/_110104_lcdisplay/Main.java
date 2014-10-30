package prog._110104_lcdisplay;

import java.io.IOException;
import java.util.StringTokenizer;

//ID: 29049OA

class Main {
	
	private static final int buffSize = 255;
	    
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
    	
    	StringTokenizer st = null;
    	
        while((st = readTokens(30)) != null) {    		
			int size = Integer.parseInt( st.nextToken() );
			if ( size == 0 ) return;
			char[] numbers = st.nextToken().toCharArray();
			char[][] display = new char[size*2 + 3][(size + 3) * numbers.length];
			
			for ( int inx = 0 ; inx < numbers.length ; inx++ ){
				addNumber( display, drawNumber( size, numbers[inx]), inx, size );
			}
			for ( int inx = 0 ; inx < display.length ; inx++ ){
				for ( int jnx = 0 ; jnx< display[inx].length -1 ; jnx++ ){
					System.out.print( display[inx][jnx]);
				}
				System.out.println();
			}
			System.out.println();
		}
    }
    
    void addNumber( char[][] display, char[][] singleNum, int index, int size ){
    	int startRow = index * ( size + 3 );
    	int endRow = ( index + 1 ) * ( size + 3 ); 
    	for ( int inx = 0 ; inx < singleNum.length ; inx++ ){
    		int knx = 0;
    		for ( int jnx = startRow ; jnx < endRow ; jnx++ ){
    			display[inx][jnx] = singleNum[inx][knx++];
    		}
    	}
    }
    
    
    char[][] drawNumber ( int size, char number ){
    	char[][] singleNum = new char[size*2 +3][size+3];
    	for ( int inx = 0 ; inx < singleNum.length ; inx++ ){
    		for ( int jnx = 0 ; jnx < singleNum[inx].length ; jnx++ ){
    			singleNum[inx][jnx] = ' ';
    		}
    	}
    	switch( number ) {
    		case '1' : 
    			drawTopRightLine( size, singleNum); 
    			drawBottomRightLine( size, singleNum) ; break;
    		case '2' :
    			drawTopLine( size, singleNum );
    			drawTopRightLine( size, singleNum );
    			drawMiddleLine( size, singleNum );
    			drawBottomLeftLine( size, singleNum );
    			drawBottomLine( size, singleNum ); break;
    		case '3' :
    			drawTopLine( size, singleNum );
    			drawTopRightLine( size, singleNum );
    			drawMiddleLine( size, singleNum );
    			drawBottomRightLine( size, singleNum );
    			drawBottomLine( size, singleNum ); break;
    		case '4' :
    			drawTopLeftLine( size, singleNum );
    			drawTopRightLine( size, singleNum );
    			drawMiddleLine( size, singleNum );
    			drawBottomRightLine( size, singleNum ); break;
    		case '5' :
    			drawTopLine( size, singleNum );
    			drawTopLeftLine( size, singleNum );
    			drawMiddleLine( size, singleNum );
    			drawBottomRightLine( size ,singleNum );
    			drawBottomLine( size, singleNum ); break;
    		case '6' :
    			drawTopLine( size, singleNum );
    			drawTopLeftLine( size, singleNum );
    			drawMiddleLine( size, singleNum );
    			drawBottomLeftLine( size, singleNum );
    			drawBottomRightLine( size, singleNum );
    			drawBottomLine( size, singleNum ); break;
    		case '7' :
    			drawTopLine( size, singleNum );
    			drawTopRightLine( size, singleNum );
    			drawBottomRightLine( size, singleNum ); break;
    		case '8' :
    			drawTopLine( size, singleNum );
    			drawTopLeftLine( size, singleNum );
    			drawTopRightLine( size, singleNum );
    			drawMiddleLine( size, singleNum );
    			drawBottomLeftLine( size, singleNum );
    			drawBottomRightLine( size, singleNum );
    			drawBottomLine( size, singleNum ); break; 
    		case '9' :
    			drawTopLine( size, singleNum);
    			drawTopRightLine( size, singleNum );
    			drawTopLeftLine( size, singleNum );
    			drawMiddleLine( size, singleNum );
    			drawBottomRightLine( size, singleNum );
    			drawBottomLine( size, singleNum ); break;
    		case '0' :
    			drawTopLine( size, singleNum );
    			drawTopLeftLine( size, singleNum );
    			drawTopRightLine( size, singleNum );
    			drawBottomLeftLine( size, singleNum );
    			drawBottomRightLine( size, singleNum );
    			drawBottomLine( size, singleNum ); break;
    	}
    	return singleNum;
    }
        
    void drawTopLine( int size, char[][] singleNum ){
		for ( int inx = 1 ; inx <= size ; inx++  ){
			singleNum[0][inx] = '-';
		}
	}
	
	void drawMiddleLine( int size, char[][] singleNum ){
		for ( int inx = 1; inx <= size ; inx++ ){
			singleNum[size+1][inx] = '-';
		}
	}
	
	void drawBottomLine( int size, char[][] singleNum ){
		for ( int inx = 1; inx <= size ; inx++ ){
			singleNum[singleNum.length-1][inx] = '-';
		}
	}
	
	void drawTopLeftLine( int size, char[][] singleNum ){
		for ( int inx = 1; inx <= size ; inx++ ){
			singleNum[inx][0] = '|';
		}
	}
	
	void drawTopRightLine( int size, char[][] singleNum ){
		for ( int inx = 1; inx <= size ; inx++ ){
			singleNum[inx][size+1] = '|';
		}
	}
	
	void drawBottomLeftLine( int size, char[][] singleNum ){
		for ( int inx = 1 ; inx <= size  ; inx++ ){
			singleNum[inx + size + 1][0] = '|';
		}
	}
	
	void drawBottomRightLine( int size, char[][] singleNum ){
		for ( int inx = 1;  inx <= size ; inx++ ){
			singleNum[inx + size + 1][size+1] = '|';
		}
	}
}