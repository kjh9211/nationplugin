package me.example.nationsystem.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class AdminCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!sender.hasPermission("nation.admin")) {
            sender.sendMessage("§c이 명령어를 사용할 권한이 없습니다.");
            return true;
        }

        if (args.length == 0) {
            sender.sendMessage("§e사용법: /admin 설정|리로드|강제삭제 ...");
            return true;
        }

        switch (args[0].toLowerCase()) {
            case "설정":
                // config.yml 설정 변경
                sender.sendMessage("§a설정을 변경합니다.");
                break;
            case "리로드":
                sender.sendMessage("§a플러그인 설정을 다시 불러옵니다.");
                break;
            case "강제삭제":
                // 국가 강제 삭제
                sender.sendMessage("§a국가를 강제 삭제합니다.");
                break;
            default:
                sender.sendMessage("§c알 수 없는 관리자 명령어입니다.");
        }

        return true;
    }
}
