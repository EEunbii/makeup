package com.example.makeup.controller;

import com.example.makeup.dto.MemberDTO;
import com.example.makeup.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
@Log4j2
public class MemberController {

    private final MemberService memberService;


   //회원가입
    @GetMapping("/register")
    public String userForm(Model model){
        model.addAttribute("memberDTO" , new MemberDTO());

        return "member/memberForm";
    }
    @PostMapping("/register")
    public String memberFormPost(@Valid MemberDTO memberDTO, BindingResult bindingResult, Model model){

        log.info("");
        if(bindingResult.hasErrors()) {
            return "member/memberForm";

        }

        try{
            memberService.saveMember(memberDTO);
        }catch (IllegalStateException e){

            model.addAttribute("msg",e.getMessage());

            return  "member/memberForm";
        }
        return null;
    }

    //로그인
    @GetMapping("/login")
    public String loginMember(){
        return "/member/loginForm";
    }



}
