package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements  MemberService{
    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //배우가 배우를 캐스팅하는 방식이 아니라
    //기획자(AppConfig)가 배우를 캐스팅하는 방식
    private final MemberRepository memberRepository;

    @Autowired //생성자에 자동 의존관계 주입 실시 //ac.getBean(MemberRepository.class) 처럼 동작
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
