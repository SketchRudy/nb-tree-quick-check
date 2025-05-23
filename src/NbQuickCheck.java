import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NbQuickCheck {

  /**
   * Performs a pre-order traversal of the tree, printing each node on a separate line.
   * Does nothing if the root is not present in the tree.
   *
   * @param tree the tree represented as a map of parent nodes to child lists
   * @param root the root node to start traversal from
   */
  public static void preOrder(Map<Integer, List<Integer>> tree, int root) {
    Set<Integer> visited = new HashSet<>();
    preOrderHelper(tree, root, visited);
  }

  public static void preOrderHelper(Map<Integer, List<Integer>> tree, int root, Set<Integer> visited) {
    if(!tree.containsKey(root) || visited.contains(root)) return;

    System.out.println(root);
    visited.add(root);

    for (int i : tree.get(root)) {
        preOrderHelper(tree, i, visited);
    }
  }

  /**
   * Returns the minimum value in the tree.
   * Returns Integer.MAX_VALUE if the root is null.
   *
   * @param root the root node of the tree
   * @return the minimum value in the tree or Integer.MAX_VALUE if root is null
   */
  public static int minVal(Node<Integer> root) {
    if (root == null) {
      return Integer.MAX_VALUE;
    }

    int min = root.value;
    for (var i : root.children) {
      int childMin = minVal(i);
      min = Math.min(min, childMin);
    }
    
    return min;
  }
  
}
