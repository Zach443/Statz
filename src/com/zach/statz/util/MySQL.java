package com.zach.statz.util;

import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zach.statz.Statz;

public class MySQL {

	public boolean tableContainsPlayer(Player player) {
		PreparedStatement pCheck; 
		try {
			pCheck = Statz.connection.prepareStatement("SELECT * FROM 'PlayerData' WHERE name=?");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}


}
