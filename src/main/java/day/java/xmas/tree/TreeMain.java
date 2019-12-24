package day.java.xmas.tree;

public class TreeMain {

    public static void main(String[] args) throws InterruptedException {
        LightDecorationTreeMaker treeMaker = new SimpleLightDecorationTreeMaker();
        treeMaker.setHeight(59);
        TreePrinter treePrinter = new BlinkTreePrinter(treeMaker);

        treePrinter.print();
    }
}
