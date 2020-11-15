public class MyStackTest {
    public static void main(String... args){
        MyStack<String> strStack= new MyStack<String>(10);
        strStack.push("Apple");
        strStack.push("Banana");
        strStack.push("Organe");

        MyStack<Student> stuStack= new MyStack<Student>(10);
        stuStack.push(new Student("Bob", 10, "001"));
        stuStack.push(new Student("Alice", 12, "002"));

        String strPop= strStack.pop();
        System.out.println(strPop);

        Student stuPop= stuStack.pop();
        System.out.println(stuPop.name);

        // stuPop= stuStack.pop();
        // System.out.println(stuPop.name);

        // stuPop= stuStack.pop();
        // System.out.println(stuPop.name);
    }
    
}
