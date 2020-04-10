package jt.sys;

import com.sun.org.apache.xpath.internal.objects.XString;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;

/**
 * Hello world!
 */
public class BinaryTree {
    public static void main(String[] args) {
        /**
         * 实现要求：
         * 1、根据已有的代码片段，实现一个二叉排序树；
         * 2、用中序遍历输出排序结果，结果形如：0，1，2 ，3 ，4， 5， 6， 7， 8， 9，
         * 3、注意编写代码注释
         */
        final int[] values = {1, 3, 4, 5, 2, 8, 6, 7, 9, 0};
        // TODO:
            Node node=new Node(values[0]);//将第一个数字作为根节点
            for (int i : values) {
                node.insert(node, i);
            }
            node.inorder(node);
    }

    public static Node createBinaryTree(Node node, int value) {
        // TODO:
        return node;
    }

    public static void inOrderTransval(Node node) {
        // TODO:
    }
}
