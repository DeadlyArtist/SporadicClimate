package sporadicclimate.item;

import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;

public class ModItems {

    public static Map<Identifier, ItemData> data = new HashMap<>();


    public static ItemData register(ItemData.Builder builder) {
        var item = builder.build();
        data.put(item.id, item);
        return item;
    }

    public static void init() {

    }
}
