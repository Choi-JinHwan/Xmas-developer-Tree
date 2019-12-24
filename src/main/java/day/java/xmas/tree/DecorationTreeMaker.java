package day.java.xmas.tree;

public interface DecorationTreeMaker extends TreeMaker {

    public String getLeaf();
    public void setLeaf(String string);

    public String[] getDecorations();
    public void setDecorations(String[] decorations);

}
