package sporadicclimate.fabric;

import sporadicclimate.component.ModComponents;
import sporadicclimate.item.ModBlocks;
import sporadicclimate.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class RegistryInitManagerFabric {
    public static void registerComponents() {
        ModComponents.data.forEach((id, obj) -> {
            Registry.register(Registries.DATA_COMPONENT_TYPE, id, obj);
        });
    }

    public static void registerBlocks() {
        ModBlocks.data.forEach((id, obj) -> {
            Registry.register(Registries.BLOCK, id, obj.get());
        });
    }

    public static void registerItems() {
        ModItems.data.forEach((id, obj) -> {
            Registry.register(Registries.ITEM, id, obj.get());
            for (var group : obj.groups) {
                ItemGroupEvents.modifyEntriesEvent(group).register((itemGroup) -> itemGroup.add(obj.get()));
            }
        });
    }

    public static void init() {
        registerComponents();
        registerBlocks();
        registerItems();
    }
}
