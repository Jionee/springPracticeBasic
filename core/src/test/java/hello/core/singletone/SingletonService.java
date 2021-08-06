package hello.core.singletone;

public class SingletonService {
    //자기 자신을 딱 하나만 가지도록 -> static
    //자바가 뜰 때 이걸 new해서 하나 딱 가지고 있음
    private static final SingletonService instance = new SingletonService();

    //싱글톤 인스턴스를 조회하고 싶을 때는 오직 이것만을 public을 이용해서
    //항상 같은 instance만 반환함
    public static SingletonService getInstance(){
        return instance;
    }
    //생성자를 private으로 하면 외부에서는 new가 안됨!
    private SingletonService(){

    }
    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
