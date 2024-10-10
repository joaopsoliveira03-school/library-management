package Specification;

import Entity.Member;

public class MemberIsNotSuspendedSpecification implements Specification<Member> {
    @Override
    public boolean isSatisfiedBy(Member member) {
        return !member.isSuspended();
    }
}