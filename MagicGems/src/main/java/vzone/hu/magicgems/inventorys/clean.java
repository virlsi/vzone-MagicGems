package vzone.hu.magicgems.inventorys;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import vzone.hu.magicgems.Main;

import java.util.*;

public class clean implements Listener {
    private final Main plugin;
    public clean(Main plugin) {
        this.plugin = plugin;
    }


    public int randomNumber(){
        Random random = new Random();

        int randomNumber = random.nextInt(100) + 1;

        return randomNumber;
    }

    public ItemStack mainItem(){
        ItemStack item = new ItemStack(Material.BAMBOO);
        ItemMeta itemMeta = item.getItemMeta();

        ConfigurationSection configSection = this.plugin.getcleanGuiConfig().getConfigurationSection("Items.");
        if (configSection != null){
            Set<String> keys = configSection.getKeys(false);
            for (String key : keys) {
                String Action = configSection.getString(key + ".Action");
                if (Action != null && Action.equals("Clean")) {
                    Material itemMaterial = Material.valueOf(this.plugin.getcleanGuiConfig().getString("Items." + key + ".Material").toUpperCase());
                    String itemName = this.plugin.getcleanGuiConfig().getString("Items." + key + ".Name");
                    Integer itemCustomModelData = this.plugin.getcleanGuiConfig().getInt("Items." + key + ".CustomModelData");
                    List<String> itemLore = this.plugin.getcleanGuiConfig().getStringList("Items." + key + ".Lore");


                    if (itemMaterial != null) {
                        item.setType(itemMaterial);
                    }

                    if(itemName != null){
                        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', itemName));
                    }

                    if(itemCustomModelData != null && itemCustomModelData > 0){
                        itemMeta.setCustomModelData(itemCustomModelData);
                    }

                    if (itemLore != null) {
                        List<String> newList = new ArrayList<String>();
                        for (String string : itemLore) {
                            newList.add(string.replace("&", "§"));
                        }
                        itemMeta.setLore(newList);
                    }

                    item.setItemMeta(itemMeta);

                }
            }
        }


        return item;
    }


    public ItemStack filterItem(){
        ItemStack item = new ItemStack(Material.BAMBOO);
        ItemMeta itemMeta = item.getItemMeta();

        ConfigurationSection configSection = this.plugin.getcleanGuiConfig().getConfigurationSection("Items.");
        if (configSection != null){
            Set<String> keys = configSection.getKeys(false);
            for (String key : keys) {
                String Action = configSection.getString(key + ".Action");
                if (Action != null && Action.equals("Filter")) {
                    Material itemMaterial = Material.valueOf(this.plugin.getcleanGuiConfig().getString("Items." + key + ".Material").toUpperCase());
                    String itemName = this.plugin.getcleanGuiConfig().getString("Items." + key + ".Name");
                    Integer itemCustomModelData = this.plugin.getcleanGuiConfig().getInt("Items." + key + ".CustomModelData");
                    List<String> itemLore = this.plugin.getcleanGuiConfig().getStringList("Items." + key + ".Lore");


                    if (itemMaterial != null) {
                        item.setType(itemMaterial);
                    }

                    if(itemName != null){
                        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', itemName));
                    }

                    if(itemCustomModelData != null && itemCustomModelData > 0){
                        itemMeta.setCustomModelData(itemCustomModelData);
                    }

                    if (itemLore != null) {
                        List<String> newList = new ArrayList<String>();
                        for (String string : itemLore) {
                            newList.add(string.replace("&", "§"));
                        }
                        itemMeta.setLore(newList);
                    }

                    item.setItemMeta(itemMeta);

                }
            }
        }


        return item;
    }


    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event){
        String inventoryTitle = event.getView().getTitle();
        String invTitle = this.plugin.getcleanGuiConfig().getString("Title");
        if(invTitle == null){
            invTitle = "Null";
        }
        if (!inventoryTitle.equals(ChatColor.translateAlternateColorCodes('&', invTitle))) return;

        Player player = (Player) event.getPlayer();



        ConfigurationSection configSectionItem = this.plugin.getcleanGuiConfig().getConfigurationSection("Items.");
        if (configSectionItem != null) {
            Set<String> keyS = configSectionItem.getKeys(false);
            for (String keY : keyS) {
                String Action = configSectionItem.getString(keY + ".Action");
                if (Action != null && Action.equals("cleanableItem")) {
                    Integer rawItem = configSectionItem.getInt(keY + ".Slot");
                    ItemStack item = event.getInventory().getItem(rawItem);
                    if(item != null){
                        player.getInventory().addItem(item);
                    }
                    return;
                }
            }
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory clickedInventory = event.getClickedInventory();
        String inventoryTitle = event.getView().getTitle();
        String invTitle = this.plugin.getcleanGuiConfig().getString("Title");
        if(invTitle == null){
            invTitle = "Null";
        }
        if (!inventoryTitle.equals(ChatColor.translateAlternateColorCodes('&', invTitle)) || clickedInventory == null) return;

        String prefix = this.plugin.getMessagesConfig().getString("Prefix");
        String CleanFailedWrong = this.plugin.getMessagesConfig().getString("CleanFailed.Wrong");
        String CleanFailedBroke = this.plugin.getMessagesConfig().getString("CleanFailed.Broke");
        String NoCleanableItem = this.plugin.getMessagesConfig().getString("NoCleanableItem");

        Player player = (Player) event.getWhoClicked();
        int rawSlot = event.getRawSlot();

        event.setCancelled(true);


        Integer cleanableItemSlot = 10;

        ConfigurationSection configSection2 = this.plugin.getcleanGuiConfig().getConfigurationSection("Items.");
        if (configSection2 != null){
            Set<String> keys = configSection2.getKeys(false);
            for (String key : keys) {
                String Action = configSection2.getString(key + ".Action");
                if (Action != null && Action.equals("cleanableItem")) {
                    cleanableItemSlot = configSection2.getInt(key + ".Slot");
                }
            }
        }

        if (rawSlot == cleanableItemSlot) {
            event.setCancelled(false);
        }

        if (clickedInventory == event.getWhoClicked().getInventory() || rawSlot == event.getWhoClicked().getInventory().getHeldItemSlot()) {
            event.setCancelled(false);
        }

        ItemStack rawItem = clickedInventory.getItem(cleanableItemSlot);
        if (rawItem == null || rawItem.getType() == Material.AIR) return;

        ItemMeta itemMeta = rawItem.getItemMeta();
        if (itemMeta == null || !itemMeta.hasDisplayName()) return;

        String itemName = itemMeta.getDisplayName();


        ConfigurationSection configSectionItem = this.plugin.getcleanGuiConfig().getConfigurationSection("Items.");
        if (configSectionItem != null){
            Set<String> keyS = configSectionItem.getKeys(false);
            for (String keY : keyS) {
                String Action = configSectionItem.getString(keY + ".Action");
                if (Action != null && Action.equals("Clean")) {
                    if (rawSlot == configSectionItem.getInt(keY + ".Slot")) {
                        ConfigurationSection configSection = plugin.getConfig().getConfigurationSection("gems.");
                        if (configSection != null) {
                            Set<String> keys = configSection.getKeys(false);
                            for (String key : keys) {
                                String rawItemName = configSection.getString(key + ".RawItemName");
                                if (rawItemName != null && itemName.equals(ChatColor.translateAlternateColorCodes('&', rawItemName))) {
                                    Material gemItemMaterial = Material.valueOf(configSection.getString(key + ".Material"));
                                    String gemItemName = configSection.getString(key + ".Name");
                                    List<String> gemItemLore = configSection.getStringList(key + ".Lore");
                                    Integer gemItemModelData = configSection.getInt(key + ".CustomModelData");
                                    Boolean gemItemGlow = configSection.getBoolean(key + ".Glow");
                                    String gemItemAbility = configSection.getString(key + ".Ability");
                                    if (gemItemName != null) {
                                        ItemStack cleanedItem = new ItemStack(gemItemMaterial);
                                        ItemMeta cleanedItemMeta = cleanedItem.getItemMeta();
                                        assert cleanedItemMeta != null;
                                        if (gemItemMaterial != null) {
                                            cleanedItemMeta.setUnbreakable(true);
                                            cleanedItemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DYE, ItemFlag.HIDE_UNBREAKABLE);
                                        }
                                        if (gemItemName != null) {
                                            cleanedItemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', gemItemName));
                                        }

                                        if (gemItemLore != null) {
                                            List<String> newList = new ArrayList<String>();
                                            if(randomNumber() < 20){
                                                rawItem.setAmount(rawItem.getAmount() - 1);
                                                if(randomNumber() < 50){
                                                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + CleanFailedBroke));
                                                    return;
                                                }else{
                                                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + CleanFailedWrong));
                                                    return;
                                                }
                                            }else{
                                                if(randomNumber() > 5){
                                                    if(randomNumber() > 15){
                                                        if(randomNumber() > 20){
                                                            if(randomNumber() > 30){
                                                                for (String string : gemItemLore) {
                                                                    newList.add(string.replace("&", "§").replace("%rarity%", "§fけ§8けけけけ"));
                                                                }
                                                            }else{
                                                                for (String string : gemItemLore) {
                                                                    newList.add(string.replace("&", "§").replace("%rarity%", "§fけけ§8けけけ"));
                                                                }
                                                            }
                                                        }else{
                                                            for (String string : gemItemLore) {
                                                                newList.add(string.replace("&", "§").replace("%rarity%", "§fけけけ§8けけ"));
                                                            }
                                                        }
                                                    }else{
                                                        for (String string : gemItemLore) {
                                                            newList.add(string.replace("&", "§").replace("%rarity%", "§fけけけけ§8け"));
                                                        }
                                                    }
                                                }else{
                                                    for (String string : gemItemLore) {
                                                        newList.add(string.replace("&", "§").replace("%rarity%", "§fけけけけけ"));
                                                    }
                                                }
                                            }
                                            cleanedItemMeta.setLore(newList);
                                        }

                                        if (gemItemModelData != null) {
                                            cleanedItemMeta.setCustomModelData(gemItemModelData);
                                        }

                                        if (gemItemGlow != null) {
                                            if (gemItemGlow) {
                                                cleanedItemMeta.addEnchant(Enchantment.DURABILITY, 1, true);
                                                cleanedItemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                                            }
                                        }


                                        cleanedItem.setItemMeta(cleanedItemMeta);
                                        player.getInventory().addItem(cleanedItem);
                                        rawItem.setAmount(rawItem.getAmount() - 1);
                                        return;
                                    }
                                }
                            }
                        }

                    }
                }
            }
        }
    }

    @EventHandler
    public void onInventoryDrag(InventoryDragEvent event) {
        String InvTitle = this.plugin.getcleanGuiConfig().getString("Title");
        if(InvTitle == null){
            InvTitle = "Null";
        }
        Player player = (Player) event.getWhoClicked();
        Inventory draggedInventory = event.getInventory();
        String inventoryTitle = event.getView().getTitle();
        if (draggedInventory == null) return;

        if (inventoryTitle.equals(ChatColor.translateAlternateColorCodes('&', InvTitle))) {
            event.setCancelled(true);

            if (draggedInventory == player.getInventory()) {
                event.setCancelled(false);
            }
        }
    }

    public void openCleanInventory(Player player) {


        String InvTitle = this.plugin.getcleanGuiConfig().getString("Title");
        if(InvTitle == null){
            InvTitle = "Null";
        }

        Integer size = this.plugin.getcleanGuiConfig().getInt("Size");
        if(size != null){
            size = 36;
        }

        Inventory inv = Bukkit.createInventory(null, size, ChatColor.translateAlternateColorCodes('&', InvTitle));

        ItemStack item = filterItem();
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(" ");
        item.setItemMeta(meta);

        Integer cleanableItemSlot = 10;

        ConfigurationSection configSection2 = this.plugin.getcleanGuiConfig().getConfigurationSection("Items.");
        if (configSection2 != null){
            Set<String> keys = configSection2.getKeys(false);
            for (String key : keys) {
                String Action = configSection2.getString(key + ".Action");
                if (Action != null && Action.equals("cleanableItem")) {
                    cleanableItemSlot = configSection2.getInt(key + ".Slot");

                }
            }
        }



        Integer itemInt = 0;
        Integer cleanaItem = 1;

        ConfigurationSection configSection = this.plugin.getcleanGuiConfig().getConfigurationSection("Items.");
        if (configSection != null){
            Set<String> keys = configSection.getKeys(false);
            for (String key : keys) {
                String Action = configSection.getString(key + ".Action");
                if (Action != null && Action.equals("Clean")) {
                    itemInt = configSection.getInt(key + ".Slot");
                    cleanaItem = configSection.getInt(key + ".Slot");
                }
            }
        }

        for (int i = 0; i < inv.getSize(); i++) {
            if (i == cleanableItemSlot) continue;
            if (i == cleanaItem) continue;
            inv.setItem(i, item);
        }

        inv.setItem(itemInt, mainItem());

        player.openInventory(inv);
    }


}
