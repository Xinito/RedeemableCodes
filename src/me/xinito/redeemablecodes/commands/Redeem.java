package me.xinito.redeemablecodes.commands;

import me.xinito.redeemablecodes.RedeemableCodes;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Redeem implements CommandExecutor {
	
	private RedeemableCodes plugin;
	
	public Redeem(RedeemableCodes plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		int length = args.length;
		
		Player player = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("redeem") && sender instanceof Player) {
			if (length == 1) {
				String validKey = plugin.getConfig().getString("Keys");
				
				if (validKey.contains(args[0])) {
					player.sendMessage(ChatColor.YELLOW + "Matching key!");
				} else {
					player.sendMessage(ChatColor.RED + "Incorrect key!");
				}
			} else {
				player.sendMessage(ChatColor.RED + "Incorrect args!");
			}
		}
		
		return false;
	}
}
