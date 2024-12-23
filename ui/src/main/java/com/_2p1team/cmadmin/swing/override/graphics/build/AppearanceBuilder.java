package com._2p1team.cmadmin.swing.override.graphics.build;

import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.configs.*;

public final class AppearanceBuilder {
    private final Appearance appearance;

    public AppearanceBuilder() {
        this.appearance = new Appearance();
    }

    public AppearanceBuilder enableInteractivity() {
        this.appearance.enableInteractivity();
        return this;
    }

    public AppearanceBuilder disableInteractivity() {
        this.appearance.disableInteractivity();
        return this;
    }

    public AppearanceBuilder setBackgroundConfiguration(final BackgroundConfiguration config) {
        this.appearance.setBackgroundConfiguration(config);
        return this;
    }

    public AppearanceBuilder setForegroundConfiguration(final ForegroundConfiguration config) {
        this.appearance.setForegroundConfiguration(config);
        return this;
    }

    public AppearanceBuilder setIconSet(final IconSet iconSet) {
        this.appearance.setIconSet(iconSet);
        return this;
    }

    public AppearanceBuilder setFontSet(final FontSet fontSet) {
        this.appearance.setFontSet(fontSet);
        return this;
    }

    public AppearanceBuilder setBorderConfiguration(final BorderConfiguration config) {
        this.appearance.setBorderConfiguration(config);
        return this;
    }

    public Appearance build() {
        return this.appearance;
    }
}