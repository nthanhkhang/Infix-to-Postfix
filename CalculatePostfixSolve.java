import java.util.Stack;

public class CalculatePostfixSolve implements Requirement2_OutputGetter{
	private String inputString;
	private double resultOfExpression;
	
	public CalculatePostfixSolve()
	{
		this.inputString = "";
		this.resultOfExpression = 0;
	}
	
	public CalculatePostfixSolve(String inputString)
	{
		this.inputString = inputString;
		this.resultOfExpression = 0;
	}
	
	public void setInputString(String inputString)
	{
		this.inputString = inputString;
	}	
	
	public double getResultOfExpression()
	{
		this.resultOfExpression = calculatePostfix();
		return this.resultOfExpression;
	}	
	private double calculatePostfix()
	{
		String[] tokens = null;
		tokens = stringTokenizer(inputString);
		Stack <Double> Stack = new Stack <>();
		for(int i = 0 ; i < tokens.length ; i++){
            if(isNum(tokens[i]) == true){
                Stack.push(Double.parseDouble(tokens[i]));
            }
            else{
                double s2 = Stack.pop();
                double s1 = Stack.pop();
				switch (tokens[i].charAt(0))
				{
                    case '+':
                    Stack.push(s1 + s2);
                    break;
                    case '-':
                    Stack.push(s1 - s2);
                    break;
                    case '*':
                    Stack.push(s1 * s2);
                    break;
                    case '/':
                    Stack.push(s1 / s2);
                    break;
                    case '^':
                    Stack.push(Math.pow(s1,s2));
                    break;
                }
            }
        }
		return Stack.pop();
	}
	
	private boolean isNum(String c)
	{
    	return c.matches("0|([1-9][0-9]*)");
	}
	
	private String[] stringTokenizer(String str)
	{
        String[] tokens = null;
        tokens = str.split(" ");
		return tokens;
	}

}
