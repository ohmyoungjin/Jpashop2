package jpabook.jpashop;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    //EntityManager 주입
    @PersistenceContext
    private EntityManager em;

    public MemberRepository(EntityManager em) {
        this.em = em;
    }

    public Long save(Member member) {
        em.persist(member);
        em.flush();
        return member.getId();
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }
}
