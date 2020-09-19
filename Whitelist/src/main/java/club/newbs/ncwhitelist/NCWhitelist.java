package club.newbs.ncwhitelist;

import club.newbs.ncwhitelist.commands.WhitelistCmd;
import club.newbs.ncwhitelist.listeners.WhitelistInventory;
import club.newbs.ncwhitelist.listeners.WhitelistJoin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class NCWhitelist extends JavaPlugin {

    @Override
    public void onEnable() {

        //Load Internals
        loadCommands();
        loadListeners();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void loadCommands(){

        //Whitelist Command
        try{
            this.getCommand("whitelist").setExecutor(new WhitelistCmd());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadListeners(){

        //Whitelist Join Listener
        try{
            Bukkit.getPluginManager().registerEvents(new WhitelistJoin(), this);
        } catch(Exception e){
            e.printStackTrace();
        }

        //Whitelist Inventory Listener
        try{
            Bukkit.getPluginManager().registerEvents(new WhitelistInventory(), this);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
