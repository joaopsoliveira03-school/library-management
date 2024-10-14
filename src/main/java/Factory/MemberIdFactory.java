package Factory;

import Entity.MemberId;

public class MemberIdFactory {
    public static MemberId createMemberId(String id) {
        return new MemberId(id);
    }
}
