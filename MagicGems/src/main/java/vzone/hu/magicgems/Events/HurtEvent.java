package vzone.hu.magicgems.Events;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import vzone.hu.magicgems.Main;

import java.util.List;
import java.util.Set;


public class HurtEvent implements Listener {
    private final Main plugin;
    public HurtEvent(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            ConfigurationSection configSection = plugin.getConfig().getConfigurationSection("gems.");
            Double b = 0.0;
            if (configSection != null) {
                Set<String> keys = configSection.getKeys(false);
                ItemStack helmet = player.getInventory().getHelmet();
                ItemStack chestplate = player.getInventory().getChestplate();
                ItemStack leggings = player.getInventory().getLeggings();
                ItemStack boots = player.getInventory().getBoots();
                    for (String key : keys) {
                        String rawItemName = configSection.getString(key + ".Name");
                        if(helmet != null && helmet.getType() != Material.AIR){
                            ItemMeta helmetItemMeta = helmet.getItemMeta();
                            List<String> helmetItemMetaLore = helmetItemMeta.getLore();
                            if(helmetItemMetaLore != null){
                                for (String string : helmetItemMetaLore){
                                    if (rawItemName != null && string.contains(rawItemName.replace("&", "§"))) {
                                        String gemItemAbility = configSection.getString(key + ".Ability");
                                        if(gemItemAbility == null){
                                            return;
                                        }
                                        if(gemItemAbility.equals("resistance")){
                                            for (String string2 : helmetItemMetaLore) {
                                                if (string2.contains("§fけけけけけ")) {
                                                    b = b + 0.125;
                                                }
                                                if (string2.contains("§fけけけけ§8け")) {
                                                    b = b + 0.1;
                                                }
                                                if (string2.contains("§fけけけ§8けけ")) {
                                                    b = b + 0.075;
                                                }
                                                if (string2.contains("§fけけ§8けけけ")) {
                                                    b = b + 0.05;
                                                }
                                                if (string2.contains("§fけ§8けけけけ")) {
                                                    b = b + 0.025;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if(chestplate != null && chestplate.getType() != Material.AIR) {
                            ItemMeta chestplateItemMeta = chestplate.getItemMeta();
                            List<String> chestplateItemMetaLore = chestplateItemMeta.getLore();
                            if (chestplateItemMetaLore != null) {
                                for (String string : chestplateItemMetaLore) {
                                    if (rawItemName != null && string.contains(rawItemName.replace("&", "§"))) {
                                        String gemItemAbility = configSection.getString(key + ".Ability");
                                        if (gemItemAbility == null) {
                                            return;
                                        }
                                        if (gemItemAbility.equals("resistance")) {
                                            for (String string2 : chestplateItemMetaLore) {
                                                if (string2.contains("§fけけけけけ")) {
                                                    b = b + 0.125;
                                                }
                                                if (string2.contains("§fけけけけ§8け")) {
                                                    b = b + 0.1;
                                                }
                                                if (string2.contains("§fけけけ§8けけ")) {
                                                    b = b + 0.075;
                                                }
                                                if (string2.contains("§fけけ§8けけけ")) {
                                                    b = b + 0.05;
                                                }
                                                if (string2.contains("§fけ§8けけけけ")) {
                                                    b = b + 0.025;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if(leggings != null && leggings.getType() != Material.AIR) {
                            ItemMeta leggingsItemMeta = leggings.getItemMeta();
                            List<String> leggingsItemMetaLore = leggingsItemMeta.getLore();
                            if (leggingsItemMetaLore != null) {
                                for (String string : leggingsItemMetaLore) {
                                    if (rawItemName != null && string.contains(rawItemName.replace("&", "§"))) {
                                        String gemItemAbility = configSection.getString(key + ".Ability");
                                        if (gemItemAbility == null) {
                                            return;
                                        }
                                        if (gemItemAbility.equals("resistance")) {
                                            for (String string2 : leggingsItemMetaLore) {
                                                if (string2.contains("§fけけけけけ")) {
                                                    b = b + 0.125;
                                                }
                                                if (string2.contains("§fけけけけ§8け")) {
                                                    b = b + 0.1;
                                                }
                                                if (string2.contains("§fけけけ§8けけ")) {
                                                    b = b + 0.075;
                                                }
                                                if (string2.contains("§fけけ§8けけけ")) {
                                                    b = b + 0.05;
                                                }
                                                if (string2.contains("§fけ§8けけけけ")) {
                                                    b = b + 0.025;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if(boots != null && boots.getType() != Material.AIR) {
                            ItemMeta bootsItemMeta = boots.getItemMeta();
                            List<String> bootsItemMetaLore = bootsItemMeta.getLore();
                            if (bootsItemMetaLore != null) {
                                for (String string : bootsItemMetaLore) {
                                    if (rawItemName != null && string.contains(rawItemName.replace("&", "§"))) {
                                        String gemItemAbility = configSection.getString(key + ".Ability");
                                        if (gemItemAbility == null) {
                                            return;
                                        }
                                        if (gemItemAbility.equals("resistance")) {
                                            for (String string2 : bootsItemMetaLore) {
                                                if (string2.contains("§fけけけけけ")) {
                                                    b = b + 0.125;
                                                }
                                                if (string2.contains("§fけけけけ§8け")) {
                                                    b = b + 0.1;
                                                }
                                                if (string2.contains("§fけけけ§8けけ")) {
                                                    b = b + 0.075;
                                                }
                                                if (string2.contains("§fけけ§8けけけ")) {
                                                    b = b + 0.05;
                                                }
                                                if (string2.contains("§fけ§8けけけけ")) {
                                                    b = b + 0.025;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }

                    }
            }

            if(b != 0.0){
                Double c = event.getDamage() * b;
                event.setDamage(event.getDamage() - c);
            }
        }
    }

}
