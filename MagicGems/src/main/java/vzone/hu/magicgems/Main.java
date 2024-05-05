package vzone.hu.magicgems;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import vzone.hu.magicgems.Events.DamageEvent;
import vzone.hu.magicgems.Events.HurtEvent;
import vzone.hu.magicgems.inventorys.clean;
import vzone.hu.magicgems.inventorys.upgrade;

import java.io.File;
import java.io.IOException;

public final class Main extends JavaPlugin implements Listener {

    private File messagesConfigFile;
    private FileConfiguration messagesConfig;
    private File cleanGuiConfigFile;
    private FileConfiguration cleanGuiConfig;
    private File upgardeGuiConfigFile;
    private FileConfiguration upgardeGuiConfig;
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new clean(this), this);
        getServer().getPluginManager().registerEvents(new command(this), this);
        getServer().getPluginManager().registerEvents(new upgrade(this), this);
        getServer().getPluginManager().registerEvents(new DamageEvent(this), this);
        getServer().getPluginManager().registerEvents(new HurtEvent(this), this);
        getServer().getPluginManager().registerEvents(new ArmorAttributes(), this);
        //getServer().getPluginManager().registerEvents(new TesztClass(this), this);
        getCommand("magicgems").setExecutor(new command(this));
        createMessagesConfig();
        createcleanGuiConfig();
        createupgardeGuiConfig();
        File configFile = new File(getDataFolder(), "config.yml");
        if (!configFile.exists()) {
            getConfig().options().copyDefaults(true);
        }
        saveConfig();
    }

    public void reloadMessagesConfig() {
        if (messagesConfigFile != null) {
            messagesConfig = YamlConfiguration.loadConfiguration(messagesConfigFile);
        }else{
            Bukkit.getServer().getConsoleSender().sendMessage("§c[ERROR] MagicGems | Messages.yml not found.");
            Bukkit.getPluginManager().disablePlugin(this);
        }
    }

    public void reloadcleanGuiConfig() {
        if (cleanGuiConfigFile != null) {
            cleanGuiConfig = YamlConfiguration.loadConfiguration(cleanGuiConfigFile);
        }else{
            Bukkit.getServer().getConsoleSender().sendMessage("§c[ERROR] MagicGems | cleanGui.yml not found.");
            Bukkit.getPluginManager().disablePlugin(this);
        }
    }

    public void reloadupgardeGuiConfig() {
        if (upgardeGuiConfigFile != null) {
            upgardeGuiConfig = YamlConfiguration.loadConfiguration(upgardeGuiConfigFile);
        }else{
            Bukkit.getServer().getConsoleSender().sendMessage("§c[ERROR] MagicGems | upgardeGui.yml not found.");
            Bukkit.getPluginManager().disablePlugin(this);
        }
    }


    public FileConfiguration getMessagesConfig() {
        return this.messagesConfig;
    }
    public FileConfiguration getcleanGuiConfig() {
        return this.cleanGuiConfig;
    }
    public FileConfiguration getupgardeGuiConfig() {
        return this.upgardeGuiConfig;
    }

    private void createMessagesConfig() {
        messagesConfigFile = new File(getDataFolder(), "messages.yml");
        if (!messagesConfigFile.exists()) {
            messagesConfigFile.getParentFile().mkdirs();
            saveResource("messages.yml", false);
        }

        messagesConfig = new YamlConfiguration();
        try {
            messagesConfig.load(messagesConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    private void createcleanGuiConfig() {
        cleanGuiConfigFile = new File(getDataFolder(), "cleanGui.yml");
        if (!cleanGuiConfigFile.exists()) {
            cleanGuiConfigFile.getParentFile().mkdirs();
            saveResource("cleanGui.yml", false);
        }

        cleanGuiConfig = new YamlConfiguration();
        try {
            cleanGuiConfig.load(cleanGuiConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    private void createupgardeGuiConfig() {
        upgardeGuiConfigFile = new File(getDataFolder(), "upgardeGui.yml");
        if (!upgardeGuiConfigFile.exists()) {
            upgardeGuiConfigFile.getParentFile().mkdirs();
            saveResource("upgardeGui.yml", false);
        }

        upgardeGuiConfig = new YamlConfiguration();
        try {
            upgardeGuiConfig.load(upgardeGuiConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
