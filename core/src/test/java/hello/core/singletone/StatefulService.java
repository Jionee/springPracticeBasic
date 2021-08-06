package hello.core.singletone;

public class StatefulService {
    //private int price; //상태를 유지하는 필드 //공유되는 필드인데 클라이언트가 이 값을 변경 가능하다. //이러면 안됨
//    public void order(String name,int price){
//        System.out.println("name = " + name + "price = " + price);
//        this.price = price; //여기가 문제!
//    }

    //변경
    //파라미터를 사용하여 스프링 빈은 항상 무상태(stateliss)로 설계하자!!
    public int order(String name,int price){
        System.out.println("name = " + name + "price = " + price);
        return price;
    }

//    public int getPrice(){
//        return price;
//    }
}
