package com.example.project;

public class DLL<T> {
	private DLLNode<T> head;
	private DLLNode<T> current;

    public DLL() {
        head = current = null;
    }
    public boolean empty() {
        return head == null;
    }
    public boolean last() {
        return current.next == null;
    }
    public boolean first() {
        return current.previous == null;
    }
    public boolean full() {
        return false;
    }
    public void findFirst() {
        current = head;
    }
    public void findNext() {
        current = current.next;
    }
    public void findPrevious() {
        current = current.previous;
    }
    public T retrieve() {
        return current.data;
    }
    public void update(T val) {
        current.data = val;
    }
    public void insert(T val) {
        DLLNode<T> tmp = new DLLNode<T>(val);
        if(empty()) {
            current = head = tmp;
        }
        else {
            tmp.next = current.next;
            tmp.previous = current;
            if(current.next != null)
                current.next.previous = tmp;
            current.next = tmp;
            current = tmp;
        }
    }
    public void remove() {
        if(current == head) {
            head = head.next;
            if(head != null)
               head.previous = null;
        }
        else {
            current.previous.next = current.next;
            if(current.next != null)
               current.next.previous = current.previous;
        }
        if(current.next == null)
            current = head;
        else
            current = current.next;
    }
  public void removeBetween(T e1, T e2) {
    // Step 1: Find the node with element e1
    Node<T> current = head;
    while (current != null && !current.data.equals(e1)) {
        current = current.next;
    }

    // If e1 is not found, or if e2 does not exist after e1, exit
    if (current == null) {
        return;
    }

    // Step 2: Set start to e1's node and move current to the next node
    Node<T> start = current;
    current = current.next;

    // Traverse until we find e2 or reach the end of the list
    while (current != null && !current.data.equals(e2)) {
        current = current.next;
    }

    // If e2 is not found, exit
    if (current == null) {
        return;
    }

    // Step 3: At this point, 'start' is the node with e1 and 'current' is the node with e2
    // Remove all nodes between start and current
    Node<T> temp = start.next;
    while (temp != current) {
        Node<T> nextNode = temp.next;
        // Disconnect the node
        temp.prev = temp.next = null;
        temp = nextNode;
    }

    // Step 4: Link e1's node to e2's node to bypass the removed nodes
    start.next = current;
    current.prev = start;

    // Step 5: Move current pointer to head if the removal was successful
    this.current = head;
}
}
    }
}
