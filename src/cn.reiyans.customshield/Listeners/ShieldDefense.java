package cn.reiyans.customshield.Listeners;

import cn.nukkit.block.Block;
import cn.nukkit.entity.Entity;
import cn.nukkit.entity.EntityHuman;
import cn.nukkit.entity.item.EntityPrimedTNT;
import cn.nukkit.entity.projectile.EntityProjectile;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.event.entity.ProjectileHitEvent;
import cn.nukkit.Player;
import cn.nukkit.level.ParticleEffect;
import cn.nukkit.level.Position;
import cn.nukkit.level.Sound;
import cn.nukkit.potion.Effect;
import cn.reiyans.customshield.Items.ShieldBase.ShieldMath;
import java.util.Arrays;
import java.util.List;
import static cn.nukkit.utils.Utils.random;

public class ShieldDefense implements Listener {

    List<String> ShieldsList = Arrays.asList("amethyst:shield","bamboo:shield","barrel:shield","bee:shield","copper:shield","crimson:shield","diamond:shield"
    ,"dripstone:shield","ender:shield","gold:shield","iron:shield","magma:shield","mushroom:shield","netherite_crimson:shield","netherite_warped:shield"
    ,"nether:shield","sculk:shield","sculk_shrieker:shield","sea:shield","shulker:shield","skely:shield","slime:shield","tnt:shield","torch:shield","warped:shield"
    ,"wither_skely:shield","wooden:shield");
    @EventHandler
    public void ShieldCheck1(EntityDamageByEntityEvent event) {
        Entity hitPlayer1 = event.getEntity();
        Entity attacker = event.getDamager();
        if (hitPlayer1 instanceof Player) {
            Player hitPlayer = (Player) event.getEntity();
            if (hitPlayer.isSneaking() && ShieldsList.contains(hitPlayer.getOffhandInventory().getItem(0).getNamespaceId())) {
                String shieldName = hitPlayer.getOffhandInventory().getItem(0).getNamespaceId();
                ShieldEffect(hitPlayer, attacker, shieldName);
            } else if (hitPlayer.isSneaking() && ShieldsList.contains(hitPlayer.getInventory().getItemInHand().getNamespaceId())) {
                String shieldName = hitPlayer.getInventory().getItemInHand().getNamespaceId();
                ShieldEffect(hitPlayer, attacker, shieldName);
            }
        }
    }
    @EventHandler
    public void ShieldsCheck2(ProjectileHitEvent event) {
        if (event.getMovingObjectPosition().entityHit instanceof EntityHuman) {
            Entity attacker = ((EntityProjectile) event.getEntity()).shootingEntity;
            Player hitPlayer = (Player) event.getMovingObjectPosition().entityHit;
            if (hitPlayer.isSneaking() && ShieldsList.contains(hitPlayer.getOffhandInventory().getItem(0).getNamespaceId())) {
                String shieldName = hitPlayer.getOffhandInventory().getItem(0).getNamespaceId();
                ShieldEffect(hitPlayer,attacker,shieldName);
            }else if(hitPlayer.isSneaking() && ShieldsList.contains(hitPlayer.getInventory().getItemInHand().getNamespaceId())){
                String shieldName = hitPlayer.getInventory().getItemInHand().getNamespaceId();
                ShieldEffect(hitPlayer,attacker,shieldName);
            }
        }
    }
    private void ShieldEffect(Player hitPlayer,Entity attacker,String shieldName){
        if(shieldName != null && hitPlayer.isSneaking()) {
                Position attackerPos1 = new Position(attacker.x+1,attacker.y+0.3,attacker.z+1);
                Position attackerPos2 = new Position(attacker.x-1,attacker.y+0.3,attacker.z-1);
                Position hitPlayerPos1 = new Position(hitPlayer.x+1,hitPlayer.y+0.3,hitPlayer.z+1);
                Position hitPlayerPos2 = new Position(hitPlayer.x-1,hitPlayer.y+0.3,hitPlayer.z-1);
                switch (shieldName) {
                    case "crimson:shield" -> {
                        hitPlayer.getLevel().addParticleEffect(hitPlayerPos1, ParticleEffect.EXPLOSION_CAULDRON);
                        hitPlayer.getLevel().addParticleEffect(hitPlayerPos2, ParticleEffect.EXPLOSION_CAULDRON);
                    }
                    case "diamond:shield" -> hitPlayer.addEffect(Effect.getEffect(10).setAmplifier(1).setDuration(30));
                    case "ender:shield" -> {
                        Position RandomPosition = new Position(attackerPos1.x + (Math.random() * 15), attacker.y, attackerPos1.z + (Math.random() * 15));
                        hitPlayer.teleport(hitPlayer.getLevel().getSafeSpawn(RandomPosition));
                        ShieldMath.CircleParticle(hitPlayer, ParticleEffect.END_CHEST, 1.0);
                        ShieldMath.CircleParticle(attacker, ParticleEffect.EXPLOSION_CAULDRON, 1.0);
                    }
                    case "magma:shield" -> {
                            hitPlayer.getLevel().addParticleEffect(hitPlayerPos1, ParticleEffect.EXPLOSION_CAULDRON);
                            hitPlayer.getLevel().addParticleEffect(hitPlayerPos2, ParticleEffect.EXPLOSION_CAULDRON);
                            attacker.setOnFire(3);
                    }
                    case "mushroom:shield" -> new ShieldMath().RandomEffectFunc(hitPlayer);
                    case "netherite_crimson:shield" -> hitPlayer.addEffect(Effect.getEffect(12).setAmplifier(1).setDuration(55));
                    case "netherite_warped:shield" -> hitPlayer.addEffect(Effect.getEffect(12).setAmplifier(2).setDuration(75));
                    case "nether:shield" -> {
                            attacker.getLevel().setBlock(attacker.getPosition(), Block.get(90));
                            Position MiddlePos = new Position((attacker.x + hitPlayer.x) / 2, hitPlayer.y, (attacker.z + hitPlayer.z) / 2);
                            hitPlayer.getLevel().addParticleEffect(MiddlePos, ParticleEffect.END_CHEST);
                            ShieldMath.CircleParticle(hitPlayer, ParticleEffect.END_CHEST, 1);
                    }
                    case "sculk:shield" -> {
                        attacker.getLevel().setBlock(attacker.getDirectionVector(), Block.get(90));
                        Position MiddlePos1 = new Position((attackerPos1.x + hitPlayerPos2.x) / 2, hitPlayer.y, (attackerPos1.z + hitPlayerPos2.z) / 2);
                        hitPlayer.getLevel().addParticleEffect(MiddlePos1, ParticleEffect.SCULK_CHARGE);
                        hitPlayer.getLevel().addParticleEffect(hitPlayerPos1, ParticleEffect.SCULK_CHARGE);
                        attacker.getLevel().addParticleEffect(attackerPos2, ParticleEffect.SCULK_CHARGE);
                        hitPlayer.setAmbientSoundEvent(Sound.SPREAD_SCULK);
                    }
                    case "sculk_shrieker:shield" -> {
                        hitPlayer.getLevel().addParticleEffect(hitPlayer.getPosition(), ParticleEffect.SCULK_SOUL);
                        ShieldMath.CircleParticle(hitPlayer, ParticleEffect.SCULK_CHARGE, 0.9);
                    }
                    case "sea:shield" -> hitPlayer.addEffect(Effect.getEffect(16).setAmplifier(2).setDuration(85));
                    case "shulker:shield" -> {
                            attacker.addEffect(Effect.getEffect(24).setAmplifier(1).setDuration(60));
                            Position attackerPos4 = new Position(attacker.x, attacker.y + 2, attacker.z);
                            attacker.teleport(attackerPos4);
                    }
                    case "skely:shield" -> hitPlayer.addEffect(Effect.getEffect(24).setAmplifier(1).setDuration(40));
                    case "slime:shield" -> ShieldMath.PlayerView(hitPlayer, attacker, 12);
                    case "tnt:shield" -> {
                            EntityPrimedTNT TNT = new EntityPrimedTNT(attacker.chunk, EntityPrimedTNT.getDefaultNBT(attacker));
                            TNT.spawnToAll();
                    }
                    case "torch:shield" -> hitPlayer.addEffect(Effect.getEffect(16).setAmplifier(1).setDuration(65));
                    case "warped:shield" -> {
                        hitPlayer.getLevel().addParticleEffect(hitPlayerPos2, ParticleEffect.EXPLOSION_CAULDRON);
                        hitPlayer.getLevel().addParticleEffect(hitPlayerPos1, ParticleEffect.EXPLOSION_CAULDRON);
                    }
                    case "wither_skely:shield" ->
                            hitPlayer.addEffect(Effect.getEffect(24).setAmplifier(2).setDuration(60));
                }
            }
        }
    }


