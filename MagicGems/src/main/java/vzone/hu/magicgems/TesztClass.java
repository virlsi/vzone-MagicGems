package vzone.hu.magicgems;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import java.util.List;
import java.util.stream.Collectors;

public class TesztClass implements Listener {
    private final Main plugin;
    public TesztClass(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onSneakEvent(PlayerMoveEvent e){
        if(e.getPlayer().isSneaking()){
            List<String> conf = this.plugin.getcleanGuiConfig().getConfigurationSection("Items").getKeys(false).stream().collect(Collectors.toList());
            String key = "Items.clean.";
            e.getPlayer().sendMessage(this.plugin.getcleanGuiConfig().getString(key + "Material"));
        }
    }



}
