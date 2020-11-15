public class MyStack <E>{
    private final int size;
    private int top;
    private E[] elements;

    @SuppressWarnings("unchecked")
    public MyStack(int size){
        this.size= size;
        this.top= 0;
        this.elements= (E[]) new Object[size];
    }

    void push(E input){
        if (top >= size){
            return;
        }
        elements[top]= input;    
        top+= 1;    
    }

    E pop(){
        E output= elements[top - 1];
        top-= 1;
        return output;
    }
}
