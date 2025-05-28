package me.example.nationsystem.storage;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class YamlStorage implements Storage {

    private final JavaPlugin plugin;
    private File file;
    private YamlConfiguration data;

    public YamlStorage(JavaPlugin plugin) {
        this.plugin = plugin;
        this.file = new File(plugin.getDataFolder(), "data.yml");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                plugin.getLogger().severe("data.yml 파일 생성 실패: " + e.getMessage());
            }
        }
        this.data = YamlConfiguration.loadConfiguration(file);
    }

    @Override
    public void load() {
        data = YamlConfiguration.loadConfiguration(file);
        plugin.getLogger().info("YAML 저장소에서 데이터 로드 완료.");
    }

    @Override
    public void save() {
        try {
            data.save(file);
            plugin.getLogger().info("YAML 저장소에 데이터 저장 완료.");
        } catch (IOException e) {
            plugin.getLogger().severe("data.yml 저장 실패: " + e.getMessage());
        }
    }

    public YamlConfiguration getData() {
        return data;
    }
}
