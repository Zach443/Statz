package com.zach.statz;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.zach.statz.util.EventListener;
import com.zach.statz.util.Log;

import java.sql.Connection;


public class Statz extends JavaPlugin implements Listener{

	public static Connection connection;
	
        public boolean debug;
        public String host;
	public String username;
	public String password;
        public String port;
        public String database;
	
	static Statz plugin;
	
	public void onEnable() {
		saveDefaultConfig();
                
		getServer().getPluginManager().registerEvents(new EventListener(), this);
		
                this.debug = getConfig().getBoolean("Debug");
		this.host = getConfig().getString("MySQL.Host");
                this.username = getConfig().getString("MySQL.Username");
		this.password = getConfig().getString("MySQL.Password");
                this.port = getConfig().getString("MySQL.Port");
                this.database = getConfig().getString("MySQL.Database");
                
                this.debug("Host = " + host);
                this.debug("username = " + username);
                this.debug("password = " + password);
                this.debug("port = " + port);
                this.debug("database = " + database);
		
                Statz.plugin = this;
	}
	
	public void onDisable() {
		
	}
        
	public void openConnection() {
		try {
                    // "jdbc:mysql://localhost:3306/Database?user=root&password="
                        connection = DriverManager
                    .getConnection("jdbc:mysql://"
                    + host + ":"
                    + port + "/"
                    + database + "?"
                    + "user=" + username + "&"
                    + "password=" + password);
		} catch (SQLException e) {
			e.printStackTrace();
			getLogger().log(Level.SEVERE, "Connection to database failed, please check your config!");
		}
	}
	
	public void closeConnection() {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Statz getSelf() {
		return plugin;
	}
        
        public void debug(String msg) {
            if (this.debug) {
                Log.info(msg);
            }
        }
	
}
