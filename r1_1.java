import java.util.Scanner;
class r1_1 {
    public static void main(String[] args) {
        // int x = 4, y = 1;
        int sh = 0, ln = 0, sum = 0;
        String text = "\ntsuki atte kudasai!";

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        int output[] = new int[3];
        int gcd = GCD(x,y);

        System.out.printf("INPUT : %d %d\n",x,y);
        System.out.println("GCD : "+gcd);

        if(gcd == 1){

            sh = y ;
            ln = x ;
            sum = x * y;

            output[0] = sh;
            output[1] = ln;
            output[2] = sum;

        }else if(gcd == x || gcd == y){
            if(gcd == x){
                sh = x;
                ln = 1;
            }
            if(gcd == y){
                sh = 1;
                ln = y;
            }           

            sum = Math.max(x,y);        

            output[0] = sh;
            output[1] = ln;
            output[2] = sum;
        }else {
            sh = y ;
            ln = x ;
            sum = x * y;

            output[0] = sh;
            output[1] = ln;
            output[2] = sum;
        }

        System.out.printf("%d %d %d %s",output[0],output[1],output[2],text);
    } 

    static int GCD(int x, int y)
    {
        if (y == 0)
            return x;
        return GCD(y, x % y);
    }
}