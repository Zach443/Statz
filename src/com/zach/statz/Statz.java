package com.zach.statz;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.zach.statz.util.EventListener;

import java.sql.Connection;


public class Statz extends JavaPlugin implements Listener{

	public static Connection connection;
	
	public Logger logger = getLogger();
	
	public String address;
	public String username;
	public String password;
	
	static Statz plugin;
	
	public void onEnable() {
		saveDefaultConfig();
		Statz.plugin = this;
		
		saveConfig();
		getServer().getPluginManager().registerEvents(new EventListener(), this);
		getConfig().options().copyDefaults();
		
		this.address = getConfig().getString("IP");
		this.password = getConfig().getString("password");
		this.username = getConfig().getString("username");
		
		saveConfig();
	}
	
	public void onDisable() {
		
	}
	
	public void openConnection() {
		try {
			connection = DriverManager.getConnection(address, username, password);
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
	
}
