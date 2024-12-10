package com.keyin.tournament;

import com.keyin.member.Member;
import com.keyin.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private MemberRepository memberRepository;

    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    public Optional<Tournament> getTournamentById(Long id) {
        return tournamentRepository.findById(id);
    }

    public Tournament addTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    public Optional<Tournament> updateTournament(Long id, Tournament updatedTournament) {
        return tournamentRepository.findById(id).map(tournament -> {
            tournament.setStartDate(updatedTournament.getStartDate());
            tournament.setEndDate(updatedTournament.getEndDate());
            tournament.setLocation(updatedTournament.getLocation());
            tournament.setEntryFee(updatedTournament.getEntryFee());
            tournament.setCashPrizeAmount(updatedTournament.getCashPrizeAmount());
            return tournamentRepository.save(tournament);
        });
    }

    public void deleteTournament(Long id) {
        tournamentRepository.deleteById(id);
    }

    public Optional<Tournament> addMembersToTournament(Long tournamentId, Set<Long> memberIds) {
        return tournamentRepository.findById(tournamentId).map(tournament -> {
            Set<Member> members = memberRepository.findAllById(memberIds).stream().collect(Collectors.toSet());
            tournament.getMembers().addAll(members);
            return tournamentRepository.save(tournament);
        });
    }
}
