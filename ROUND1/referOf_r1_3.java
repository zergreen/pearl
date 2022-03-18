import java.util.*;
import java.io.*;

public class hard {

    static int fuel = 25;
    static int jump = 10;

    static ArrayList<Integer> list = new ArrayList<Integer>();
    static ArrayList<Integer> refer = new ArrayList<Integer>();
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int totalPath = 3;
        

        int point[][] = new int [totalPath][99];

        int totalPoint[] = { 3, 3, 4};
        // int totalPoint = new int[totalPath];
        int sum[] = new int[totalPath];

        point[0][0] = 6;
        point[0][1] = 8;
        point[0][2] = 9;
 
        point[1][0] = 7;
        point[1][1] = 8;
        point[1][2] = 5;

        point[2][0] = 1;
        point[2][1] = 1;
        point[2][2] = 1;
        point[2][3] = 1;

        for(int i=0; i<point.length; i++){
            for(int j=0 ; j<point[i].length; j++){
                sum[i] += point[i][j];
            }
        }

        for(int i=0; i<sum.length; i++){
            System.out.println(sum[i]);
        }

        
        int num[] = { 3, 3, 4};
        int count = 0;
        int min = num[0];
        
        //find min value
        for(int i=0; i<num.length; i++){
            if(num[i] < min){
                min = num[i];
            }
        }

        //count that min value
        for(int i=0; i<num.length; i++){
            if(min == num[i]){ 
                count++;
            }
        }

        System.out.printf("min = %d, count = %d\n", min,count);

        int index = 0;


        for(int i=0; i<num.length; i++){
            // System.out.printf("num[%d] = %d \n", i, num[i]);
            if(num[i] == 3){
                index = i;
                System.out.println("NUMBER = " + num[i]);
                System.out.println("INDEX = " + index);
                cal(point,index);
            }

        }

        // System.out.println(Arrays.toString(point[0][99]));
        // for(int i=0;i == 0;i++){
        //     for(int j=0;j<point[i].length;j++){
        //         System.out.println(point[i][j]);
        //     }

        // }

        // while(!list.isEmpty()){
        //     System.out.println(list.get(0));
        //     list.remove(0);
        // }

        int size = list.size();

        int compare[] = new int[size];

        int keepIndex[] = new int[size];

        // while()
        for(int i=0; i < size ; i++){
            compare[i] = list.get(i);
            keepIndex[i] = refer.get(i);
        }

        System.out.println(Arrays.toString(compare));

        min = compare[0];
        index = 0;

        for(int i = 0 ; i < size ; i++){
            if(compare[i] < min){
                min = compare[i];
                index = keepIndex[i];
            }
        }

        System.out.println("MIN = " + min);
        System.out.println("INDEX = " + (index+1));


        
        


    }
    static void cal(int arr[][], int index){
        // arr[index][i]
        // Queue q = new Queue();
        
        int sum = 0;
        int len = arr[index].length;
        for(int i=0; i<len;i++){
            // System.out.println(arr[index][i]);
            if(arr[index][i] <= jump && sum <= fuel){                
                sum += arr[index][i];
            }else {
                System.out.println("VALUE MORE THAN " + jump + " or SUM more than fule \nSYSTEM EXIT");
                return;
            }
            

        }



        System.out.println("SUM = " + sum);
        System.out.println("INDEX " + index);

        list.add(sum);
        refer.add(index);

        
    }
}