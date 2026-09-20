package com.sammy.lodestone.systems.rendering.particle.screen.emitter;

import com.sammy.lodestone.systems.rendering.particle.screen.base.ScreenParticle;
import net.minecraft.item.ItemStack;

public record ParticleEmitter(EmitterSupplier supplier) {

    public void tick(ItemStack stack, float x, float y, ScreenParticle.RenderOrder renderOrder) {
        supplier.tick(stack, x, y, renderOrder);
    }

    public interface EmitterSupplier {
        void tick(ItemStack stack, float x, float y, ScreenParticle.RenderOrder renderOrder);
    }
}
