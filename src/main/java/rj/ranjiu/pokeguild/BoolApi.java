package rj.ranjiu.pokeguild;

import org.bukkit.Bukkit;

public class BoolApi {

    public static boolean PlayerPoints(){
        return Bukkit.getPluginManager().isPluginEnabled("PlayerPoints");

    }

    public static boolean Vault(){
        return Bukkit.getPluginManager().isPluginEnabled("Vault");
    }

    public static boolean PlaceholderAPI(){
        return Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI");
    }
    
    public static boolean VexView(){
        return Bukkit.getPluginManager().isPluginEnabled("VexView");
    }

}
