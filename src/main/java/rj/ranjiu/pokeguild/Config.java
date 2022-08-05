package rj.ranjiu.pokeguild;

import java.util.List;

public final class Config {

    public static String Prefix;
    public static String HELP;
    public static List<?> guild_list;
    public static void LoadConfig(){

        Prefix = PokeGuild.PokeGuild.getConfig().getString("Prefix");
        HELP = "&e=======&bPokeGuild指令帮助======== \n&e||\n&e||  &c/reload 重载插件\n&e||  &c/help 获得帮助\n&e==============END=================";
        guild_list = PokeGuild.PokeGuild.getConfig().getList("Guild_List");
    }


}
