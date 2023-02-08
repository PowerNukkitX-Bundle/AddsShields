package cn.reiyans.customshield.Items.Shields;
import cn.nukkit.item.customitem.CustomItem;
import cn.nukkit.item.customitem.CustomItemDefinition;
import cn.nukkit.item.customitem.data.ItemCreativeCategory;
import cn.reiyans.customshield.Items.ShieldBase.ShieldBase;

public class SculkShield extends ShieldBase implements CustomItem {
    public SculkShield() {
        super("Sculk Shield");
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
        return "sculk:shield";
    }

    @Override
    public String getTextureName() {
        return "sculk";
    }
}