import java.util.Scanner;

public class two {
    public static void main(String[] args){
        System.out.println("Hello World");

        double input = 3.005;
        double mod ;
        double money = 0;
        mod = 3.005 * 1000;
        double m = mod % 1000;
        System.out.println(m);
        int x = (int)mod;
        System.out.println(x);

        if(x < 1000 || x > 1000){
            money += 500;
            x -= 1000;
        }
        if(x < 1000 || x > 1000){
            if(x%1000==0) money += m * 1;
            
        }
        



    }
}