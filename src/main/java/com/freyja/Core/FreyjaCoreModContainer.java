package com.freyja.core;

import com.google.common.eventbus.EventBus;
import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.ModMetadata;

import java.util.Arrays;

/**
 * @author Freyja
 *         Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class FreyjaCoreModContainer extends DummyModContainer {

    public FreyjaCoreModContainer()
    {
        super(new ModMetadata());

        ModMetadata md = getMetadata();
        md.description = "Coremod used by Freyja's Mods";
        md.name = "Freyja core";
        md.modId = "Freyja_core";
        md.version = "0.0.1";
        md.credits = "Freyja";
        md.authorList = Arrays.asList("Freyja");
        md.url = "";
    }

    @Override
    public boolean registerBus(EventBus bus, LoadController controller)
    {
        return true;
    }
}
