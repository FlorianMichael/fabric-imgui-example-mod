package de.florianmichael.imguiexample.mixin;

import de.florianmichael.imguiexample.ExampleMod;
import de.florianmichael.imguiexample.imgui.ImGuiImpl;
import imgui.ImGui;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class ExampleMixin {
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		ExampleMod.LOGGER.info("This line is printed by an example mod mixin!");
	}

	@Inject(method = "render", at = @At("RETURN"))
	private void render(MatrixStack matrices, int mouseX, int mouseY, float delta, CallbackInfo ci) {
		ImGuiImpl.draw(io -> {
			// Example on how to use a custom Font
			// ImGui.pushFont(ImGuiImpl.defaultFont);
			if (ImGui.begin("Hello World")) {
				ImGui.end();
			}

			ImGui.showDemoWindow();
			// ImGui.popFont();
		});
	}
}
