package com.javaman.subterranean.decorator;

import com.google.common.base.Predicate;
import com.javaman.subterranean.blocks.ModBlocks;

import net.minecraft.block.BlockStone;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

class SubPredicate implements Predicate<IBlockState>
{
    public SubPredicate()
    {
    }

    public boolean apply(IBlockState p_apply_1_)
    {
        if (p_apply_1_ != null && p_apply_1_.getBlock() == ModBlocks.lapisCobblestone)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
