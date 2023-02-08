package cn.reiyans.customshield.Items.Shields;

import cn.nukkit.item.customitem.CustomItem;
import cn.nukkit.item.customitem.CustomItemDefinition;
import cn.nukkit.item.customitem.data.ItemCreativeCategory;
import cn.reiyans.customshield.Items.ShieldBase.ShieldBase;

public class SlimeShield extends ShieldBase implements CustomItem {
    public SlimeShield() {
        super("Slime Shield");
    }
    public CustomItemDefinition getDefinition() {
        return CustomItemDefinition.customBuilder(this, ItemCreativeCategory.EQUIPMENT)
                .allowOffHand(true)
                .allowOffHand(true)
                .foil(true)
                .build();
    }
    @Override
    public String getNamespaceId() {//物品标识符
        return "slime:shield";
    }
    @Override
    public String getTextureName() { return "slime";}
}