import java.util.Scanner;

class q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String in = "9876543.24680000";
        String out = "";
        // String in = sc.nextLine();

        String[] digit = {"ศูนย์","หนึ่ง","สอง","สาม","สี่","ห้า","หก","เจ็ด","แปด","เก้า"};
        String[] lev = {"", "สิบ","ร้อย","พัน","หมื่น","แสน","ล้าน"};
        String[] symbol = {"เอ็ด","ยี่"};

        // String output = "";        

        // if(in.charAt(n)=='1'){
        //     output += format[1];
        // }

        // println(output);
        String l ="9876543"; // left
        String r ="2468"; // right

        String lout ="";
        String rout ="";

        int llen = l.length();
        int rlen = r.length();

        int point = in.indexOf('.');
        println("point : " + point);


        { //cut 0 from left side text
           
            // println(r);
            
            r = in.substring(point); // becareful
            int count=1;
            int lenofr=r.length();

            // println(l);

            while(true){
                // char ch;
                char ch = r.charAt(lenofr-count);
                // println(ch);
                if(ch != '0') break;            
                count++; 
            }

            // println("count : " + count); //5
            
            r=r.substring(0, lenofr - (count-1));
            //l before : 01000090000
            // println(r);
            //l after : 0100009

            // println(in.substring(0,8));

            String temp=in.substring(0,point); // becareful
            // println("temp : "+temp);
            // // l=l.substring(7);
            in = temp + r;
            // println(in);
            
            
        }

        for(int i=0;i<in.length();i++){
            char ch = in.charAt(i);
            // print(ch+"");

            if(ch=='.'){
                out += "จุด";
                continue;
            }

            int num = Character.getNumericValue(ch);
            out += digit[num];

            if(i<7){
                out += lev[llen-(i+1)];
            }

            // println(out);
        }

        println(out);

        // for(int i=0;i<llen;i++){
        //     char ch;
        //     ch = l.charAt(i);
        //     print(ch+"");
        //     int num = Character.getNumericValue(ch);
        //     lout += digit[num];
        //     lout += lev[llen-(i+1)];
        //     println(lout);
        // }

        // println("-----");

        // for(int i=0;i<rlen;i++){
        //     char ch;
        //     ch = r.charAt(i);
        //     print(ch+" ");
        //     int num = Character.getNumericValue(ch);
        //     rout += digit[num];
        //     // out += lev[rlen-(i+1)];
        //     println(rout);
        // }

        // out = lout + "จุด" + rout;

        // println(out);

        

        println(in);
        r = "";
        l = "";
        int num = 0;
        point = 0;
        
        point = in.indexOf('.');
        println("point : " + point);
        
        l = in.substring(point+1);
        r = in.substring(0,point);

        println("right(123) : " + r);
        println("left(.0) : " + l);
        
        num = Integer.parseInt(r);
        println("change to number : " + num);

        String text;
        text = r + "." + l;
        println("concat : " + text);

        int numR;
        int numL;

        numL = Integer.parseInt(l);
        numR = Integer.parseInt(r);

        
        // { //cut 0 from left side text
        //     int count=1;
        //     int lenofl=l.length();

        //     // println(l);

        //     while(true){
        //         // char ch;
        //         char ch = l.charAt(lenofl-count);
        //         // println(ch);
        //         if(ch != '0') break;            
        //         count++; 
        //     }

        //     // println("count : " + count); //5
            
        //     l=l.substring(0, lenofl - (count-1));
        //     //l before : 01000090000
        //     // println(l);
        //     //l after : 0100009
        // }

        // double d = 123456789.1234567890;
        // println(d);
    }

    public static void println(Object line) {
        System.out.println(line);
    }

    public static void print(Object line) {
        System.out.print(line);
    }
}
