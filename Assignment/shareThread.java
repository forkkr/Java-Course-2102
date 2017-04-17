package labmanual7;
import java.util.logging.Level;
import java.util.logging.Logger;
class shareThread extends Thread
{
    static int value = 0;
    public void run()
    {
        for(int i = 0; i < 10 ; i++)
        {
            int x = value;
            yield();
            x++;
            value = x;
        }
    }

    public static void main(String[] args) throws InterruptedException {
       shareThread [] st = new shareThread[10];
       for(int i = 0; i < 10; i++)
       {
           st[i] = new shareThread();
           st[i].start();
           st[i].join();
           st[i].sleep(10);
       }
 System.out.println("Final Value: "+ value);
}
}


