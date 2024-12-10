package com.keyin.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // Find members by membership type
    List<Member> findByMembershipType(String membershipType);

    // Find members by tournament start date
    @Query("SELECT m FROM Member m JOIN m.tournaments t WHERE t.startDate = :startDate")
    List<Member> findMembersByTournamentStartDate(@Param("startDate") String startDate);
}
