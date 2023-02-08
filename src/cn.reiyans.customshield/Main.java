package cn.reiyans.customshield;

import cn.nukkit.Server;
import cn.nukkit.inventory.CraftingManager;
import cn.nukkit.inventory.ShapedRecipe;
import cn.nukkit.item.Item;
import cn.nukkit.plugin.PluginBase;
import cn.reiyans.customshield.Items.Shields.AmethystShield;
import cn.reiyans.customshield.Items.Shields.BambooShield;
import cn.reiyans.customshield.Items.Shields.BarrelShield;
import cn.reiyans.customshield.Items.Shields.BeeNestShield;
import cn.reiyans.customshield.Items.Shields.CopperShield;
import cn.reiyans.customshield.Items.Shields.CrimsonShield;
import cn.reiyans.customshield.Items.Shields.DiamondShield;
import cn.reiyans.customshield.Items.Shields.DripStoneShield;
import cn.reiyans.customshield.Items.Shields.EnderShield;
import cn.reiyans.customshield.Items.Shields.GoldenShield;
import cn.reiyans.customshield.Items.Shields.IronShield;
import cn.reiyans.customshield.Items.Shields.MagmaShield;
import cn.reiyans.customshield.Items.Shields.MushRoomShield;
import cn.reiyans.customshield.Items.Shields.NetherPortalShield;
import cn.reiyans.customshield.Items.Shields.NetheriteCrimsonShield;
import cn.reiyans.customshield.Items.Shields.NetheriteWarpedShield;
import cn.reiyans.customshield.Items.Shields.SculkShield;
import cn.reiyans.customshield.Items.Shields.SculkShriekerShield;
import cn.reiyans.customshield.Items.Shields.SeaLanternShield;
import cn.reiyans.customshield.Items.Shields.ShulkerShield;
import cn.reiyans.customshield.Items.Shields.SkelyShield;
import cn.reiyans.customshield.Items.Shields.SlimeShield;
import cn.reiyans.customshield.Items.Shields.TntShield;
import cn.reiyans.customshield.Items.Shields.TorchShield;
import cn.reiyans.customshield.Items.Shields.WarpedShield;
import cn.reiyans.customshield.Items.Shields.WitherShield;
import cn.reiyans.customshield.Items.Shields.WoodenShield;
import cn.reiyans.customshield.Listeners.ShieldDefense;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main extends PluginBase {

    private static Main instance;
    private static final String[] RECIPE = new String[] {
            "omo",
            "ooo",
            "aoa"
    };

    @Override
    public void onEnable() {
        instance = this;
        this.getLogger().info("The AddsShield enabled ! Version 1.0.2");
        this.getLogger().info("The AddsShield author is Reiyans");
        Server.getInstance().getPluginManager().registerEvents(new ShieldDefense(), this);
        try {
            Item.registerCustomItem(List.of(AmethystShield.class, BambooShield.class, BarrelShield.class, BeeNestShield.class, CrimsonShield.class
            , CopperShield.class, CrimsonShield.class, DiamondShield.class, DripStoneShield.class, EnderShield.class, GoldenShield.class, IronShield.class
            , MagmaShield.class, MushRoomShield.class, NetheriteCrimsonShield.class, NetheriteWarpedShield.class, NetherPortalShield.class, SculkShield.class
            , SculkShield.class, SculkShriekerShield.class, SeaLanternShield.class, ShulkerShield.class, SkelyShield.class, SlimeShield.class, TntShield.class
            , TorchShield.class, WarpedShield.class, WitherShield.class, WoodenShield.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        CraftingManager craftingManager = Server.getInstance().getCraftingManager();
        craftingManager.registerRecipe(new ShapedRecipe(new SculkShriekerShield(), RECIPE, getWoodRecipeMap(Item.fromString("SCULK_SHRIEKER")), new ArrayList<>()));
        craftingManager.registerRecipe(new ShapedRecipe(new AmethystShield(), RECIPE, getWoodRecipeMap(Item.get(Item.AMETHYST_SHARD)), new ArrayList<>()));
        craftingManager.registerRecipe(new ShapedRecipe(new EnderShield(), RECIPE, getWoodRecipeMap(Item.get(Item.ENDER_EYE)), new ArrayList<>()));
        craftingManager.registerRecipe(new ShapedRecipe(new SculkShield(), RECIPE, getWoodRecipeMap(Item.fromString("SCULK")), new ArrayList<>()));
        craftingManager.registerRecipe(new ShapedRecipe(new IronShield(), RECIPE, getWoodRecipeMap(Item.get(Item.IRON_BLOCK)), new ArrayList<>()));
        craftingManager.registerRecipe(new ShapedRecipe(new CopperShield(), RECIPE, getWoodRecipeMap(Item.fromString("Copper_block")), new ArrayList<>()));
        craftingManager.registerRecipe(new ShapedRecipe(new TorchShield(), RECIPE, getWoodRecipeMap(Item.get(Item.TORCH)), new ArrayList<>()));
        craftingManager.registerRecipe(new ShapedRecipe(new SeaLanternShield(), RECIPE, getWoodRecipeMap(Item.get(Item.SEA_LANTERN)), new ArrayList<>()));
        craftingManager.registerRecipe(new ShapedRecipe(new MagmaShield(), RECIPE, getWoodRecipeMap(Item.get(Item.MAGMA)), new ArrayList<>()));
        craftingManager.registerRecipe(new ShapedRecipe(new WoodenShield(), RECIPE, getWoodRecipeMap(Item.get(Item.PLANKS)), new ArrayList<>()));
        craftingManager.registerRecipe(new ShapedRecipe(new NetheriteCrimsonShield(), RECIPE, getNetherRecipe1Map(Item.get(Item.NETHERITE_INGOT)), new ArrayList<>()));
        craftingManager.registerRecipe(new ShapedRecipe(new NetheriteWarpedShield(), RECIPE, getNetherRecipe2Map(Item.get(Item.NETHERITE_INGOT)), new ArrayList<>()));
        craftingManager.registerRecipe(new ShapedRecipe(new SkelyShield(), RECIPE, getWoodRecipeMap(Item.get(Item.BONE_BLOCK)), new ArrayList<>()));
        craftingManager.registerRecipe(new ShapedRecipe(new WitherShield(), RECIPE, getWoodRecipeMap(Item.get(Item.SKULL_BLOCK)), new ArrayList<>()));
        craftingManager.registerRecipe(new ShapedRecipe(new SlimeShield(), RECIPE, getWoodRecipeMap(Item.get(Item.SLIMEBALL)), new ArrayList<>()));
        craftingManager.registerRecipe(new ShapedRecipe(new BeeNestShield(), RECIPE, getWoodRecipeMap(Item.fromString("bee_nest")), new ArrayList<>()));
        craftingManager.registerRecipe(new ShapedRecipe(new TntShield(), RECIPE, getWoodRecipeMap(Item.get(Item.TNT)), new ArrayList<>()));
        craftingManager.registerRecipe(new ShapedRecipe(new ShulkerShield(), RECIPE, getWoodRecipeMap(Item.get(Item.SHULKER_SHELL)), new ArrayList<>()));
        craftingManager.registerRecipe(new ShapedRecipe(new GoldenShield(), RECIPE, getWoodRecipeMap(Item.get(Item.GOLD_INGOT)), new ArrayList<>()));
        craftingManager.registerRecipe(new ShapedRecipe(new BarrelShield(), RECIPE, getWoodRecipeMap(Item.fromString("barrel")), new ArrayList<>()));
        craftingManager.registerRecipe(new ShapedRecipe(new DripStoneShield(), RECIPE, getWoodRecipeMap(Item.fromString("pointed_dripstone")), new ArrayList<>()));
        craftingManager.registerRecipe(new ShapedRecipe(new MushRoomShield(), RECIPE, getWoodRecipeMap(Item.get(Item.MUSHROOM_STEW)), new ArrayList<>()));
        craftingManager.registerRecipe(new ShapedRecipe(new WarpedShield(), RECIPE, getWoodRecipeMap(Item.fromString("warped_stem")), new ArrayList<>()));
        craftingManager.registerRecipe(new ShapedRecipe(new CrimsonShield(), RECIPE, getWoodRecipeMap(Item.fromString("crimson_stem")), new ArrayList<>()));
        craftingManager.registerRecipe(new ShapedRecipe(new BambooShield(), RECIPE, getWoodRecipeMap(Item.fromString("bamboo")), new ArrayList<>()));
        craftingManager.registerRecipe(new ShapedRecipe(new NetherPortalShield(), RECIPE, getNetherRecipe3Map(Item.get(Item.FLINT_AND_STEEL)), new ArrayList<>()));
        craftingManager.rebuildPacket();
    }
    @Override
    public void onDisable() {
    }
    public Map<Character, Item> getWoodRecipeMap(Item material) {
        Map<Character, Item> map = new HashMap<>();
        map.put('o', Item.get(Item.PLANKS));
        map.put('m', material);
        map.put('a', Item.get(Item.AIR));
        return map;
    }
    public Map<Character, Item> getNetherRecipe1Map(Item material) {
        Map<Character, Item> map = new HashMap<>();
        map.put('o', Item.fromString("CRIMSON_PLANKS"));
        map.put('m', material);
        map.put('a', Item.get(0));
        return map;
    }
    public Map<Character, Item> getNetherRecipe2Map(Item material) {
        Map<Character, Item> map = new HashMap<>();
        map.put('o', Item.fromString("WARPED_PLANKS"));
        map.put('m', material);
        map.put('a', Item.get(Item.AIR));
        return map;
    }
    public Map<Character, Item> getNetherRecipe3Map(Item material) {
        Map<Character, Item> map = new HashMap<>();
        map.put('o', Item.get(Item.OBSIDIAN));
        map.put('m', material);
        map.put('a', Item.get(Item.AIR));
        return map;
    }

    public static Main getInstance() {
        return instance;
    }
}
