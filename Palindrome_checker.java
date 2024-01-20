import java.util.Scanner;

public class Palindrome_checker
{
   public static void main(String args[])
   {
      String str, rev = "";
      Scanner sc = new Scanner(System.in);
 
      System.out.println("Enter a string:");
      str = sc.nextLine();
 
      int length = str.length();
 
      for ( int i = length - 1; i >= 0; i-- )
         rev = rev + str.charAt(i);
 
      if (str.equals(rev))
         System.out.println("Ther string "+str+" is a palindrome");
      else
         System.out.println("The string "+str+" is not a palindrome");
 
   }
}