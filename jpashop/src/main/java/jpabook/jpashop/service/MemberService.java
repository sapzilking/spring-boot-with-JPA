package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



//읽기기능을 하는 메소드에는 readOnly true를 넣어줘서 성능을 좀 더 최적화 할 수 있다.(여기서는 읽기 기능을 하는 메소드가 2개라 클래스의 기본 트랜잭션을 readOnly=true속성으로 주고 회원 가입에만 따로 false를 주었다.)
//jpa의 모든 데이터 변경이나 로직들은 가급적 트랜잭션 안에서 다 실행되어야 한다. 이렇게 해야 Lazy로딩이나 등등이 됨...
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 회원 가입
     */
    @Transactional
    public Long join(Member member) {
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        //이렇게 해도 멀티스레드 환경에서 동시에 접근하면 같은 이름의 멤버가 2개 만들어 질수 있으므로 데이터베이스에서 member의 name에 유니크 제약조건으로 걸어주면 더 안전하다.
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    /**
     * 회원 전체 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }


}
