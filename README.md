# Block render layer transformer

## What for?

This mod allows you to modify the render layer type of blocks (or fluid) in your resource pack, 
so that transparent textures can be used on non-transparent blocks, and so on.

## Why?

In vanilla minecraft, you cannot just put an texture with alpha channel on a normally solid-rendered block
and hope it works to be transparent. You can only get a white "background" in the texture. However, by using this
mod,  you can modify or \*tweak* the vanilla behavior of block rendering, making it possible to have a transparent
texture on a normally solid-rendered block.

## How?

add key pairs like:

    "blockIDNamespace" : "RenderLayerTypeName"
    
into 

    assets/render_layer_trans/lang/en_us.json
    
## Example

by adding 

    "render_layer_transformer.fluid.minecraft:lava" : "translucent"

and use lava textures with transparency, you can get a clear lava lake.

https://github.com/X-Green/Minecraft-Clear-Lava-Texture



## Keys for reference

for block and fluid IDs, see [BlockIDs](docs/BlockIDs.txt)

for render types, see [RenderLayerTypes](docs/RenderLayerTypes.txt)


