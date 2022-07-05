package com.aquilla.vanillaplus.item;

import com.aquilla.vanillaplus.VanillaPlus;
import com.aquilla.vanillaplus.item.custom.ModAxeItem;
import com.aquilla.vanillaplus.item.custom.ModHoeItem;
import com.aquilla.vanillaplus.item.custom.ModPickaxeItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item COPPER_NUGGET = registerItem("copper_nugget",
            new Item(new FabricItemSettings().group(ItemGroup.MISC)));

    public static final Item COPPER_SWORD = registerItem("copper_sword",
            new SwordItem(ModToolMaterials.COPPER, 3, -2.4F, new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item COPPER_AXE = registerItem("copper_axe",
            new ModAxeItem(ModToolMaterials.COPPER, 7.0F, -3.1F, new FabricItemSettings().group(ItemGroup.TOOLS)));

    public static final Item COPPER_HOE = registerItem("copper_hoe",
            new ModHoeItem(ModToolMaterials.COPPER, -1, -2.0F, new FabricItemSettings().group(ItemGroup.TOOLS)));

    public static final Item COPPER_PICKAXE = registerItem("copper_pickaxe",
            new ModPickaxeItem(ModToolMaterials.COPPER, 1, -2.8F, new FabricItemSettings().group(ItemGroup.TOOLS)));

    public static final Item COPPER_SHOVEL = registerItem("copper_shovel",
            new ShovelItem(ModToolMaterials.COPPER, 1.5F, -3.0F, new FabricItemSettings().group(ItemGroup.TOOLS)));

    public static final Item COPPER_HELMET = registerItem("copper_helmet",
            new ArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.HEAD, new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item COPPER_CHESTPLATE = registerItem("copper_chestplate",
            new ArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.CHEST, new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item COPPER_LEGGINGS = registerItem("copper_leggings",
            new ArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.LEGS, new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item COPPER_BOOTS = registerItem("copper_boots",
            new ArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.FEET, new FabricItemSettings().group(ItemGroup.COMBAT)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(VanillaPlus.MOD_ID, name), item);
    }

    public static void registerModItems() {
        VanillaPlus.LOGGER.info("Register items for " + VanillaPlus.MOD_ID);
    }
}
