package com.github.telvarost.telsdrinks.client.render.blockentity;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.PistonBlockEntityRenderer;
import org.lwjgl.opengl.GL11;

public class KettleBlockEntityRenderer extends BlockEntityRenderer {
    @Override
    public void render(BlockEntity blockEntity, double x, double y, double z, float tickDelta) {
        Tessellator tessellator = Tessellator.INSTANCE;

        // Set up OpenGL state
        GL11.glPushMatrix();
        GL11.glTranslated(x, y - 1, z); // Move to the correct position
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        // Begin drawing quads
        tessellator.startQuads();

        // Set color to blue
        tessellator.color(0.0F, 0.0F, 1.0F, 1.0F); // RGBA

        // Define the vertices for a rectangle (quad)
        // Adjust coordinates as necessary for size and positioning
        tessellator.vertex(-0.5, 0.0, -0.5);
        tessellator.vertex(0.5, 0.0, -0.5);
        tessellator.vertex(0.5, 0.0, 0.5);
        tessellator.vertex(-0.5, 0.0, 0.5);

        // Draw the rectangle
        tessellator.draw();

        // Restore OpenGL state
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
    }
}
