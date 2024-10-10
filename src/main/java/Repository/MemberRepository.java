package Repository;

import Entity.Member;
import Entity.MemberId;
import ValueObject.Email;

import java.util.List;
import java.util.Optional;

public class MemberRepository implements IMemberRepository {
    @Override
    public void save(Member member) {

    }

    @Override
    public Optional<Member> findById(MemberId id) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByEmail(Email email) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return List.of();
    }

    @Override
    public void delete(Member member) {

    }
}
