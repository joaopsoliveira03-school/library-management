package Factory;

import Entity.Member;
import Entity.MemberId;
import ValueObject.Email;

public class MemberFactory {
    public static Member createMember(MemberId memberId, String name, String email) {
        return new Member(memberId, name, new Email(email));
    }
}
