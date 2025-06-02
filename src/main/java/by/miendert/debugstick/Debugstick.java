package by.miendert.debugstick;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Debugstick extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("DebugStickPlugin включен!");
    }

    @Override
    public void onDisable() {
        getLogger().info("DebugStickPlugin выключен!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("debugstick")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("Эта команда недоступна из консоли!");
                return true;
            }

            Player player = (Player) sender;

            // Проверяем разрешение (по желанию)
            if (!player.hasPermission("debugstick.use")) {
                player.sendMessage("У вас нет разрешения на использование этой команды!");
                return true;
            }

            // Создаем debug stick
            ItemStack debugStick = new ItemStack(Material.DEBUG_STICK);

            if (player.getInventory().contains(Material.DEBUG_STICK)) {
                player.sendMessage("У вас уже есть debug stick!");
                return true;
            }

            // Выдаем предмет игроку
            player.getInventory().addItem(debugStick);
            player.sendMessage("Вам выдан debug stick!");

            return true;
        }
        return false;
    }
}
