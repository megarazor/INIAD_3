public class Main {
    public static void main(String... args){
        MyQueue<String> q= new MyQueue<String>(4);
        System.out.println(q.dequeue());
        q.enqueue("Bruh");
        q.enqueue("Epic");
        System.out.println(q.dequeue());
        q.enqueue("Style");
        q.enqueue("Epicly");
        q.enqueue("Oh yeah");
        q.enqueue("Shouldnt be enqueued");
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());


    }
    
}
