import java.util.*;

public class Test
{
    public static void main(String args[])
    {
        /*
                A
            B       C
         D     E       F
        */
        BinaryTree treeD = new BinaryTree("D");
        BinaryTree treeE = new BinaryTree("E");
        BinaryTree treeF = new BinaryTree("F");
        BinaryTree treeB = new BinaryTree("B", treeD, treeE);
        BinaryTree treeC = new BinaryTree("C", null, treeF);
        BinaryTree root = new BinaryTree("A", treeB, treeC);

        // D B E A C F
        String s = root.toString();
        System.out.println(s);

        List<BinaryTree> trees = new ArrayList<BinaryTree>();
        trees.add(treeD);
        trees.add(treeF);
        trees.add(treeC);
        trees.add(treeE);
        trees.add(root);
        trees.add(treeB);

        Collections.sort(trees);

        for (SimpleTree t : trees)
        {
            System.out.println();
            System.out.print(t.getValue() + " ");
            System.out.println();
        }
    }
}
