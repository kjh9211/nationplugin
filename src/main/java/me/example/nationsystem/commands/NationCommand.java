package me.example.nationsystem.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NationCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("플레이어만 사용할 수 있는 명령어입니다.");
            return true;
        }

        if (args.length == 0) {
            player.sendMessage("§e사용법: /국가 생성|초대|수락|강등|승급|채팅|창고|스폰|스폰지정");
            return true;
        }

        switch (args[0].toLowerCase()) {
            case "생성":
                // NationManager.createNation(player, ...);
                player.sendMessage("§a국가를 생성합니다.");
                break;
            case "초대":
                // NationManager.invite(player, args[1]);
                player.sendMessage("§a초대를 보냈습니다.");
                break;
            case "수락":
                if (args.length < 2) {
                    player.sendMessage("§c사용법: /국가 수락 [국가명]");
                    return true;
                }
                player.sendMessage("§a" + args[1] + " 국가의 초대를 수락했습니다.");
                break;
            case "강등":
            case "승급":
            case "채팅":
            case "창고":
            case "스폰":
            case "스폰지정":
                player.sendMessage("§e이 기능은 아직 개발 중입니다.");
                break;
            default:
                player.sendMessage("§c알 수 없는 하위 명령어입니다.");
        }

        return true;
    }
}
