package me.example.nationsystem;

import me.example.nationsystem.commands.AdminCommand;
import me.example.nationsystem.commands.NationCommand;
import me.example.nationsystem.storage.*;
import org.bukkit.plugin.java.JavaPlugin;

public class NationSystem extends JavaPlugin {

    private Storage storage;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        String type = getConfig().getString("storage-type", "local");

        switch (type.toLowerCase()) {
            case "mysql":
                storage = new MySQLStorage(this);
                break;
            default:
                storage = new YamlStorage(this);
        }

        storage.load();
        getCommand("국가").setExecutor(new NationCommand());
        getCommand("admin").setExecutor(new AdminCommand());


        getLogger().info("NationSystem 플러그인이 활성화되었습니다.");
    }

    @Override
    public void onDisable() {
        if (storage != null) {
            storage.save();
        }
        getLogger().info("NationSystem 플러그인이 비활성화되었습니다.");
    }

    public Storage getStorage() {
        return storage;
    }
}
