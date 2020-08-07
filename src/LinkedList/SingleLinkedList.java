package LinkedList;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

public class SingleLinkedList {
    public SingleLinkedList next;
    private Node head;
    private int length = 0;
    public SingleLinkedList(){
        this.head = null;
    }
    public void add(Node node){
        Node newNode = new Node();
        Node temp = head;
        while (true){
            if(temp != null){
                temp = temp.getNext();
            }else{
                temp.setNext(newNode);
            }
        }
    }
}
