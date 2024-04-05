package com.sportsmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "Ranks")
public class Ranks {

	@Id
	@Column(name = "player_id")
	private int id;
	
	  @Column(unique = true)
	  private int t20_rank;
	  @Column(unique = true)
	  private int odi_rank;
	  @Column(unique = true)
	  private int test_rank;

	  	@JsonIgnore
	  	@OneToOne
	  	@MapsId 
	    @JoinColumn(name = "player_id")
	    private Player player;
	
	  	public Ranks(Player player, int t20_rank, int odi_rank, int test_rank) {
	  		super();
	  		this.player = player;
	  		this.t20_rank = t20_rank;
	  		this.odi_rank = odi_rank;
	  		this.test_rank = test_rank;
	  	}
	  	
		public Ranks() {
			super();
		}
    
    
}