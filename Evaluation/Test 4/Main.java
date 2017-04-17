package labmanual4;

import java.util.HashMap;
import java.util.Scanner;

class input extends Thread {

    vowelsCount vc;
    frequencyCount fc;
    int tt;
    Scanner sc = new Scanner(System.in);
    String st;

    public input() {
    }

    public void run() {
        while (true) {
            st = sc.next();
            if (st.equals("#")) {
                break;
            }
            vc = new vowelsCount(st);
            vc.start();
            fc = new frequencyCount(st);
            fc.start();
            tt += vc.getCount();
        }
    }

    public void print() {
        System.out.println("Total Vowels: " + tt);
        for (int i = 0; i < 26; i++) {
            if (frequencyCount.fr[i] != 0) {
                char ch = (char) (i + 97);
                System.out.print(ch + ": " + frequencyCount.fr[i] + " ");
            }
        }
    }
}

class vowelsCount extends Thread {

    String s;
    int cnt;

    public vowelsCount(String s) {
        this.s = s.toLowerCase();
        cnt = 0;
    }

    public void run() {
        int ln = s.length();
        try {
            if (ln == 0) {
                wait();
            } else {
                for (int i = 0; i < ln; i++) {
                    if (s.charAt(i) == 'a') {
                        cnt++;
                    } else if (s.charAt(i) == 'i') {
                        cnt++;
                    } else if (s.charAt(i) == 'o') {
                        cnt++;
                    } else if (s.charAt(i) == 'e') {
                        cnt++;
                    } else if (s.charAt(i) == 'u') {
                        cnt++;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public int getCount() {
        return cnt;
    }
}

class frequencyCount extends Thread {
    // static HashMap x = new HashMap();
    // static  HashMap<Character, Integer> map = new HashMap();

    static int[] fr = new int[26];
    String s;

    public frequencyCount(String s) {
        this.s = s.toLowerCase();
    }

    public void run() {
        try {

            int ln = s.length();
            if (ln == 0) {
                wait();
            } else {
                for (int i = 0; i < ln; i++) {
                    int x = s.charAt(i) - 'a';
                    fr[x]++;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

public class Main {

    public static void main(String[] args) {
        input inp = new input();
        inp.start();
        try {
            inp.join();
        } catch (Exception e) {
            System.out.println(e);
        }
        inp.print();
    }
}
