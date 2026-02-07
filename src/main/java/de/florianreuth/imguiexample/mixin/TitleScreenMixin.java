package de.florianreuth.imguiexample.mixin;

import de.florianreuth.imguiexample.screens.ExampleScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin extends Screen {

    protected TitleScreenMixin(Component title) {
        super(title);
    }

    @Inject(method = "init", at = @At("RETURN"))
    public void render(CallbackInfo ci) {
        this.addRenderableWidget(Button.builder(Component.literal("ImGui Demo"), (button) -> {
            Minecraft.getInstance().setScreen(new ExampleScreen());
        }).bounds(this.width - 75 - 3, 3, 70, 20).build());
    }
}
