package LinkedList;

public class NodeCB {
    private int clipBoardNumber;
    private NodeD<Character> topOfClipBoard;
    DoubleLinkedList<Character> myLinkedList;
    private NodeCB next;

    public NodeCB() {
        clipBoardNumber = 0;
        topOfClipBoard = null;
        myLinkedList = new DoubleLinkedList<>();
        next = null;
    }

    public NodeCB(DoubleLinkedList<Character> myLinkedList, int clipBoardNumber){
        this.clipBoardNumber = clipBoardNumber;
        this.myLinkedList = myLinkedList;
        this.topOfClipBoard = myLinkedList.top;
    }

    public int getClipBoardNumber() {
        return clipBoardNumber;
    }

    public void setClipBoardNumber(int clipBoardNumber) {
        this.clipBoardNumber = clipBoardNumber;
    }

    public NodeD getTopOfClipBoard() {
        return topOfClipBoard;
    }

    public void setTopOfClipBoard(NodeD topOfClipBoard) {
        this.topOfClipBoard = topOfClipBoard;
    }

    public NodeCB getNext(){return next;}

    public void setNext(NodeCB next){this.next = next;}

    public DoubleLinkedList<Character> getMyLinkedList(){return myLinkedList;}
}
