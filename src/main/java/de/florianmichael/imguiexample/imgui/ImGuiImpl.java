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
import org.lwjgl.glfw.GLFW;

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

        data.setConfigFlags(ImGuiConfigFlags.DockingEnable);
        // In case you want to enable Viewports on Windows, you have to do this instead of the above line:
        // data.setConfigFlags(ImGuiConfigFlags.DockingEnable | ImGuiConfigFlags.ViewportsEnable);

        imGuiImplGlfw.init(handle, true);
        imGuiImplGl3.init();
    }

    public static void draw(final RenderInterface runnable) {
        imGuiImplGlfw.newFrame(); // Handle keyboard and mouse interactions
        ImGui.newFrame();
        runnable.render(ImGui.getIO());
        ImGui.render();

        imGuiImplGl3.renderDrawData(ImGui.getDrawData());
        if (ImGui.getIO().hasConfigFlags(ImGuiConfigFlags.ViewportsEnable)) {
            final long pointer = GLFW.glfwGetCurrentContext();
            ImGui.updatePlatformWindows();
            ImGui.renderPlatformWindowsDefault();

            GLFW.glfwMakeContextCurrent(pointer);
        }
    }

// https://gist.github.com/FlorianMichael/b9d5ea2a4cb89c99e6da7dad68524c07
// Can be used to load buffered images in ImGui
//    public static int fromBufferedImage(BufferedImage image) {
//        final int[] pixels = new int[image.getWidth() * image.getHeight()];
//        image.getRGB(0, 0, image.getWidth(), image.getHeight(), pixels, 0, image.getWidth());
//
//        final ByteBuffer buffer = BufferUtils.createByteBuffer(image.getWidth() * image.getHeight() * 4);
//
//        for (int y = 0; y < image.getHeight(); y++) {
//            for (int x = 0; x < image.getWidth(); x++) {
//                final int pixel = pixels[y * image.getWidth() + x];
//
//                buffer.put((byte) ((pixel >> 16) & 0xFF));
//                buffer.put((byte) ((pixel >> 8) & 0xFF));
//                buffer.put((byte) (pixel & 0xFF));
//                buffer.put((byte) ((pixel >> 24) & 0xFF));
//            }
//        }
//
//        buffer.flip();
//
//        final int texture = GlStateManager._genTexture();
//        GlStateManager._bindTexture(texture);
//
//        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
//        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
//
//        GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA8, image.getWidth(), image.getHeight(), 0, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, buffer);
//
//        return texture;
//    }
}
