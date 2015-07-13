package me.xinito.redeemablecodes;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import me.xinito.redeemablecodes.commands.Create;
import me.xinito.redeemablecodes.commands.Redeem;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class RedeemableCodes extends JavaPlugin {
	
	public static RedeemableCodes plugin;
	
	//TODO Permissions.
	//TODO Remove key after being redeemed.
	//TODO Rewards
	//TODO ??
	
	Logger logger = Logger.getLogger("Minecraft");
	
	@Override
	public void onEnable() {
		plugin = this;
		create();
		
		this.getCommand("create").setExecutor(new Create(this));
		this.getCommand("redeem").setExecutor(new Redeem(this));
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public void create() {
		File folder = new File(this.getDataFolder() + "/");
		folder.mkdirs();
		File f = new File(this.getDataFolder() + "/" + "keys.yml");
		
		if (!f.exists()) {
			try {
				f.createNewFile();
				
				FileConfiguration fc = YamlConfiguration.loadConfiguration(f);
				
				fc.set("Keys", "0");
				
				try {
					fc.save(f);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 
	}
	
	/*
	public void set(String path, String NumberAsString) {
		File folder = new File(this.getDataFolder() + "/");
		folder.mkdirs();
		File f = new File(this.getDataFolder() + "/" + "keys.yml");
		
		if (f.exists()) {
				
			FileConfiguration fc = YamlConfiguration.loadConfiguration(f);
				
			fc.set(path, NumberAsString);
				
			try {
				fc.save(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public Object get(String path) {
		File folder = new File(this.getDataFolder() + "/");
		folder.mkdirs();
		File f = new File(this.getDataFolder() + "/" + "keys.yml");
		
		if (f.exists()) {
			FileConfiguration fc = YamlConfiguration.loadConfiguration(f);
			Object result = fc.get(path);
        
			return result;
        
		} else{
			return null;
		}
	}
	*/
}
