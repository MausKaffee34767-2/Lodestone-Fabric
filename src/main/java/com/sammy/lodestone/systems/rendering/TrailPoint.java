package com.sammy.lodestone.systems.rendering;


import net.minecraft.client.render.VertexConsumer;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vector4f;

public record TrailPoint(float xp, float xn, float yp, float yn, float z) {


    public TrailPoint(Vector4f pos, Vec2f perp) {
        this(pos.getX() + perp.x, pos.getX() - perp.x, pos.getY() + perp.y, pos.getY() - perp.y, pos.getZ());
    }

    public void renderStart(VertexConsumer builder, VFXBuilders.WorldVFXBuilder.WorldVertexPlacementSupplier supplier, float u0, float v0, float u1, float v1) {
        supplier.placeVertex(builder, null, xp, yp, z, u0, v0);
        supplier.placeVertex(builder, null, xn, yn, z, u1, v0);
    }

    public void renderEnd(VertexConsumer builder, VFXBuilders.WorldVFXBuilder.WorldVertexPlacementSupplier supplier, float u0, float v0, float u1, float v1) {
        supplier.placeVertex(builder, null, xn, yn, z, u1, v1);
        supplier.placeVertex(builder, null, xp, yp, z, u0, v1);
    }

    public void renderMid(VertexConsumer builder, VFXBuilders.WorldVFXBuilder.WorldVertexPlacementSupplier supplier, float u0, float v0, float u1, float v1) {
        renderEnd(builder, supplier, u0, v0, u1, v1);
        renderStart(builder, supplier, u0, v0, u1, v1);
    }
}
