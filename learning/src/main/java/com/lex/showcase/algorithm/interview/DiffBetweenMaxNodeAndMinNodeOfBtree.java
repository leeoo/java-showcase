package com.lex.showcase.algorithm.interview;

/**
 * 阿里2015在线笔试附加题
 * 第二题：写一个函数，输入一个二叉树，树中每个节点存放了一个整数值，函数返回这棵二叉树中相差最大的两个节点间的差值绝对值。请注意程序效率。
 * (大意，插入一个二叉树，求二叉树最大节点和最小节点的绝对值)
 */
public class DiffBetweenMaxNodeAndMinNodeOfBtree {

    public static void main(String[] args) {
        int a[] = {1, 45, 6, 7, 12, 89, 2, 17};
        Btree1 b = new Btree1(-10000, 10000);
        TreeNode1 treeNode1 = new TreeNode1(a[0]);
        for (int i = 1; i < a.length; i++) {
            b.insert(treeNode1, a[i]);
        }
        b.FindMax_Min(treeNode1);
        b.Max_Min_abs();
    }

}

//树节点
class TreeNode1 {
    private TreeNode1 leftChild;
    private TreeNode1 rightChild;
    int intege;

    public TreeNode1 getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode1 leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode1 getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode1 rightChild) {
        this.rightChild = rightChild;
    }

    public int getIntege() {
        return intege;
    }

    public void setIntege(int intege) {
        this.intege = intege;
    }

    public TreeNode1(int intege) {
        super();
        this.intege = intege;
    }
}

//二叉树
class Btree1 {
    private int max;
    private int min;

    public Btree1(int max, int min) {
        super();
        this.max = max;
        this.min = min;
    }

    //构造二叉树
    public void insert(TreeNode1 root, int i) {
        if (root == null) {
            System.out.println("树为空");
        } else {
            if (root.getIntege() < i) {
                if (root.getLeftChild() != null) {
                    insert(root.getLeftChild(), i);
                } else {
                    root.setLeftChild(new TreeNode1(i));
                }
            } else {
                if (root.getRightChild() != null) {
                    insert(root.getRightChild(), i);
                } else {
                    root.setRightChild(new TreeNode1(i));
                }
            }
        }
    }

    //插入二叉树，遍历找到节点最大值和最小值
    public void FindMax_Min(TreeNode1 root) {
        if (root == null) {
            System.out.println("该树为空");
        } else {
            if (root.getIntege() > max) {
                max = root.getIntege();
            }
            if (root.getIntege() < min) {
                min = root.getIntege();
            }
//System.out.println(root.getIntege() + "  ");
            if (root.getLeftChild() != null) {
                FindMax_Min(root.getLeftChild());
            }
            if (root.getRightChild() != null) {
                FindMax_Min(root.getRightChild());
            }
        }
    }

    public void Max_Min_abs() {
        System.out.println(max - min);
    }

}

