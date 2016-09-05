import java.util.*;
//Press ctr+c to terminate the thread input.

public class prog2thread  extends Thread {
    private Thread t;
    private String in;
    double rand = 0;
    int front=0;
    int rear=-1;
    double arr[]=new double[64];
    long start,end;
    int pos=0,tem=0;
prog2thread( String name){
       in = name;
       System.out.println("Creating " +  in );
   }


    public void run(){
        System.out.print("next double input ");
        Random r =new Random();
      while(true){
        try {
      Thread.sleep(100);
       rand = 1+(100 - 1)*r.nextDouble();
       q(rand);
   } catch (Exception e) {
   System.out.println(e);
   }
    
      }       
    }
     public void start ()
   {
      System.out.println("Starting " +  in );
      if (t == null)
      {
         t = new Thread (this, in);
         t.start ();
      }
   }

public void q(double d){

arr[pos]=d;


tem=(pos+1)%64;
while(pos!=tem){
    System.out.println(arr[tem]);
    tem=(tem+1)%64;
}
System.out.println("-----------------------------------------------------------------------------------------------");
pos=(pos+1)%64;


}





}




   