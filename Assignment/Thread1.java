package labmanual7;

import java.util.Random;

class even extends Thread {

    int num;

    public even(int num) {
        this.num = num;
    }

    public void run() {
        System.out.println(num * num);
    }
}

class odd extends Thread {

    int num;

    public odd(int num) {
        this.num = num;
    }

    public void run() {
        System.out.println(num * num * num);
    }
}

public class Thread1 {

    public static void main(String[] args) {
        Random rand = new Random();
        while (true) {
            int num = rand.nextInt(50);

            if (num % 2 == 0) {
                even square = new even(num);
                square.start();
            } else {
                odd cube = new odd(num);
                cube.start();
            }
        }
    }

}
