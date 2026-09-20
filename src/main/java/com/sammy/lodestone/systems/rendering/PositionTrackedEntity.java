package com.sammy.lodestone.systems.rendering;

import net.minecraft.util.math.Vec3d;

import java.util.ArrayList;

public interface PositionTrackedEntity {
    void trackPastPositions();

    ArrayList<Vec3d> getPastPositions();
}
