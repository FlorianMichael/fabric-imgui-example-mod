/*
 * This file is part of fabric-imgui-example-mod - https://github.com/FlorianMichael/fabric-imgui-example-mod
 * by FlorianMichael/EnZaXD and contributors
 */
package de.florianmichael.imguiexample.imgui;

import imgui.*;
import imgui.extension.implot.ImPlot;
import imgui.flag.ImGuiConfigFlags;
import imgui.gl3.ImGuiImplGl3;
import imgui.glfw.ImGuiImplGlfw;

public class ImGuiImpl {
    private final static ImGuiImplGlfw imGuiImplGlfw = new ImGuiImplGlfw();
    private final static ImGuiImplGl3 imGuiImplGl3 = new ImGuiImplGl3();

    public static void create(final long handle) {
        ImGui.createContext();
        ImPlot.createContext();

        final ImGuiIO data = ImGui.getIO();
        data.setIniFilename("modid.ini");
        data.setFontGlobalScale(1F);

        // If you want to have custom fonts, you can use the following code here

//        {
//            final ImFontAtlas fonts = data.getFonts();
//            final ImFontGlyphRangesBuilder rangesBuilder = new ImFontGlyphRangesBuilder();
//
//            rangesBuilder.addRanges(data.getFonts().getGlyphRangesDefault());
//            rangesBuilder.addRanges(data.getFonts().getGlyphRangesCyrillic());
//            rangesBuilder.addRanges(data.getFonts().getGlyphRangesJapanese());
//
//            final short[] glyphRanges = rangesBuilder.buildRanges();
//
//            final ImFontConfig basicConfig = new ImFontConfig();
//            basicConfig.setGlyphRanges(data.getFonts().getGlyphRangesCyrillic());
//
//            final List<ImFont> generatedFonts = new ArrayList<>();
//            for (int i = 5 /* MINIMUM_FONT_SIZE */; i < 50 /* MAXIMUM_FONT_SIZE */; i++) {
//                basicConfig.setName("<Font Name> " + i + "px");
//                generatedFonts.add(fonts.addFontFromMemoryTTF(IOUtils.toByteArray(Objects.requireNonNull(ImGuiImpl.class.getResourceAsStream("<File Path>"))), i, basicConfig, glyphRanges));
//            }
//            fonts.build();
//            basicConfig.destroy();
//        }

        // The "generatedFonts" list now contains an ImFont for each scale from 5 to 50, you should save the font scales you want as global fields here to use them later:
        // For example:
        // defaultFont = generatedFonts.get(30); // Font scale is 30
        // How you can apply the font then, you can see in ExampleMixin

        imGuiImplGlfw.init(handle, true);

        data.setConfigFlags(ImGuiConfigFlags.DockingEnable);
        imGuiImplGl3.init();
    }

    public static void draw(final RenderInterface runnable) {
        imGuiImplGlfw.newFrame(); // Handle keyboard and mouse interactions
        ImGui.newFrame();
        runnable.render(ImGui.getIO());
        ImGui.render();

        imGuiImplGl3.renderDrawData(ImGui.getDrawData());
    }
}
