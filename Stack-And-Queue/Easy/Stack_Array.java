class ArrayStack {
    //Array stack
    private int[] stackArray;
    // Maximum capacity
    private int capacity;
    // Index of top element
    private int topIndex;
    //constructor to create array
    public ArrayStack(int capacity) {
        this.capacity = capacity;
        stackArray = new int[capacity];
        topIndex  = -1;
    }
    //push a new vakue by incrementing index
    public void push(int x) {
        if (topIndex == capacity - 1) {
            throw new StackOverflowError("Stack is full! Cannot push " + x);
        }
        topIndex++;
        stackArray[topIndex] = x;
    }
    //return last element and decrement topindex
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty! Cannot pop.");
        }
        return stackArray[topIndex--];
    }
    //return topIndex
    public int top() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty! Cannot view top.");
        }
        return  stackArray[topIndex];
    }
    //if topIndex is -1 it means its empty
    public boolean isEmpty() {
        return topIndex == -1;
    }
}
