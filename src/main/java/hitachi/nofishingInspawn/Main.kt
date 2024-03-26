package hitachi.nofishingInspawn

import hitachi.nofishingInspawn.HexUtil.color
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.java.JavaPlugin
import java.util.*


class Main : JavaPlugin(), Listener {
    companion object {
        var getValues: Plugin? = null
    }

    override fun onEnable() {
        getValues = this
        saveDefaultConfig()
        server.pluginManager.registerEvents(this, this)
    }

    @EventHandler
    fun onClick(event: PlayerInteractEvent) {
        val player = event.player
        if (event.material == Material.FISHING_ROD) {
            val exceptionWorlds = this.config.getStringList("name-world")
            if (exceptionWorlds.contains(player.world.name)) {
                if (event.action == Action.RIGHT_CLICK_AIR || event.action == Action.RIGHT_CLICK_BLOCK) {
                    event.isCancelled = true;
                    player.sendMessage(color(this.config.getString("message")!!))
                }
            }
        }
    }
}
