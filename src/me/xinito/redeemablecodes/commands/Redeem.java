package me.xinito.redeemablecodes.commands;

import java.util.List;
import java.util.Random;

import me.xinito.redeemablecodes.RedeemableCodes;
import me.xinito.redeemablecodes.SettingsManager;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Redeem implements CommandExecutor {
	
	private RedeemableCodes plugin;
	
	public Redeem(RedeemableCodes plugin) {
		this.plugin = plugin;
	}
	
	SettingsManager settings = SettingsManager.getInstance();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		int length = args.length;
		
		Player player = (Player) sender;
		
    	if (!sender.hasPermission("rc.redeem"))
        {
          sender.sendMessage(ChatColor.RED + "No permission!");
          return true;
        }
		
		if (cmd.getName().equalsIgnoreCase("redeem") && sender instanceof Player) {
			if (length == 1) {
				
				List<String> keys = settings.getKeys().getStringList("Keys");
				List<String> list = plugin.getConfig().getStringList("Rewards");
				Random r = new Random();
				String material = list.get(r.nextInt(list.size()));
				
				if (keys.contains(args[0])) {
					if (material == null) {
						player.sendMessage(plugin.prefix + ChatColor.RED + "No rewards have been added yet.");
					} else {
						player.getInventory().addItem(this.reward(Material.getMaterial(material)));
						player.sendMessage(plugin.prefix + ChatColor.GREEN + "Succesfully redeemed your" + ChatColor.YELLOW + " key!");
						keys.remove(String.valueOf(Integer.valueOf(args[0])));
						settings.getKeys().set("Keys", keys);
						settings.saveKeys();
					}
					
				} else {
					player.sendMessage(ChatColor.RED + "Incorrect key!");
				}
			} else {
				player.sendMessage(ChatColor.RED + "Incorrect args!");
			}
		}
		
		return false;
	}
	
    public ItemStack reward(Material material) {
		
    	ItemStack item = new ItemStack(material);
    	
    	return item;
    	
    }
}