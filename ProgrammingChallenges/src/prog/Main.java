package prog;

import java.io.*;
import java.util.*;

public class Main implements Runnable{
	static String ReadLn(int maxLength){  // utility function to read from stdin,
        // Provided by Programming-challenges, edit for style only
		byte line[] = new byte [maxLength];
		int length = 0;
		int input = -1;
		try{
			while (length < maxLength){//Read untill maxlength				
				input = System.in.read();
				if ((input < 0) || (input == '\n')) break; //or untill end of line ninput
				line [length++] += input;
			}
	
			if ((input < 0) && (length == 0)) return null;  // eof
			return new String(line, 0, length);
		}catch (IOException e){
			return null;
		}
	}

	public static void main(String args[])  // entry point from OS
	{		
		Main myWork = new Main();  // Construct the bootloader
		myWork.run();            // execute
	}

	public void run() {
		new myStuff().run();
	}
}
class myStuff implements Runnable{
	public void run(){
		// Your program here	
		
		
		while( true ){
			String inputLine = Main.ReadLn(1000000);
			if( inputLine == null || inputLine.trim().length() < 1 ) break;
			String[] arrAgu = inputLine.split(" ");

			int[] aguNum = new int[(Integer.parseInt(arrAgu[1].replaceAll("\\p{Space}", ""))-Integer.parseInt(arrAgu[0]))+1];
			boolean chkArr = true;
			int nowNum = 0;
			int cnt = 1;
			int maxCnt = 0;
			
			for(int i=0;i<aguNum.length;i++){
				aguNum[i] = Integer.parseInt(arrAgu[0].replaceAll("\\p{Space}", ""))+i;
			}
			
			for(int i=0;i<aguNum.length;i++){
				chkArr = true;			
				nowNum = aguNum[i];
				cnt = 1;			
				//System.out.println(aguNum[i]+" "+nowNum+" "+ cnt);
				while(chkArr){
					
					if(nowNum % 2 == 0){
						nowNum /= 2;
					}else{
						nowNum = (nowNum * 3) + 1;
					}
					
					cnt++;				
					//System.out.println(aguNum[i]+" "+nowNum+" "+ cnt);
					if(nowNum == 1){
						chkArr = false;
					}
				}
				
				if(maxCnt < cnt){
					maxCnt = cnt;
				}
			}
			
			System.out.println(arrAgu[0]+ " " +arrAgu[1].replaceAll("\\p{Space}", "") + " " + maxCnt);
		}
		
	}

// You can insert more classes here if you want.
}