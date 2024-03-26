package hitachi.nofishingInspawn

import net.md_5.bungee.api.ChatColor
import java.util.regex.Pattern

object HexUtil {
    fun color(message: String): String {
        var message = message
        val pattern = Pattern.compile("&#([A-Fa-f0-9]{6})")
        val matcher = pattern.matcher(message)
        while (matcher.find()) {
            val color = matcher.group(1)
            val replacement = ChatColor.of("#$color").toString()
            message = message.replace("&#$color", replacement)
        }
        message = message.replace("\n", "\n")
        return ChatColor.translateAlternateColorCodes('&', message)
    }
}