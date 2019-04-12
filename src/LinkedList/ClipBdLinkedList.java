package LinkedList;

public class ClipBdLinkedList {
    private NodeCB top;
    private NodeCB tail;

    public ClipBdLinkedList() {
        tail = top = null;
    }

    public NodeCB getTop(){return top;}

    public NodeCB getTail(){return tail;}

    public void add(NodeCB cbToAdd){
        cbToAdd.setNext(top);
        top = cbToAdd;
    }


    // create methods you need.

}