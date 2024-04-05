package com.sportsmanagement.controller;

import com.sportsmanagement.model.Ranks;
import com.sportsmanagement.service.RanksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ranks")
public class RanksController {

    @Autowired
    private RanksService ranksService;

    @PostMapping("/addRanks")
    public ResponseEntity<Ranks> addRanks(@RequestBody Ranks ranks) {
        Ranks newRanks = ranksService.addRanks(ranks);
        return new ResponseEntity<>(newRanks, HttpStatus.CREATED);
    }

    @PostMapping("/addMultipleRanks")
    public ResponseEntity<List<Ranks>> addRanks(@RequestBody List<Ranks> ranksList) {
        List<Ranks> newRanksList = ranksService.addRanks(ranksList);
        return new ResponseEntity<>(newRanksList, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteRank/{id}")
    public ResponseEntity<?> deleteRank(@PathVariable("id") int id) {
        ranksService.deleteRanks(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/allRanks")
    public ResponseEntity<List<Ranks>> getAllRanks() {
        List<Ranks> ranksList = ranksService.getAllRanks();
        return new ResponseEntity<>(ranksList, HttpStatus.OK);
    }

    @GetMapping("/rankById/{id}")
    public ResponseEntity<Ranks> getRankById(@PathVariable("id") int id) {
        Ranks ranks = ranksService.getRanksById(id);
        if (ranks != null) {
            return new ResponseEntity<>(ranks, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @GetMapping("/topODIRankedPlayers")
//    public ResponseEntity<List<Ranks>> getTopODIRankedPlayers() {
//        List<Ranks> ranksList = ranksService.getTopODIRankedPlayers();
//        return new ResponseEntity<>(ranksList, HttpStatus.OK);
//    }

    @PutMapping("/updateT20Rank/{id}")
    public ResponseEntity<Ranks> updateT20Rank(@PathVariable("id") int id, @RequestBody int rank) {
        Ranks updatedRanks = ranksService.updateT20Rank(id, rank);
        if (updatedRanks != null) {
            return new ResponseEntity<>(updatedRanks, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateODIRank/{id}")
    public ResponseEntity<Ranks> updateODIRank(@PathVariable("id") int id, @RequestBody int rank) {
        Ranks updatedRanks = ranksService.updateODIRank(id, rank);
        if (updatedRanks != null) {
            return new ResponseEntity<>(updatedRanks, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateTestRank/{id}")
    public ResponseEntity<Ranks> updateTestRank(@PathVariable("id") int id, @RequestBody int rank) {
        Ranks updatedRanks = ranksService.updateTestRank(id, rank);
        if (updatedRanks != null) {
            return new ResponseEntity<>(updatedRanks, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
