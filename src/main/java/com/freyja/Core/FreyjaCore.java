package com.freyja.Core;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

import java.util.Map;

/**
 * @author Freyja
 *         Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */

@IFMLLoadingPlugin.TransformerExclusions("com.freyja.Core")
public class FreyjaCore implements IFMLLoadingPlugin {

    public FreyjaCore() {}

    @Override
    public String[] getLibraryRequestClass()
    {
        return null;
    }

    @Override
    public String[] getASMTransformerClass()
    {
        return new String[]{"com.freyja.Core.FreyjaCoreTransformer"};
    }

    @Override
    public String getModContainerClass()
    {
        return "com.freyja.Core.FreyjaCoreModContainer";
    }

    @Override
    public String getSetupClass()
    {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data)
    {
    }
}
