package rj.ranjiu.pokeguild.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rj.ranjiu.pokeguild.Config;
import java.util.Arrays;
import java.util.List;

public class PokeGuild implements CommandExecutor, TabCompleter {
    //reload command
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("PokeGuild")||label.equalsIgnoreCase("pgd")){
            if (args.length != 0){
                if (args[0].equalsIgnoreCase("reload")&&sender.isOp()){
                    rj.ranjiu.pokeguild.PokeGuild.PokeGuild.reloadConfig();
                    rj.ranjiu.pokeguild.PokeGuild.PokeGuild.saveConfig();
                    Config.LoadConfig();
                    sender.sendMessage(Config.Prefix + "插件配置文件已重载");
                    return true;
                }
            }else{
                sender.sendMessage(Config.Prefix+ "输入参数有误,请输入参数");
                return true;
            }
        }
        if (label.equalsIgnoreCase("PokeGuild")||label.equalsIgnoreCase("pgd")){
            if (args.length != 0){
                if (args[0].equalsIgnoreCase("gui")){
                    return true;
                }
            }else{
                sender.sendMessage(Config.Prefix+ "输入参数有误,请输入参数");
                return true;
            }
        }
        if (label.equalsIgnoreCase("PokeGuild")||label.equalsIgnoreCase("pgd")){
            if (args.length != 0){
                if (args[0].equalsIgnoreCase("help")){
                    sender.sendMessage(Config.HELP);
                    return true;
                }
            }else{
                sender.sendMessage(Config.Prefix+ "输入参数有误,请输入参数");
                return true;
            }
        }
        return false;
    }

    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        String[] commands = new String[] {"help","reload","gui"};
        if (!(sender instanceof Player)) {
            // 控制台注册个鬼
            return null;
        }
        if (args.length >= 2) {
            // 前两个参数已经输入完成，不继续提示
            return null;
        }
        if (args.length == 1){
            //第一个参数时
            return Arrays.asList(commands);

        }
        return null;
    }
}
