package com.sportsmanagement.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sportsmanagement.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer>{
//
//	@Query("SELECT p.id, p.player_name, r.:role_rank " +
//		       "FROM Player p " +
//		       "JOIN Ranks r ON p.id= r.id " +
//		       "WHERE p.player_department = :department AND r.:role_rank IS NOT NULL " +
//		       "ORDER BY r.:role_rank  ASC LIMIT :limit")
//	@Query("SELECT p FROM Player p")
//	List<Player> topPlayers(String department, String role, int limit);
//	@Query("SELECT p FROM Player p JOIN FETCH p.ranks r WHERE p.department = :department AND " +
//            "((:role = 'Batsmen' AND r.odi_rank IS NOT NULL) OR " +
//            "(:role = 'Wicketkeeper' AND r.odi_rank IS NOT NULL) OR " +
//            "(:role = 'Allrounder' AND r.odi_rank IS NOT NULL) OR " +
//            "(:role = 'Bowler' AND r.odi_rank IS NOT NULL)) " +
//            "ORDER BY r.odiRank ASC, r.odi_rank ASC, r.testRank ASC")
//    @Query("SELECT p FROM Player p JOIN FETCH p.ranks r ON p.id = r.id WHERE p.department = ?1 AND r.?2 IS NOT NULL ORDER BY r.?3 ASC LIMIT ?2")
//	@Query(value = "SELECT p.* FROM Player p JOIN Ranks r ON p.id = r.player_id WHERE p.player_department = ?1 AND r.role = ?2 ORDER BY r.rank ASC LIMIT ?3", nativeQuery = true)
//

//	@Query("SELECT p FROM Player p JOIN p.ranks r WHERE p.department = :department AND (r.t20_rank IS NOT NULL OR r.odi_rank IS NOT NULL OR r.test_rank IS NOT NULL) ORDER BY CASE "
//			+ "WHEN :role = 't20' THEN r.t20_rank "
//			+ "WHEN :role = 'odi' THEN r.odi_rank "
//			+ "WHEN :role = 'test' THEN r.test_rank "
//			+ "ELSE 0 END ASC LIMIT :limit")


//	List<Player> topPlayers(String department, String role, PageRequest pageRequest);

	
}