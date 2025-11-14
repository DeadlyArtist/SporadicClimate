package sporadicclimate.item;

import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.HashMap;
import java.util.Map;

public class ModBlocks {
    public static Map<Identifier, BlockData> data = new HashMap<>();


    public static BlockData register(BlockData.Builder builder) {
        var block = builder.build();
        data.put(block.id, block);
        ModItems.register(ItemData.fromBlock(block));
        return block;
    }

    public static void init() {

    }
}
