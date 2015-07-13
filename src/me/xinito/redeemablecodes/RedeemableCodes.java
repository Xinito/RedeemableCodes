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
	
	SettingsManager settings = SettingsManager.getInstance();
	
	//TODO Permissions.
	//TODO Remove key after being redeemed.
	//TODO Rewards
	//TODO ??
	
	Logger logger = Logger.getLogger("Minecraft");
	
	@Override
	public void onEnable() {
		
		plugin = this;
		settings.setup(this);
		
		this.getCommand("create").setExecutor(new Create(this));
		this.getCommand("redeem").setExecutor(new Redeem(this));
	}
	
	@Override
	public void onDisable() {
		settings.saveKeys();
	}
}
