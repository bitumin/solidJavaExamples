package com.solid;

public interface BadTree {
    // common to binary and balanced
    public void findMax();
    public void findMin();
    public void traverse();
    // only useful for balanced
    public void rightRotation();
    public void leftRotation();
}
