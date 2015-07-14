package me.xinito.redeemablecodes;

import java.util.logging.Logger;

import me.xinito.redeemablecodes.commands.Create;
import me.xinito.redeemablecodes.commands.Redeem;
import me.xinito.redeemablecodes.commands.Reward;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class RedeemableCodes extends JavaPlugin {
	
	//TODO Permissions.
	//TODO ??
	
	public static RedeemableCodes plugin;
	
	public static String prefix = ChatColor.YELLOW + "[RC] ";
	
	SettingsManager settings = SettingsManager.getInstance();
		
	Logger logger = Logger.getLogger("Minecraft");
	
	@Override
	public void onEnable() {
		
		plugin = this;
		settings.setup(this);
		
		this.getCommand("createkey").setExecutor(new Create(this));
		this.getCommand("redeem").setExecutor(new Redeem(this));
		this.getCommand("reward").setExecutor(new Reward(this));
		
		String path = "Rewards";
	    getConfig().addDefault(path, "");
	    getConfig().options().copyDefaults(true);
	    saveConfig();
	}
	
	@Override
	public void onDisable() {
		settings.saveKeys();
		saveConfig();
	}
}
