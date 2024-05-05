package vzone.hu.magicgems.Events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import vzone.hu.magicgems.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DamageEvent implements Listener {
    private final Main plugin;
    public DamageEvent(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        Entity damager = event.getDamager();
        if (damager instanceof Player) {
            Player player = (Player) damager;
            if(player.getInventory().getItemInMainHand() == null && player.getInventory().getItemInMainHand().getType() == Material.AIR){
                return;
            }
            ItemStack weapon = player.getInventory().getItemInMainHand();
            ConfigurationSection configSection = plugin.getConfig().getConfigurationSection("gems.");
            if (configSection != null) {
                Set<String> keys = configSection.getKeys(false);
                for (String key : keys) {
                    String rawItemName = configSection.getString(key + ".Name");
                    ItemMeta itemMeta = weapon.getItemMeta();
                    if(itemMeta == null){
                        return;
                    }
                    List<String> itemLore = itemMeta.getLore();
                    if(itemLore == null){
                        return;
                    }
                    for (String string : itemLore){
                        if (rawItemName != null && string.contains(rawItemName.replace("&", "§"))) {
                            String gemItemAbility = configSection.getString(key + ".Ability");
                            if(gemItemAbility == null){
                                return;
                            }
                            if(gemItemAbility.equals("strength")){
                                Double b = 0.0;
                                for (String string2 : itemLore) {
                                    if (string2.contains("§fけけけけけ")) {
                                        b = 2.0;
                                    }
                                    if (string2.contains("§fけけけけ§8け")) {
                                        b = 1.8;
                                    }
                                    if (string2.contains("§fけけけ§8けけ")) {
                                        b = 1.6;
                                    }
                                    if (string2.contains("§fけけ§8けけけ")) {
                                        b = 1.4;
                                    }
                                    if (string2.contains("§fけ§8けけけけ")) {
                                        b = 1.2;
                                    }
                                }
                                event.setDamage(event.getDamage() * b);


                            }
                        }
                    }
                }
            }
        }

    }
}
