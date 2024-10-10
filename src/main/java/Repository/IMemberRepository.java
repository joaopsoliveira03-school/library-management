package Repository;

import Entity.Member;
import Entity.MemberId;
import ValueObject.Email;

import java.util.List;
import java.util.Optional;

public interface IMemberRepository {
    void save(Member member);
    Optional<Member> findById(MemberId id);
    Optional<Member> findByEmail(Email email);
    List<Member> findAll();
    void delete(Member member);
}