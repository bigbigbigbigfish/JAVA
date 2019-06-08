import java.util.Stack;


public class LangNumber {
    public static void main(String[] args) {
        String str = "sewaewa1232515";
        System.out.println(getMaxNum(str));
//        Scanner sc = new Scanner(System.in);
//        String string = sc.nextLine();
//        System.out.println(string);
    }
//    import java.util.Scanner;
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            String str = sc.nextInt();
//        }
//    }
    public static StringBuffer getMaxNum(String str) {
        int maxLength = 0;
        StringBuffer maxNumBuffer = null;
        int nowLength = 0;
        StringBuffer nowNumBuffer = null;
        for(int i =0;i<str.length();i++) {
            if(str.charAt(i)>=48 &&str.charAt(i)<=57) {
                if(nowLength ==0) {
                    nowNumBuffer = new StringBuffer(String.valueOf(str.charAt(i)));
                    nowLength++;
                } else {
                    nowNumBuffer.append(str.charAt(i));
                    nowLength++;
                    if(nowLength>=maxLength) {
                        maxLength = nowLength;
                        maxNumBuffer = nowNumBuffer;
                    }
                }
            } else {
                nowLength = 0;
                nowNumBuffer =null;
            }
        }
        return maxNumBuffer;


    }




    public boolean chkParenthesis(String A, int n) {
        if (A.length() !=n &&A.length() ==0) return false;
        Stack<Character> stack = new Stack<Character>();
        for(int i =0 ;i< A.length(); i++) {
            char c = A.charAt(i);
            if(c =='(' ) {
                stack.push(c);
            } else {
                if( c==')') {
                    if(stack.isEmpty()) {
                        return false;
                    }
                    char top = stack.pop();
                    if(top =='(') {
                        stack.pop();
                    }
                }
            }
        }
        return stack.isEmpty();
    }










}
