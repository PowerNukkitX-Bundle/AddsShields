package cn.reiyans.customshield.Items.ShieldBase;

import cn.nukkit.entity.item.EntityPrimedTNT;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public class BlockTNT extends EntityPrimedTNT {
    public BlockTNT(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
        this.fireProof = true;
        this.fireTicks = 0;
        this.maxFireTicks = 0;
    }
}