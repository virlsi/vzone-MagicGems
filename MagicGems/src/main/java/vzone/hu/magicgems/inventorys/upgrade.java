package vzone.hu.magicgems.inventorys;

import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import vzone.hu.magicgems.Main;

import java.util.*;

import static vzone.hu.magicgems.ArmorAttributes.*;

public class upgrade implements Listener {

    private final Main plugin;
    public upgrade(Main plugin) {
        this.plugin = plugin;
    }


    public ItemStack mainItem(){
        ItemStack item = new ItemStack(Material.BAMBOO);
        ItemMeta itemMeta = item.getItemMeta();

        ConfigurationSection configSection = this.plugin.getupgardeGuiConfig().getConfigurationSection("Items.");
        if (configSection != null){
            Set<String> keys = configSection.getKeys(false);
            for (String key : keys) {
                String Action = configSection.getString(key + ".Action");
                if (Action != null && Action.equals("Upgrade")) {
                    Material itemMaterial = Material.valueOf(this.plugin.getupgardeGuiConfig().getString("Items." + key + ".Material").toUpperCase());
                    String itemName = this.plugin.getupgardeGuiConfig().getString("Items." + key + ".Name");
                    Integer itemCustomModelData = this.plugin.getupgardeGuiConfig().getInt("Items." + key + ".CustomModelData");
                    List<String> itemLore = this.plugin.getupgardeGuiConfig().getStringList("Items." + key + ".Lore");


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



    public ItemStack finalItem(ItemStack item, ItemStack gem, String gemName){
        ItemMeta itemMeta = item.getItemMeta();
        List<String> rawItemLore = Objects.requireNonNull(item.getItemMeta()).getLore();
        List<String> FinalLore = plugin.getConfig().getStringList("ItemLore");
        ItemMeta gemMeta = gem.getItemMeta();
        List<String> gemLore = gemMeta.getLore();

        String b = "asd";
        for (String string : gemLore){
            if(string.contains("§fけけけけけ")){
                b = "§fけけけけけ";
            }
            if(string.contains("§fけけけけ§8け")){
                b = "§fけけけけ§8け";
            }
            if(string.contains("§fけけけ§8けけ")){
                b = "§fけけけ§8けけ";
            }
            if(string.contains("§fけけ§8けけけ")){
                b = "§fけけ§8けけけ";
            }
            if(string.contains("§fけ§8けけけけ")){
                b = "§fけ§8けけけけ";
            }
        }


        List<String> newList = new ArrayList<String>();
        for (String string : FinalLore) {
            newList.add(string.replace("&", "§").replace("%rarity%", b).replace("%gem%", gemName));
        }
        if(rawItemLore != null){
            for (String string : rawItemLore){
                newList.add(string);
            }
        }


        itemMeta.setLore(newList);
        item.setAmount(1);
        item.setItemMeta(itemMeta);
        return item;
    }


    public ItemStack finalItemHealth(ItemStack item, ItemStack gem, String gemName, String wear){
        ItemMeta itemMeta = item.getItemMeta();
        List<String> rawItemLore = Objects.requireNonNull(item.getItemMeta()).getLore();
        List<String> FinalLore = plugin.getConfig().getStringList("ItemLore");
        ItemMeta gemMeta = gem.getItemMeta();
        List<String> gemLore = gemMeta.getLore();

        String b = "asd";
        Integer a = 0;
        for (String string : gemLore){
            if(string.contains("§fけけけけけ")){
                a = 6;
                b = "§fけけけけけ";
            }
            if(string.contains("§fけけけけ§8け")){
                a = 4;
                b = "§fけけけけ§8け";
            }
            if(string.contains("§fけけけ§8けけ")){
                a = 3;
                b = "§fけけけ§8けけ";
            }
            if(string.contains("§fけけ§8けけけ")){
                a = 2;
                b = "§fけけ§8けけけ";
            }
            if(string.contains("§fけ§8けけけけ")){
                a = 1;
                b = "§fけ§8けけけけ";
            }
        }

        if(wear.equals("head")){
            if(item.getType() == Material.NETHERITE_HELMET){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
                itemMeta.setAttributeModifiers(Netherite_Helmet(Attribute.GENERIC_MAX_HEALTH, healthModifier).getItemMeta().getAttributeModifiers());
            }
            if(item.getType() == Material.DIAMOND_HELMET){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
                itemMeta.setAttributeModifiers(Diamond_Helmet(Attribute.GENERIC_MAX_HEALTH, healthModifier).getItemMeta().getAttributeModifiers());
            }
            if(item.getType() == Material.GOLDEN_HELMET){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
                itemMeta.setAttributeModifiers(Golden_Helmet(Attribute.GENERIC_MAX_HEALTH, healthModifier).getItemMeta().getAttributeModifiers());
            }
            if(item.getType() == Material.IRON_HELMET){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
                itemMeta.setAttributeModifiers(Iron_Helmet(Attribute.GENERIC_MAX_HEALTH, healthModifier).getItemMeta().getAttributeModifiers());
            }
            if(item.getType() == Material.CHAINMAIL_HELMET){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
                itemMeta.setAttributeModifiers(Chainmail_Helmet(Attribute.GENERIC_MAX_HEALTH, healthModifier).getItemMeta().getAttributeModifiers());
            }
            if(item.getType() == Material.LEATHER_HELMET){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
                itemMeta.setAttributeModifiers(Leather_Helmet(Attribute.GENERIC_MAX_HEALTH, healthModifier).getItemMeta().getAttributeModifiers());
            }
            if(item.getType() == Material.TURTLE_HELMET){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
                itemMeta.setAttributeModifiers(Turtle_Helmet(Attribute.GENERIC_MAX_HEALTH, healthModifier).getItemMeta().getAttributeModifiers());
            }
        }
        if(wear.equals("chest")){
            if(item.getType() == Material.NETHERITE_CHESTPLATE){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
                itemMeta.setAttributeModifiers(Netherite_Chestplate(Attribute.GENERIC_MAX_HEALTH, healthModifier).getItemMeta().getAttributeModifiers());
            }
            if(item.getType() == Material.DIAMOND_CHESTPLATE){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
                itemMeta.setAttributeModifiers(Diamond_Chestplate(Attribute.GENERIC_MAX_HEALTH, healthModifier).getItemMeta().getAttributeModifiers());
            }
            if(item.getType() == Material.GOLDEN_CHESTPLATE){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
                itemMeta.setAttributeModifiers(Golden_Chestplate(Attribute.GENERIC_MAX_HEALTH, healthModifier).getItemMeta().getAttributeModifiers());
            }
            if(item.getType() == Material.IRON_CHESTPLATE){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
                itemMeta.setAttributeModifiers(Iron_Chestplate(Attribute.GENERIC_MAX_HEALTH, healthModifier).getItemMeta().getAttributeModifiers());
            }
            if(item.getType() == Material.CHAINMAIL_CHESTPLATE){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
                itemMeta.setAttributeModifiers(Chainmail_Chestplate(Attribute.GENERIC_MAX_HEALTH, healthModifier).getItemMeta().getAttributeModifiers());
            }
            if(item.getType() == Material.LEATHER_CHESTPLATE){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
                itemMeta.setAttributeModifiers(Leather_Chestplate(Attribute.GENERIC_MAX_HEALTH, healthModifier).getItemMeta().getAttributeModifiers());
            }
        }
        if(wear.equals("legs")){
            if(item.getType() == Material.NETHERITE_LEGGINGS){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
                itemMeta.setAttributeModifiers(Netherite_Leggings(Attribute.GENERIC_MAX_HEALTH, healthModifier).getItemMeta().getAttributeModifiers());
            }
            if(item.getType() == Material.DIAMOND_LEGGINGS){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
                itemMeta.setAttributeModifiers(Diamond_Leggings(Attribute.GENERIC_MAX_HEALTH, healthModifier).getItemMeta().getAttributeModifiers());
            }
            if(item.getType() == Material.GOLDEN_LEGGINGS){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
                itemMeta.setAttributeModifiers(Golden_Leggings(Attribute.GENERIC_MAX_HEALTH, healthModifier).getItemMeta().getAttributeModifiers());
            }
            if(item.getType() == Material.IRON_LEGGINGS){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
                itemMeta.setAttributeModifiers(Iron_Leggings(Attribute.GENERIC_MAX_HEALTH, healthModifier).getItemMeta().getAttributeModifiers());
            }
            if(item.getType() == Material.CHAINMAIL_LEGGINGS){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
                itemMeta.setAttributeModifiers(Chainmail_Leggings(Attribute.GENERIC_MAX_HEALTH, healthModifier).getItemMeta().getAttributeModifiers());
            }
            if(item.getType() == Material.LEATHER_LEGGINGS){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
                itemMeta.setAttributeModifiers(Leather_Leggings(Attribute.GENERIC_MAX_HEALTH, healthModifier).getItemMeta().getAttributeModifiers());
            }
        }
        if(wear.equals("feet")){
            if(item.getType() == Material.NETHERITE_BOOTS){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
                itemMeta.setAttributeModifiers(Netherite_Boots(Attribute.GENERIC_MAX_HEALTH, healthModifier).getItemMeta().getAttributeModifiers());
            }
            if(item.getType() == Material.DIAMOND_BOOTS){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
                itemMeta.setAttributeModifiers(Diamond_Boots(Attribute.GENERIC_MAX_HEALTH, healthModifier).getItemMeta().getAttributeModifiers());
            }
            if(item.getType() == Material.GOLDEN_BOOTS){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
                itemMeta.setAttributeModifiers(Golden_Boots(Attribute.GENERIC_MAX_HEALTH, healthModifier).getItemMeta().getAttributeModifiers());
            }
            if(item.getType() == Material.IRON_BOOTS){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
                itemMeta.setAttributeModifiers(Iron_Boots(Attribute.GENERIC_MAX_HEALTH, healthModifier).getItemMeta().getAttributeModifiers());
            }
            if(item.getType() == Material.CHAINMAIL_BOOTS){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
                itemMeta.setAttributeModifiers(Chainmail_Boots(Attribute.GENERIC_MAX_HEALTH, healthModifier).getItemMeta().getAttributeModifiers());
            }
            if(item.getType() == Material.LEATHER_BOOTS){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
                itemMeta.setAttributeModifiers(Leather_Boots(Attribute.GENERIC_MAX_HEALTH, healthModifier).getItemMeta().getAttributeModifiers());
            }
        }



        List<String> newList = new ArrayList<String>();
        for (String string : FinalLore) {
            newList.add(string.replace("&", "§").replace("%rarity%", b).replace("%gem%", gemName));
        }
        if(rawItemLore != null){
            for (String string : rawItemLore){
                newList.add(string);
            }
        }


        itemMeta.setLore(newList);
        item.setAmount(1);
        item.setItemMeta(itemMeta);
        return item;
    }


    public ItemStack finalItemSpeed(ItemStack item, ItemStack gem, String gemName, String wear){
        ItemMeta itemMeta = item.getItemMeta();
        List<String> rawItemLore = Objects.requireNonNull(item.getItemMeta()).getLore();
        List<String> FinalLore = plugin.getConfig().getStringList("ItemLore");
        ItemMeta gemMeta = gem.getItemMeta();
        List<String> gemLore = gemMeta.getLore();
        if(itemMeta == null){
            return null;
        }
        String b = "asd";
        Double a = 0.0;
        for (String string : gemLore){
            if(string.contains("§fけけけけけ")){
                a = 0.04;
                b = "§fけけけけけ";
            }
            if(string.contains("§fけけけけ§8け")){
                a = 0.032;
                b = "§fけけけけ§8け";
            }
            if(string.contains("§fけけけ§8けけ")){
                a = 0.024;
                b = "§fけけけ§8けけ";
            }
            if(string.contains("§fけけ§8けけけ")){
                a = 0.016;
                b = "§fけけ§8けけけ";
            }
            if(string.contains("§fけ§8けけけけ")){
                a = 0.008;
                b = "§fけ§8けけけけ";
            }
        }



        if(wear.equals("head")){
            if(item.getType() == Material.NETHERITE_HELMET){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
                itemMeta.setAttributeModifiers(Netherite_Helmet(Attribute.GENERIC_MOVEMENT_SPEED, healthModifier).getItemMeta().getAttributeModifiers());
            }
            if(item.getType() == Material.DIAMOND_HELMET){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
                itemMeta.setAttributeModifiers(Diamond_Helmet(Attribute.GENERIC_MOVEMENT_SPEED, healthModifier).getItemMeta().getAttributeModifiers());
            }
            if(item.getType() == Material.GOLDEN_HELMET){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
                itemMeta.setAttributeModifiers(Golden_Helmet(Attribute.GENERIC_MOVEMENT_SPEED, healthModifier).getItemMeta().getAttributeModifiers());
            }
            if(item.getType() == Material.IRON_HELMET){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
                itemMeta.setAttributeModifiers(Iron_Helmet(Attribute.GENERIC_MOVEMENT_SPEED, healthModifier).getItemMeta().getAttributeModifiers());
            }
            if(item.getType() == Material.CHAINMAIL_HELMET){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
                itemMeta.setAttributeModifiers(Chainmail_Helmet(Attribute.GENERIC_MOVEMENT_SPEED, healthModifier).getItemMeta().getAttributeModifiers());
            }
            if(item.getType() == Material.LEATHER_HELMET){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
                itemMeta.setAttributeModifiers(Leather_Helmet(Attribute.GENERIC_MOVEMENT_SPEED, healthModifier).getItemMeta().getAttributeModifiers());
            }
            if(item.getType() == Material.TURTLE_HELMET){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
                itemMeta.setAttributeModifiers(Turtle_Helmet(Attribute.GENERIC_MOVEMENT_SPEED, healthModifier).getItemMeta().getAttributeModifiers());
            }
        }
        if(wear.equals("chest")){
            if(item.getType() == Material.NETHERITE_CHESTPLATE){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
                itemMeta.setAttributeModifiers(Netherite_Chestplate(Attribute.GENERIC_MOVEMENT_SPEED, healthModifier).getItemMeta().getAttributeModifiers());
            }
            if(item.getType() == Material.DIAMOND_CHESTPLATE){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
                itemMeta.setAttributeModifiers(Diamond_Chestplate(Attribute.GENERIC_MOVEMENT_SPEED, healthModifier).getItemMeta().getAttributeModifiers());
            }
            if(item.getType() == Material.GOLDEN_CHESTPLATE){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
                itemMeta.setAttributeModifiers(Golden_Chestplate(Attribute.GENERIC_MOVEMENT_SPEED, healthModifier).getItemMeta().getAttributeModifiers());
            }
            if(item.getType() == Material.IRON_CHESTPLATE){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
                itemMeta.setAttributeModifiers(Iron_Chestplate(Attribute.GENERIC_MOVEMENT_SPEED, healthModifier).getItemMeta().getAttributeModifiers());
            }
            if(item.getType() == Material.CHAINMAIL_CHESTPLATE){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
                itemMeta.setAttributeModifiers(Chainmail_Chestplate(Attribute.GENERIC_MOVEMENT_SPEED, healthModifier).getItemMeta().getAttributeModifiers());
            }
            if(item.getType() == Material.LEATHER_CHESTPLATE){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
                itemMeta.setAttributeModifiers(Leather_Chestplate(Attribute.GENERIC_MOVEMENT_SPEED, healthModifier).getItemMeta().getAttributeModifiers());
            }
        }
        if(wear.equals("legs")){
            if(item.getType() == Material.NETHERITE_LEGGINGS){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
                itemMeta.setAttributeModifiers(Netherite_Leggings(Attribute.GENERIC_MOVEMENT_SPEED, healthModifier).getItemMeta().getAttributeModifiers());
            }
            if(item.getType() == Material.DIAMOND_LEGGINGS){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
                itemMeta.setAttributeModifiers(Diamond_Leggings(Attribute.GENERIC_MOVEMENT_SPEED, healthModifier).getItemMeta().getAttributeModifiers());
            }
            if(item.getType() == Material.GOLDEN_LEGGINGS){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
                itemMeta.setAttributeModifiers(Golden_Leggings(Attribute.GENERIC_MOVEMENT_SPEED, healthModifier).getItemMeta().getAttributeModifiers());
            }
            if(item.getType() == Material.IRON_LEGGINGS){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
                itemMeta.setAttributeModifiers(Iron_Leggings(Attribute.GENERIC_MOVEMENT_SPEED, healthModifier).getItemMeta().getAttributeModifiers());
            }
            if(item.getType() == Material.CHAINMAIL_LEGGINGS){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
                itemMeta.setAttributeModifiers(Chainmail_Leggings(Attribute.GENERIC_MOVEMENT_SPEED, healthModifier).getItemMeta().getAttributeModifiers());
            }
            if(item.getType() == Material.LEATHER_LEGGINGS){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
                itemMeta.setAttributeModifiers(Leather_Leggings(Attribute.GENERIC_MOVEMENT_SPEED, healthModifier).getItemMeta().getAttributeModifiers());
            }
        }
        if(wear.equals("feet")){
            if(item.getType() == Material.NETHERITE_BOOTS){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
                itemMeta.setAttributeModifiers(Netherite_Boots(Attribute.GENERIC_MOVEMENT_SPEED, healthModifier).getItemMeta().getAttributeModifiers());
            }
            if(item.getType() == Material.DIAMOND_BOOTS){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
                itemMeta.setAttributeModifiers(Diamond_Boots(Attribute.GENERIC_MOVEMENT_SPEED, healthModifier).getItemMeta().getAttributeModifiers());
            }
            if(item.getType() == Material.GOLDEN_BOOTS){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
                itemMeta.setAttributeModifiers(Golden_Boots(Attribute.GENERIC_MOVEMENT_SPEED, healthModifier).getItemMeta().getAttributeModifiers());
            }
            if(item.getType() == Material.IRON_BOOTS){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
                itemMeta.setAttributeModifiers(Iron_Boots(Attribute.GENERIC_MOVEMENT_SPEED, healthModifier).getItemMeta().getAttributeModifiers());
            }
            if(item.getType() == Material.CHAINMAIL_BOOTS){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
                itemMeta.setAttributeModifiers(Chainmail_Boots(Attribute.GENERIC_MOVEMENT_SPEED, healthModifier).getItemMeta().getAttributeModifiers());
            }
            if(item.getType() == Material.LEATHER_BOOTS){
                AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", a, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
                itemMeta.setAttributeModifiers(Leather_Boots(Attribute.GENERIC_MOVEMENT_SPEED, healthModifier).getItemMeta().getAttributeModifiers());
            }
        }


        List<String> newList = new ArrayList<String>();
        for (String string : FinalLore) {
            newList.add(string.replace("&", "§").replace("%rarity%", b).replace("%gem%", gemName));
        }
        if(rawItemLore != null){
            for (String string : rawItemLore){
                newList.add(string);
            }
        }


        itemMeta.setLore(newList);
        item.setAmount(1);
        item.setItemMeta(itemMeta);
        return item;
    }


    public ItemStack filterItem(){
        ItemStack item = new ItemStack(Material.BAMBOO);
        ItemMeta itemMeta = item.getItemMeta();

        ConfigurationSection configSection = this.plugin.getupgardeGuiConfig().getConfigurationSection("Items.");
        if (configSection != null){
            Set<String> keys = configSection.getKeys(false);
            for (String key : keys) {
                String Action = configSection.getString(key + ".Action");
                if (Action != null && Action.equals("Filter")) {
                    Material itemMaterial = Material.valueOf(this.plugin.getupgardeGuiConfig().getString("Items." + key + ".Material").toUpperCase());
                    String itemName = this.plugin.getupgardeGuiConfig().getString("Items." + key + ".Name");
                    Integer itemCustomModelData = this.plugin.getupgardeGuiConfig().getInt("Items." + key + ".CustomModelData");
                    List<String> itemLore = this.plugin.getupgardeGuiConfig().getStringList("Items." + key + ".Lore");


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
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory clickedInventory = event.getClickedInventory();
        String inventoryTitle = event.getView().getTitle();
        String invTitle = this.plugin.getupgardeGuiConfig().getString("Title");
        if(invTitle == null){
            invTitle = "Null";
        }
        if (!inventoryTitle.equals(ChatColor.translateAlternateColorCodes('&', invTitle)) || clickedInventory == null) return;

        String prefix = this.plugin.getMessagesConfig().getString("Prefix");
        String WrongItem = this.plugin.getMessagesConfig().getString("WrongItem");
        String AlreadyGem = this.plugin.getMessagesConfig().getString("AlreadyGem");

        Player player = (Player) event.getWhoClicked();
        int rawSlot = event.getRawSlot();

        event.setCancelled(true);

        Integer GemItemSlot = 12;

        ConfigurationSection configSection2 = this.plugin.getupgardeGuiConfig().getConfigurationSection("Items.");
        if (configSection2 != null){
            Set<String> keys = configSection2.getKeys(false);
            for (String key : keys) {
                String Action = configSection2.getString(key + ".Action");
                if (Action != null && Action.equals("Gem")) {
                    GemItemSlot = configSection2.getInt(key + ".Slot");
                }
            }
        }

        Integer rawItemSlot = 10;

        ConfigurationSection configSection3 = this.plugin.getupgardeGuiConfig().getConfigurationSection("Items.");
        if (configSection3 != null){
            Set<String> keys = configSection3.getKeys(false);
            for (String key : keys) {
                String Action = configSection3.getString(key + ".Action");
                if (Action != null && Action.equals("Item")) {
                    rawItemSlot = configSection3.getInt(key + ".Slot");
                }
            }
        }

        if (rawSlot == GemItemSlot) {
            event.setCancelled(false);
        }

        if (rawSlot == rawItemSlot) {
            event.setCancelled(false);
        }

        if (clickedInventory == event.getWhoClicked().getInventory() || rawSlot == event.getWhoClicked().getInventory().getHeldItemSlot()) {
            event.setCancelled(false);
        }

        ItemStack rawItemGem = clickedInventory.getItem(GemItemSlot);
        if (rawItemGem == null || rawItemGem.getType() == Material.AIR) return;

        ItemStack rawUpgradeableItem = clickedInventory.getItem(rawItemSlot);
        if (rawUpgradeableItem == null || rawUpgradeableItem.getType() == Material.AIR) return;

        ItemMeta itemMeta = rawItemGem.getItemMeta();
        if (itemMeta == null || !itemMeta.hasDisplayName()) return;

        String itemName = itemMeta.getDisplayName();


        ConfigurationSection configSectionItem = this.plugin.getupgardeGuiConfig().getConfigurationSection("Items.");
        if (configSectionItem != null){
            Set<String> keyS = configSectionItem.getKeys(false);
            for (String keY : keyS) {
                String Action = configSectionItem.getString(keY + ".Action");
                if (Action != null && Action.equals("Upgrade")) {
                    if (rawSlot == configSectionItem.getInt(keY + ".Slot")) {
                        ConfigurationSection configSection = plugin.getConfig().getConfigurationSection("gems.");
                        if (configSection != null) {
                            Set<String> keys = configSection.getKeys(false);
                            for (String key : keys) {
                                String rawItemName = configSection.getString(key + ".Name");
                                if (rawItemName != null && itemName.equals(rawItemName.replace("&", "§"))) {
                                    String itemAbility = configSection.getString(key + ".Ability");
                                    if(itemAbility == null){
                                        return;
                                    }
                                    if(itemAbility.equals("strength")){
                                        if(rawUpgradeableItem.getType() == Material.WOODEN_SWORD || rawUpgradeableItem.getType() == Material.STONE_SWORD || rawUpgradeableItem.getType() == Material.IRON_SWORD || rawUpgradeableItem.getType() == Material.GOLDEN_SWORD || rawUpgradeableItem.getType() == Material.DIAMOND_SWORD || rawUpgradeableItem.getType() == Material.NETHERITE_SWORD){
                                            Boolean a = false;
                                            List<String> c = rawUpgradeableItem.getItemMeta().getLore();
                                            if(c != null){
                                                for (String string : c){
                                                    if (string.contains("け")) {
                                                        a = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            if(!a || rawUpgradeableItem.getItemMeta().getLore() == null){

                                                rawItemGem.setAmount(rawItemGem.getAmount() - 1);

                                                player.getInventory().addItem(finalItem(rawUpgradeableItem, rawItemGem, ChatColor.translateAlternateColorCodes('&', rawItemName)));
                                                rawUpgradeableItem.setAmount(rawUpgradeableItem.getAmount() - 1);

                                            }else{
                                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + AlreadyGem));
                                            }
                                        }else{
                                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + WrongItem));
                                        }
                                    }
                                    if(itemAbility.equals("resistance")){
                                        if(rawUpgradeableItem.getType() == Material.LEATHER_BOOTS || rawUpgradeableItem.getType() == Material.LEATHER_LEGGINGS ||
                                                rawUpgradeableItem.getType() == Material.LEATHER_CHESTPLATE || rawUpgradeableItem.getType() == Material.LEATHER_HELMET ||
                                                rawUpgradeableItem.getType() == Material.GOLDEN_BOOTS || rawUpgradeableItem.getType() == Material.GOLDEN_LEGGINGS ||
                                                rawUpgradeableItem.getType() == Material.GOLDEN_CHESTPLATE || rawUpgradeableItem.getType() == Material.GOLDEN_HELMET ||
                                                rawUpgradeableItem.getType() == Material.CHAINMAIL_BOOTS || rawUpgradeableItem.getType() == Material.CHAINMAIL_LEGGINGS ||
                                                rawUpgradeableItem.getType() == Material.CHAINMAIL_CHESTPLATE || rawUpgradeableItem.getType() == Material.CHAINMAIL_HELMET ||
                                                rawUpgradeableItem.getType() == Material.IRON_BOOTS || rawUpgradeableItem.getType() == Material.IRON_LEGGINGS ||
                                                rawUpgradeableItem.getType() == Material.IRON_CHESTPLATE || rawUpgradeableItem.getType() == Material.IRON_HELMET ||
                                                rawUpgradeableItem.getType() == Material.DIAMOND_BOOTS || rawUpgradeableItem.getType() == Material.DIAMOND_LEGGINGS ||
                                                rawUpgradeableItem.getType() == Material.DIAMOND_CHESTPLATE || rawUpgradeableItem.getType() == Material.DIAMOND_HELMET ||
                                                rawUpgradeableItem.getType() == Material.NETHERITE_BOOTS || rawUpgradeableItem.getType() == Material.NETHERITE_LEGGINGS ||
                                                rawUpgradeableItem.getType() == Material.NETHERITE_CHESTPLATE || rawUpgradeableItem.getType() == Material.NETHERITE_HELMET ||
                                                rawUpgradeableItem.getType() == Material.TURTLE_HELMET){
                                            Boolean a = false;
                                            List<String> c = rawUpgradeableItem.getItemMeta().getLore();
                                            if(c != null){
                                                for (String string : c){
                                                    if (string.contains("け")) {
                                                        a = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            if(!a || rawUpgradeableItem.getItemMeta().getLore() == null){

                                                rawItemGem.setAmount(rawItemGem.getAmount() - 1);

                                                player.getInventory().addItem(finalItem(rawUpgradeableItem, rawItemGem, ChatColor.translateAlternateColorCodes('&', rawItemName)));
                                                rawUpgradeableItem.setAmount(rawUpgradeableItem.getAmount() - 1);

                                            }else{
                                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + AlreadyGem));
                                            }
                                        }else{
                                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + WrongItem));
                                        }
                                    }
                                    if(itemAbility.equals("healt")){
                                        if(rawUpgradeableItem.getType() == Material.LEATHER_BOOTS || rawUpgradeableItem.getType() == Material.LEATHER_LEGGINGS ||
                                                rawUpgradeableItem.getType() == Material.LEATHER_CHESTPLATE || rawUpgradeableItem.getType() == Material.LEATHER_HELMET ||
                                                rawUpgradeableItem.getType() == Material.GOLDEN_BOOTS || rawUpgradeableItem.getType() == Material.GOLDEN_LEGGINGS ||
                                                rawUpgradeableItem.getType() == Material.GOLDEN_CHESTPLATE || rawUpgradeableItem.getType() == Material.GOLDEN_HELMET ||
                                                rawUpgradeableItem.getType() == Material.CHAINMAIL_BOOTS || rawUpgradeableItem.getType() == Material.CHAINMAIL_LEGGINGS ||
                                                rawUpgradeableItem.getType() == Material.CHAINMAIL_CHESTPLATE || rawUpgradeableItem.getType() == Material.CHAINMAIL_HELMET ||
                                                rawUpgradeableItem.getType() == Material.IRON_BOOTS || rawUpgradeableItem.getType() == Material.IRON_LEGGINGS ||
                                                rawUpgradeableItem.getType() == Material.IRON_CHESTPLATE || rawUpgradeableItem.getType() == Material.IRON_HELMET ||
                                                rawUpgradeableItem.getType() == Material.DIAMOND_BOOTS || rawUpgradeableItem.getType() == Material.DIAMOND_LEGGINGS ||
                                                rawUpgradeableItem.getType() == Material.DIAMOND_CHESTPLATE || rawUpgradeableItem.getType() == Material.DIAMOND_HELMET ||
                                                rawUpgradeableItem.getType() == Material.NETHERITE_BOOTS || rawUpgradeableItem.getType() == Material.NETHERITE_LEGGINGS ||
                                                rawUpgradeableItem.getType() == Material.NETHERITE_CHESTPLATE || rawUpgradeableItem.getType() == Material.NETHERITE_HELMET ||
                                                rawUpgradeableItem.getType() == Material.TURTLE_HELMET){
                                            Boolean a = false;
                                            List<String> c = rawUpgradeableItem.getItemMeta().getLore();
                                            if(c != null){
                                                for (String string : c){
                                                    if (string.contains("け")) {
                                                        a = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            if(!a || rawUpgradeableItem.getItemMeta().getLore() == null){

                                                rawItemGem.setAmount(rawItemGem.getAmount() - 1);
                                                if(rawUpgradeableItem.getType() == Material.LEATHER_HELMET || rawUpgradeableItem.getType() == Material.GOLDEN_HELMET ||
                                                        rawUpgradeableItem.getType() == Material.CHAINMAIL_HELMET || rawUpgradeableItem.getType() == Material.IRON_HELMET ||
                                                        rawUpgradeableItem.getType() == Material.DIAMOND_HELMET || rawUpgradeableItem.getType() == Material.NETHERITE_HELMET ||
                                                        rawUpgradeableItem.getType() == Material.TURTLE_HELMET){
                                                    String wear = "head";
                                                    player.getInventory().addItem(finalItemHealth(rawUpgradeableItem, rawItemGem, ChatColor.translateAlternateColorCodes('&', rawItemName), wear));
                                                    rawUpgradeableItem.setAmount(rawUpgradeableItem.getAmount() - 1);
                                                }
                                                if(rawUpgradeableItem.getType() == Material.LEATHER_CHESTPLATE || rawUpgradeableItem.getType() == Material.GOLDEN_CHESTPLATE ||
                                                        rawUpgradeableItem.getType() == Material.CHAINMAIL_CHESTPLATE || rawUpgradeableItem.getType() == Material.IRON_CHESTPLATE ||
                                                        rawUpgradeableItem.getType() == Material.DIAMOND_CHESTPLATE || rawUpgradeableItem.getType() == Material.NETHERITE_CHESTPLATE){
                                                    String wear = "chest";
                                                    player.getInventory().addItem(finalItemHealth(rawUpgradeableItem, rawItemGem, ChatColor.translateAlternateColorCodes('&', rawItemName), wear));
                                                    rawUpgradeableItem.setAmount(rawUpgradeableItem.getAmount() - 1);
                                                }
                                                if(rawUpgradeableItem.getType() == Material.LEATHER_LEGGINGS || rawUpgradeableItem.getType() == Material.GOLDEN_LEGGINGS ||
                                                        rawUpgradeableItem.getType() == Material.CHAINMAIL_LEGGINGS || rawUpgradeableItem.getType() == Material.IRON_LEGGINGS ||
                                                        rawUpgradeableItem.getType() == Material.DIAMOND_LEGGINGS || rawUpgradeableItem.getType() == Material.NETHERITE_LEGGINGS){
                                                    String wear = "legs";
                                                    player.getInventory().addItem(finalItemHealth(rawUpgradeableItem, rawItemGem, ChatColor.translateAlternateColorCodes('&', rawItemName), wear));
                                                    rawUpgradeableItem.setAmount(rawUpgradeableItem.getAmount() - 1);
                                                }
                                                if(rawUpgradeableItem.getType() == Material.LEATHER_BOOTS || rawUpgradeableItem.getType() == Material.GOLDEN_BOOTS ||
                                                        rawUpgradeableItem.getType() == Material.CHAINMAIL_BOOTS || rawUpgradeableItem.getType() == Material.IRON_BOOTS ||
                                                        rawUpgradeableItem.getType() == Material.DIAMOND_BOOTS || rawUpgradeableItem.getType() == Material.NETHERITE_BOOTS){
                                                    String wear = "feet";
                                                    player.getInventory().addItem(finalItemHealth(rawUpgradeableItem, rawItemGem, ChatColor.translateAlternateColorCodes('&', rawItemName), wear));
                                                    rawUpgradeableItem.setAmount(rawUpgradeableItem.getAmount() - 1);
                                                }

                                            }else{
                                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + AlreadyGem));
                                            }
                                        }else{
                                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + WrongItem));
                                        }
                                    }
                                    if(itemAbility.equals("speed")){
                                        if(rawUpgradeableItem.getType() == Material.LEATHER_BOOTS || rawUpgradeableItem.getType() == Material.LEATHER_LEGGINGS ||
                                                rawUpgradeableItem.getType() == Material.LEATHER_CHESTPLATE || rawUpgradeableItem.getType() == Material.LEATHER_HELMET ||
                                                rawUpgradeableItem.getType() == Material.GOLDEN_BOOTS || rawUpgradeableItem.getType() == Material.GOLDEN_LEGGINGS ||
                                                rawUpgradeableItem.getType() == Material.GOLDEN_CHESTPLATE || rawUpgradeableItem.getType() == Material.GOLDEN_HELMET ||
                                                rawUpgradeableItem.getType() == Material.CHAINMAIL_BOOTS || rawUpgradeableItem.getType() == Material.CHAINMAIL_LEGGINGS ||
                                                rawUpgradeableItem.getType() == Material.CHAINMAIL_CHESTPLATE || rawUpgradeableItem.getType() == Material.CHAINMAIL_HELMET ||
                                                rawUpgradeableItem.getType() == Material.IRON_BOOTS || rawUpgradeableItem.getType() == Material.IRON_LEGGINGS ||
                                                rawUpgradeableItem.getType() == Material.IRON_CHESTPLATE || rawUpgradeableItem.getType() == Material.IRON_HELMET ||
                                                rawUpgradeableItem.getType() == Material.DIAMOND_BOOTS || rawUpgradeableItem.getType() == Material.DIAMOND_LEGGINGS ||
                                                rawUpgradeableItem.getType() == Material.DIAMOND_CHESTPLATE || rawUpgradeableItem.getType() == Material.DIAMOND_HELMET ||
                                                rawUpgradeableItem.getType() == Material.NETHERITE_BOOTS || rawUpgradeableItem.getType() == Material.NETHERITE_LEGGINGS ||
                                                rawUpgradeableItem.getType() == Material.NETHERITE_CHESTPLATE || rawUpgradeableItem.getType() == Material.NETHERITE_HELMET ||
                                                rawUpgradeableItem.getType() == Material.TURTLE_HELMET){
                                            Boolean a = false;
                                            List<String> c = rawUpgradeableItem.getItemMeta().getLore();
                                            if(c != null){
                                                for (String string : c){
                                                    if (string.contains("け")) {
                                                        a = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            if(!a || rawUpgradeableItem.getItemMeta().getLore() == null){

                                                rawItemGem.setAmount(rawItemGem.getAmount() - 1);
                                                if(rawUpgradeableItem.getType() == Material.LEATHER_HELMET || rawUpgradeableItem.getType() == Material.GOLDEN_HELMET ||
                                                        rawUpgradeableItem.getType() == Material.CHAINMAIL_HELMET || rawUpgradeableItem.getType() == Material.IRON_HELMET ||
                                                        rawUpgradeableItem.getType() == Material.DIAMOND_HELMET || rawUpgradeableItem.getType() == Material.NETHERITE_HELMET ||
                                                        rawUpgradeableItem.getType() == Material.TURTLE_HELMET){
                                                    String wear = "head";
                                                    player.getInventory().addItem(finalItemSpeed(rawUpgradeableItem, rawItemGem, ChatColor.translateAlternateColorCodes('&', rawItemName), wear));
                                                    rawUpgradeableItem.setAmount(rawUpgradeableItem.getAmount() - 1);
                                                }
                                                if(rawUpgradeableItem.getType() == Material.LEATHER_CHESTPLATE || rawUpgradeableItem.getType() == Material.GOLDEN_CHESTPLATE ||
                                                        rawUpgradeableItem.getType() == Material.CHAINMAIL_CHESTPLATE || rawUpgradeableItem.getType() == Material.IRON_CHESTPLATE ||
                                                        rawUpgradeableItem.getType() == Material.DIAMOND_CHESTPLATE || rawUpgradeableItem.getType() == Material.NETHERITE_CHESTPLATE){
                                                    String wear = "chest";
                                                    player.getInventory().addItem(finalItemSpeed(rawUpgradeableItem, rawItemGem, ChatColor.translateAlternateColorCodes('&', rawItemName), wear));
                                                    rawUpgradeableItem.setAmount(rawUpgradeableItem.getAmount() - 1);
                                                }
                                                if(rawUpgradeableItem.getType() == Material.LEATHER_LEGGINGS || rawUpgradeableItem.getType() == Material.GOLDEN_LEGGINGS ||
                                                        rawUpgradeableItem.getType() == Material.CHAINMAIL_LEGGINGS || rawUpgradeableItem.getType() == Material.IRON_LEGGINGS ||
                                                        rawUpgradeableItem.getType() == Material.DIAMOND_LEGGINGS || rawUpgradeableItem.getType() == Material.NETHERITE_LEGGINGS){
                                                    String wear = "legs";
                                                    player.getInventory().addItem(finalItemSpeed(rawUpgradeableItem, rawItemGem, ChatColor.translateAlternateColorCodes('&', rawItemName), wear));
                                                    rawUpgradeableItem.setAmount(rawUpgradeableItem.getAmount() - 1);
                                                }
                                                if(rawUpgradeableItem.getType() == Material.LEATHER_BOOTS || rawUpgradeableItem.getType() == Material.GOLDEN_BOOTS ||
                                                        rawUpgradeableItem.getType() == Material.CHAINMAIL_BOOTS || rawUpgradeableItem.getType() == Material.IRON_BOOTS ||
                                                        rawUpgradeableItem.getType() == Material.DIAMOND_BOOTS || rawUpgradeableItem.getType() == Material.NETHERITE_BOOTS){
                                                    String wear = "feet";
                                                    player.getInventory().addItem(finalItemSpeed(rawUpgradeableItem, rawItemGem, ChatColor.translateAlternateColorCodes('&', rawItemName), wear));
                                                    rawUpgradeableItem.setAmount(rawUpgradeableItem.getAmount() - 1);
                                                }

                                            }else{
                                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + AlreadyGem));
                                            }
                                        }else{
                                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + WrongItem));
                                        }
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
        String InvTitle = this.plugin.getupgardeGuiConfig().getString("Title");
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


    public void openUpgardeInventory(Player player) {

        String InvTitle = this.plugin.getupgardeGuiConfig().getString("Title");
        if(InvTitle == null){
            InvTitle = "Null";
        }

        Integer size = this.plugin.getupgardeGuiConfig().getInt("Size");
        if(size != null){
            size = 36;
        }

        Inventory inv = Bukkit.createInventory(null, size, ChatColor.translateAlternateColorCodes('&', InvTitle));

        ItemStack item = filterItem();
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(" ");
        item.setItemMeta(meta);

        Integer rawitem = 10;

        ConfigurationSection configSection2 = this.plugin.getupgardeGuiConfig().getConfigurationSection("Items.");
        if (configSection2 != null){
            Set<String> keys = configSection2.getKeys(false);
            for (String key : keys) {
                String Action = configSection2.getString(key + ".Action");
                if (Action != null && Action.equals("Item")) {
                    rawitem = configSection2.getInt(key + ".Slot");

                }
            }
        }

        Integer gemitem = 12;

        ConfigurationSection configSection3 = this.plugin.getupgardeGuiConfig().getConfigurationSection("Items.");
        if (configSection3 != null){
            Set<String> keys = configSection3.getKeys(false);
            for (String key : keys) {
                String Action = configSection3.getString(key + ".Action");
                if (Action != null && Action.equals("Gem")) {
                    gemitem = configSection3.getInt(key + ".Slot");

                }
            }
        }



        Integer itemInt = 0;
        Integer upgradeItem = 1;

        ConfigurationSection configSection = this.plugin.getupgardeGuiConfig().getConfigurationSection("Items.");
        if (configSection != null){
            Set<String> keys = configSection.getKeys(false);
            for (String key : keys) {
                String Action = configSection.getString(key + ".Action");
                if (Action != null && Action.equals("Upgrade")) {
                    itemInt = configSection.getInt(key + ".Slot");
                    upgradeItem = configSection.getInt(key + ".Slot");
                }
            }
        }

        for (int i = 0; i < inv.getSize(); i++) {
            if (i == rawitem) continue;
            if (i == gemitem) continue;
            if (i == upgradeItem) continue;
            inv.setItem(i, item);
        }

        inv.setItem(itemInt, mainItem());

        player.openInventory(inv);
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event){
        String inventoryTitle = event.getView().getTitle();
        String invTitle = this.plugin.getupgardeGuiConfig().getString("Title");
        if(invTitle == null){
            invTitle = "Null";
        }
        if (!inventoryTitle.equals(ChatColor.translateAlternateColorCodes('&', invTitle))) return;

        Player player = (Player) event.getPlayer();



        ConfigurationSection configSectionItem = this.plugin.getupgardeGuiConfig().getConfigurationSection("Items.");
        if (configSectionItem != null) {
            Set<String> keyS = configSectionItem.getKeys(false);
            for (String keY : keyS) {
                String Action = configSectionItem.getString(keY + ".Action");
                if (Action != null && Action.equals("Item")) {
                    Integer rawItem = configSectionItem.getInt(keY + ".Slot");
                    ItemStack item = event.getInventory().getItem(rawItem);
                    if(item != null){
                        player.getInventory().addItem(item);
                    }
                }
                if (Action != null && Action.equals("Gem")) {
                    Integer rawItem = configSectionItem.getInt(keY + ".Slot");
                    ItemStack item = event.getInventory().getItem(rawItem);
                    if(item != null){
                        player.getInventory().addItem(item);
                    }
                }
            }
        }
    }

}
