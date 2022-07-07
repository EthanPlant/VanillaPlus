package com.aquilla.vanillaplus.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Oxidizable;
import net.minecraft.block.StoneButtonBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public class OxidizableButtonBlock extends StoneButtonBlock implements Oxidizable {
    private final OxidationLevel oxidationLevel;

    public OxidizableButtonBlock(Oxidizable.OxidationLevel oxidationlevel, Settings settings) {
        super(settings);
        this.oxidationLevel = oxidationlevel;
    }

    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        this.tickDegradation(state, world, pos, random);
    }

    public boolean hasRandomTicks(BlockState state) {
        return Oxidizable.getIncreasedOxidationBlock(state.getBlock()).isPresent();
    }

    @Override
    public OxidationLevel getDegradationLevel() {
        return this.oxidationLevel;
    }
}
