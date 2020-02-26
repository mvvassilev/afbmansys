package com.afb.mansys.api;

import com.afb.mansys.model.Member;
import com.afb.mansys.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @RequestMapping("members/new")
    @PostMapping
    public void insertMember(@RequestBody Member member){
        memberService.insertMember(member);
    }

    @RequestMapping("members")
    @GetMapping
    public List<Member> getAllMembers(){
        return memberService.getAllMembers();
    }
}
