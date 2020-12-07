package sample10.composite2;

import java.util.Map;

public class Variable extends Expression {
    private String name;

    public Variable(String name) {
        this.name = name;
    }

    public float eval(Map<String, Float> variables) {
        return variables.get(name);
    }
    
    public void print() {
        System.out.printf("%s", name);
    }
}
