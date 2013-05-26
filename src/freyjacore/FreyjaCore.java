package freyjacore;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

import java.util.Map;

/**
 * @author Freyja
 *         Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */

@IFMLLoadingPlugin.TransformerExclusions("freyjacore.")
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
        return new String[]{"freyjacore.FreyjaCoreTransformer"};
    }

    @Override
    public String getModContainerClass()
    {
        return "freyjacore.FreyjaCoreModContainer";
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
