import java.util.*;
import java.util.regex.Pattern;

public class q1 {
private static Pattern pattern= Pattern.compile("-?\\d+(\\.\\d+)?");
public static boolean isNumeric (String strNum){
    if(strNum==null){
        return false;
    }
    return pattern.matcher(strNum).matches();
    }
    public static boolean isOperator(String opt){
        if(opt.equals("/") || opt.equals("-") || opt.equals("+") || opt.equals("*")){
        return true;
        }
    return false;
    }
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String data = sc.nextLine();
    System.out.println(portfix(data));
    }


    public static String portfix(String expression){
    StringTokenizer st = new StringTokenizer(expression);
    Queue <String> queue =new LinkedList<String>();
    Stack <String> stack = new Stack<String>();
    while(st.hasMoreTokens()){
        queue.add(st.nextToken());
    }
    String operatorC = " ";
    while(!queue.isEmpty()){
        String t = queue.poll();
        

        if(isNumeric(t)){
            if(operatorC .equals(" ")){
                // if(stack.isEmpty())
                    stack.push("" + t);
                // else{
                //     String a =stack.pop();
                    
                // }
            }
                
            else {
                String a = stack.pop();
                //System.out.println(a);
                stack.push("("+ a + ")");
                stack.push(""+t);
                operatorC =" ";
            }
        }
        
        else if(isOperator(t)){
                if(operatorC.equals(" ")){
                    String b = stack.pop();
                    String a = stack.pop();
                    stack.push(""+a+t+b+"");
                    operatorC = t;
                    //System.out.println(operatorC);
                }
                else{
                   
                    if(t .equals("+")||t .equals("-")){
                        String b = stack.pop();
                        String a = stack.pop();
                        
                        if(operatorC == "*" || operatorC == "/"){
                            stack.push("("+a+t+b+")");
                            operatorC = t;
                        }
                        else{
                            stack.push(""+a+t+b+"");
                            operatorC = t;
                        }
                    }
                    else if(t .equals("*")||t .equals("/")){
                        String b = stack.pop();
                        String a = stack.pop();
                       // System.out.println("2"+a+"  "+ b);
                         if(operatorC == "+"|| operatorC =="-"){
                            
                            stack.push(""+a+t+b+"");
                            operatorC = t;
                        }
                        else{
                            stack.push(""+a+t+"("+b+")");
                            operatorC = t;
                        }
                    }
                }
// if(stack.isEmpty()&&queue.isEmpty()){
// stack.push("" + a + t + b + "");
// }
// else
// stack.push("(" + a + t + b + ")");
            }
           
        }
        return stack.pop();
    }

}

