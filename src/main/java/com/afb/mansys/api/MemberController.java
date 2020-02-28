package com.afb.mansys.api;

import com.afb.mansys.model.Member;
import com.afb.mansys.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("members")
@RestController
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping(path = "new")
    public void insertMember(@Valid @NotNull @RequestBody Member member) {
        memberService.insertMember(member);
    }

    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    @GetMapping(path = "{id}")
    public Member getMemberByID(@PathVariable("id") UUID id) {
        return memberService.getMemberByID(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteMember(@PathVariable("id") UUID id) {
        memberService.deleteMember(id);
    }

    @PutMapping(path = "{id}")
    public void updateMember(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody Member member) {
        memberService.updateMember(id, member);
    }
}
