import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        // 6 2 5 = 12
        // 1 10 32 5 = 32         

        int maxNum = 0;
        int maxIn = 0;

        String input[] = new String[N];

        for(int i=0;i<N;i++) {
            int num = sc.nextInt();
            input[i] = Integer.toBinaryString(num);
            // println("your input i : " + input[i]);

            maxIn = (num > maxNum) ? i : maxIn;
            maxNum = (num > maxNum) ? num : maxNum;
            // println("Max number : " + maxNum);
            // println("Max Index : " + maxIn);
        }

        int lSt = input[maxIn].length();

        for(int i=0; i<input.length; i++) {
            String zero = "";
            int zlen = 0;
            int len = input[i].length();
            zlen = lSt - len;

            for(int j=0; j<zlen; j++){
                zero += "0";
            }

            input[i] = zero + input[i];
            // println(input[i]);            
        }

        ArrayList<int[]> list = new ArrayList<int[]>();

        for(int i=0; i<input.length;i++){
            int bi[] = new int[lSt];

            for(int j=0; j<input[i].length(); j++) {
                bi[j] = Character.getNumericValue(input[i].charAt(j));

            }

            // println(Arrays.toString(bi));

            list.add(bi);
        }

        findDistance(list);

        System.exit(0);
    }

    public static void findDistance(ArrayList<int[]> list) {
        // println("In method findDistance \n  " + Arrays.toString(list.get(0)));
        int len = list.size();
        int sum=0;
        
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                sum += d(list.get(i),list.get(j));
                // println(sum);
            }
        }

        // println("Distance is " + sum);
        println(sum);
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

    public static void println(Object line) {
        System.out.println(line);
    }

    public static void print(Object line) {
        System.out.print(line);
    }
}