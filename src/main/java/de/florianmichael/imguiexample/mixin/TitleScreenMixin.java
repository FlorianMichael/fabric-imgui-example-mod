package de.florianmichael.imguiexample.mixin;

import de.florianmichael.imguiexample.imgui.RenderInterface;
import de.florianmichael.imguiexample.screens.ExampleScreen;
import imgui.ImGui;
import imgui.ImGuiIO;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.Text;
import net.minecraft.world.gen.GeneratorOptions;
import net.minecraft.world.gen.WorldPresets;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin extends Screen {

    protected TitleScreenMixin(Text title) {
        super(title);
    }

    @Inject(method = "init", at = @At("RETURN"))
    public void render(CallbackInfo ci) {
        this.addDrawableChild(ButtonWidget.builder(Text.literal("ImGui Demo"), (button) -> {
            MinecraftClient.getInstance().setScreen(new ExampleScreen());
        }).dimensions(this.width - 75 - 3, 3, 70, 20).build());
    }
}
