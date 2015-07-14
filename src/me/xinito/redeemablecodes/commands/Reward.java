package me.xinito.redeemablecodes.commands;

import java.util.List;

import me.xinito.redeemablecodes.RedeemableCodes;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Reward implements CommandExecutor {
	
	private RedeemableCodes plugin;
	
	public Reward(RedeemableCodes plugin) {
		this.plugin = plugin;
	}
	
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	Player player = (Player) sender;
               
    	if (!sender.hasPermission("rc.reward.add"))
        {
          sender.sendMessage(ChatColor.RED + "No permission!");
          return true;
        }
    	
    	if(!(sender instanceof Player)){
        	sender.sendMessage(ChatColor.RED + "Only players can do this!");
        	return true;
        }
               
        if(cmd.getName().equalsIgnoreCase("reward")){
                       
        	if(args.length == 0){
        		player.sendMessage(ChatColor.RED + "Incorrect args");
        	}
        	if(args.length == 1){
        		player.sendMessage(ChatColor.RED + "Incorrect args");
        	}
        	if (args.length == 2) {
        		if (args[0].equalsIgnoreCase("add")) {
        			List<String> list = plugin.getConfig().getStringList("Rewards");
        			list.add(args[1]);
        			plugin.getConfig().set("Rewards", list);
        			plugin.saveConfig();
        			player.sendMessage(plugin.prefix + ChatColor.GREEN + "Successfully added: " + ChatColor.YELLOW + args[1]);
        		}
        	}
        }
        
        return false;
   }
}
