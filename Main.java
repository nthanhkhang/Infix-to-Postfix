import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Main { //Sinh vien co the doc hieu nhung khong duoc sua file nay

	public static void main(String[] args) throws IOException {
		ArrayList<String> inputArray1 = new ArrayList<String>();
		ArrayList<String> inputArray2 = new ArrayList<String>();
		ArrayList<String> requirement1 = new ArrayList<String>();
		ArrayList<Double> requirement2 = new ArrayList<Double>();
		
		ReadFile read = new ReadFile("input1.txt");
		inputArray1 = read.readFileResult();
		
		read = new ReadFile("input2.txt");
		inputArray2 = read.readFileResult();
		
		// Assignment 1
		for(String str : inputArray1){
			requirement1.add(new InfixToPostfixSolve(str).getOutputString());
		}
		
		File file = new File("output1.txt");
		FileOutputStream stream = new FileOutputStream(file);
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(stream));
		for(String str : requirement1){
			writer.write(str);
			writer.newLine();
		}	     
	    writer.close();
		
		// Assignment 2
		for(String str : inputArray2){
			requirement2.add(new CalculatePostfixSolve(str).getResultOfExpression());
		}
		
		file = new File("output2.txt");
		stream = new FileOutputStream(file);
		writer = new BufferedWriter(new OutputStreamWriter(stream));
		for(double result : requirement2){
			writer.write((new BigDecimal(Double.toString(result))).toPlainString());
			writer.newLine();
		}	     
	    writer.close();
		
	}

}
