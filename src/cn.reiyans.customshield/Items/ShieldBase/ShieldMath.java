package cn.reiyans.customshield.Items.ShieldBase;

import cn.nukkit.Player;
import cn.nukkit.entity.Entity;
import cn.nukkit.level.ParticleEffect;
import cn.nukkit.math.Vector3;
import cn.nukkit.potion.Effect;
import java.util.Random;

public class ShieldMath {
    public void RandomEffectFunc (Entity player){
        Random random = new Random();
        int Seed = random.nextInt(26)+1;
        player.addEffect(Effect.getEffect(Seed).setAmplifier(1).setDuration(60));
    }
    public static void PlayerView(Entity hitPlayer, Entity attacker, double backValue){
        if(hitPlayer.yaw>=22.5&&hitPlayer.yaw< 67.5){
            Vector3 dPosition1 = new Vector3(hitPlayer.x-backValue, hitPlayer.y,hitPlayer.z+backValue);
            attacker.teleport(hitPlayer.getLevel().getSafeSpawn(dPosition1));
        }else if(hitPlayer.yaw>=67.5&&hitPlayer.yaw<112.5){
            Vector3 dPosition = new Vector3(hitPlayer.x-backValue, hitPlayer.y,hitPlayer.z);
            attacker.teleport(hitPlayer.getLevel().getSafeSpawn(dPosition));
        }else if(hitPlayer.yaw>=112.5&&hitPlayer.yaw<147.5){
            Vector3 dPosition = new Vector3(hitPlayer.x-backValue, hitPlayer.y,hitPlayer.z-backValue);
            attacker.teleport(hitPlayer.getLevel().getSafeSpawn(dPosition));
        }else if(hitPlayer.yaw>=147.5&&hitPlayer.yaw<192.5){
            Vector3 dPosition = new Vector3(hitPlayer.x, hitPlayer.y,hitPlayer.z-backValue);
            attacker.teleport(hitPlayer.getLevel().getSafeSpawn(dPosition));
        }else if(hitPlayer.yaw>=192.5&&hitPlayer.yaw<247.5){
            Vector3 dPosition = new Vector3(hitPlayer.x+backValue, hitPlayer.y,hitPlayer.z-backValue);
            attacker.teleport(hitPlayer.getLevel().getSafeSpawn(dPosition));
        }else if(hitPlayer.yaw>=247.5&&hitPlayer.yaw<292.5){
            Vector3 dPosition = new Vector3(hitPlayer.x+backValue, hitPlayer.y,hitPlayer.z);
            attacker.teleport(hitPlayer.getLevel().getSafeSpawn(dPosition));
        }else if(hitPlayer.yaw>=292.5&&hitPlayer.yaw<337.5){
            Vector3 dPosition = new Vector3(hitPlayer.x+backValue, hitPlayer.y,hitPlayer.z+backValue);
            attacker.teleport(hitPlayer.getLevel().getSafeSpawn(dPosition));
        }else{
            Vector3 dPosition = new Vector3(hitPlayer.x, hitPlayer.y,hitPlayer.z+backValue);
            attacker.teleport(hitPlayer.getLevel().getSafeSpawn(dPosition));
        }
    }
    public static void CircleParticle(Entity player, ParticleEffect effect, double radius){
        final double x =  player.getX();
        final double y =  player.getY();
        final double z =  player.getZ();
        Vector3 vc = new Vector3(x,y,z);
        int a = 0;
        while(a<361) {
            vc.setComponents(x + Math.sin(a * Math.PI / 180) * radius, y + 0.5, z + Math.cos(a * Math.PI / 180) * radius);
            player.getLevel().addParticleEffect(vc,effect);
            a = a+15;
        }
    }
    public static void RandomJump(Entity hitplayer,Entity attacker,int direction){//the function is adopt to slimeshield,but i haven't good idea now
        final double x =  attacker.getX();
        final double y =  attacker.getY();
        final double z =  attacker.getZ();
    }
}
