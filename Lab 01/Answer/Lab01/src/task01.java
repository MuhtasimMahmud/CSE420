import java.io.File;

import java.util.*;
import java.util.regex.*;  

public class task01 
{
	public static void main(String [] args) throws Exception
	{
		File file = new File("inputs.txt");
		Scanner sc = new Scanner(file);
		
		List<String> keywords = Arrays.asList("int", "float", "double", "String", "if", "else", "for", "public", "return", "static", "super", "abstract", 
				"break", "this", "throw", "try","void", "boolean", "byte", "case", "catch", "char", "class", "continue", "default", "do", "extends", "final", 
				"finally","implements", "import", "instanceof", "interface","long", "native", "new", "package", "private", "protected", "short",  "switch", 
				"synchronized", "throws", "transient",  "volatile", "while", "false", "true", "null");
		
		List<String> math_operators = Arrays.asList("+", "-", "*", "/", "=", "^");
		List<String> logical_operators = Arrays.asList("<", ">", "||", "&&", "!=");

		
		
		List<String> keywords_set = new ArrayList<String>();
		List<String> identifiers_set = new ArrayList<String>();
		List<String> math_set = new ArrayList<String>();
		List<String> logical_set = new ArrayList<String>();
		List<String> numerical_set = new ArrayList<String>();
		List<String> others_set = new ArrayList<String>();
		
		
		while(sc.hasNextLine()) 
		{
			String s = sc.nextLine();
			String[] arr = s.split(" ", s.length() );
			
			for(String a : arr) 
			{
				if(keywords.contains(a)) 
				{
					if(!keywords_set.contains(a))
						keywords_set.add(a);
				}
				else if(math_operators.contains(a)) 
				{ 
					if(!math_set.contains(a))
						math_set.add(a);
				}
					
				else if(logical_operators.contains(a))
				{
					if(!logical_set.contains(a))
						logical_set.add(a);
				}
				else if(Pattern.matches("[0-9]+(.[0-9]+)?", a))
				{
					if(!numerical_set.contains(a))
						numerical_set.add(a);
				}
				else if(Pattern.matches("[a-zA-Z]+", a))
				{
					if(!identifiers_set.contains(a))
						identifiers_set.add(a);
				}
				else 
				{
					if(!others_set.contains(a))
						others_set.add(a);
				}
			}
		}
		
		System.out.print("Keywords : ");
		for(int i=0; i<keywords_set.size(); i++) 
		{
			System.out.print(keywords_set.get(i));
			if(i < keywords_set.size()-1)
				System.out.print(", ");
		}
		
		System.out.println();
		
		System.out.print("Identifier : ");
		for(int i=0; i<identifiers_set.size(); i++) 
		{
			System.out.print(identifiers_set.get(i));
			if(i < identifiers_set.size()-1)
				System.out.print(", ");
		}
		
		System.out.println();
		
		System.out.print("Math operators : ");
		for(int i=0; i<math_set.size(); i++) 
		{
			System.out.print(math_set.get(i));
			if(i < math_set.size()-1)
				System.out.print(", ");
		}
		
		System.out.println();
		
		System.out.print("logical operators : ");
		for(int i=0; i<logical_set.size(); i++) 
		{
			System.out.print(logical_set.get(i));
			if(i < logical_set.size()-1)
				System.out.print(", ");
		}
		
		System.out.println();
		
		System.out.print("Numerical values : ");
		for(int i=0; i<numerical_set.size(); i++) 
		{
			System.out.print(numerical_set.get(i));
			if(i < numerical_set.size()-1)
				System.out.print(", ");
		}
		
		System.out.println();
		
		System.out.print("Others : ");
		for(String a : others_set) 
		{
			System.out.print(a + "  ");
		}
		
	}
}