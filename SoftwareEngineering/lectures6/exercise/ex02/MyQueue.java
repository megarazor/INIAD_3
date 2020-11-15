public class MyQueue <E> {
    private int size;
    private int tail;
    private int head;
    private E[] elements;

    @SuppressWarnings("unchecked")
    public MyQueue(int size){
        this.size= size;
        this.tail= 0;
        this.head= 0;
        this.elements= (E[]) new Object[size];
    }

    public void enqueue(E input){
        if (tail == head){
            if (elements[head] != null){
                return;
            }
        }

        elements[tail]= input;
        tail+= 1;
        tail%= size;
    }

    public E dequeue(){
        if (tail == head){
            if (elements[head] == null){
                return null;
            }
        }
        E output= elements[head];
        elements[head]= null;
        head+= 1;
        head%= size;
        return output;
    }
}