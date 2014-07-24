package com.zach.statz.util;

import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zach.statz.Statz;

public class MySQL {

	public boolean tableContainsPlayer(Player player) {
		try {
			PreparedStatement sql = Statz.connection.prepareStatement("SELECT * FROM 'player_data' WHERE uuid=?");
			sql.setString(1, player.getUniqueId().toString());
			ResultSet resultSet = sql.executeQuery();
			boolean containsPlayer = resultSet.next();
			
			resultSet.close();
			sql.close();
			return containsPlayer;
			
		} catch (SQLException e) {
			e.printStackTrace();
			Log.warn("An error has occured while checking the database. Please check your config for errors!");
			
		}
		return false;
	}
	
	
}
