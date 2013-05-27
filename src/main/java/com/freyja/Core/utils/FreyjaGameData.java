package com.freyja.core.utils;

import com.google.common.collect.Maps;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.registry.ItemData;
import net.minecraft.item.Item;

import java.util.HashMap;

/**
 * @author Freyja
 *         Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class FreyjaGameData {
    private static HashMap<Integer, String> idMap = Maps.newHashMap();

    public static Boolean partofMod(String modId, int itemID)
    {
        return !(idMap.isEmpty() || !idMap.containsKey(itemID)) && idMap.get(itemID).equals(modId);
    }

    public static void newItemAdded(Item item)
    {
        ModContainer mc = Loader.instance().activeModContainer();
        if (mc == null) {
            mc = Loader.instance().getMinecraftModContainer();
        }
        String itemType = item.getClass().getName();
        ItemData itemData = new ItemData(item, mc);

        if (!"Minecraft".equals(itemData.getModId())) {
            idMap.put(itemData.getItemId(), itemData.getModId());
        }
    }

}
