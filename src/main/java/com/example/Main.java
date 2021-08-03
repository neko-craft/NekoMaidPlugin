package com.example;

import cn.apisium.nekomaid.NekoMaid;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.annotation.dependency.Dependency;
import org.bukkit.plugin.java.annotation.plugin.ApiVersion;
import org.bukkit.plugin.java.annotation.plugin.Description;
import org.bukkit.plugin.java.annotation.plugin.Plugin;
import org.bukkit.plugin.java.annotation.plugin.Website;
import org.bukkit.plugin.java.annotation.plugin.author.Author;

@Plugin(name = "ExamplePlugin", version = "0.0.0")
@Description("An example plugin for NekoMaid.")
@Author("Someone")
@Website("https://neko-craft.com")
@ApiVersion(ApiVersion.Target.v1_13)
@Dependency("NekoMaid")
public class Main extends JavaPlugin {
    @SuppressWarnings("deprecation")
    @Override
    public void onEnable() {
        NekoMaid.INSTANCE
                .addScript(this, getConfig().getString("script", "http://127.0.0.1:1234/index.js"))
                .onConnected(this, client -> client.onWithAck("motd", () -> getServer().getMotd()));
    }
}
