package com.example.makeup.service;


import com.example.makeup.dto.MemberDTO;
import com.example.makeup.entity.Member;
import com.example.makeup.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@Transactional
@RequiredArgsConstructor

public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;

    //로그인

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Member member=
             memberRepository.findByEmail(email);

        if(member==null){
            throw new UsernameNotFoundException(email);

        }
        return User.builder()
                .username(member.getEmail())
                .password(member.getPassword())//로그인시 입력한 비밀번호와 비교할값
                .roles(String.valueOf(member.getRole()))
                .build();
    }

        //회원가입

    public Member saveMember(MemberDTO memberDTO) {
        //회원가입여부 확인
        validateDuplicateMember(memberDTO.getEmail());

        Member member =
                memberDTO.dtoToEntity(memberDTO);

        member =
                memberRepository.save(member);
        return null;
    }

    //회원가입시 회원 가입여부 확인하는 메소드

    private void validateDuplicateMember(String email){


        Member member=
                memberRepository.findByEmail(email);

        if(member !=null){
            throw new IllegalStateException("이미 가입된 회원입니다.");

        }


    }


}





