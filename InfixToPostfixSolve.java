import java.util.*;
public class InfixToPostfixSolve implements Requirement1_OutputGetter 
{
	private String inputString;
	private String outputString;
	
	public InfixToPostfixSolve()
	{
		this.inputString = "";
		this.outputString = "";
	}
	
	public InfixToPostfixSolve(String inputString)
	{ 
		this.inputString = inputString;
		this.outputString = "";
	}
		
	public void setInputString(String inputString)
	{ 
		this.inputString = inputString;
	}
	public String getOutputString() 
	{
    	this.outputString = infixToPostfix();
		return outputString;
	}	
	private String infixToPostfix()
	{
		String[] tokens = null;
		tokens = stringTokenizer(inputString);
		Stack <String> stack = new Stack <String> ();
		String out = "";
		for(int i = 0; i<tokens.length; i++)
		{
			if(isNum(tokens[i]) == true)
			{
                out = out + tokens[i] + " ";
            }
			else if(tokens[i].charAt(0) == '(')
			{
                stack.push(tokens[i]);
            }
			else if(tokens[i].charAt(0) == ')')
			{
				while(!stack.isEmpty() && stack.peek().charAt(0) != '(')
				{
                    out = out + stack.pop() + " ";
                }
				if(!stack.isEmpty() && stack.peek().charAt(0) != '(')
				{
					break;
				}
                else{
                    stack.pop();
                	}
            }
            else{
                while(!stack.isEmpty() && priorityOfOperator(tokens[i]) <= priorityOfOperator(stack.peek())){
                    out = out + stack.pop() + " ";
                }
                stack.push(tokens[i]);
            }
        }
        while(!stack.isEmpty()){
            out = out + stack.pop() + " ";
        }
		return out;
	}
	
	private String[] stringTokenizer(String str){
		String[] tokens = null;
		tokens = str.split(" ");
		return tokens;
	}
	    
	private boolean isNum(String c) {
    	return c.matches("0|([1-9][0-9]*)");
    }
	
	private int priorityOfOperator(String op){
		char operator = op.charAt(0);
		if(operator == '+' || operator == '-') 
			return 1;
		else if(operator == '*' || operator == '/') 
			return 2;
		else if(operator == '^') 
			return 3;
    	return 0;
    }   
}