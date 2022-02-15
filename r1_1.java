import java.util.Scanner;

public class r1_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        
        /*  Describe variable
        *   sh := short
        *   ln := long
        *   ch := chosen
        *   gcd := greater than common divide
        */

        String text = "\ntsuki atte kudasai!";
        // int x = 10, y = 15; // if you Lazy input use this
        int x_sh = 0, y_ln = 0;
        long sum = 0;
        int ch_x = 0, ch_y = 0;

        int gcd = GCD(x,y);

        x_sh = x / gcd;
        y_ln = y / gcd;
        
        // System.out.println("GCD : " + gcd);
        // System.out.println("x / gcd = " + x_sh);
        // System.out.println("y / gcd = " + y_ln);

        ch_x = y_ln;
        ch_y = x_sh;

        sum = (long)gcd * (long)x_sh * (long)y_ln;

        // System.out.println("Short : " + ch_x);
        // System.out.println("Long : " + ch_y);
        // System.out.println("sum = " + sum);

        // System.out.println(text);

        System.out.printf("%d %d %d%s", ch_x, ch_y, sum, text);
    }

    static int GCD(int x, int y)
    {
        if (y == 0)
            return x;
        return GCD(y, x % y);
    }
    
}

