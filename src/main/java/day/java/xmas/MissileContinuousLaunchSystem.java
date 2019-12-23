package day.java.xmas;

public class MissileContinuousLaunchSystem {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("missile continuous launch system setup");
        printLoadingBar("loading complete");
        for(int i=0; i<10; i++){
            printLoadingBar("missile"+(i+1)+" setup complete!!!!\tlaunch!!!!!!");
        }
    }

    private static void printLoadingBar(String message) throws InterruptedException {
        printLoadingBar("=",100, message);
    }
    private static void printLoadingBar(String string, String message) throws InterruptedException {
        printLoadingBar(string,100, message);
    }

    private static void printLoadingBar(String string, int sleep, String message) throws InterruptedException {
        System.out.print("[");
        for(int i=0; i<10; i++){
            System.out.print(string);
            Thread.sleep(sleep);
        }
        System.out.print("]");
        System.out.println(":\t"+message);
    }
}
