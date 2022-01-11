public class LinkedList implements LinkedListInterface{
    ListNode head;
    ListNode tail;

    private class ListNode{
        private Object element;
        private ListNode next;
        public ListNode(){
            element=null;
            next=null;
        }
        public ListNode(Object element, ListNode next){
            this.element=element;
            this.next=next;
        }
        public Object getElement(){
            return this.element;
        }
        public ListNode getNext(){
            return this.next;
        }
        public void setElement(Object element){
            this.element=element;
        }
        public void setNext(ListNode next){
            this.next=next;
        }

        public String toString(){
            return ""+element+"->"+next;
        }
    }

    public LinkedList(){
        head=new ListNode();
        tail=head;
    }
    public void addFirst(Object obj){
        head.setElement(obj);
        head=new ListNode(null,head);
    }
    public void addLast(Object obj){
        ListNode temp=new ListNode(obj,null);
        tail.setNext(temp);
        tail=temp;
    }
    public Object removeFirst(){
        if(head.getNext()==tail){
            throw new EmptyLinkedListException();
        }
        Object output=head.getNext().getElement();
        head.setNext(head.getNext().getNext());
        return output;
    }
    public Object removeLast(){
        ListNode next=head.getNext();
        while(next.getNext()!=tail){
            next=next.getNext();
        }
        Object output=tail.getElement();
        next.setNext(null);
        tail=next;

        return output;
    }

    //Iterator
    public ListIterator getIterator(){
        return new LinkedListIterator(this.head);
    }
    private class LinkedListIterator implements ListIterator{
        private ListNode current;
        public LinkedListIterator(ListNode head){
            current=head;
        }
        public boolean hasNext(){
            return (current.getNext()!=null);
        }
        public Object next(){
            if(!(hasNext())){
                throw new IllegalStateException();
            }
            current=current.getNext();
            return current.getElement();
        }
    }

    public int size(){
        ListIterator iterator=getIterator();
        int i=0;
        while(iterator.hasNext()){
            iterator.next();
            i++;
        }
        return i;
    }


    public String toString(){
        return head.toString();
    }
}
interface LinkedListInterface{
    void addFirst(Object obj);
    void addLast(Object obj);
    Object removeFirst();
    Object removeLast();
}
interface ListIterator{
    boolean hasNext();
    Object next();
}
class EmptyLinkedListException extends RuntimeException{}
