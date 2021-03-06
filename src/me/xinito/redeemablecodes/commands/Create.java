package me.xinito.redeemablecodes.commands;

import java.util.List;
import java.util.Random;

import me.xinito.redeemablecodes.RedeemableCodes;
import me.xinito.redeemablecodes.SettingsManager;

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
	
	SettingsManager settings = SettingsManager.getInstance();
       
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	Player player = (Player) sender;
               
    	if (!sender.hasPermission("rc.createkey"))
        {
          sender.sendMessage(ChatColor.RED + "No permission!");
          return true;
        }
    	
    	if(!(sender instanceof Player)){
        	sender.sendMessage(ChatColor.RED + "Only players can do this!");
        	return true;
        }
               
        if(cmd.getName().equalsIgnoreCase("createkey")){
                       
        	Random random = new Random();
        	
        	int key = random.nextInt(799999999) + 100000000;
                       
        	if(args.length == 0){
        		player.sendMessage(plugin.prefix + ChatColor.GREEN + "Succesfully generated: " + ChatColor.YELLOW + key);
                               
        		List<String> keys = settings.getKeys().getStringList("Keys");
        		keys.add(String.valueOf(Integer.valueOf(key)));
        		settings.getKeys().set("Keys", keys);
        		settings.saveKeys();
        	}
        }
        
        return false;
        
   }
}