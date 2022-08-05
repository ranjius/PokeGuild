package rj.ranjiu.pokeguild;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public final class PokeGuild extends JavaPlugin {

    public static PokeGuild PokeGuild;


    @Override
    public void onEnable() {
        // start ok function
        PokeGuild = this;
        info("开始加载配置文件","INFO");
        saveConfig();
        Config.LoadConfig();
        for (Object pgd:Config.guild_list){
            info("加载公会: " + pgd,"INFO");
        }
        info("配置文件加载完毕","INFO");
        if (Bukkit.getPluginCommand("PokeGuild") != null) {
            Bukkit.getPluginCommand("PokeGuild").setExecutor(new rj.ranjiu.pokeguild.command.PokeGuild());
        }
        Objects.requireNonNull(Bukkit.getPluginCommand("PokeGuild")).setTabCompleter(new rj.ranjiu.pokeguild.command.PokeGuild());
        info("插件加载完毕","INFO");
        info("作者：然就 策划:匿名氏(冷骚)","INFO");
        info("版本: "+ getDescription().getVersion(),"INFO");
        info("感谢使用","INFO");
    }

    @Override
    public void onDisable() {
        // uninstall ok function
        info("插件卸载中.....","INFO");
        saveConfig();
        Config.LoadConfig();
        for (Object pgd:Config.guild_list){
            info("保存公会: " + pgd,"INFO");
        }
        info("配置文件已保存","INFO");
        info("插件卸载完成","INFO");
        info("感谢使用","INFO");
    }

    @Override
    public void onLoad(){
        // Loading function
        info("开始加载.....","INFO");
        if (!BoolApi.PlaceholderAPI()){Bukkit.getPluginManager().disablePlugin(this); info("插件的必要前置未加载","ERROR");}
        if (BoolApi.PlayerPoints()&&getConfig().getBoolean("PlayerPoints")){info("PlayerPoints: ✔ 相关功能已启动","INFO");}
        if (BoolApi.Vault()&&getConfig().getBoolean("Vault")){info("Vault: ✔ 相关功能已开启","INFO");}
        if (BoolApi.VexView()){info("VexView: ✔ 相关功能已开启","INFO");}else{Bukkit.getPluginManager().disablePlugin(this); info("插件的必要前置未加载","ERROR");}
        info("功能检查完毕","INFO");
    }

    public void info(@NotNull String message,@NotNull String type){
        // info function
        if (type.equalsIgnoreCase("INFO")){
            Bukkit.getLogger().info(Config.Prefix + ChatColor.GREEN + "[INFO]: " +  message);
        }else if (type.equalsIgnoreCase("WARN")){
            Bukkit.getLogger().warning(Config.Prefix + ChatColor.YELLOW + "[WARNING]: " +message);
        }else if (type.equalsIgnoreCase("ERROR")){
            output(Config.Prefix + ChatColor.RED + "[ERROR]: " + message);
        }
        else {
            output(Config.Prefix + ChatColor.RED +  "输入类型错误");
        }

    }

    public void output(@NotNull String message){
        System.out.println(message);
    }
}
