package day.java.xmas;

import org.fusesource.jansi.AnsiConsole;

import java.io.IOException;
import java.util.Random;

import static day.java.xmas.WindowsColor.*;

public class Tree {
    public static String bulb = YELLOW_BOLD_BRIGHT+"o"+RESET;
    public static  String leaf = GREEN_BOLD_BRIGHT + "-" + RESET;
    public static String[] treeObjects = {bulb, leaf};
    public static StringBuilder stringBuilder= new StringBuilder();



    public static void main(String[] args) throws InterruptedException {
        /*
        System.out.print("input number << ");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();*/
        int height = 10;
        makeTree(height);

        printTree();


    }

    private static void makeTree(int height) {
        for(int y=0;y<height; y++){
            for (int x1=0; x1<height-y; x1++) {
                print(" ");
            }
            for (int x2=0; x2<(y*2+1); x2++) {
                printTressObject();
            }
            nextLine();
        }
    }

    private static void printTree() throws InterruptedException {
        while(true){
            blink(stringBuilder,bulb,"x");
            blink(stringBuilder,"x",bulb);
        }
    }

    private static void blink(StringBuilder stringBuilder, String blinkTarget1, String blinkTarget2) throws InterruptedException {
        String outputString = stringBuilder.toString();
        outputString = outputString.replace(blinkTarget1,blinkTarget2);
        AnsiConsole.out.println(outputString);
        Thread.sleep(100l);
        windowsClearConsole();
    }

    private static void windowsClearConsole()  {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void print(String string){
        stringBuilder.append(string);
    }
    public static void println(String string){
        stringBuilder.append(string+"\n");
    }
    public static void nextLine(){
        stringBuilder.append("\n");
    }

    public static void printTressObject(){
        int randomIndex = new Random().nextInt(treeObjects.length);
        stringBuilder.append(treeObjects[randomIndex]);
    }
}
