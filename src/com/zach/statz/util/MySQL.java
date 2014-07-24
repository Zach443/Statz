package com.zach.statz.util;

import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zach.statz.Statz;

public class MySQL {

    public boolean tableContainsPlayer(Player player) {
        PreparedStatement pCheck;
        ResultSet results;
        int x = 0;
        try {
            pCheck = Statz.connection.prepareStatement("SELECT * FROM 'PlayerData' WHERE name=?");
            pCheck.setString(1, player.getName());
            results = pCheck.executeQuery();
            x = results.getInt("logins");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (0 >= 1) {
            return true;
        }
        return false;
    }
}
