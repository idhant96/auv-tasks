import java.util.*;

class averager {
     static float avg = 0;
    static float getavg(int x,int y, float av){
        return (av*x + y)/(x+1);
    }

   public static void main(String[] args) {
    
    int i=0;
    int j=0;
     
       Scanner sc=new Scanner(System.in);
       int check=0;
      while(true){
        System.out.println("enter the new header");
        
        j=sc.nextInt();
        if (j<360){
        avg=getavg(i,j,avg);
        i++;
    }
        else{
            System.out.println(" The average of " +i+" headers was ->"+avg);
            System.exit(1);
        }
        System.out.println("do u want to view the average? press 1 else any number");
        check =sc.nextInt();
        if (check==1)
             System.out.println(" The average of " +i+" headers was ->"+avg);



   }
}
}