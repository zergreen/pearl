import java.util.Scanner;
import java.util.Arrays;
public class r1_4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        // int size = 5;
        // String name[] = { "John", "Clara", "Sepia", "Ruby", "Ben"};
        // int score[] = { 30, 50, 90, 120, 72}; 

        int size = sc.nextInt();
        
        String winner[] = new String[size];        
        String name[] = new String[size];
        int score[] = new int[size];

        for(int i = 0; i < size; i++){
            name[i] = sc.next();
            score[i] = sc.nextInt();
        }
                
        key(name, score, winner);
    }

    public static void key(String[] name, int score[], String winner[]){
        // int key = -1;
        // key = 0;
        // System.out.printf("name: %s | score: %d\n", name[key], score[key]);

        // Print Arrays of score and name
        // System.out.println("Name: " + Arrays.toString(name));
        // System.out.println("Score: " + Arrays.toString(score));

        int temp[] = score;
        // System.out.println(Arrays.toString(temp));

        int max = -1;
        int index = -1;

        // ทำซ้ำไปสามรอบ เพราะเราหา 3 อันดับแรก
        for(int j = 0; j < 3; j++){
            
            //ex. หาค่าสูงสุด แล้ว เอาค่าที่ได้ไปใส่ไว้ ใน max กับ index
            for(int i=0; i < temp.length; i++){

                if(max < temp[i]){
                    max = temp[i];
                    // System.out.println(max);
                    index = i;                
                }
            }
            // System.out.println("j round : " + j);

            temp[index] = 0; //ex. เปลี่ยนค่า temp[4] = 0; //

            winner[j] = name[index];
            // System.out.println(winner[j]);
            
            max = -1; //ex. คืนค่า max กลับเป็นค่าเริ่มต้น -> 120 => 0
        }

        for(int i = 0; i < 3; i++){
            System.out.println(winner[i]);
        }

    }


}
