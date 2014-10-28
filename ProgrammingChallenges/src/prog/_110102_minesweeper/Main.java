package prog._110102_minesweeper;

import java.io.IOException;
import java.util.StringTokenizer;

//ID: 110102

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
    	
    	int row = -1;
    	int col = -1;
    	int num = 1;
    	
    	while( true ){
    		StringTokenizer defineLine = readTokens(30);
        	row = Integer.parseInt(defineLine.nextToken());
        	col = Integer.parseInt(defineLine.nextToken());
        	if( row == 0 && col == 0 ) break;
        	if( num > 1 ) System.out.println();
        	System.out.println("Field #" + num++ + ":" );
        	int[][] mines = createMines( row, col );
        	for ( int inx = 1; inx < row+1 ; inx++ ){
        		for ( int jnx = 1; jnx < col+1 ; jnx++ ){
        			int mine = mines[inx][jnx];
        			if( mine < 0 ){
        				System.out.print( "*" );
        			}else{
        				System.out.print( mine );
        			}
        		}
        		System.out.println();
        	}
    	}
    	
    	
    }
    
    int[][] createMines( int row, int col ){
    	int[][] mines = new int[row+2][col+2];
    	for ( int inx = 1; inx < row+1 ; inx++ ){
    		char[] line = readLine( col*2 ).toCharArray();
    		for ( int jnx = 1; jnx < col+1 ; jnx++ ){
    		    mines[inx][jnx] = line[ jnx-1 ] != '.' ? -10 :0;
    		}
    	}
    	
    	for ( int inx = 1; inx < row+1 ; inx++ ){
    		for ( int jnx = 1 ; jnx < col+1 ; jnx++ ){
    			if( mines[inx][jnx] < 0 ){
    				mines[inx-1][jnx-1]++;
    				mines[inx-1][jnx]++;
    				mines[inx-1][jnx+1]++;
    				mines[inx][jnx-1]++;
    				mines[inx][jnx+1]++;
    				mines[inx+1][jnx-1]++;
    				mines[inx+1][jnx]++;
    				mines[inx+1][jnx+1]++;
    			}
    		}
    	}
    	return mines;
    }
   
}
