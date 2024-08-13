// --== CS400 File Header Information ==--
// Name: Orion Meng
// Email: dmeng8@wisc.edu
// Team: CC
// TA: Abhinav (agarwal72@cs.wisc.edu)
// Lecturer: Florian Heimerl
// Notes to Grader: N/A

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Stack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/*
 * Tests the functionality of RedBlackTree.java.
 * @author Orion Meng
 */
class TestRedBlackTree {
  
  /*
   * TEST CASE 1:
   * ======================
   *        ROOT(b)
   *        /   \
   *    NODE(b) NODE(b)
   *                \
   *                NODE(r)
   * ======================
   */
  @Test
  public static void test1() {
    RedBlackTree<Integer> tree = new RedBlackTree<>();
    tree.insert(2);
    tree.insert(1);
    tree.insert(3);
    tree.insert(4);
    assertEquals("[2, 1, 3, 4]", tree.root.toString());
    assertEquals(true, tree.root.isBlack);
    assertEquals(true, tree.root.leftChild.isBlack);
    assertEquals(true, tree.root.rightChild.isBlack);
    assertEquals(false, tree.root.rightChild.rightChild.isBlack);
    System.out.println(tree.root.toString());
  }
  
  /*
   * TEST CASE 2:
   * ======================
   *        ROOT(b)
   *        /   \
   *    NODE(b) NODE(b)
   *    /
   * NODE(r)
   * ======================
   */
  @Test
  public static void test2() {
    RedBlackTree<Integer> tree = new RedBlackTree<>();
    tree.insert(3);
    tree.insert(2);
    tree.insert(4);
    tree.insert(1);
    assertEquals("[3, 2, 4, 1]", tree.root.toString());
    assertEquals(true, tree.root.isBlack);
    assertEquals(true, tree.root.leftChild.isBlack);
    assertEquals(true, tree.root.rightChild.isBlack);
    assertEquals(false, tree.root.leftChild.leftChild.isBlack);
  }
  
  /*
   * TEST CASE 3:
   * ======================
   *        ROOT(b)
   *        /   \
   *    NODE(b) NODE(b)
   *        \
   *        NODE(r)
   * ======================
   */
  @Test
  public static void test3() {
    RedBlackTree<Integer> tree = new RedBlackTree<>();
    tree.insert(3);
    tree.insert(1);
    tree.insert(4);
    tree.insert(2);
    assertEquals("[3, 1, 4, 2]", tree.root.toString());
    assertEquals(true, tree.root.isBlack);
    assertEquals(true, tree.root.leftChild.isBlack);
    assertEquals(true, tree.root.rightChild.isBlack);
    assertEquals(false, tree.root.leftChild.rightChild.isBlack);
  }
  
  /*
   * TEST CASE 4:
   * ======================
   *        ROOT(b)
   *        /   \
   *    NODE(b) NODE(b)
   *            /
   *        NODE(r)
   * ======================
   */
  @Test
  public static void test4() {
    RedBlackTree<Integer> tree = new RedBlackTree<>();
    tree.insert(2);
    tree.insert(1);
    tree.insert(4);
    tree.insert(3);
    assertEquals("[2, 1, 4, 3]", tree.root.toString());
    assertEquals(true, tree.root.isBlack);
    assertEquals(true, tree.root.leftChild.isBlack);
    assertEquals(true, tree.root.rightChild.isBlack);
    assertEquals(false, tree.root.rightChild.leftChild.isBlack);
  }

  /*
   * Main method.
   */
  public static void main(String args[]) {
    test1();
    //test2();
    //test3();
    //test4();
  }
  
}
