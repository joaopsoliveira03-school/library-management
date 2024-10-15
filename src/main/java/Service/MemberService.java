package Service;

import Entity.Member;
import Entity.MemberId;
import Exceptions.BusinessException;
import Factory.MemberFactory;
import Repository.IMemberRepository;
import ValueObject.Email;

public class MemberService {
    private final IMemberRepository memberRepository;

    public MemberService(IMemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member registerMember(MemberId memberId, String name, String email) {
        if (memberRepository.findByEmail(new Email(email)).isPresent()) {
            throw new BusinessException("Member with this email already exists");
        }
        Member member = MemberFactory.createMember(memberId, name, email);
        memberRepository.save(member);
        return member;
    }

    public void deleteMember(MemberId memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new BusinessException("Member not found"));
        memberRepository.delete(member);
    }
}