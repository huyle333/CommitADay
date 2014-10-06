import java.io.*;
import java.util.*;

public class windowssearch {

	public static void main(String[] args) throws FileNotFoundException{
		int prefixOfToken = 0;
		int isWord = 0;
		String first = "";
		Scanner file = new Scanner(new File("/home/huyle333/workspace/windowssearch/src/PracticeInput1.txt"));
		String keyword = file.next();
		while (file.hasNext()){
			String word = file.next();
			if(word.equals(keyword))
				isWord++;
			if(word.contains(keyword)){
				prefixOfToken++;
			}
		}
		System.out.print(isWord + ";");
		System.out.print(prefixOfToken + ";");
		System.out.print(first);
	}
}
