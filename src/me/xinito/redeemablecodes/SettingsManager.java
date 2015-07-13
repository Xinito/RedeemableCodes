package me.xinito.redeemablecodes;
 
import java.io.File;
import java.io.IOException;
 
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
 
public class SettingsManager {
       
	//Credits Aurorion
	
	private SettingsManager() { }
       
    static SettingsManager instance = new SettingsManager();
       
    public static SettingsManager getInstance() {
    	return instance;
    }
       
    Plugin plugin;
       
    FileConfiguration keys;
    File kfile;
       
    public void setup(Plugin plugin){
    	if(!plugin.getDataFolder().exists()){
    		plugin.getDataFolder().mkdirs();
    	}
               
    	kfile = new File(plugin.getDataFolder(), "Keys.yml");
    	if(!kfile.exists()){
    		try{
    			kfile.createNewFile();
    			Bukkit.getLogger().info("Keys.yml created!");
    		}
    		catch (IOException e){
    			Bukkit.getLogger().severe("Could not create Keys.yml!");
    			e.printStackTrace();
    		}
    	}
    		keys = YamlConfiguration.loadConfiguration(kfile);
    }
       
    public FileConfiguration getKeys(){
    	return keys;
    }
       
    public void saveKeys(){
    	try{
    		keys.save(kfile);
    	}
    	catch (IOException e){
    		Bukkit.getLogger().severe("Could not save Keys.yml!");
    		e.printStackTrace();
    	}
    }
       
    public void reloadKeys(){
    	
    	keys = YamlConfiguration.loadConfiguration(kfile);
    }
}
