package jpabook.jpashop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MemberRepositoryTest {


    @Autowired
    MemberRepository memberRepository;


    @Test
    @Transactional
    public void testMember() throws Exception {
        //given
        Member member = new Member();
        member.setUsername("memberA");
        //when
        Long saveId = memberRepository.save(member);
        System.out.println("saveId : " + saveId);
        Member findMember = memberRepository.find(saveId);
        System.out.println("findMemberId : " + findMember.getId());

        //than
        assertThat(findMember.getId().equals(member.getId()));
        assertThat(findMember.getUsername().equals(member.getUsername()));
        assertThat(findMember).isEqualTo(member);
    }

}