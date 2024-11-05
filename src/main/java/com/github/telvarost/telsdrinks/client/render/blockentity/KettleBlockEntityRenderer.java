package com.github.telvarost.telsdrinks.client.render.blockentity;

import com.github.telvarost.telsdrinks.blockentity.KettleBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import org.lwjgl.opengl.GL11;

@Environment(EnvType.CLIENT)
public class KettleBlockEntityRenderer extends BlockEntityRenderer {

    public KettleBlockEntityRenderer() {
    }

    @Override
    public void render(BlockEntity blockEntity, double x, double y, double z, float tickDelta) {
        GL11.glPushMatrix();

        // Position the kettle
        GL11.glTranslatef((float) x, (float) y, (float) z);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        // Bind the texture
        this.bindTexture("/assets/telsdrinks/blockentity/liquids.png");

        // Scale and render the model
        float scale = 0.6666667F; // Adjust scale as necessary
        GL11.glScalef(scale, -scale, -scale);

        // set offset to the horizontal pixel offset for your texture

        double HALF_PIXEL_OFFSET = 0.03125;
        double Z_FIGHT_OFFSET = 0.001F;

        double LEFT = 10.F/16.F + HALF_PIXEL_OFFSET;
        double RIGHT = 13.F/16.F + HALF_PIXEL_OFFSET;
        double BOTTOM = 4.F/16.F + HALF_PIXEL_OFFSET;
        double TOP = (12.F/16.F);

        double TEXTURE_WIDTH = 2;
        double TEXTURE_HEIGHT = 5;

//        double LEFT = 9.F/16.F;
//        double RIGHT = 14.F/16.F + 0.06125;
//        double BOTTOM = 4.F/16.F;
//        double TOP = (12.F/16.F);
//
//        double TEXTURE_WIDTH = 4;
//        double TEXTURE_HEIGHT = 5;

//        double LEFT = 9.F/16.F;
//        double RIGHT = 14.F/16.F + 0.06125;
//        double BOTTOM = 3.F/16.F;
//        double TOP = (12.F/16.F);
//
//        double TEXTURE_WIDTH = 4;
//        double TEXTURE_HEIGHT = 6;

        double uv_x_offset = ((KettleBlockEntity) blockEntity).liquidHorizontalOffset;;
        int uv_y_offset = (5 - blockEntity.world.getBlockMeta(blockEntity.x, blockEntity.y, blockEntity.z));

        //double Z_FIGHT_OFFSET = 0.001;
        if (((KettleBlockEntity) blockEntity).dirX) {

            double POSX_BASE = 19.F/16.F + HALF_PIXEL_OFFSET + Z_FIGHT_OFFSET;
            double NEGX_BASE = 5.F/16.F - HALF_PIXEL_OFFSET - Z_FIGHT_OFFSET;

            Tessellator tessellator = Tessellator.INSTANCE;
            tessellator.startQuads();

            tessellator.vertex(POSX_BASE, -TOP, -RIGHT, (TEXTURE_WIDTH + uv_x_offset) / 64.0F, (uv_y_offset) / 32.0F);
            tessellator.vertex(POSX_BASE, -BOTTOM, -RIGHT, (TEXTURE_WIDTH + uv_x_offset) / 64.0F, (TEXTURE_HEIGHT + uv_y_offset) / 32.0F);
            tessellator.vertex(POSX_BASE, -BOTTOM, -LEFT, (0 + uv_x_offset) / 64.0F, (TEXTURE_HEIGHT + uv_y_offset) / 32.0F);
            tessellator.vertex(POSX_BASE, -TOP, -LEFT, (0 + uv_x_offset) / 64.0F, uv_y_offset / 32.0F);

            tessellator.vertex(NEGX_BASE, -TOP, -LEFT, (0 + uv_x_offset) / 64.0F, uv_y_offset / 32.0F);
            tessellator.vertex(NEGX_BASE, -BOTTOM, -LEFT, (0 + uv_x_offset) / 64.0F, (TEXTURE_HEIGHT + uv_y_offset) / 32.0F);
            tessellator.vertex(NEGX_BASE, -BOTTOM, -RIGHT, (TEXTURE_WIDTH + uv_x_offset) / 64.0F, (TEXTURE_HEIGHT + uv_y_offset) / 32.0F);
            tessellator.vertex(NEGX_BASE, -TOP, -RIGHT, (TEXTURE_WIDTH + uv_x_offset) / 64.0F, uv_y_offset / 32.0F);

            tessellator.draw();
        } else {
            double POSZ_BASE = 19.F/16.F + HALF_PIXEL_OFFSET + Z_FIGHT_OFFSET - 1.5;
            double NEGZ_BASE = 5.F/16.F - HALF_PIXEL_OFFSET - Z_FIGHT_OFFSET - 1.5;


            Tessellator tessellator = Tessellator.INSTANCE;
            tessellator.startQuads();
            tessellator.vertex(LEFT, -TOP, NEGZ_BASE, (0 + uv_x_offset) / 64.0F, uv_y_offset / 32.0F);
            tessellator.vertex(LEFT, -BOTTOM, NEGZ_BASE, (0 + uv_x_offset) / 64.0F, (TEXTURE_HEIGHT + uv_y_offset) / 32.0F);
            tessellator.vertex(RIGHT, -BOTTOM, NEGZ_BASE, (TEXTURE_WIDTH + uv_x_offset) / 64.0F, (TEXTURE_HEIGHT + uv_y_offset) / 32.0F);
            tessellator.vertex(RIGHT, -TOP, NEGZ_BASE, (TEXTURE_WIDTH + uv_x_offset) / 64.0F, uv_y_offset / 32.0F);

            tessellator.vertex(RIGHT, -TOP, POSZ_BASE, (TEXTURE_WIDTH + uv_x_offset) / 64.0F, uv_y_offset / 32.0F);
            tessellator.vertex(RIGHT, -BOTTOM, POSZ_BASE, (TEXTURE_WIDTH + uv_x_offset) / 64.0F, (TEXTURE_HEIGHT + uv_y_offset) / 32.0F);
            tessellator.vertex(LEFT, -BOTTOM, POSZ_BASE, (0 + uv_x_offset) / 64.0F, (TEXTURE_HEIGHT + uv_y_offset) / 32.0F);
            tessellator.vertex(LEFT, -TOP, POSZ_BASE, (0 + uv_x_offset) / 64.0F, uv_y_offset / 32.0F);

            tessellator.draw();
        }

        // Restore OpenGL state
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F); // Reset color
        GL11.glPopMatrix();
    }
}
