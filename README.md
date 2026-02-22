# This project is most likely end of life

Mojang Studios
has [recently announced](https://www.minecraft.net/en-us/article/another-step-towards-vibrant-visuals-for-java-edition)
that Minecraft will transition its graphics engine from OpenGL to Vulkan.

At the time of writing, the [imgui-java](https://github.com/SpaiR/imgui-java) project used by this template does not yet
support the Vulkan graphics API (see the pull request [here](https://github.com/SpaiR/imgui-java/pull/120)). As a
result, this
project will most likely stop working following the release of Minecraft 26.2.

# Fabric ImGui Example Mod

This example contains the following features:

- Basic ImGui/ImPlot Usage
- Custom Font Rendering
- Basic Viewport implementation
- Image loading into ImGui

## Setup

For setup instructions please see the [fabric wiki page](https://fabricmc.net/wiki/tutorial:setup) that relates to the
IDE that you are using.

## ImGui usage

You can draw ImGui elements at any point in the render pipeline using this:

```java
ImGuiImpl.draw(io -> {
    if (ImGui.begin("Hello World")) {
        ImGui.end();
    }
    ImGui.showDemoWindow();
});
```

Keep in mind that ImGui needs to be initialized, so you must not remove the MinecraftClient mixin in the ImGui package.

### Screens

When your rendering has to be found to a screen (e.g. like the ExampleScreen), implement the `RenderInterface` in your
screen class
and override the given render functions. That requires the GameRenderer mixin in the ImGui package.

## License

This template is available under the CC0 license. Feel free to learn from it and incorporate it in your own projects.
