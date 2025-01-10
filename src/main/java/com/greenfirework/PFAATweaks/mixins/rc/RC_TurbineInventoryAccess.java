package com.greenfirework.PFAATweaks.mixins.rc;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import mods.railcraft.common.blocks.RailcraftTileEntity;
import mods.railcraft.common.blocks.machine.TileMultiBlock;
import mods.railcraft.common.blocks.machine.alpha.TileSteamTurbine;
import mods.railcraft.common.util.inventory.StandaloneInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

@Mixin(value=TileSteamTurbine.class, remap=true)
public abstract class RC_TurbineInventoryAccess extends TileMultiBlock implements IInventory {

	@Shadow(remap=false)
    private final StandaloneInventory inv;
	
	
	
	public RC_TurbineInventoryAccess() {
		super(null);
		this.inv = null;
	}
	
	public int getSizeInventory() {
        return this.inv.getSizeInventory();
	}

	public ItemStack getStackInSlot(int slotIn) {
        final RC_TurbineInventoryAccessor mBlock = (RC_TurbineInventoryAccessor)this.getMasterBlock();
        if (mBlock != null && this.isStructureValid()) {
            return mBlock.getInv().getStackInSlot(slotIn);
        }
        return null;
	}

	public ItemStack decrStackSize(int index, int count) {
        final RC_TurbineInventoryAccessor mBlock = (RC_TurbineInventoryAccessor)this.getMasterBlock();
        if (mBlock != null && this.isStructureValid()) {
            return mBlock.getInv().decrStackSize(index, count);
        }
        return null;
	}

	public ItemStack getStackInSlotOnClosing(int index) {
		return null;
	}

	public void setInventorySlotContents(int index, ItemStack stack) {
        final RC_TurbineInventoryAccessor mBlock = (RC_TurbineInventoryAccessor)this.getMasterBlock();
        if (mBlock != null && this.isStructureValid()) {
            mBlock.getInv().setInventorySlotContents(index, stack);
        }
	}

	public String getInventoryName() {
		return this.getName();
	}

	@Override
	public boolean hasCustomInventoryName() {
        final RC_TurbineInventoryAccessor mBlock = (RC_TurbineInventoryAccessor)this.getMasterBlock();
        if (mBlock != null && this.isStructureValid()) {
            mBlock.getInv().hasCustomInventoryName();
        }
        return false;
	}

	public int getInventoryStackLimit() {
		return 1;
	}

	public boolean isUseableByPlayer(EntityPlayer player) {
        return RailcraftTileEntity.isUseableByPlayerHelper(this, player);
	}

	public void openInventory() {
	}

	public void closeInventory() {		
	}

	public boolean isItemValidForSlot(int index, ItemStack stack) {
        if (stack == null) {
            return false;
        }
        final TileSteamTurbine mBlock = (TileSteamTurbine)this.getMasterBlock();
        return mBlock != null && this.isStructureValid() && stack.getItem() == TileSteamTurbine.getSampleRotor().getItem();
	}
	
}
