package ru.ssau.tk.abrosimovamargo.sandbox.functions;

public class LinkedListTabulatedFunction extends AbstractTabulatedFunction{

    private int count = 0;
    private Node head;

    protected class Node {
        public double x;
        public double y;
        public Node prev;
        public Node next;
    }

    public void addNode(double x, double y) {
        Node newNode = new Node();
        newNode.x = x;
        newNode.y = y;
        if (head == null) {
            head = newNode;
            newNode.prev = newNode;
            newNode.next = newNode;
        } else {
            Node last = head.prev;
            newNode.prev = last;
            newNode.next = head;
            head.prev = newNode;
            last.next = newNode;
        }
        count += 1;
    }


    @Override
    int floNorIndexOfX(double x) {
        return 0;
    }

    @Override
    double extrapolateLeft(double x) {
        return 0;
    }

    @Override
    double extrapolateRight(double x) {
        return 0;
    }

    @Override
    double interpolate(double x, int floorIndex) {
        return 0;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public double getX(int index) {
        return 0;
    }

    @Override
    public double getY(int index) {
        return 0;
    }

    @Override
    public void setY(int index, double value) {

    }

    @Override
    public int indexOfX(double x) {
        return 0;
    }

    @Override
    public int indexOfY(double y) {
        return 0;
    }

    @Override
    public double leftBound() {
        return 0;
    }

    @Override
    public double rightBound() {
        return 0;
    }
}
