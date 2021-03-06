package com.afb.mansys.api;

import com.afb.mansys.model.Member;
import com.afb.mansys.service.MemberService;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@JsonSerialize
@CrossOrigin("http://localhost:4200")
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

    @GetMapping(path = "all")
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    @GetMapping(path = "{id}")
    public Member getMemberByID(@PathVariable("id") int id) {
        return memberService.getMemberByID(id)
                .orElse(null);
    }

    @GetMapping(path = "region/{regionInput}")
    public Optional<List<Member>> getMembersInRegion(@PathVariable("regionInput") String region) {
        return memberService.getMembersInRegion(region);
    }


    @DeleteMapping(path = "{id}")
    public void deleteMember(@PathVariable("id") int id) {
        memberService.deleteMember(id);
    }

    @PutMapping(path = "{id}")
    public void updateMember(@PathVariable("id") int id, @Valid @NotNull @RequestBody Member member) {
        memberService.updateMember(id, member);
    }
}
