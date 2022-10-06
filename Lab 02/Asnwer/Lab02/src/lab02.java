import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class lab02 
{
   public static void main(String[] args) throws FileNotFoundException 
   {
	   File file = new File("inputs.txt");
	   Scanner input = new Scanner(file);
      
      int num=input.nextInt();
      input.nextLine();
      
      int line=1;
      
      while(input.hasNext())
      {
         String s = input.nextLine().trim();

         if(email(s))
         {
            System.out.print("Email, "+line);
         }
         else if(web(s))
         {
            System.out.print("Web, " +line);
         }
         else if(!web(s) && !email(s))
         {
            System.out.print("Invalid address for email or web , "+line);
         }
         
         line++;
         System.out.println();
      }    
   }
   
   public static boolean email(String s)
   {
      int state=0;
      boolean email=false;
      
      int i=0;
      
		/*
		 * some example of email addresses: 
		 * Rizwan24@gmail.com 
		 * mahmud.mzs16@gmail.com
		 * muhtasim.mahmud@g.bracu.ac.bd
		 * abir@yahoo.com
		 */
      
      while(i<s.length())
      {
         switch(state)
         {
            case 0: 
            	if( Character.isLetter(s.charAt(i)) ) 
	               state=1;
	            else
	               state = 6;
            	
	            i++; 
	            break;
	            
            case 1: 
            	if( Character.isLetter(s.charAt(i)) || s.charAt(i) == '.' || Character.isDigit(s.charAt(i))) 
            		state=1;
            	else if(s.charAt(i)=='@')
            		state=2;
            	else
            		state = 6;
            	
            	i++;
            	break;
            	
            case 2: 
            	if( Character.isLetter(s.charAt(i))) 
            		state=2;
            	else if(s.charAt(i)=='.')
            		state=3;
            	else
            		state = 6;
            	
            	i++; 
            	break; 

            case 3:
            	if(Character.isLetter(s.charAt(i))) 
            	{
            		state = 3;
            		if(i == s.length()-1)
            			email = true;
            	}
            	else if(s.charAt(i) == '.')
            		state = 4;
            	else
            		state = 6;
            	
            	i++; 
            	break; 
            
            case 4:
            	if(Character.isLetter(s.charAt(i)))
            		state = 4;
            	else if(s.charAt(i) == '.')
            		state = 5;
            	else
            		state = 6;
            	
            	i++;
            	break;
            
            case 5:
            	if(Character.isLetter(s.charAt(i))) 
            	{
            		state = 5;
            		if(i == s.length()-1)
            			email = true;
            	}
            	else
            		state = 6;
            	
            	i++;
            	break;
            	
            case 6: 
            		if(Character.isLetter(s.charAt(i)) || Character.isDigit(s.charAt(i)) )
            			state = 6;
            		
            		i++;
            		break;
         }
      }
      return email;
   }
   
   
   public static boolean web(String s)
   {
      int state=0;
      boolean website=false;
      
      int i=0;
      
		/*
		 * some example of web addresses: 
		 * http://www.abc.com 
		 * https://www.bbc.com
		 * www.aaa.com 
		 * www.ddd.org
		 */
      
      while(i<s.length())
      {
         switch(state)
         {
         	case 0:
         		if(Character.isLetter(s.charAt(i)))
         			state = 0;
         		else if(i > 0 && s.charAt(i) == ':')
         			state = 1;
         		else if(i > 0 && s.charAt(i) == '.')
         			state = 3;
         		else
         			state = 5;
         		
         		i++;
         		break;
         		
         	case 1:
         		if(s.charAt(i) == '/') 
         		{
         			i++;
         			if(s.charAt(i) == '/')
         				state = 2;
         			else
         				state = 5;
         		}
         		else
         			state = 5;
         		
         		i++;
         		break;
         			
         		
         	case 2:
         		if(Character.isLetter(s.charAt(i)))
         			state = 2;
         		else if(s.charAt(i) == '.')
         			state = 3;
         		else
         			state = 5;
         		
         		i++;
         		break;
         	
         	case 3:
         		if(Character.isLetter(s.charAt(i)) || Character.isDigit(s.charAt(i)))
         			state = 3;
         		else if(s.charAt(i) == '.')
         			state = 4;
         		else 
         			state = 5;
         		
         		i++;
         		break;
         		
         	case 4:
         		if(Character.isLetter(s.charAt(i))) 
         		{
         			state = 4;
         			if(i == s.length()-1)
         				website = true;
         		} 
         			
         		else
         			state = 5;
         		
         		i++;
         		break;
         		
         	case 5:
         		if(Character.isLetter(s.charAt(i)) || Character.isDigit(s.charAt(i)))
         			state = 5;
         		i++;
         		break;
         }
      }
      
      return website;
   }
   
}
