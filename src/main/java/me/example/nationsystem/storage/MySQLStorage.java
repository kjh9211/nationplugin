package me.example.nationsystem.storage;

import org.bukkit.plugin.java.JavaPlugin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLStorage implements Storage {

    private final JavaPlugin plugin;
    private Connection connection;

    public MySQLStorage(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void load() {
        String host = plugin.getConfig().getString("mysql.host");
        int port = plugin.getConfig().getInt("mysql.port");
        String database = plugin.getConfig().getString("mysql.database");
        String username = plugin.getConfig().getString("mysql.username");
        String password = plugin.getConfig().getString("mysql.password");
        boolean useSSL = plugin.getConfig().getBoolean("mysql.useSSL");

        String url = "jdbc:mysql://" + host + ":" + port + "/" + database + "?useSSL=" + useSSL;

        try {
            connection = DriverManager.getConnection(url, username, password);
            plugin.getLogger().info("MySQL 연결 성공.");
        } catch (SQLException e) {
            plugin.getLogger().severe("MySQL 연결 실패: " + e.getMessage());
        }
    }

    @Override
    public void save() {
        plugin.getLogger().info("MySQL 저장 방식은 개별 쿼리를 통해 자동으로 수행됩니다.");
    }

    public Connection getConnection() {
        return connection;
    }
}
