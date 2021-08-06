package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloLombok {
    private String name;
    private int age;
    
    public static void main(String[] args){
        HelloLombok helloLombok = new HelloLombok();
        //getter,setter를 자동으로 만들어줌
        helloLombok.getAge();
        helloLombok.setAge(10);
        System.out.println("helloLombok = " + helloLombok);
    }
}
