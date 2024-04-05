package com.sportsmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.sportsmanagement.model.Player;
import com.sportsmanagement.service.PlayerService;

import java.util.List;

@Controller
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

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
    

    // below done
    @GetMapping("/addPlayer")
    public String showAddPlayerForm() {
    	return "addPlayer";
    }
    
    @PostMapping("/addPlayer")
    public String addPlayer(Player player) {
        playerService.addPlayer(player);
        return "redirect:/players/";
    }
    
    //above done

    
    // get and put for add All Players
    
    
    
    
    // list all players

//	working
//    @GetMapping("/showPlayers")
//    public String showPlayers(Model model) {
//      List<Player> players = playerService.getAllPlayers();
//      model.addAttribute("players", players);
//    	return "showPlayers";
//    }

    @GetMapping("/listPlayers")
    public ModelAndView listPlayers() {
    	ModelAndView mv = new ModelAndView();
    	List<Player> player = playerService.getAllPlayers();
    	mv.addObject("players", player);
    	mv.setViewName("listPlayers");
    	return mv;
    }
//    public String listPlayers(Model model) {
//        List<Player> players = playerService.getAllPlayers();
//        model.addAttribute("players", players);
//        return "listPlayers";
//    }
    
    
    // list all players
    
    
    
    //working
    @PostMapping("/addAll")
    public ResponseEntity<List<Player>> addPlayers(@RequestBody List<Player> players) {
        List<Player> newPlayers = playerService.addPlayers(players);
        return new ResponseEntity<>(newPlayers, HttpStatus.CREATED);
    }

    
    
    
    
    
    
    
    
    
    @GetMapping("/deletePlayer")
    public String showDeletePlayerForm() {
        return "deletePlayer";
    }

    @PostMapping("/deletePlayer")
    public String deletePlayer(@RequestParam int id) {
        playerService.deletePlayer(id);
        return "redirect:/players/";
    }




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

    
    @GetMapping("/updatePlayer")
    public String showUpdatePlayerForm() {
        return "updatePlayer";
    }

    @PostMapping("/updatePlayer")
    public String updatePlayer(@RequestParam int id, @RequestParam String type, @RequestParam String value) {
        if ("age".equals(type)) {
            playerService.updatePlayerAge(id, Integer.parseInt(value));
        } else if ("department".equals(type)) {
            playerService.updatePlayerDepartment(id, value);
        }
        return "redirect:/players/";
    }
    
    
}






//	@Autowired
//    private final PlayerService playerService;
//
//    public PlayerController(PlayerService playerService) {
//        this.playerService = playerService;
//    }
//
//    @GetMapping("/list")
//    public String listPlayers(Model model) {
//        List<Player> players = playerService.getAllPlayers();
//        model.addAttribute("players", players);
//        return "player/list";
//    }
//
//    @GetMapping("/add")
//    public String showAddPlayerForm(Model model) {
//        model.addAttribute("player", new Player());
//        return "player/form";
//    }
//
//    @PostMapping("/add")
//    public String addPlayer(@Valid @ModelAttribute("player") Player player, BindingResult result) {
//        if (result.hasErrors()) {
//            return "player/form";
//        }
//        playerService.addPlayer(player);
//        return "redirect:/players/list";
//    }
//
//    @GetMapping("/update/{id}")
//    public String showUpdatePlayerForm(@PathVariable("id") int id, Model model) {
//        Player player = playerService.getPlayerById(id);
//        model.addAttribute("player", player);
//        return "player/form";
//    }
//
//    @PostMapping("/update/{id}")
//    public String updatePlayer(@PathVariable("id") int id, @Valid @ModelAttribute("player") Player player, BindingResult result) {
//        if (result.hasErrors()) {
//            return "player/form";
//        }
//        playerService.updatePlayer(player);
//        return "redirect:/players/list";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String deletePlayer(@PathVariable("id") int id) {
//        playerService.deletePlayer(id);
//        return "redirect:/players/list";
//    }

