package com.sportsmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.sportsmanagement.dao.PlayerRepository;
import com.sportsmanagement.model.Player;
import com.sportsmanagement.model.Ranks;
import com.sportsmanagement.service.PlayerService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;
    
    @Autowired
    private PlayerRepository playerRepository;

    public PlayerController(PlayerService playerService) {
    	super();
    	this.playerService = playerService;
    }
    
    
    //working
    @GetMapping("/")
    public String home(Model model) {
    	List<Player> players = playerService.getAllPlayers();
        model.addAttribute("players", players);
        return "index"; // Assuming index.jsp is your home page````		
    }
    

//below is working perfectly
    @GetMapping("/addPlayer")
    public String showAddPlayerForm() {
    	return "addPlayer";
    }

    @PostMapping("/addPlayer")
    public String addPlayer(@ModelAttribute Player player, Model model) {
    	
    	if(!player.getName().matches("[a-zA-Z]+")) {
    		model.addAttribute("error", "Name must contain only letters");
        	return "addPlayer";
    	} else if(player.getAge()<20 || player.getAge()>45) {
    		model.addAttribute("error", "Age must be between 20 and 45");
        	return "addPlayer";
    	} else if(playerRepository.existsById(player.getId())) {
    		model.addAttribute("error", "ID already exists");
        	return "addPlayer";
    	} else if(playerRepository.existsById(player.getRanks().getT20_rank())) {
    		model.addAttribute("error", "T20 rank already exists");
    		return "addPlayer";
    	} else if(playerRepository.existsById(player.getRanks().getOdi_rank())) {
    		model.addAttribute("error", "ODI rank already exists");
    		return "addPlayer";
    	} else if(playerRepository.existsById(player.getRanks().getTest_rank())) {
    		model.addAttribute("error", "TEST rank already exists");
    		return "addPlayer";
    	}
    	else {
			Ranks ranks = new Ranks();
		    ranks.setT20_rank(player.getRanks().getT20_rank());
		    ranks.setOdi_rank(player.getRanks().getOdi_rank());
		    ranks.setTest_rank(player.getRanks().getTest_rank());
		    player.setRanks(ranks);
			playerService.addPlayer(player);
		    return "redirect:/players/";
    	}
    }

    @PostMapping("/checkIdExists/{id}")
    @ResponseBody
    public boolean checkIdExists(@RequestParam int id) {
    	
    	boolean idExists = playerService.checkIdExists(id);
    	
    	return idExists;
    }
    
// above is working perfectly
    
    
    @GetMapping("/listPlayers")
    public ModelAndView listPlayers() {
    	ModelAndView mv = new ModelAndView();
    	List<Player> player = playerService.getAllPlayers();
    	mv.addObject("players", player);
    	mv.setViewName("listPlayers");
    	return mv;
    }

    
    
    //working
    @PostMapping("/addAll")
    public ResponseEntity<List<Player>> addPlayers(@RequestBody List<Player> players) {
        List<Player> newPlayers = playerService.addPlayers(players);
        return new ResponseEntity<>(newPlayers, HttpStatus.CREATED);
    }

    
    
    //below DELETE WORKING
    @GetMapping("/deletePlayer")
    public String showDeletePlayerForm() {
        return "deletePlayer";
    }

    @PostMapping("/deletePlayer")
    public String deletePlayer(@RequestParam("id") int id, Model model) {
    	Optional<Player> opt = playerRepository.findById(id);
    	if(opt.isPresent()) {
    		playerService.deletePlayer(id);
    		model.addAttribute("error", "Player with ID " + id +" deleted successfully");
    	} else {
    		model.addAttribute("error", "Player with ID " + id + " not found");
    	}
    	return "deletePlayer";
    }
    //above code DELETE WORKING
    

    //working
    @GetMapping("/getById/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable("id") int id) {
        Player player = playerService.getPlayerById(id);
        return new ResponseEntity<>(player, player != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping("/pickTopPlayers")
    public String getTopPlayersFromODIRank() {
//        List<Player> topPlayers = playerService.getTopPlayers();
        return "pickTopPlayers";
    }

    
    
    //below Update Code working
    @GetMapping("/updatePlayer")
    public String showUpdatePlayerForm() {
        return "updatePlayer";
    }

    @PostMapping("/updatePlayer")
    public String updatePlayer(@RequestParam int id, @RequestParam String type, @RequestParam String value, Model model) {
        if(!playerService.checkIdExists(id)) {
        	model.addAttribute("message", "Player with ID " + id + " not found");
        	return "updatePlayer";
        }
    	if ("age".equalsIgnoreCase(type)) {
            playerService.updatePlayerAge(id, Integer.parseInt(value));
            model.addAttribute("message", "Player with ID " + id + "'s age was updated");
        	return "updatePlayer";
    	} else if ("department".equalsIgnoreCase(type)) {
    		playerService.updatePlayerDepartment(id, value);
            model.addAttribute("message", "Player with ID " + id + "'s department was updated");
        	return "updatePlayer";

    	}
        return "updatePlayer";
    }
    
    //above Update code working
    
}

