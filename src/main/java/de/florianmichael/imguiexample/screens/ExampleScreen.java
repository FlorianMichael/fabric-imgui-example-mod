package de.florianmichael.imguiexample.screens;

import de.florianmichael.imguiexample.imgui.ImGuiImpl;
import imgui.ImGui;
import imgui.flag.ImGuiWindowFlags;
import imgui.type.ImBoolean;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ExampleScreen extends Screen {
    public ExampleScreen() {
        super(Text.literal("Example Screen"));
    }

    private static final ImBoolean showDemoWindow = new ImBoolean(false);

    @Override
    public boolean shouldPause() {
        return false; // Don't pause the game
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return true; // Allow closing with ESC
    }

    @Override
    public void renderBackground(DrawContext context, int mouseX, int mouseY, float delta) {} // No background rendering needed

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        ImGuiImpl.draw(io -> {
            if(ImGui.begin("Hello, World!", ImGuiWindowFlags.None)) {
                ImGui.setWindowSize(800, 600);

                ImGui.checkbox("Show Demo Window", showDemoWindow);
            }
            ImGui.end();

            ImGui.showDemoWindow(showDemoWindow);
        });
    }
}
