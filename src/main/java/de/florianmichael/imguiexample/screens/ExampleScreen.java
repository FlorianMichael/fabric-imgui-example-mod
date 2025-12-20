package de.florianmichael.imguiexample.screens;

import de.florianmichael.imguiexample.imgui.RenderInterface;
import imgui.ImGui;
import imgui.ImGuiIO;
import imgui.type.ImBoolean;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public final class ExampleScreen extends Screen implements RenderInterface {

    private static final ImBoolean showDemoWindow = new ImBoolean(false);

    public ExampleScreen() {
        super(Component.literal("Example Screen"));
    }

    @Override
    public void render(ImGuiIO io) {
        if (ImGui.begin("Hello, World!")) {
            ImGui.setWindowSize(800, 600);
            ImGui.checkbox("Show Demo Window", showDemoWindow);
            ImGui.end();
        }

        ImGui.showDemoWindow(showDemoWindow);
    }

    @Override
    public boolean isPauseScreen() {
        return false; // Only relevant in singleplayer
    }

}
