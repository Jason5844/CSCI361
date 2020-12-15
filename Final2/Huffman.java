import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Huffman
{
  // This is the Huffman tree.
  private Tree nodes;
  public static void encode(Node root, String str,
                          Map<Character, String> huffmanCode)
      {
          if (root == null) {
              return;
          }

          // Found a leaf node
          if (isLeaf(root)) {
              huffmanCode.put(root.ch, str.length() > 0 ? str : "1");
          }

          encode(root.left, str + '0', huffmanCode);
          encode(root.right, str + '1', huffmanCode);
      }

      // Traverse the Huffman Tree and decode the encoded string
      public static int decode(Node root, int index, StringBuilder sb)
      {
          if (root == null) {
              return index;
          }

          // Found a leaf node
          if (isLeaf(root)) {
              System.out.print(root.ch);
              return index;
          }

          index++;

          root = (sb.charAt(index) == '0') ? root.left : root.right;
          index = decode(root, index, sb);
          return index;
      }
  // This populates the nodes attribute from a file.
  public void bulidTreeFromFile(String fileName) throws FileNotFoundException
  {
    List<Tree> items = new ArrayList<Tree>();
    populateNodesFromFile(fileName, items);
    nodes = buildTreeFromNodes(items);
  }

  private void populateNodesFromFile(String fileName, List<Tree> nodes) throws FileNotFoundException
  {
    File file = new File(fileName);
    Scanner scanner = new Scanner(file);

    while (scanner.hasNextLine())
    {
      String line = scanner.nextLine();
      String[] data = line.split(",");

      char character = data[0].charAt(0);
      int frequency = Integer.parseInt(data[1]);

      Tree node = new Tree(null, null, character, frequency);
      nodes.add(node);
    }

    scanner.close();
  }

  private Tree buildTreeFromNodes(List<Tree> nodes)
  {
    if(nodes.size() == 1)
    {
      return nodes.get(0);
    }
    else
    {
      Collections.sort(nodes);

      Tree left = nodes.get(0);
      Tree right = nodes.get(1);
      int total = left.getTotal() + right.getTotal();

      Tree newNode = new Tree(left, right, Character.MIN_VALUE, total);

      if(nodes.size() == 2)
        return newNode;

      nodes.remove(left);
      nodes.remove(right);
      nodes.add(newNode);

      return buildTreeFromNodes(nodes);
    }
  }

  public void printTree()
  {
    System.out.println(nodes.toString());
  }

  public String getCode(char ch)
  {
    return buildCode(nodes, ch, "");
  }

  private String buildCode(Tree root, char ch, String code)
  {
    if (root.isLeaf() && Character.isLetter(root.getChar()))
    {
      return root.getChar() == ch ? code : "";
    }
    String leftCode = buildCode(root.getLeft(), ch, code + "0");
    String rightCode = buildCode(root.getRight(), ch, code + "1");

    code = leftCode.length() > 0 ? leftCode : rightCode;
    return code;
  }
}
