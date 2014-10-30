package prog._110106_interpreter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;



// wrong answer
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
    
    
    int currentRegisterPos = 0;
    public void begin() {
    	
    	int numberOfCases = Integer.parseInt(readLine( 100 ));
    	readLine( 100 ); // blank line
    	
    	for( int cases = 0 ; cases < numberOfCases; cases++ ){
    		Map<String,String> registers = new HashMap<String,String>(10);
    		for( int inx = 0 ; inx < 10 ; inx++ ){
    			registers.put(String.valueOf(inx), "000");
    		}
    		
    		List<String> ram = new ArrayList<String>(1000);
    		while( true ){
    			String instruction = readLine( 100 );
    			if( instruction== null || instruction.trim().length() < 1) break;
    			ram.add(instruction);
    		}
    		int instructionSize = ram.size();
    		for( int inx= ram.size() ; inx < 1000; inx++ ){
    			ram.add("000");
    		}
    		
    		int totalExecuted = 0; 
    		currentRegisterPos = 0;
    		while( currentRegisterPos < instructionSize ){
    			totalExecuted = totalExecuted + executeInstruction(ram.get(currentRegisterPos), registers, ram);
    		}

    		System.out.println(totalExecuted);
    		if(cases < numberOfCases - 1){
    			System.out.println();
    		}
    	}
    }
    
    public int executeInstruction(String instruction, Map<String,String> registers, List<String> ram){
    	char mainInstruction = instruction.charAt(0);
    	currentRegisterPos++;
		switch(mainInstruction){
			case '1': return 1;
			case '2': return setValueToRegister(registers, instruction.charAt(1), instruction.charAt(2)); 
			case '3': return addValueToRegister(registers, instruction.charAt(1), instruction.charAt(2)); 
			case '4': return multiplyValueToRegister(registers, instruction.charAt(1), instruction.charAt(2));
			case '5': return setRegisterValueToRegister(registers, instruction.charAt(1), instruction.charAt(2));
			case '6': return addRegisterValueToRegister(registers, instruction.charAt(1), instruction.charAt(2));
			case '7': return multiplyRegisterValueToRegister(registers, instruction.charAt(1), instruction.charAt(2));
			case '8': return setRamValueToRegister(registers, instruction.charAt(1), instruction.charAt(2), ram);
			case '9': return setRamValueFromRegister(registers, instruction.charAt(1), instruction.charAt(2), ram); 
			case '0': return gotoRegister(registers, instruction.charAt(1), instruction.charAt(2), ram );
		}
		return 0;
    }
    
    public int setValueToRegister(Map<String,String> registers, char registerLoc, char value){
    	registers.put(String.valueOf(registerLoc), "00" + String.valueOf(value));
    	return 1;
    }
    
    
    public int addValueToRegister(Map<String,String> registers, char registerLoc, char value){
    	int excuted = 1;
    	int result = Integer.parseInt(registers.get(String.valueOf(registerLoc))) + Character.getNumericValue(value);
    	if( result > 1000 ){
    		result = result%1000;
    		excuted++;
    	}
    	registers.put(String.valueOf(registerLoc), toRegisterFormat(result));
    	return excuted;
    }
    
    public int multiplyValueToRegister(Map<String,String> registers, char registerLoc, char value){
    	int excuted = 1;
    	int result = Integer.parseInt(registers.get(String.valueOf(registerLoc))) * Character.getNumericValue(value);
    	if( result > 1000 ){
    		result = result%1000;
    		excuted++;
    	}
    	registers.put(String.valueOf(registerLoc), toRegisterFormat(result));
    	return excuted;
    }
    
    public int setRegisterValueToRegister(Map<String,String> registers, char registerLoc, char valueRegisterLoc){
    	registers.put(String.valueOf(registerLoc),registers.get(String.valueOf(valueRegisterLoc)));
    	return 1;
    }
    
    public int addRegisterValueToRegister(Map<String,String> registers, char registerLoc, char valueRegisterLoc){
    	int excuted = 1;
    	int result = Integer.parseInt(registers.get(String.valueOf(registerLoc))) + Integer.parseInt(registers.get(String.valueOf(valueRegisterLoc)));
    	if( result > 1000 ){
    		result = result%1000;
    		//excuted++;
    	}
    	registers.put(String.valueOf(registerLoc), toRegisterFormat(result));
    	return excuted;
    }
    
    public int multiplyRegisterValueToRegister(Map<String,String> registers, char registerLoc, char valueRegisterLoc){
    	int excuted = 1;
    	int result = Integer.parseInt(registers.get(String.valueOf(registerLoc))) * Integer.parseInt(registers.get(String.valueOf(valueRegisterLoc)));
    	if( result > 1000 ){
    		result = result%1000;
    		//excuted++;
    	}
    	registers.put(String.valueOf(registerLoc), toRegisterFormat(result));
    	return excuted;
    }
    
    public int setRamValueToRegister(Map<String,String> registers, char registerLoc, char ramAddrRegisterLoc, List<String> ram){
    	int ramAddr = Integer.parseInt(registers.get(String.valueOf(ramAddrRegisterLoc)));
    	registers.put(String.valueOf(registerLoc),ram.get(ramAddr));
    	return 1;
    }
    
    public int setRamValueFromRegister(Map<String,String> registers, char registerLoc, char ramAddrRegisterLoc, List<String> ram){
    	int ramAddr = Integer.parseInt(registers.get(String.valueOf(ramAddrRegisterLoc)));
    	ram.set(ramAddr,registers.get(String.valueOf(registerLoc)));
    	return 1;
    }
    
    public int gotoRegister(Map<String,String> registers, char registerLoc, char chkRegisterLoc, List<String> ram){
    	String registerValue = registers.get(String.valueOf(chkRegisterLoc));
    	if( registerValue.contains("0")){
    		return 1;
    	}else{
    		currentRegisterPos = Character.getNumericValue(registerLoc);
    		return 1 + executeInstruction(registers.get(String.valueOf(registerLoc)), registers, ram );
    	}
    }
    
    
    public String toRegisterFormat(int numbers){
    	int result = numbers;
    	if( result > 100 ){
    		return String.valueOf(result);
    	}else if( result > 10 ){
    		return "0" + String.valueOf(result);
    	}else{
    		return "00" + String.valueOf(result);
    	}
    }
   
}
