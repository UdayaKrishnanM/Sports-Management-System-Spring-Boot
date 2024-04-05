package com.sportsmanagement.model;


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
	  private String name;
	
	  @Column(name = "player_age")
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


//	working 
//{
//"id": 1,
//"name": "Player Name",
//"age": 25,
//"department": "Player Department",
//"ranks": {
//"id":5,
//"t20_rank": 41,
//"odi_rank": 42,
//"test_rank": 43
//}
//}

//    @Id
//    @PrimaryKeyJoinColumn
//    @Column(name = "player_id")
//    private int id;
//
//    @Column(name = "player_name")
//    private String name;
//
//    @Column(name = "player_age")
//    private int age;
//
//    @Column(name = "player_department")
//    private String department;
//
//    @OneToOne(mappedBy = "player", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Ranks ranks;
//
//    public Player() {
//    }
//
//    public Player(int id, String name, int age, String department, Ranks ranks) {
//        this.id = id;
//        this.name = name;
//        this.age = age;
//        this.department = department;
//        this.ranks = ranks;
//    }
//
//    // Getters and setters
//    
//
//    @Override
//    public String toString() {
//        return "Player{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", age=" + age +
//                ", department='" + department + '\'' +
//                ", ranks=" + ranks +
//                '}';
//    }
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public int getAge() {
//		return age;
//	}
//
//	public void setAge(int age) {
//		this.age = age;
//	}
//
//	public String getDepartment() {
//		return department;
//	}
//
//	public void setDepartment(String department) {
//		this.department = department;
//	}
//
//	public Ranks getRanks() {
//		return ranks;
//	}
//
//	public void setRanks(Ranks ranks) {
//		this.ranks = ranks;
//	}
//}
//
//
//
