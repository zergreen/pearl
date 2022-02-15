import java.util.Scanner;

public class first {
    public static void main(String[] args){
        int input;
        input = 5;
        String code = "XNFHDOG";
        int ascii;

        System.out.println(code);

        int len = code.length();
        char[] ch = new char[len];
        for(int i = 0; i < len; i++){
            ch[i] = code.charAt(i);
            ascii = (int)ch[i] + input;
            if(ascii > 90) ascii -= 26;
            ch[i] = (char)ascii;
            // ch[i] = ch[i] + (char)input; 
        }
        String output = new String(ch);
        System.out.println(output+" : from output");
        System.out.println(ch);
    }
}
