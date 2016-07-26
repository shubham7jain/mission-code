/*
Given an absolute path for a file (Unix-style), simplify it.

Examples:

path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
Note that absolute path always begin with ‘/’ ( root directory )
Path will not have whitespace characters.
*/
public class Solution {
	public String simplifyPath(String a) {
	    Stack<String> stack = new Stack<>();
	    String[] splits = a.split("\\/");
	    String result = "";
	    for(String split : splits) {
	        if (split.equals("")) {
	            
            }
	    	else if(split.equals(".")) {
	            
	        } else if(split.equals("..")) {
	            if(!stack.isEmpty())
	            stack.pop();
	        } else {
	            stack.push(split);
	        }
	    }
	    StringBuilder sb = new StringBuilder();
	    while(!stack.isEmpty()) {
	        sb.insert(0, "/" + stack.pop());
	    }
	    if(sb.length()==0)
	        return "/";
	    return sb.toString();
	}
}
