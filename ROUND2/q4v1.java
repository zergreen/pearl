import java.util.Scanner;

public class q4v1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String out = "";
        String in = "2345678.0";
        // String in = sc.nextLine();

        String[] digit = {"ศูนย์","หนึ่ง","สอง","สาม","สี่","ห้า","หก","เจ็ด","แปด","เก้า"};
        String[] lev = {"", "สิบ","ร้อย","พัน","หมื่น","แสน","ล้าน"};
        String[] symbol = {"เอ็ด","ยี่"};

        // boolean check = true;
        int point = in.indexOf('.');
        boolean check = (point == -1) ? false : true;
        // print(check); 
        println("point : " + point);

        // int lenofin = in.length();
        // boolean movetopoint = (point == in.length()-1) ? false : true;
        // println(movetopoint);

        if(check)
        {
            { //cut 0 from left side text

                String r = in.substring(point);
                int count=1;
                int lenofr=r.length();
    
                while(true){
                    char ch = r.charAt(lenofr-count);
                    if(ch != '0') break;            
                    count++; 
                }
                
                r=r.substring(0, lenofr - (count-1));
    
                String temp=in.substring(0,point);
                in = temp + r;          
            }
        }
        int memo = 0;

        for(int i=0;i<in.length();i++){
            char ch = in.charAt(i);
            if(ch=='.' ){
                out += "จุด";
                continue;
            }      

            int num = Character.getNumericValue(ch);
            out += digit[num];

            if(i < point) out += lev[point-(i+1)];
        }

        println(out); //output answer
    }

    public static void println(Object line) {
        System.out.println(line);
    }

    public static void print(Object line) {
        System.out.print(line);
    }
}
