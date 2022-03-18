import java.util.*;

public class r1_3 {

    static int fuel;
    static int jump;

    static ArrayList<Integer> list = new ArrayList<Integer>();
    static ArrayList<Integer> refer = new ArrayList<Integer>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // fuel = 23;
        fuel = sc.nextInt();
        // jump = 10;
        jump = sc.nextInt();
        // int totalPath = 4;
        int totalPath = sc.nextInt();

        ArrayList<Integer> point[] = new ArrayList [totalPath];

        for(int i=0; i < point.length; i++){
            point[i] = new ArrayList<Integer>();
        }

        // int num[] = { 3, 3, 4, 2};

        // point[0].add(6);
        // point[0].add(8);
        // point[0].add(9);

        // point[1].add(7);
        // point[1].add(8);
        // point[1].add(5);
        
        // point[2].add(1);
        // point[2].add(1);
        // point[2].add(1);
        // point[2].add(1);

        // point[3].add(5);
        // point[3].add(4);

        


        int num[] = new int[totalPath];

        for(int i=0; i < point.length; i++){
            num[i] = sc.nextInt();
            for(int j=0; j < num[i]; j++){
                point[i].add(sc.nextInt());
            }
        }


    

        // for(int i=0; i < totalPath; i++){
        //     System.out.println(point[i]);
        // }

        int count = 0;
        int min = num[0];

        for(int i = 0; i < num.length; i++){
            if(num[i] < min){
                min = num[i];
            }
        }

        for(int i = 0; i < num.length; i++){
            if(num[i] == min){
                count++;
            }
        }

        // System.out.printf("min = %d, count = %d\n", min,count);

        // // System.out.println("OK");
        // System.out.println(Arrays.toString(num));


        int index = 0;
        for(int i = 0; i < num.length; i++){
            if(num[i] == min){
                
                index = i;
                // System.out.printf("NUM[%d] = ", i, num[i]);                
                // System.out.println("INDEX " + index);
                cal(point, index);
            }
        }

        int size = list.size();

        int compare[] = new int[size];

        int keepIndex[] = new int[size];

        // while()
        for(int i=0; i < size ; i++){
            compare[i] = list.get(i);
            keepIndex[i] = refer.get(i);
        }

        // System.out.println(Arrays.toString(compare));

        min = compare[0];
        index = 0;

        for(int i = 0 ; i < size ; i++){
            if(compare[i] <= min){
                min = compare[i];
                index = keepIndex[i];
            }
        }

        // System.out.println("MIN = " + min);
        // System.out.println("INDEX = " + index);
        System.out.print((index+1));




    }

    static void cal(ArrayList myList[], int index){
        // myList[index][i]
        // Queue q = new Queue();

        // System.out.println("main");

        
        int sum = 0;
        int len = myList[index].size();
        // System.out.printf("len = %d\n", len);
        for(int i=0; i<len;i++){
            // System.out.println(myList[index][i]);
            int temp = (int)myList[index].get(i);
            // System.out.printf("temp = %d, i = %d\n", temp,i);

            if(temp <= jump && sum <= fuel){                
                sum += temp;
            }else {
                // System.out.println("VALUE MORE THAN " + jump + " or SUM more than fule \nSYSTEM EXIT");
                return;
            }
            

        }

        // System.out.println("SUM = " + sum);
        // System.out.println("INDEX " + index);

        list.add(sum);
        refer.add(index);
        
    }
}
