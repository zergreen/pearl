import java.util.*;

public class q2 {
    public static void main(String[] args) {

        // input();
        // String data[] = new String[10];
        // Scanner sc = new Scanner(System.in);
        // for(int i=0; i<10; i++){
        //     data[i] = sc.nextLine();
        // }

        String data[] = {
                "1 0 1 0 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 1",
                "0 1 0 1 0 1 0 0 0 1 0 0 0 0 0 0 0 0 1 0",
                "0 0 0 0 1 0 0 0 0 0 1 0 0 0 1 0 0 1 0 0",
                "0 0 0 0 0 1 0 0 0 0 0 0 0 1 0 1 0 0 0 0",
                "0 0 1 0 1 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0",
                "0 0 0 1 0 1 0 0 0 0 0 0 0 0 0 1 0 1 0 0",
                "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0",
                "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0",
                "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0",
                "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0"
        };

        // String data[] = {
        //         " 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 ",
        //         " 0 0 0 1 0 0 0 0 0 0 0 1 0 0 0 1 0 0 0 0 ",
        //         " 0 0 0 0 1 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 ",
        //         " 0 0 0 0 0 1 0 0 0 1 0 0 0 0 0 0 0 0 0 0 ",
        //         " 0 0 0 0 1 0 0 0 0 0 1 0 0 0 0 0 1 0 0 0 ",
        //         " 0 0 0 1 0 1 0 0 0 0 0 1 0 0 0 1 0 0 0 0 ",
        //         " 0 0 0 0 0 0 1 0 0 0 1 0 0 0 1 0 0 0 1 0 ",
        //         " 0 1 0 0 0 0 0 1 0 1 0 0 0 1 0 0 0 0 0 0 ",
        //         " 0 0 0 0 0 0 0 0 1 0 1 0 1 0 0 0 0 0 0 0 ",
        //         " 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 ",
        // };

        int line[][] = new int[10][20];

        for(int i=0; i<10; i++){
            for(int j=0; j < 20; j++){
                String cp = data[i];
                cp = cp.replaceAll("\\s", "");
                int num = Character.getNumericValue(cp.charAt(j));
                // println(num);
                line[i][j] = num;
            }
        }

        // println("ORIGINAL");
        // printArr(line);
        
        /***
         * !obj.bfs(row, column, arr2D[][], posX, posY, color)
         * row : number of row in arr2D
         * column : number of column in arr2D
         * posX : position X of | arr2D[posX][] | you want to fill color
         * posY : position Y of | arr2D[][posY] | want to fill color
         * color : color you like to fill
         */

        BFS obj = new BFS(line);

        for(int j=0;j<20;j++){ //begin line[0][j] ; j=20(column) ; เข้าลูปแถวแรกให้หมด
            if(line[0][j] == 1){
                obj.bfs(10, 20, 0, j, 9);
                // break;
            }
        }

        obj.output();

        // obj.bfs(10, 20, line, 0, 10, 9);

        // println("After insert color");
        // printArr(line);

        System.exit(0);

    }

    public static void printArr(int[][] arr) {
        int size = arr.length;
        int len = arr[0].length;
        print("size : " + size + " --- length : " + len + "\n");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < len; j++) {
                print(arr[i][j] + " ");
            }
            println("");
        }
    }

    public static void println(Object line) {
        System.out.println(line);
    }

    public static void print(Object line) {
        System.out.print(line);
    }
}

// Class to store the pairs
class Pair implements Comparable<Pair> {
    int posX;
    int posY;

    public Pair(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    @Override
    public int compareTo(Pair o) {
        return posY - o.posY;
    };
}

class BFS {
    int count=0; // ตัวแปรตรวจสอบว่า เข้าฟังก์ชั่น bfs ไปแล้วกี่รอบ
    
    // Visiting array 
    int vis[][] = new int[10][20]; 
    
    //data Array[][]
    int [][]data;

    BFS(int[][] data){ // contructor
        this.data = data;
    }
    
    public int validCoord(int x, int y, int n, int m) {
        if (x < 0 || y < 0) { // จมจอไหม ถ้าจม ค่ามันจะติดลบ
            // ในเรื่อง cg ตำแหน่งหน้าจอจะเริ่มที่ (x,y) : (0, 0)
            return 0;
        }
        if (x >= n || y >= m) { // n : row , m : column ของขนาด arr2D[m][n]
            return 0;
        }
        return 1;
    }

    public void output(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                if(vis[i][j] == 0 && data[i][j] == 1){
                    System.out.printf("%d %d\n",i,j);
                }
            }
        }
    } // output()

    // Function to run bfs
    public void bfs(int n, int m, int x, int y, int color) {

        // Initialing all as zero
        // for (int i = 0; i < 10; i++) {
        //     for (int j = 0; j < 20; j++) {
        //             vis[i][j] = 0;
        //         }
        // }
                
        // Creating queue for bfs
        Queue<Pair> obj = new LinkedList<>();

        // Pushing pair of {x, y}
        Pair pq = new Pair(x, y);
        obj.add(pq);

        // Marking {x, y} as visited
        vis[x][y] = 1;

        // Until queue is empty
        while (!obj.isEmpty()) {
            // Extracting front pair
            Pair coord = obj.peek(); // coord : co-ordinate (x,y ร่วม) peek() เอาหัวคิวมาดู
            int x1 = coord.posX;
            int y1 = coord.posY;
            int preColor = data[x1][y1]; // สีเดิม
            
            data[x1][y1] = color; // สีใหม่
            
            // Popping front pair of queue
            obj.remove(); // เอาหัวคิวออกไป

            /***
             * !validCoord(x1 + 1, y1, n, m) == 1
             * เป็นเมธอดเชคว่า จุดร่วมปัจจุบัน x,y มันเกินขนาด arr2D[n][m] ไหม และ
             * มันจมจอป่าว(ถ้าจมจอ พิกัดจะติดลบ) (ซึ่งถ้าเกิน ค่าพวกมันจะติดลบ)
             * - x1 + 1 : up (x)
             * - y1 : (y)
             * - n : row ของ arr2D[n][m]
             * - m : column ของ arr2D[n][m]
             * 
             * !vis[x1 + 1][y1] == 0
             * เชคว่า... มาร์ค vis[x][y] จุดนี้ ว่ามาเยือนแล้วรึยัง
             * - [x1 + 1] : up (x)
             * - [y1] : (y)
             * 
             * !data[x1 + 1][y1] == preColor
             * เชคว่า data[x][y] ใช่สีเก่ารึเปล่า
             * - [x1 + 1] : up (x)
             * - [y1] : (y)
             */

            /***
             * Pair p = new Pair(x1 + 1, y1)
             * สร้าง จุดใหม่
             * 
             * obj.add(p)
             * แอดจุดลงคิว
             * 
             * vis[x1 + 1][y1] = 1;
             * ทำมาคพิกัดว่ามาแล้วนะ
             */            

            // NE : North East
            if ((validCoord(x1 - 1, y1 + 1, n, m) == 1) && vis[x1 - 1][y1 + 1] == 0 && data[x1 - 1][y1 + 1] == preColor) {
                Pair p = new Pair(x1 - 1, y1 + 1);
                obj.add(p);
                vis[x1 - 1][y1 + 1] = 1;
            }
            
            // NW : North West
            if ((validCoord(x1 - 1, y1 - 1, n, m) == 1) && vis[x1 - 1][y1 - 1] == 0 && data[x1 - 1][y1 - 1] == preColor) {
                Pair p = new Pair(x1 - 1, y1 - 1);
                obj.add(p);
                vis[x1 - 1][y1 - 1] = 1;
            }            
            
            // SW : South West
            if ((validCoord(x1 + 1, y1 - 1, n, m) == 1) && vis[x1 + 1][y1 - 1] == 0 && data[x1 + 1][y1 - 1] == preColor) {
                // System.out.println("I reach SW");
                Pair p = new Pair(x1 + 1, y1 - 1);
                obj.add(p);
                vis[x1 + 1][y1 - 1] = 1;
            }
    
            // SE : South East
            if ((validCoord(x1 + 1, y1 + 1, n, m) == 1) && vis[x1 + 1][y1 + 1] == 0 && data[x1 + 1][y1 + 1] == preColor) {
                // System.out.println("I reach SE");
                Pair p = new Pair(x1 + 1, y1 + 1);
                obj.add(p);
                vis[x1 + 1][y1 + 1] = 1;
            }
    
            // W : West + 1
            if ((validCoord(x1, y1 - 2, n, m) == 1) && vis[x1][y1 - 2] == 0 && data[x1][y1 - 2] == preColor) {
                Pair p = new Pair(x1, y1 - 2);
                obj.add(p);
                vis[x1][y1 - 2] = 1;
            }
    
            // E : East + 1
            if ((validCoord(x1, y1 + 2, n, m) == 1) && vis[x1][y1 + 2] == 0 && data[x1][y1 + 2] == preColor) {
                Pair p = new Pair(x1, y1 + 2);
                obj.add(p);
                vis[x1][y1 + 2] = 1;
            }

            // // N : North
            // if ((validCoord(x1 + 1, y1, n, m) == 1) && vis[x1 + 1][y1] == 0 && data[x1 + 1][y1] == preColor) {
                //     Pair p = new Pair(x1 + 1, y1);
                //     obj.add(p);
            //     vis[x1 + 1][y1] = 1;
            // }

            // // S : South
            // if ((validCoord(x1 - 1, y1, n, m) == 1) && vis[x1 - 1][y1] == 0 && data[x1 - 1][y1] == preColor) {
            //     Pair p = new Pair(x1 - 1, y1);
            //     obj.add(p);
            //     vis[x1 - 1][y1] = 1;
            // }

            // // E : East
            // if ((validCoord(x1, y1 + 1, n, m) == 1) && vis[x1][y1 + 1] == 0 && data[x1][y1 + 1] == preColor) {
            //     Pair p = new Pair(x1, y1 + 1);
            //     obj.add(p);
            //     vis[x1][y1 + 1] = 1;
            // }            
            
            //// W : West
            // if ((validCoord(x1, y1 - 1, n, m) == 1) && vis[x1][y1 - 1] == 0 && data[x1][y1 - 1] == preColor) {
                //     Pair p = new Pair(x1, y1 - 1);
                //     obj.add(p);
                //     vis[x1][y1 - 1] = 1;
                // }
                
        } // while

        // System.out.println("\nROUND : " + count++);

        //// Printing The Changed Matrix Of Pixels
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         System.out.print(data[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();


        // System.out.println("VISITED[101][101]");
        // for (int i = 0; i < 10; i++) {
        //     for (int j = 0; j < 20; j++) {
        //         System.out.print(vis[i][j] + "");
        //     }
        //     System.out.println();
        // }
        // System.out.println();

        // // output();
        // // System.out.println("output");
        // for (int i = 0; i < 10; i++) {
        //     for (int j = 0; j < 20; j++) {
        //         if(vis[i][j] == 0 && data[i][j] == 1){
        //             System.out.printf("%d %d\n",i,j);
        //         }
        //     }
        //     // System.out.println();
        // }
        // System.out.println();

    } // BFS()
}