package com.lyc.study.collection.tree;

/**
 * 二叉树实现
 * Created by liyuanchi on 2017/11/16
 */
public class BTNode {
    private char key; //数据
    private BTNode left,right;//左右子节点



    public BTNode(char key, BTNode left, BTNode right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    public char getKey() {
        return key;
    }

    public void setKey(char key) {
        this.key = key;
    }

    public BTNode getLeft() {
        return left;
    }

    public void setLeft(BTNode left) {
        this.left = left;
    }

    public BTNode getRight() {
        return right;
    }

    public void setRight(BTNode right) {
        this.right = right;
    }
}
