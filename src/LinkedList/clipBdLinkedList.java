package LinkedList;

public class clipBdLinkedList {
    private NodeCB top;
    private NodeCB tail;

    public clipBdLinkedList() {
        tail = top = null;
    }

    public clipBdLinkedList(NodeCB top) {
        this.top = top;
        NodeCB tail = top;
        while(tail.getNext() != null){
            tail = tail.getNext();
        }
        this.tail = tail;
    }

    public void add(NodeCB board){
        board.setNext(top);
        top = board;
    }

    public NodeCB getTop(){
        return top;
    }

    public NodeCB getTail(){
        return tail;
    }

    public void remove(){
        top = top.getNext();
    }

}
