package de.florianmichael.imguiexample;

import de.florianmichael.imguiexample.screens.ExampleScreen;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("modid");

    public static final KeyBinding EXAMPLE_KEYBINDING = new KeyBinding(
            "key.imguiexample.example_keybinding",
            GLFW.GLFW_KEY_RIGHT_SHIFT,
            "key.categories.imguiexample"
    );

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        LOGGER.info("Hello Fabric world!");

        // Ingame example with ImGui, also see GameRendererMixin
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (EXAMPLE_KEYBINDING.wasPressed()) {
                client.setScreen(new ExampleScreen());
            }
        });
    }
}
