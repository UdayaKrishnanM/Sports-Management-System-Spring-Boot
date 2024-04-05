package com.sportsmanagement.service;

import com.sportsmanagement.dao.RanksRepository;
import com.sportsmanagement.model.Ranks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RanksService {

    @Autowired
    private RanksRepository ranksRepository;

    public Ranks addRanks(Ranks ranks) {
        return ranksRepository.save(ranks);
    }

    public List<Ranks> addRanks(List<Ranks> ranksList) {
        return ranksRepository.saveAll(ranksList);
    }

    public void deleteRanks(int id) {
        ranksRepository.deleteById(id);
    }

    public List<Ranks> getAllRanks() {
        return ranksRepository.findAll();
    }

    public Ranks getRanksById(int id) {
        Optional<Ranks> ranksOptional = ranksRepository.findById(id);
        return ranksOptional.orElse(null);
    }

//    public List<Ranks> getTopODIRankedPlayers() {
//        return ranksRepository.findTopODIRankedPlayers();
//    }

    public Ranks updateT20Rank(int id, int rank) {
        Ranks ranks = ranksRepository.findById(id).orElse(null);
        if (ranks != null) {
            ranks.setT20_rank(rank);
            return ranksRepository.save(ranks);
        }
        return null;
    }

    public Ranks updateODIRank(int id, int rank) {
        Ranks ranks = ranksRepository.findById(id).orElse(null);
        if (ranks != null) {
            ranks.setOdi_rank(rank);
            return ranksRepository.save(ranks);
        }
        return null;
    }

    public Ranks updateTestRank(int id, int rank) {
        Ranks ranks = ranksRepository.findById(id).orElse(null);
        if (ranks != null) {
            ranks.setTest_rank(rank);
            return ranksRepository.save(ranks);
        }
        return null;
    }
}
