/*
Write a program to validate if the input string has redundant braces?
Return 0/1 
 0 -> NO 1 -> YES 

Input will be always a valid expression

and operators allowed are only + , * , - , /

Example:

((a+b)) has redundant braces so answer will be 1
(a + (a + b)) doesn't have have any redundant braces so answer will be 0

*/
public class Solution {
	public int braces(String a) {
	    Stack<Character> stack = new Stack<>(); 
	    for(int i=0;i<a.length();i++) {
	        if(a.charAt(i) == ')') {
	            boolean isSymbolPresent = false;
	            while(!stack.isEmpty() && stack.peek()!='(') {
	                char poppedElement = stack.pop();
	                if(poppedElement == '+' || poppedElement == '*' || poppedElement =='-' || poppedElement == '/') {
	                    isSymbolPresent = true;
	                }
	            }
	            if(!isSymbolPresent) {
	                return 1;
	            }
	            if(stack.peek() == '(') {
	                stack.pop();
	            }
	        } else {
	            stack.push(a.charAt(i));
	        }
	    }
	    
	    return 0;
	}
}
