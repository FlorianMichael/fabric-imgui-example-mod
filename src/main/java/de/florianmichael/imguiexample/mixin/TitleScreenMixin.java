package de.florianmichael.imguiexample.mixin;

import de.florianmichael.imguiexample.imgui.RenderInterface;
import imgui.ImGui;
import imgui.ImGuiIO;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(TitleScreen.class)
public class TitleScreenMixin implements RenderInterface {

    @Override
    public void render(ImGuiIO io) {
        ImGui.begin("Hello World");
        // Draw something here, see the official example module for more information:
        // https://github.com/ocornut/imgui/blob/master/imgui_demo.cpp
        ImGui.end();

        ImGui.showDemoWindow();
    }

}
