package com.example.makeup.dto;


import com.example.makeup.constant.Role;
import com.example.makeup.entity.Member;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class MemberDTO {

    private Long id;

    @NotBlank
    @Size(min = 2, max = 10, message = "이름은 2자 이상 10자이하로 작성해주세요")
    private String name;


    @NotBlank
    @Size(min = 6, max = 15, message = "특수문자 포함")
    private String password;


    private int tel;

    @Email(message = "이메일 형식으로 작성해주세요.")
    @NotBlank(message = "이메일을 작성해주세요.")
    @Size(min = 10,max = 30,message = "이메일은 10자이상 30자이하로 작성해주세요.")
    private String email;

    private String address;

    private Role role;

    public Member dtoToEntity(MemberDTO memberDTO) {
        PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

        Member member= new Member();
        member.setName(memberDTO.getName());
        member.setPassword(passwordEncoder.encode(memberDTO.getPassword()));
        member.setTel(memberDTO.getTel());

        member.setEmail(memberDTO.getEmail());
        member.setAddress(memberDTO.getAddress());
        member.setRole(Role.ADMIN);

        return member;

    }



}



