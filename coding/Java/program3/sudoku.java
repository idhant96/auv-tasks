import java.util.*;
public class sudoku{
    
    public void distinct(int a[]){
         int flag;
            for (int k=1;k<=9;k++){ flag=0;
                 for (int j=0;j<9;j++){
                    if (a[j]==k){
                        flag++;
                       }
                }
                if (flag==0||flag>1){
                    System.out.println("not distinct ");
                    System.exit(1);
                }
            }
        }
    
        public boolean sum_check(int a[][]){
            int sum_col,sum_row;
                 for (int i=0;i<9;i++){
                     sum_col=0;
                     sum_row=0;
            for ( int j=0;j<9;j++){
                sum_row+=a[i][j];
                sum_col+=a[j][i];
            }
            if (sum_row!=45||sum_col!=45){
                System.out.print("this is not a valid at pos ");
                return false;
            
                }
            }
            return true;
        }
        
        public void sum_box(int a[]){
            int sum_col,sum_row;
            sum_col = 0;
            sum_row=0;
            for( int j=0;j<9;j++){
                sum_row+=a[j];
                sum_col+=a[j];
            }
             if(sum_row!=45||sum_col!=45){
            System.out.print("this is not a valid at box");
            System.exit(1);
        }       
        }
        public void box_check(int a, int b, int arr[][], sudoku obj) {
        int i,j,k=0;
        int v[]=new int [9];
        for (i=a;i<a+3;i++)
            for ( j=b;j<b+3;j++)
                 v[k++]=arr[i][j];
             obj.sum_box(v);
             obj.distinct(v);
        }



    public static void main(String ap[]){
        int sum_row=0;
        int sum_col=0;
        int i,j,flag=0,k=0;
        int x[]=new int [9];
        Scanner sc=new Scanner(System.in);
        int  arr[][] =new int [9][9];
        String a[]= new String [9];
        for ( i=0;i<9;i++){
            System.out.print("enter the "+ (i+1)+" row ");
            for ( j=0;j<9;j++){
                arr[i][j] =sc.nextInt();
                
            }
        }
    //    int  arr[][] = { {7,2,3,6,5,9,8,4,1},
    //                     {6,4,5,1,7,8,2,3,9},
    //                     {8,1,9,3,4,2,7,5,6},
    //                     {5,3,4,2,6,7,1,9,8},
    //                     {2,8,1,4,9,3,6,7,5},
    //                     {9,7,6,8,1,5,4,2,3},
    //                     {1,6,7,5,3,4,9,8,2},
    //                     {4,5,8,9,2,1,3,6,7},
    //                     {3,9,2,7,8,6,5,1,4} };

        System.out.println(Arrays.deepToString(arr));
        sudoku obj=new sudoku();
        if (obj.sum_check(arr)){
             //checking rows and cols
        for (i=0;i<9;i++){k=0;
            for ( j=0;j<9;j++,k++){
                x[k]=arr[i][j];
                
            }
            obj.distinct(x);
        }
         for (i=0;i<9;i++){k=0;
            for ( j=0;j<9;j++,k++){
                x[k]=arr[j][i];
               
            }
             obj.distinct(x);
        }
        // checking boxes   
        
       for ( int p = 0 ;p<7;p+=3)
        for (int  q= 0 ; q <7;q+=3)
            obj.box_check(q,p,arr, obj);
            System.out.println("Soololed!!");
        }
        
        
        else{

            System.exit(1);
        }
    }
}