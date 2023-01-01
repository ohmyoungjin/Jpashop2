package jpabook.jpashop.controller;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members/new")
    public String createForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    //굳이 MemberForm을 만들어야 했을까? Entity를 쓰면 되지 않나 ?
    //이에 대한 답은 Entity는 최대한 순수하게 유지하는 것이 좋다.
    //그래서 MemberForm 만들어서 사용한다
    public String create(@Valid MemberForm memberform, BindingResult result) {

        if (result.hasErrors()) {
            return "members/createMemberForm";
        }

        Address address = new Address(memberform.getCity(), memberform.getStreet(), memberform.getZipcode());

        Member member = new Member();
        member.setName(memberform.getName());
        member.setAddress(address);

        memberService.join(member);
        return "redirect:/";

    }

    @GetMapping("/members")
    public String list(Model model) {
        //뿌릴 때도 Entity를 반환하기 보다는
        //DTO로 컨버팅 후에 화면단에 넘기는 것이 좋다.
        //템플릿 엔진 같은 경우로 넘길 때는 Entity 사용을 해도 되지만,
        //Api로 사용되는 경우 외부로 나갈 때 Entity를 사용하게 되면
        //기준이 변경되고, 노출되지 말아야할 정보가 노출될 위험이 있어서 컨버팅 후에 넘기자 !
        List<Member> members = memberService.findMember();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
