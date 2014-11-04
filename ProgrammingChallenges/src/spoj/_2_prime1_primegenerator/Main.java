package spoj._2_prime1_primegenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
        myWork.begin_05();                    
    }
    
    
    
    public void begin() {

    	/*
89867
89891
89897
89899
89909
89917
89923
89939
89959
89963
    	 */
    	int numberOfTestCases = Integer.parseInt(readLine(10));
    	
    	for( int testCaseIdx = 0 ; testCaseIdx < numberOfTestCases ; testCaseIdx++ ){
    		String[] inputs = readLine(100).split(" ");
    		
    		int min = Integer.parseInt(inputs[0]);
    		int max = Integer.parseInt(inputs[1]);
    		generatePrimes_03(min, max);
    		System.out.println();
    		
    	}
    	
    	
    }
    
    
    
    
    public void begin_01() {

    	long start = System.nanoTime();
    	generatePrimes_01(2, 11);
    	System.out.println();
    	generatePrimes_01(89867, 89963);
    	System.out.println();
    	generatePrimes_01(89867, 89963);
    	System.out.println();
    	generatePrimes_01(2, 11);
    	generatePrimes_01(89867, 89963);
    	System.out.println();
    	generatePrimes_01(89867, 89963);
    	System.out.println();
    	
    	System.out.println("elipsed time: " + (System.nanoTime() - start) );	// 17245024
    	
    }
    
    void generatePrimes_01(int min, int max){
    	for( int integer= min<2?2:min ; integer < max+1 ; integer++ ){
    		boolean isPrime = true;
    		for( int check = 2; check < integer && integer>2; check++ ){
    			if(integer%check == 0){
    				isPrime = false;
    				break;
    			}
    		}
    		
    		if(isPrime){
    			System.out.println(integer );
    		}
    	}
    }
    
    public void begin_02() {

    	long start = System.nanoTime();
    	generatePrimes_02(2, 11);
    	System.out.println();
    	generatePrimes_02(89867, 89963);
    	System.out.println();
    	generatePrimes_02(89867, 89963);
    	System.out.println();
    	generatePrimes_02(2, 11);
    	System.out.println();
    	generatePrimes_02(89867, 89963);
    	System.out.println();
    	generatePrimes_02(89867, 89963);
    	System.out.println();
    	//generatePrimes_02(89867, 899630);
    	
    	System.out.println("elipsed time: " + (System.nanoTime() - start) );	// 3437424
    	
    }
    
    void generatePrimes_02(int min, int max){
    	for( int integer= min<2?2:min ; integer < max+1 ; integer++ ){
    		boolean isPrime = true;
    		int check = 2;
    		int maxCheck = integer;
    		while(integer>2 && check < maxCheck){
    			if(integer%check == 0){
    				isPrime = false;
    				break;
    			}else{
    				maxCheck= integer/check++;
    			}
    		}
    		
    		if(isPrime){
    			System.out.println(integer );
    		}
    	}
    }
    
    
    public void begin_03() {

    	long start = System.nanoTime();
    	generatePrimes_03(2, 11);
    	System.out.println();
    	generatePrimes_03(89867, 89963);
    	System.out.println();
    	generatePrimes_03(89867, 89963);
    	System.out.println();
    	generatePrimes_03(2, 11);
    	System.out.println();
    	generatePrimes_03(89867, 89963);
    	System.out.println();
    	generatePrimes_03(89867, 89963);
    	System.out.println();
    	//generatePrimes_02(89867, 899630);
    	
    	System.out.println("elipsed time: " + (System.nanoTime() - start) );	// 2821728
    	
    }
    
    
    Set<Integer> primeNumbers = new HashSet<Integer>(500,500);
    void generatePrimes_03(int min, int max){
    	for( int integer= min<2?2:min ; integer < max+1 ; integer++ ){
    		boolean isPrime = true;
    		if( !primeNumbers.contains(integer)){
    			int check = 2;
        		int maxCheck = integer;
        		while(integer>2 && check < maxCheck){
        			if(integer%check == 0){
        				isPrime = false;
        				break;
        			}else{
        				maxCheck= integer/check++;
        			}
        		}
        		if(isPrime) primeNumbers.add(integer);
    		}
    		
    		
    		if(isPrime){
    			System.out.println(integer );
    		}
    	}
    }
    
    public void begin_04() {

    	// Sieve of Eratosthenes
    	// http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
    	long start = System.nanoTime();
    	initializePrimes();
    	generatePrimes_04(2, 11);
    	System.out.println();
    	generatePrimes_04(89867, 89963);
    	System.out.println();
    	generatePrimes_04(89867, 89963);
    	System.out.println();
    	generatePrimes_04(2, 11);
    	System.out.println();
    	generatePrimes_04(89867, 89963);
    	System.out.println();
    	generatePrimes_04(89867, 89963);
    	System.out.println();
    	//generatePrimes_02(89867, 899630);
    	
    	System.out.println("elipsed time: " + (System.nanoTime() - start) );	// 2821728
    	
    }
    
    Set<Integer> nonePrimeNumbers = new HashSet<Integer>(500,500);
    void initializePrimes(){
    	nonePrimeNumbers.add(1);
    	for( int integer = 2; integer < 1000000001 ; integer++ ){
    		System.out.println("integer: " + integer);
    		if(!nonePrimeNumbers.contains(integer)){
    			int currentMutiplyNumber = integer;
    			int currentMutipliedNumber = integer*currentMutiplyNumber;
    			while(currentMutipliedNumber<1000000000){
    				nonePrimeNumbers.add(currentMutipliedNumber);
    				System.out.println("    - currentMutipliedNumber: " + currentMutipliedNumber);
    				currentMutipliedNumber = integer*++currentMutiplyNumber;
    			}
    		}
    	}
    	
    }
    
    
    void generatePrimes_04(int min, int max){
    	for( int integer= min ; integer < max+1 ; integer++ ){
    		if(!nonePrimeNumbers.contains(integer)){
    			System.out.println(integer );
    		}
    	}
    }
 
    
    public void begin_05() {

    	long start = System.nanoTime();
    	generatePrimes_05(2, 11);
    	System.out.println();
    	generatePrimes_05(89867, 89963);
    	System.out.println();
    	generatePrimes_05(89867, 89963);
    	System.out.println();
    	generatePrimes_05(2, 11);
    	System.out.println();
    	generatePrimes_05(89867, 89963);
    	System.out.println();
    	generatePrimes_05(89867, 89963);
    	System.out.println();
    	//generatePrimes_02(89867, 899630);
    	
    	System.out.println("elipsed time: " + (System.nanoTime() - start) );	// 5218448
    	
    }
    
    Set<Integer> primeNumbersSet = new HashSet<Integer>(500,500);
    Set<Integer> nonePrimeNumbersSet = new HashSet<Integer>(500,500);
    void generatePrimes_05(int min, int max){
    	for( int integer= min<2?2:min ; integer < max+1 ; integer++ ){
    		boolean isPrime = true;
    		if( !primeNumbersSet.contains(integer)){
    			if( nonePrimeNumbersSet.contains(integer)){
    				isPrime = false;
    			}else{
    				int check = 2;
            		int maxCheck = integer;
            		while(integer>2 && check < maxCheck){
            			if(integer%check == 0){
            				isPrime = false;
            				break;
            			}else{
            				maxCheck= integer/check++;
            			}
            		}
            		if(!isPrime) nonePrimeNumbersSet.add(integer);
    			}
    			
        		if(isPrime) primeNumbersSet.add(integer);
    		}
    		
    		
    		if(isPrime){
    			System.out.println(integer );
    		}
    	}
    }
    
   
   
}
