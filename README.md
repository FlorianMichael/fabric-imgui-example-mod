# Fabric ImGui Example Mod

## Setup

For setup instructions please see the [fabric wiki page](https://fabricmc.net/wiki/tutorial:setup) that relates to the IDE that you are using.

## ImGui usage
You can just draw ImGui stuff using this:
```java
ImGuiImpl.draw(io -> {
    if (ImGui.begin("Hello World")) {
        ImGui.end();
    }
    ImGui.showDemoWindow();
});
```
Keep in mind that ImGui needs to be initalized, so you must not remove the MinecraftClient mixin in the ImGui package

## License

This template is available under the CC0 license. Feel free to learn from it and incorporate it in your own projects.
