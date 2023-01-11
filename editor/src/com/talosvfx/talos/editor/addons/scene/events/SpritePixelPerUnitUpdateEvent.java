package com.talosvfx.talos.editor.addons.scene.events;

import com.talosvfx.talos.editor.addons.scene.utils.metadata.SpriteMetadata;
import com.talosvfx.talos.editor.notifications.TalosEvent;
import lombok.Getter;

public class SpritePixelPerUnitUpdateEvent implements TalosEvent {
    @Getter
    private SpriteMetadata spriteMetadata;
    @Override
    public void reset() {
        spriteMetadata = null;
    }

    public SpritePixelPerUnitUpdateEvent setSpriteMetadata (SpriteMetadata spriteMetadata) {
        this.spriteMetadata = spriteMetadata;
        return this;
    }
}
