package com.github.telvarost.telsdrinks.block;

//import com.github.telvarost.sameoldspells.ClientUtil;
//import com.github.telvarost.sameoldspells.Config;
//import com.github.telvarost.sameoldspells.mixin.WorldAccessor;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.Box;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class Kettle extends TemplateBlock {

    private final float MUG_WIDTH = 0.0625F * 3;
    private final float MUG_HEIGHT = 0.5F + 0.0625F;

    public Kettle(Identifier identifier, Material material) {
        super(identifier, material);
        this.setBoundingBox(MUG_WIDTH, 0.0F, MUG_WIDTH, 1.0F - MUG_WIDTH, MUG_HEIGHT, 1.0F - MUG_WIDTH);
    }

    @Override
    public boolean isOpaque() {
        return false;
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Override
    public boolean isSolidFace(BlockView blockView, int x, int y, int z, int i) {
        return false;
    }

//    @Environment(EnvType.CLIENT)
//    @Override
//    public boolean isSideVisible(BlockView blockView, int x, int y, int z, int side) {
//        if (  !Config.config.RENDER_SPELLS_CONFIG.DISABLE_ALL_SPELL_RENDERING
//           && Config.config.RENDER_SPELLS_CONFIG.ARROW_SPELL
//        ) {
//            return true;
//        } else {
//            return false;
//        }
//    }

//    @Environment(EnvType.CLIENT)
//    @Override
//    public Box getBoundingBox(World world, int x, int y, int z) {
//        if (  !Config.config.RENDER_SPELLS_CONFIG.DISABLE_ALL_SPELL_RENDERING
//           && Config.config.RENDER_SPELLS_CONFIG.ARROW_SPELL
//        ) {
//            return Box.createCached((double)x + this.minX, (double)y + this.minY, (double)z + this.minZ, (double)x + this.maxX, (double)y + this.maxY, (double)z + this.maxZ);
//        } else {
//            return Box.createCached(0, 0, 0, 0, 0, 0);
//        }
//    }

//    @Override
//    public void onEntityCollision(World world, int x, int y, int z, Entity entity) {
//        if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
//            if (ClientUtil.IsParticle(entity)) {
//                return;
//            }
//        }
//
//        if (null != entity) {
//            WorldProperties worldProperties = ((WorldAccessor) world).getProperties();
//            if (null != worldProperties) {
//                world.setBlock(x, y, z, 0);
//                world.setBlockMeta(x, y, z, 0);
//
//                /** - Summon arrows */
//                ArrowEntity arrowEast = new ArrowEntity(world, (x + 0.5D) + 1, (y + 0.5D), (z + 0.5D));
//                arrowEast.velocityX = 0.5;
//                world.spawnEntity(arrowEast);
//                ArrowEntity arrowWest = new ArrowEntity(world, (x + 0.5D) - 1, (y + 0.5D), (z + 0.5D));
//                arrowWest.velocityX = -0.5;
//                world.spawnEntity(arrowWest);
//                ArrowEntity arrowNorth = new ArrowEntity(world, (x + 0.5D), (y + 0.5D), (z + 0.5D) + 1);
//                arrowNorth.velocityZ = 0.5;
//                world.spawnEntity(arrowNorth);
//                ArrowEntity arrowSouth = new ArrowEntity(world, (x + 0.5D), (y + 0.5D), (z + 0.5D) - 1);
//                arrowSouth.velocityZ = -0.5;
//                world.spawnEntity(arrowSouth);
//            }
//        }
//    }
}