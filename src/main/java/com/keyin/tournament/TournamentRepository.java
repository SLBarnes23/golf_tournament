package com.keyin.tournament;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

import com.keyin.member.Member;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {
    @Query("SELECT t.members FROM Tournament t WHERE t.id = :tournamentId")
    List<Member> findMembersByTournamentId(@Param("tournamentId") Long tournamentId);

    // Search tournaments by start date
    List<Tournament> findByStartDate(LocalDate startDate);

    // Search tournaments by location
    List<Tournament> findByLocation(String location);

    // Search tournaments by participating member name
    @Query("SELECT t FROM Tournament t JOIN t.members m WHERE m.name = :memberName")
    List<Tournament> findTournamentsByMemberName(@Param("memberName") String memberName);
}
