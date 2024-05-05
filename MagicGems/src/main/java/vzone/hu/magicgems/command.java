package vzone.hu.magicgems;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vzone.hu.magicgems.inventorys.clean;
import vzone.hu.magicgems.inventorys.upgrade;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class command implements CommandExecutor, TabCompleter, Listener {
    private final Main plugin;

    public command(Main plugin) {
        this.plugin = plugin;
    }


    public void openCleanInv(Player player) {
        clean cleanInstance = new clean(plugin);
        if (player != null) {
            cleanInstance.openCleanInventory(player);
        }
    }

    public void openUpgradeInv(Player player) {
        upgrade upgradeInstance = new upgrade(plugin);
        if (player != null) {
            upgradeInstance.openUpgardeInventory(player);
        }
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("magicgems") && sender.hasPermission("magicgems.admin")) {
            List<String> help = this.plugin.getMessagesConfig().getStringList("HelpMsg");
            String prefix = this.plugin.getMessagesConfig().getString("Prefix");
            String relaodMSG = this.plugin.getMessagesConfig().getString("Reload");
            String playerNotFound = this.plugin.getMessagesConfig().getString("PlayerNotFound");
            String gemNotFound = this.plugin.getMessagesConfig().getString("GemNotFound");
            String abilityMissing = this.plugin.getMessagesConfig().getString("AbilityMissing");
            String gemGiveMessageToSender = this.plugin.getMessagesConfig().getString("GemGiveMessageToSender");
            String gemGiveMessageToTarget = this.plugin.getMessagesConfig().getString("GemGiveMessageToTarget");
            String MaxRarity = this.plugin.getMessagesConfig().getString("MaxRarity");
            String MinRarity = this.plugin.getMessagesConfig().getString("MinRarity");
            String consolePrefix = "§fMagicGems » ";
            if(args.length < 1){
                for (String line : help) {
                    sender.sendMessage(ChatColor.RESET + ChatColor.translateAlternateColorCodes('&', line));
                }
                return true;
            }
            if (args.length < 3) {
                if (Objects.equals(args[0].toLowerCase(), "reload")) {
                    this.plugin.reloadConfig();
                    this.plugin.reloadMessagesConfig();
                    this.plugin.reloadcleanGuiConfig();
                    this.plugin.reloadupgardeGuiConfig();
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + relaodMSG));
                    return true;
                }

                for (String line : help) {
                    sender.sendMessage(ChatColor.RESET + ChatColor.translateAlternateColorCodes('&', line));
                }
                return true;

            }
            if (Objects.equals(args[0].toLowerCase(), "give")) {
                String gemName = args[1];
                Player player = Bukkit.getPlayer(args[2]);
                Integer ammount = 0;
                if (args.length > 3 && args[3] != null) {
                    ammount = Integer.valueOf(args[3]);
                } else {
                    ammount = 1;
                }

                Integer rarity = 1;
                if (args.length > 4 && args[4] != null) {
                    rarity = Integer.valueOf(args[4]);
                    if(rarity < 1){
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + MinRarity));
                        return true;
                    }
                    if(rarity > 5){
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + MaxRarity));
                        return true;
                    }
                } else {
                    for (String line : help) {
                        sender.sendMessage(ChatColor.RESET + ChatColor.translateAlternateColorCodes('&', line));
                    }
                    return true;
                }

                Boolean silentGive = false;
                if (args.length > 5 && args[5] != null && args[5].equalsIgnoreCase("-s")) {
                    silentGive = true;
                }

                if (player == null) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + playerNotFound));
                    return true;
                }

                if (this.plugin.getConfig().getString("gems." + gemName + ".Material") == null) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + gemNotFound));
                    return true;
                }

                Material gemItemMaterial = Material.valueOf(this.plugin.getConfig().getString("gems." + gemName + ".Material"));
                String gemItemName = this.plugin.getConfig().getString("gems." + gemName + ".Name");
                List<String> gemItemLore = this.plugin.getConfig().getStringList("gems." + gemName + ".Lore");
                Integer gemItemModelData = this.plugin.getConfig().getInt("gems." + gemName + ".CustomModelData");
                Boolean gemItemGlow = this.plugin.getConfig().getBoolean("gems." + gemName + ".Glow");
                String gemItemAbility = this.plugin.getConfig().getString("gems." + gemName + ".Ability");


                ItemStack gem = new ItemStack(Material.BEDROCK);
                ItemMeta gemMeta = gem.getItemMeta();

                if (gemItemMaterial != null) {
                    gem.setType(gemItemMaterial);
                    gemMeta.setUnbreakable(true);
                    gemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DYE, ItemFlag.HIDE_UNBREAKABLE);
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + gemNotFound));
                }

                if (gemItemName != null) {
                    gemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', gemItemName));
                }

                if (gemItemLore != null) {

                    List<String> newList = new ArrayList<String>();
                    if(rarity == 1){
                        for (String string : gemItemLore) {
                            newList.add(string.replace("&", "§").replace("%rarity%", "§fけ§8けけけけ"));
                        }
                    }
                    if(rarity == 2){
                        for (String string : gemItemLore) {
                            newList.add(string.replace("&", "§").replace("%rarity%", "§fけけ§8けけけ"));
                        }
                    }
                    if(rarity == 3){
                        for (String string : gemItemLore) {
                            newList.add(string.replace("&", "§").replace("%rarity%", "§fけけけ§8けけ"));
                        }
                    }
                    if(rarity == 4){
                        for (String string : gemItemLore) {
                            newList.add(string.replace("&", "§").replace("%rarity%", "§fけけけけ§8け"));
                        }
                    }
                    if(rarity == 5){
                        for (String string : gemItemLore) {
                            newList.add(string.replace("&", "§").replace("%rarity%", "§fけけけけけ"));
                        }
                    }

                    gemMeta.setLore(newList);
                }

                if (gemItemModelData != null) {
                    gemMeta.setCustomModelData(gemItemModelData);
                }

                if (gemItemGlow != null) {
                    if (gemItemGlow) {
                        gemMeta.addEnchant(Enchantment.DURABILITY, 1, true);
                        gemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    }
                }

                if (gemItemAbility == null) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + abilityMissing));
                    Bukkit.getServer().getConsoleSender().sendMessage(consolePrefix + "§cNincs ability megadva a következő gemnek: " + gemName);
                    return true;
                }

                if (ammount != null) {
                    gem.setAmount(ammount);
                } else {
                    gem.setAmount(1);
                }

                gem.setItemMeta(gemMeta);
                if (silentGive) {
                    player.getInventory().addItem(gem);
                    if (sender instanceof Player) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + gemGiveMessageToSender.replace("%gem%", gemName).replace("%player%", player.getName())));
                    }
                } else {
                    player.getInventory().addItem(gem);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + gemGiveMessageToTarget.replace("%gem%", gemName)));
                    if (sender instanceof Player) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + gemGiveMessageToSender.replace("%gem%", gemName).replace("%player%", player.getName())));
                    }
                }
                return true;
            }
            if (Objects.equals(args[0].toLowerCase(), "open")) {
                if(sender instanceof Player) {
                    String menuName = args[1];
                    Player player = Bukkit.getPlayer(args[2]);
                    Player playerSender = (Player) sender;

                    if (Objects.equals(menuName.toLowerCase(), "cleaner")) {
                        if (player == null) {
                            openCleanInv(playerSender);
                        } else {
                            openCleanInv(player);
                        }
                    }
                    if (Objects.equals(menuName.toLowerCase(), "upgarde")) {
                        if (player == null) {
                            openUpgradeInv(playerSender);
                        } else {
                            openUpgradeInv(player);
                        }
                    }
                }else{
                    String menuName = args[1];
                    Player player = Bukkit.getPlayer(args[2]);

                    if (Objects.equals(menuName.toLowerCase(), "cleaner")) {
                        if (player == null) {
                            for (String line : help) {
                                sender.sendMessage(ChatColor.RESET + ChatColor.translateAlternateColorCodes('&', line));
                            }
                            return true;
                        } else {
                            openCleanInv(player);
                        }
                    }
                    if (Objects.equals(menuName.toLowerCase(), "upgarde")) {
                        if (player == null) {
                            for (String line : help) {
                                sender.sendMessage(ChatColor.RESET + ChatColor.translateAlternateColorCodes('&', line));
                            }
                            return true;
                        } else {
                            openUpgradeInv(player);
                        }
                    }
                }
            }


            return true;
        }
        return true;
    }

    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if ((command.getName().equalsIgnoreCase("magicgems") || command.getName().equalsIgnoreCase("mg")) && sender.hasPermission("worldswitchtitle.admin")) {
            String current = args[args.length - 1];

            if (args.length == 1) {
                return List.of("reload", "give", "open");
            }

            if (args.length == 2) {
                if (Objects.equals(args[0].toLowerCase(), "give")) {
                    return plugin.getConfig().getConfigurationSection("gems").getKeys(false).stream().collect(Collectors.toList());
                }
                if (Objects.equals(args[0].toLowerCase(), "open")) {
                    return List.of("cleaner", "upgarde");
                }
            }


            if (args.length == 3) {
                return (List) Bukkit.getOnlinePlayers().stream().map(OfflinePlayer::getName).filter((name) -> {
                    return name.startsWith(current);
                }).collect(Collectors.toList());
            }

            if (args.length == 4) {
                if (Objects.equals(args[0].toLowerCase(), "give")) {
                    return List.of("1", "2", "3");
                }
            }

            if (args.length == 5) {
                if (Objects.equals(args[0].toLowerCase(), "give")) {
                    return List.of("1", "2", "3", "4", "5");
                }
            }

            if (args.length == 6) {
                if (Objects.equals(args[0].toLowerCase(), "give")) {
                    return List.of("-s");
                }
            }
        }

        return null;
    }

}