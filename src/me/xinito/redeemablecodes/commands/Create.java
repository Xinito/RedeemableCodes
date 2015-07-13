package me.xinito.redeemablecodes.commands;


import java.util.List;
import java.util.Random;

import me.xinito.redeemablecodes.RedeemableCodes;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Create implements CommandExecutor {
	
	private RedeemableCodes plugin;
	
	public Create(RedeemableCodes plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		int length = args.length;
		
		Player player = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("create") && sender instanceof Player) {
			
			Random random = new Random();
			
			int key = random.nextInt(999999999) + 100000000;
			
			if (length == 0) {
				
				player.sendMessage(ChatColor.GREEN + "Random key: " + key);
				
				List<String> keys = plugin.getConfig().getStringList("Keys");
				keys.add(String.valueOf(Integer.valueOf((key))));
				plugin.getConfig().set("Keys", keys);
				plugin.saveConfig();				
			}
		}
		
		return false;
	}
}
