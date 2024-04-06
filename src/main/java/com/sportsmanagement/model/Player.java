package com.sportsmanagement.model;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Entity
@Table(name = "Player")
public class Player {
	
		@Id
		@Column(name = "id")
		private int id;
	
	  @Column(name = "player_name")
	  @Pattern(regexp = "^[a-zA-Z]+$", message = "Name must contain only letters")
	  private String name;
	
	  @Column(name = "player_age")
	  @Min(value = 20, message = "Age must be atleast 20")
	  @Max(value = 45, message = "Age must be atleast 45")
	  private int age;
	
	  @Column(name = "player_department")
	  private String department;
	
	  @OneToOne(cascade = CascadeType.ALL, mappedBy = "player")
	  @PrimaryKeyJoinColumn
	    private Ranks ranks;

	  
	  
		public Player(int id, String name, int age, String department, Ranks ranks) {
			super();
			this.id = id;
			this.name = name;
			this.age = age;
			this.department = department;
			this.ranks = ranks;
			this.ranks.setPlayer(this);
		}



		public Player() {
			super();
		}



		public Player(int id, String name, int age, String department) {
			super();
			this.id = id;
			this.name = name;
			this.age = age;
			this.department = department;
		}
	
	
}	