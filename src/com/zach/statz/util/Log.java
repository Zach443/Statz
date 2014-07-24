package com.zach.statz.util;

import java.util.logging.Logger;
import org.bukkit.Bukkit;

public class Log {

	private static final char COLOR_MC_CHAR = (char) 167;
        private static Logger logger;

	public static void info(String msg){
			logger.info(colorChat(msg));
	}
	public static void config(String msg){
			info(msg);
	}
	public static void warn(String msg){
			System.err.println(colorChat(msg));
	}
	public static void err(String msg){
			System.err.println(colorChat(msg));
	}

    public static String colorChat(String msg) {
        return msg.replace('&', (char) 167);
    }
	public static void debug(String string) {
		System.out.println(string);
	}

    public static void setLogger(Logger logger) {
        Log.logger = logger;
    }

}