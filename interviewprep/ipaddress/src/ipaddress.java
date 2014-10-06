import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ipaddress {
	private static final String PATTERN = 
	        "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
	
	public static boolean validate(final String ip){          
	      Pattern pattern = Pattern.compile(PATTERN);
	      Matcher matcher = pattern.matcher(ip);
	      return matcher.matches();             
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		//BufferedReader reader = new BufferedReader(new FileReader("PracticeInput.txt"));
		Scanner file = new Scanner(new File("/home/huyle333/workspace/ipaddress/src/PracticeInput.txt"));
		while (file.hasNextLine()){
			String[] tokens = new String[3];
			for(int i = 0; i < 3; i++){
				tokens[i] = file.next();
				System.out.println(tokens[i]);
			}
			if(validate(tokens[0]) && validate(tokens[1]) && validate(tokens[2])){
				
			}else{
				System.out.println("Invalid");
				continue;
			}
			String[] third = tokens[2].split(".");;
			//System.out.println(tokens[2]);
		}
	}
}
