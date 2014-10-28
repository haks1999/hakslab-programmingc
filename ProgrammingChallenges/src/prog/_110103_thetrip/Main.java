package prog._110103_thetrip;

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
    		int studentsNum = Integer.parseInt(line);
    		if( studentsNum < 1) break;
    		int[] students = new int[studentsNum];
    		int totalMoney = 0;
    		for( int inx = 0 ; inx < studentsNum ; inx++ ){
    			//int money = Integer.parseInt(readLine( 100000 ).replace(".", ""));
    			int money = (int)(Double.parseDouble(readLine( 100000 )) * 100);
    			students[inx] = money;
    			totalMoney += money;
    		}
    		
    		//int avgMoney = (int)Math.ceil((double)totalMoney/(double)studentsNum);
    		boolean hasAlpha = totalMoney%studentsNum != 0;
    		int avgMoney = totalMoney/studentsNum;
    		int totalExchangeMoney = 0;
    		int totalExchanges = 0;
    		int bigger = 0;
    		for( int inx = 0 ; inx < studentsNum ; inx++ ){
    			int exchange = students[inx] - avgMoney;
    			/*
    			if( exchange < 0 ) totalExchanges++;
    			if( exchange != 0 ){
    				totalExchangeMoney += Math.abs(exchange);
    			}
    			*/
    			if( exchange > 0 ){
    				bigger++;
    				totalExchangeMoney += exchange - (hasAlpha?1:0);
    				//totalExchangeMoney += exchange;
    			}else if(exchange < 0 ){
    				bigger--;
    			}
    		}
    		/*
    		int result = totalExchangeMoney/totalExchanges - (hasAlpha?1:0);
    		System.out.println( "$" + result/100 + "." + result%100);
    		*/
    		int result = totalExchangeMoney;
    		int right = result%100;
    		System.out.println( "$" + result/100 + "." + ((right<10)?"0":"") + right);
    	}
    	
    }
   
}
