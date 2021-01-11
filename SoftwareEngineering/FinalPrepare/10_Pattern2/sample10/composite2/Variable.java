package sample10.composite2;

import java.util.Map;

public class Variable extends Expression {
    private String value;

    public Variable(String value){
        this.value= value;
    }    

    public float eval(Map<String, Float> variables){
        return variables.get(value);
    }

    public void print(){
        System.out.printf("%s", value);
    }
}
