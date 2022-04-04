package me.devtarix.TestBox;

public class Main {
    public static void main(String[] args) {
        int SECONDSTORUN = 10;
        try {
            FrameBasedSimLoop frameBasedSimLoop = new FrameBasedSimLoop();
            frameBasedSimLoop.run();
            Thread.sleep(SECONDSTORUN * 1000);
            frameBasedSimLoop.stop();
        } catch(Exception ex) {
            print(ex.getMessage());
        }
    }

    public static void print(String msg) {
        System.out.println(msg);
    }
}
