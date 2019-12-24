package day.java.xmas.tree;

import org.fusesource.jansi.AnsiConsole;

import java.io.IOException;

public class BlinkTreePrinter implements TreePrinter {

    private StringBuilderPrinter stringBuilderPrinter = new StringBuilderPrinter();
    private int interval = 1000;
    private String tree;
    private LightDecorationTreeMaker treeMaker;

    public BlinkTreePrinter(LightDecorationTreeMaker treeMaker){
        this.treeMaker = treeMaker;
        this.tree = treeMaker.make();
    }

    public void print(){
        try {
            blinkPrint(tree, treeMaker.getLightDecoration(), treeMaker.getNonLightDecoration());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void blinkPrint(String tree, String light, String nonLight) throws InterruptedException {
        String replacedTree = tree.replace(light, nonLight);
        String printTree = tree;
        boolean plug =  true;
        while (true) {
            plug = !plug;

            AnsiConsole.out.println(printTree);
            Thread.sleep(interval);
            windowsClearConsole();

            if(plug) {
                printTree = replacedTree;
            } else{
                printTree = tree;
            }
        }
    }

    private void windowsClearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }
}
