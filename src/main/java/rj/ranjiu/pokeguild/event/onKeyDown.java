package rj.ranjiu.pokeguild.event;

import lk.vexview.event.KeyBoardPressEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import rj.ranjiu.pokeguild.gui.main_gui;

public final class onKeyDown implements Listener {
    @EventHandler
    public void onKey(KeyBoardPressEvent event){
        int key_id = event.getKey();
        main_gui.drawSelf();
    }
}
