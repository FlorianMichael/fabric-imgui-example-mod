/*
 * This file is part of fabric-imgui-example-mod - https://github.com/florianreuth/fabric-imgui-example-mod
 * by Florian Reuth and contributors
 */
package de.florianreuth.imguiexample.imgui;

import imgui.ImGuiIO;

@FunctionalInterface
public interface RenderInterface {

    void render(final ImGuiIO io);

}
