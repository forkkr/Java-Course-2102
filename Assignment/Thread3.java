package labmanual7;

class chainThread extends Thread {

    private int key;

    public chainThread(int key) {
        this.key = key;
        try {
            Thread.sleep(10);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void run() {
        if (key <= 50) {
            chainThread ct = new chainThread(key + 1);
            ct.start();
            try {
                ct.join();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Running Thread " + key);
        }
    }
}

public class Thread3 {

    public static void main(String[] args) {
        chainThread ct = new chainThread(1);
        ct.start();
        try
        {
            ct.join();
        }
        catch( Exception e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("All chain Thread Excuted finally");
    }

}
