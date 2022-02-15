import java.util.Scanner;
import java.util.Arrays;
public class four 
{
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        /* manual input */
        // int[][] arr = new int[10][2];
        // for(int i=0;i<10;i++){
        //         System.out.printf("Enter (%d) [x : y] : ",i);
        //         arr[i][0] = sc.nextInt();
        //         arr[i][1] = sc.nextInt();
        // }
        
        int arr[][] = { {500, 60}, {699,71}, {1000, 100}, {239, 65}, {777, 70}, 
                        {666, 88}, {789, 90}, {800, 113}, {190, 95}, {650, 62} };
                        
        /* calculate wpm */
        // System.out.println(calWpm(777,70));
        int[] wpm = new int [10];
        for(int i=0 ;i<10;i++){
            wpm[i] = calWpm(arr[i][0],arr[i][1]);
        }
        
        // System.out.println(Arrays.toString(wpm));
        
        int max = findMax(wpm);
        
        System.out.printf("%d %d\n%d",arr[max][0],arr[max][1],wpm[max]);
    }
    
    public static int findMax(int[] arr){
        int index = 0, max = 0 ;
        for(int i=0;i<arr.length;i++){
            if(max < arr[i]){
                max = arr[i];
                index = i;
            }
        }
        // System.out.printf("max = %d , index = %d\n", max,index);
        return index;
    }
    
    public static int calWpm(double x, double y){
        double wpm = 0;
        wpm = ((x/5) / (y/60));
        // System.out.println("WPM : "+wpm);
        return (int)wpm;
    }
}

