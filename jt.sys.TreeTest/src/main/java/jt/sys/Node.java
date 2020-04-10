package jt.sys;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import java.security.Key;

public class Node {
    // 节点值 以当前节点为根的子树的节点总数
    private int value;
    // 左节点
    private Node left;
    // 右节点
    private Node right;
    //数据域
    private Integer data;

    public Node(Node left, Node right, Integer data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public Node(Integer data) {
        this(null, null, data);
    }

    // 中序遍历 (对于二叉排序树 相当于从小到大输出)
    public boolean insert(Node node, int item) {
        if (item < node.data) { //小的数左侧插入
            if (node.left == null) {
                Node temp = new Node(item);
                node.left = temp;
                temp.value= node.data;
                return true;
            } else {
                insert(node.left, item);
            }
        } else if (item > node.data) {//大的数从右侧插入
            if (node.right == null) {
                Node temp = new Node(item);
                node.right = temp;
                temp.value = node.data;
                return true;
            } else {
                insert(node.right, item);
            }
        }
        return true;
    }

    public void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            visit(node.data);
            inorder(node.right);
        }
    }

    private void visit(Integer data) {
        System.out.println(data+"");
    }
}

