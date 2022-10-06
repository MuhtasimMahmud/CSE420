import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.*;

public class task 
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		File file = new File("inputs.txt");
		Scanner sc = new Scanner(file);
		
		ArrayList<String> regEx = new ArrayList<String>();
		
		int num_of_regEx = Integer.parseInt(sc.nextLine());
		
		for(int i=0; i<num_of_regEx; i++) 
		{
			String x = sc.nextLine();
			regEx.add(x);
		}
		
		int num_of_string = Integer.parseInt(sc.nextLine());
		for(int j=0; j<num_of_string; j++) 
		{
			String a = sc.nextLine();
			
			for(int k=0; k<regEx.size(); k++) 
			{
				if(Pattern.matches(regEx.get(k), a)) 
				{
					System.out.println("YES, "+ (k+1));
					break;
				}
				else 
				{
					if(k == regEx.size()-1)
						System.out.println("NO, " + '0');
				}
			}
		}
	}
}