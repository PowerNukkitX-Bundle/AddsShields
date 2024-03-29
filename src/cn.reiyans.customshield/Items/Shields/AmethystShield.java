package cn.reiyans.customshield.Items.Shields;

import cn.nukkit.item.customitem.CustomItem;
import cn.nukkit.item.customitem.CustomItemDefinition;
import cn.nukkit.item.customitem.data.ItemCreativeCategory;
import cn.reiyans.customshield.Items.ShieldBase.ShieldBase;

public class AmethystShield extends ShieldBase implements CustomItem {
    public AmethystShield() {super("Amethyst Shield");}
    public CustomItemDefinition getDefinition() {
        return CustomItemDefinition.customBuilder(this, ItemCreativeCategory.EQUIPMENT)
                .allowOffHand(true)
                .allowOffHand(true)
                .foil(true)
                .build();
    }
    @Override
    public String getNamespaceId() {//物品标识符
        return "amethyst:shield";
    }

    @Override
    public int getMaxDurability() {
        return DURABILITY_SHIELD;
    }

    @Override
    public String getTextureName() { return "amethyst";}
}