package vzone.hu.magicgems;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Item;
import org.bukkit.event.Listener;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.UUID;

public class ArmorAttributes implements Listener {

    public static ItemStack Netherite_Helmet(Attribute attribute, AttributeModifier attributeModifier){
        ItemStack item = new ItemStack(Material.NETHERITE_HELMET);
        ItemMeta itemMeta = item.getItemMeta();

        AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier healthModifier2 = new AttributeModifier(UUID.randomUUID(), "generic.health2", 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier healthModifier3 = new AttributeModifier(UUID.randomUUID(), "generic.health3", 0.1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, healthModifier);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, healthModifier2);
        itemMeta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, healthModifier3);
        itemMeta.addAttributeModifier(attribute, attributeModifier);

        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack Diamond_Helmet(Attribute attribute, AttributeModifier attributeModifier){
        ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta itemMeta = item.getItemMeta();

        AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier healthModifier2 = new AttributeModifier(UUID.randomUUID(), "generic.health2", 2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, healthModifier);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, healthModifier2);
        itemMeta.addAttributeModifier(attribute, attributeModifier);

        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack Golden_Helmet(Attribute attribute, AttributeModifier attributeModifier){
        ItemStack item = new ItemStack(Material.GOLDEN_HELMET);
        ItemMeta itemMeta = item.getItemMeta();

        AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", 2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, healthModifier);
        itemMeta.addAttributeModifier(attribute, attributeModifier);

        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack Iron_Helmet(Attribute attribute, AttributeModifier attributeModifier){
        ItemStack item = new ItemStack(Material.IRON_HELMET);
        ItemMeta itemMeta = item.getItemMeta();

        AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", 2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, healthModifier);
        itemMeta.addAttributeModifier(attribute, attributeModifier);

        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack Chainmail_Helmet(Attribute attribute, AttributeModifier attributeModifier){
        ItemStack item = new ItemStack(Material.CHAINMAIL_HELMET);
        ItemMeta itemMeta = item.getItemMeta();

        AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", 2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, healthModifier);
        itemMeta.addAttributeModifier(attribute, attributeModifier);

        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack Leather_Helmet(Attribute attribute, AttributeModifier attributeModifier){
        ItemStack item = new ItemStack(Material.LEATHER_HELMET);
        ItemMeta itemMeta = item.getItemMeta();

        AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", 1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, healthModifier);
        itemMeta.addAttributeModifier(attribute, attributeModifier);

        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack Turtle_Helmet(Attribute attribute, AttributeModifier attributeModifier){
        ItemStack item = new ItemStack(Material.TURTLE_HELMET);
        ItemMeta itemMeta = item.getItemMeta();

        AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", 2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, healthModifier);
        itemMeta.addAttributeModifier(attribute, attributeModifier);

        item.setItemMeta(itemMeta);

        return item;
    }

    //Chests

    public static ItemStack Netherite_Chestplate(Attribute attribute, AttributeModifier attributeModifier){
        ItemStack item = new ItemStack(Material.NETHERITE_CHESTPLATE);
        ItemMeta itemMeta = item.getItemMeta();

        AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", 8, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier healthModifier2 = new AttributeModifier(UUID.randomUUID(), "generic.health2", 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier healthModifier3 = new AttributeModifier(UUID.randomUUID(), "generic.health3", 0.1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, healthModifier);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, healthModifier2);
        itemMeta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, healthModifier3);
        itemMeta.addAttributeModifier(attribute, attributeModifier);

        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack Diamond_Chestplate(Attribute attribute, AttributeModifier attributeModifier){
        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta itemMeta = item.getItemMeta();

        AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", 8, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier healthModifier2 = new AttributeModifier(UUID.randomUUID(), "generic.health2", 2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, healthModifier);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, healthModifier2);
        itemMeta.addAttributeModifier(attribute, attributeModifier);

        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack Golden_Chestplate(Attribute attribute, AttributeModifier attributeModifier){
        ItemStack item = new ItemStack(Material.GOLDEN_CHESTPLATE);
        ItemMeta itemMeta = item.getItemMeta();

        AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", 5, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, healthModifier);
        itemMeta.addAttributeModifier(attribute, attributeModifier);

        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack Iron_Chestplate(Attribute attribute, AttributeModifier attributeModifier){
        ItemStack item = new ItemStack(Material.IRON_CHESTPLATE);
        ItemMeta itemMeta = item.getItemMeta();

        AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", 6, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, healthModifier);
        itemMeta.addAttributeModifier(attribute, attributeModifier);

        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack Chainmail_Chestplate(Attribute attribute, AttributeModifier attributeModifier){
        ItemStack item = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
        ItemMeta itemMeta = item.getItemMeta();

        AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", 5, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, healthModifier);
        itemMeta.addAttributeModifier(attribute, attributeModifier);

        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack Leather_Chestplate(Attribute attribute, AttributeModifier attributeModifier){
        ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemMeta itemMeta = item.getItemMeta();

        AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, healthModifier);
        itemMeta.addAttributeModifier(attribute, attributeModifier);

        item.setItemMeta(itemMeta);

        return item;
    }

    //Legs

    public static ItemStack Netherite_Leggings(Attribute attribute, AttributeModifier attributeModifier){
        ItemStack item = new ItemStack(Material.NETHERITE_LEGGINGS);
        ItemMeta itemMeta = item.getItemMeta();

        AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", 6, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier healthModifier2 = new AttributeModifier(UUID.randomUUID(), "generic.health2", 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier healthModifier3 = new AttributeModifier(UUID.randomUUID(), "generic.health3", 0.1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, healthModifier);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, healthModifier2);
        itemMeta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, healthModifier3);
        itemMeta.addAttributeModifier(attribute, attributeModifier);

        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack Diamond_Leggings(Attribute attribute, AttributeModifier attributeModifier){
        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta itemMeta = item.getItemMeta();

        AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", 6, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        AttributeModifier healthModifier2 = new AttributeModifier(UUID.randomUUID(), "generic.health2", 2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, healthModifier);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, healthModifier2);
        itemMeta.addAttributeModifier(attribute, attributeModifier);

        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack Golden_Leggings(Attribute attribute, AttributeModifier attributeModifier){
        ItemStack item = new ItemStack(Material.GOLDEN_LEGGINGS);
        ItemMeta itemMeta = item.getItemMeta();

        AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, healthModifier);
        itemMeta.addAttributeModifier(attribute, attributeModifier);

        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack Iron_Leggings(Attribute attribute, AttributeModifier attributeModifier){
        ItemStack item = new ItemStack(Material.IRON_LEGGINGS);
        ItemMeta itemMeta = item.getItemMeta();

        AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", 5, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, healthModifier);
        itemMeta.addAttributeModifier(attribute, attributeModifier);

        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack Chainmail_Leggings(Attribute attribute, AttributeModifier attributeModifier){
        ItemStack item = new ItemStack(Material.CHAINMAIL_LEGGINGS);
        ItemMeta itemMeta = item.getItemMeta();

        AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", 4, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, healthModifier);
        itemMeta.addAttributeModifier(attribute, attributeModifier);

        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack Leather_Leggings(Attribute attribute, AttributeModifier attributeModifier){
        ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS);
        ItemMeta itemMeta = item.getItemMeta();

        AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", 2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, healthModifier);
        itemMeta.addAttributeModifier(attribute, attributeModifier);

        item.setItemMeta(itemMeta);

        return item;
    }

    //Boots

    public static ItemStack Netherite_Boots(Attribute attribute, AttributeModifier attributeModifier){
        ItemStack item = new ItemStack(Material.NETHERITE_BOOTS);
        ItemMeta itemMeta = item.getItemMeta();

        AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier healthModifier2 = new AttributeModifier(UUID.randomUUID(), "generic.health2", 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier healthModifier3 = new AttributeModifier(UUID.randomUUID(), "generic.health3", 0.1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, healthModifier);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, healthModifier2);
        itemMeta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, healthModifier3);
        itemMeta.addAttributeModifier(attribute, attributeModifier);

        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack Diamond_Boots(Attribute attribute, AttributeModifier attributeModifier){
        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta itemMeta = item.getItemMeta();

        AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        AttributeModifier healthModifier2 = new AttributeModifier(UUID.randomUUID(), "generic.health2", 2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, healthModifier);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, healthModifier2);
        itemMeta.addAttributeModifier(attribute, attributeModifier);

        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack Golden_Boots(Attribute attribute, AttributeModifier attributeModifier){
        ItemStack item = new ItemStack(Material.GOLDEN_BOOTS);
        ItemMeta itemMeta = item.getItemMeta();

        AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", 1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, healthModifier);
        itemMeta.addAttributeModifier(attribute, attributeModifier);

        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack Iron_Boots(Attribute attribute, AttributeModifier attributeModifier){
        ItemStack item = new ItemStack(Material.IRON_BOOTS);
        ItemMeta itemMeta = item.getItemMeta();

        AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", 2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, healthModifier);
        itemMeta.addAttributeModifier(attribute, attributeModifier);

        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack Chainmail_Boots(Attribute attribute, AttributeModifier attributeModifier){
        ItemStack item = new ItemStack(Material.CHAINMAIL_BOOTS);
        ItemMeta itemMeta = item.getItemMeta();

        AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", 1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, healthModifier);
        itemMeta.addAttributeModifier(attribute, attributeModifier);

        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack Leather_Boots(Attribute attribute, AttributeModifier attributeModifier){
        ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
        ItemMeta itemMeta = item.getItemMeta();

        AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "generic.health", 1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, healthModifier);
        itemMeta.addAttributeModifier(attribute, attributeModifier);

        item.setItemMeta(itemMeta);

        return item;
    }

}
