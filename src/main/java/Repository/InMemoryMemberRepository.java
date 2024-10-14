package Repository;

import Entity.Member;
import Entity.MemberId;
import ValueObject.Email;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryMemberRepository implements IMemberRepository {
    private final List<Member> members;

    public InMemoryMemberRepository() {
        members = new ArrayList<>();
    }

    @Override
    public void save(Member member) {
        members.add(member);
    }

    @Override
    public Optional<Member> findById(MemberId id) {
        return members.stream()
                      .filter(member -> member.getId().equals(id))
                      .findFirst();
    }

    @Override
    public Optional<Member> findByEmail(Email email) {
        return members.stream()
                      .filter(member -> member.getEmail().equals(email))
                      .findFirst();
    }

    @Override
    public List<Member> findAll() {
        return members;
    }

    @Override
    public void delete(Member member) {
        members.remove(member);
    }
}
