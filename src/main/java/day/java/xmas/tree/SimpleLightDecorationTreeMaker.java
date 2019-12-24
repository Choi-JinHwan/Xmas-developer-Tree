package day.java.xmas.tree;

import java.util.Random;

import static day.java.xmas.tree.WindowsColor.*;
import static day.java.xmas.tree.WindowsColor.RESET;

public class SimpleLightDecorationTreeMaker extends StringBuilderPrinter implements LightDecorationTreeMaker {

    private String leaf = GREEN_BOLD + "-" + RESET;
    private String lightDecoration = YELLOW_BOLD + "o" + RESET;
    private String nonLightDecoration = WHITE_BOLD+"x"+RESET;
    private String[] treeObjects = {lightDecoration, leaf};
    private int height = 10;

    public SimpleLightDecorationTreeMaker() {
        this.stringBuilder = new StringBuilder();
    }

    public SimpleLightDecorationTreeMaker(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    public String make() {
        return make(height);
    }

    public String make(int height) {
        for (int y = 0; y < height; y++) {
            for (int x1 = 0; x1 < height - y; x1++) {
                print(" ");
            }
            for (int x2 = 0; x2 < (y * 2 + 1); x2++) {
                printTressObject();
            }
            nextLine();
        }
        return stringBuilder.toString();
    }

    private void printTressObject() {
        int randomIndex = new Random().nextInt(treeObjects.length);
        stringBuilder.append(treeObjects[randomIndex]);
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String getLightDecoration() {
        return lightDecoration;
    }

    @Override
    public void setLightDecoration(String lightDecorations) {
        this.lightDecoration = lightDecorations;
    }

    @Override
    public String getNonLightDecoration() {
        return nonLightDecoration;
    }

    @Override
    public void setNonLightDecoration(String nonLightDecoration) {
        this.nonLightDecoration = nonLightDecoration;
    }
}
