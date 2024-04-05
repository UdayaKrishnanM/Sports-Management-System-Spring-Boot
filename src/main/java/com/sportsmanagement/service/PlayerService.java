package com.sportsmanagement.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportsmanagement.dao.PlayerRepository;
import com.sportsmanagement.dao.RanksRepository;
import com.sportsmanagement.model.Player;
import com.sportsmanagement.model.Ranks;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private RanksRepository ranksRepository;

    
    
//	worked not now ?
    public Player addPlayer(Player player) {
        Ranks ranks = player.getRanks();
        if (ranks != null) {
        	//setPlayer 1st, then rankRe.save(ranks)
        	ranks.setPlayer(player);
        	ranks = ranksRepository.save(ranks);
        }
        player.setRanks(ranks);
        return playerRepository.save(player);
    }

    
    // old code
//    public Player addPlayer(Player player) {
//        return playerRepository.save(player);
//    }

    public List<Player> addPlayers(List<Player> players) {
    	for (Player player : players) {
            if (player.getRanks() != null) {
                player.getRanks().setPlayer(player);
            }
        }
        return playerRepository.saveAll(players);
//    	old code
//    	return playerRepository.saveAll(players);
    }

    	
    	

    public String deletePlayer(int id) {
        playerRepository.deleteById(id);
        return "Player removed with id: " + id;
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayerById(int id) {
        return playerRepository.findById(id).orElse(null);
    }

//    public List<Player> getTopPlayers() {
//        List<Player> batsmen = playerRepository.topPlayers("ODI", "Batsmen", 5);
//        List<Player> wicketKeepers = playerRepository.topPlayers("ODI", "Wicketkeeper", 1);
//        List<Player> allRounders = playerRepository.topPlayers("ODI", "Allrounder", 2);
//        List<Player> bowlers = playerRepository.topPlayers("ODI", "Bowler", 3);
//
//        List<Player> topPlayers = new ArrayList();
//        topPlayers.addAll(batsmen);
//        topPlayers.addAll(wicketKeepers);
//        topPlayers.addAll(allRounders);
//        topPlayers.addAll(bowlers);
//        
////		not working code
////        List<Player> top11Players = topPlayers.stream()
////                .limit(11)
////                .collect(Collectors.toList());
////
//        return topPlayers;
//    }
    

    public Player updatePlayerDepartment(int id, String department) {
        Player player = playerRepository.findById(id).orElse(null);
        if (player != null) {
            player.setDepartment(department);
            return playerRepository.save(player);
        }
        return null;
    }

    
    public Player updatePlayerAge(int id, int age) {
        Player player = playerRepository.findById(id).orElse(null);
        if (player != null) {
            player.setAge(age);
            return playerRepository.save(player);
        }
        return null;
    }
	
}







//	@Autowired
//    private PlayerRepository playerRepository;
//
//    public PlayerService(PlayerRepository playerRepository) {
//        this.playerRepository = playerRepository;
//    }
//
//    public List<Player> getAllPlayers() {
//        return playerRepository.findAll();
//    }
//
//    public Player getPlayerById(int id) {
//        Optional<Player> playerOptional = playerRepository.findById(id);
//        return playerOptional.orElse(null);
//    }
//
//    public void addPlayer(Player player) {
//        playerRepository.save(player);
//    }
//
//    public void updatePlayer(Player player) {
//        playerRepository.save(player);
//    }
//
//    public void deletePlayer(int id) {
//        playerRepository.deleteById(id);
//    }