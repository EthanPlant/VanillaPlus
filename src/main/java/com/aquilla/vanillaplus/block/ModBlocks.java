package com.aquilla.vanillaplus.block;

import com.aquilla.vanillaplus.VanillaPlus;
import com.aquilla.vanillaplus.block.custom.ModStoneButtonBlock;
import com.aquilla.vanillaplus.block.custom.OxidizableButtonBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.Oxidizable;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static final Block OXIDIZED_COPPER_BUTTON = registerBlock("oxidized_copper_button",
            new OxidizableButtonBlock(Oxidizable.OxidationLevel.OXIDIZED, FabricBlockSettings.of(Material.METAL)
                    .strength(1.0f).requiresTool().noCollision().sounds(BlockSoundGroup.COPPER)), ItemGroup.REDSTONE);

    public static final Block WEATHERED_COPPER_BUTTON = registerBlock("weathered_copper_button",
            new OxidizableButtonBlock(Oxidizable.OxidationLevel.WEATHERED, FabricBlockSettings.of(Material.METAL)
                    .strength(1.0f).requiresTool().noCollision().sounds(BlockSoundGroup.COPPER)), ItemGroup.REDSTONE);

    public static final Block EXPOSED_COPPER_BUTTON = registerBlock("exposed_copper_button",
            new OxidizableButtonBlock(Oxidizable.OxidationLevel.EXPOSED, FabricBlockSettings.of(Material.METAL)
                    .strength(1.0f).requiresTool().noCollision().sounds(BlockSoundGroup.COPPER)), ItemGroup.REDSTONE);

    public static final Block COPPER_BUTTON = registerBlock("copper_button",
            new OxidizableButtonBlock(Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.of(Material.METAL)
                    .strength(1.0f).requiresTool().noCollision().sounds(BlockSoundGroup.COPPER)), ItemGroup.REDSTONE);

    public static final Block WAXED_OXIDIZED_COPPER_BUTTON = registerBlock("waxed_oxidized_copper_button",
            new ModStoneButtonBlock(FabricBlockSettings.of(Material.METAL)
                    .strength(1.0f).requiresTool().noCollision().sounds(BlockSoundGroup.COPPER)), ItemGroup.REDSTONE);

    public static final Block WAXED_WEATHERED_COPPER_BUTTON = registerBlock("waxed_weathered_copper_button",
            new ModStoneButtonBlock(FabricBlockSettings.of(Material.METAL)
                    .strength(1.0f).requiresTool().noCollision().sounds(BlockSoundGroup.COPPER)), ItemGroup.REDSTONE);

    public static final Block WAXED_EXPOSED_COPPER_BUTTON = registerBlock("waxed_exposed_copper_button",
            new ModStoneButtonBlock(FabricBlockSettings.of(Material.METAL)
                    .strength(1.0f).requiresTool().noCollision().sounds(BlockSoundGroup.COPPER)), ItemGroup.REDSTONE);

    public static final Block WAXED_COPPER_BUTTON = registerBlock("waxed_copper_button",
            new ModStoneButtonBlock(FabricBlockSettings.of(Material.METAL)
                    .strength(1.0f).requiresTool().noCollision().sounds(BlockSoundGroup.COPPER)), ItemGroup.REDSTONE);


    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(VanillaPlus.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(VanillaPlus.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }

    private static void initOxidizables() {
        OxidizableBlocksRegistry.registerOxidizableBlockPair(COPPER_BUTTON, EXPOSED_COPPER_BUTTON);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(EXPOSED_COPPER_BUTTON, WEATHERED_COPPER_BUTTON);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(WEATHERED_COPPER_BUTTON, OXIDIZED_COPPER_BUTTON);

        OxidizableBlocksRegistry.registerWaxableBlockPair(COPPER_BUTTON, WAXED_COPPER_BUTTON);
        OxidizableBlocksRegistry.registerWaxableBlockPair(EXPOSED_COPPER_BUTTON, WAXED_EXPOSED_COPPER_BUTTON);
        OxidizableBlocksRegistry.registerWaxableBlockPair(WEATHERED_COPPER_BUTTON, WAXED_WEATHERED_COPPER_BUTTON);
        OxidizableBlocksRegistry.registerWaxableBlockPair(OXIDIZED_COPPER_BUTTON, WAXED_OXIDIZED_COPPER_BUTTON);
    }

    public static void registerModBlocks() {
        VanillaPlus.LOGGER.info("Registering blocks for " + VanillaPlus.MOD_ID);

        initOxidizables();
    }
}
