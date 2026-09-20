package com.sammy.lodestone.mixin;


import com.sammy.lodestone.systems.postprocess.LodestoneGlslPreprocessor;
import net.minecraft.client.gl.EffectProgram;
import net.minecraft.client.gl.GLImportProcessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(EffectProgram.class)
public class EffectProgramMixin {
    @ModifyArg(method = "createFromResource(Lnet/minecraft/client/gl/Program$Type;Ljava/lang/String;Ljava/io/InputStream;Ljava/lang/String;)Lnet/minecraft/client/gl/EffectProgram;", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gl/EffectProgram;loadProgram(Lnet/minecraft/client/gl/Program$Type;Ljava/lang/String;Ljava/io/InputStream;Ljava/lang/String;Lnet/minecraft/client/gl/GLImportProcessor;)I"), index = 4)
    private static GLImportProcessor useCustomPreprocessor(GLImportProcessor org) {
        return new LodestoneGlslPreprocessor();
    }
}
