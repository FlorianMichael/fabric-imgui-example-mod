/*
 * This file is part of fabric-imgui-example-mod - https://github.com/FlorianMichael/fabric-imgui-example-mod
 * by FlorianMichael/EnZaXD and contributors
 */
package de.florianmichael.imguiexample.imgui;

import imgui.ImGui;
import imgui.ImGuiIO;
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

        imGuiImplGlfw.init(handle, true);

        data.setNavActive(false);
        data.setNavVisible(false);
        data.setKeyCtrl(false);

        data.setConfigFlags(ImGuiConfigFlags.NavNoCaptureKeyboard | ImGuiConfigFlags.DockingEnable);
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
