import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class q3o1 {
    public static void main(String[] args){
        // System.out.println("helloWorld");

        // int[] x,y;

        // int myInts[] = new int[args.length];

        // for (int i = 0; i < args.length; i++)
        //     myInts[i] = Integer.parseInt(args[i]);

        // // for (int i = 0; i < args.length; i++){
        // //     println(myInts[i]);
        // // }
        
        // int[] x = {myInts[0], myInts[1], myInts[2]}, y = {myInts[3], myInts[4], myInts[5]};
        // int sum=0;
        // sum = Math.abs(x[0] - y[0]) + Math.abs(x[1] - y[1]) + Math.abs(x[2] - y[2]);
        // println(sum);

        addZero();

        System.exit(0);

    }

    public static void println(Object line) {
        System.out.println(line);
    }

    public static void print(Object line) {
        System.out.print(line);
    }

    public static void addZero(){
        int bi1 = 1;
        int bi2 = 10;
        int bi3 = 32;

        String s1,s2,s3;
        s1 = Integer.toBinaryString(bi1);
        s2 = Integer.toBinaryString(bi2);
        s3 = Integer.toBinaryString(bi3);
        println(s1);
        println(s2);

        int len1 = s1.length();
        int len2 = s2.length();
        println("s1 : " + len1 + " and s2 : " + len2);
        int maxLen = Math.max(len1, len2);
        println(maxLen);


        int flen1;
        flen1 = maxLen - len1;
        println(flen1);

        String zero = "";

        for(int i=0;i<flen1;i++){
            zero += "0";
        }
        System.out.println(zero);

        s1 = zero + s1;

        System.out.println(s1);

        // phase 2 change to array

        // System.out.println(s1.charAt(0));

        // char ch[] = s1.toCharArray();
        // println(Arrays.toString(ch));

        int []bix = new int[s1.length()];
        int []biy = new int[s1.length()];
        // int []biz = new int[s1.length()];
        int []biz = {0,0,0,0,0,1};
        int []bia = {0,0,1,0,1,0};
        int []bib = {1,0,0,0,0,0};
        int []bic = {0,0,0,1,0,1};

        for(int i = 0 ; i < s1.length() ; i++){
            bix[i] = Character.getNumericValue(s1.charAt(i)); // convert String[i] to int[i] : "1" => 1
            biy[i] = Character.getNumericValue(s2.charAt(i)); // convert String[i] to int[i] : "1" => 1
            // biz[i] = Character.getNumericValue(s3.charAt(i)); // convert String[i] to int[i] : "1" => 1
        }

        println(Arrays.toString(bix));
        println(Arrays.toString(biy));
        println(Arrays.toString(biz));

        // int dsum = d(bix,bix) + d(bix, biy) + d(bix, biz) +
        //         d(biy, bix) + d(biy , biy) + d(biy, biz) +
        //         d(biz, bix) + d(biz , biy) + d(biz , biz);

        // int dsum = d(a, a) + d(a, b) + d(a, c) +
        //            d(b, a) + d(b, b) + d(b, c) +
        //            d(c, a) + d(c, b) + d(c, c) ;

        // int dsum = d(1, 1) + d(1, 2) + d(1, 3) +
        //            d(2, 1) + d(2, 2) + d(2, 3) +
        //            d(3, 1) + d(3, 2) + d(3, 3) ;

        // int dsum(a, b, c);

        // List<Integer> list = new List<Integer>();
        // Queue q = new Queue();

        ArrayList<int[]> list = new ArrayList<int[]>();
        // list.add(bix);
        // list.add(biy);
        list.add(biz);
        list.add(bia);
        list.add(bib);
        list.add(bic);

        findDistance(list);




                    

        // sum = Math.abs(x[0] - y[0]) + Math.abs(x[1] - y[1]) + Math.abs(x[2] - y[2]);

        // distance(bix,biy)
    }

    public static void findDistance(ArrayList<int[]> list) {
        println("In method findDistance \n  " + Arrays.toString(list.get(0)));
        int len = list.size();
        int sum=0;

        // if(len == 1) {
        //     int lenn = list.get(0).length;
        //     println(lenn);
        //     for(int i=0; i<lenn; i++){
        //         int[] a = list.get(0);
        //         println(Arrays.toString(a));
        //         int[] b = list.get(0);
        //         println(Arrays.toString(b));
        //         sum += Math.abs(a[i] - b[i]);
        //         println(i + " : "+ sum);
        //     }

        //     println("Distance is " + sum);
        //     System.exit(0);
        // }
        
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                sum += d(list.get(i),list.get(j));
                println(sum);
            }
        }

        println("Distance is " + sum);
    }

    public static int d(int[] a, int[] b){
        int sum = 0;
        int len = a.length;
        for(int i=0; i<len; i++){
            sum += Math.abs(a[i] - b[i]);
            // println(i + " : "+ sum);
        }
        return sum;
    }
}