class ArrayQueue {
    List<Integer> QueueArray;
    public ArrayQueue() {
        QueueArray = new ArrayList<>();
    }

    public void push(int x) {
       QueueArray.add(x);
    }

    public int pop() {
        return QueueArray.remove(0);
    }

    public int peek() {
        return QueueArray.get(0);
    }

    public boolean isEmpty() {
        return QueueArray.isEmpty();
    }
}
