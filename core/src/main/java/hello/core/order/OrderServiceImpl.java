package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
//import hello.core.discount.FixDiscountPolicy;
//import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor //final이 붙은 필수적인 애들을 포함한 생성자를 자동으로 만들어주는 역할
public class OrderServiceImpl implements  OrderService{

    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); //의존관계 위반(OCP 위반)

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy; //-> 구현체에 의존하지 않고 interface에만 의존한다.

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
                            //@Qualifier("mainDiscountPolicy") DiscountPolicy discountPolicy) { //Qualifier를 사용한 빈 중의성 해결
    //public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy fixDiscountPolicy) {
        //DiscountPolicy discountPolicy-> 필드 이름을 특정 것으로 해주면 autowired할 때 같은 타입 빈이 두 개 이상일 때 알아서 찾아감
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); //회원 조회
        int discountPrice = discountPolicy.discount(member,itemPrice); //단일 책임 원칙. 주문에서 할인은 잘 모르겠어 discountPolicy너가 알아서 해줘

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
