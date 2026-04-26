package de.florianreuth.imguiexample.mixin.imgui;

import de.florianreuth.imguiexample.imgui.RenderInterface;
import foundry.imgui.api.ImGuiMC;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.DeltaTracker;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class GameRendererMixin {

    @Shadow
    @Final
    private Minecraft minecraft;

    @Inject(method = "render", at = @At("RETURN"))
    private void render(DeltaTracker tickCounter, boolean tick, CallbackInfo ci) {
        if (minecraft.screen instanceof final RenderInterface renderInterface) {
            try (ImGuiMC.ActiveContext context = ImGuiMC.withImGui()) {
                if (context != null) {
                    renderInterface.render(context.io());
                }
            }
        }
    }

}
