import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile { //Sinh vien co the doc hieu nhung khong duoc sua file nay
	private ArrayList<String> inputArray;
	
	public ReadFile(String fileName) throws FileNotFoundException{
		inputArray = new ArrayList<String>();
		File file = new File(fileName); 
	    Scanner scan = new Scanner(file); 
	    while (scan.hasNextLine()){
	    	inputArray.add(scan.nextLine());
	    }
	    scan.close();
	}
	
	public ArrayList<String> readFileResult(){
		return this.inputArray;
	} 
}
