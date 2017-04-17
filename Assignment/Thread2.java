
package labmanual7;
class maxThread extends Thread
{
    private int beg , endd;
    private int[] arr;
    private int Max;
    maxThread( int[] arr , int beg ,int endd)
    {
        this.arr = arr;
        this.beg = beg;
        this.endd = endd;
        this.Max = arr[beg];
    }
    public void run()
    {
        int i;
        for( i = beg + 1; i < endd ; i++)
        {
            Max = Math.max(Max, arr[i]);
        }
    }
    int getMax()
    {
        return Max;
    }
}
public class Thread2 {
    public static int Max( int[] arr ) throws InterruptedException
    {
        int length = arr.length;
        int i = 0;
        int ans ;
        maxThread [] max = new maxThread[4];
        for( i =  0 ; i < 4 ; i++)
        {
            max[i] = new maxThread(arr , (i*length)/4 , ((i+1)*length)/4);
        }
        max[0].join();
        ans = max[0].getMax();
        for( i = 1 ; i < 4 ; i++)
        {
            max[i].join();
            ans = Math.max(ans , max[i].getMax());
        }
        return ans;
    }
    public static void main(String[] args) throws InterruptedException {
       int [] ar = new int[12];
       int xx = -3;
       for(int i = 0;  i < 12; i++)
       {
           ar[i] = xx;
           xx *=( i + 1)*xx;
       }
      int res = Max( ar);
      System.out.println(res);
    }
    
}
