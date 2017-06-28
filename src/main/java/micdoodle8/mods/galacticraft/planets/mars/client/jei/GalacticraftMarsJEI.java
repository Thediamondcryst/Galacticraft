package micdoodle8.mods.galacticraft.planets.mars.client.jei;

import mezz.jei.api.BlankModPlugin;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import micdoodle8.mods.galacticraft.core.GCBlocks;
import micdoodle8.mods.galacticraft.core.client.jei.RecipeCategories;
import micdoodle8.mods.galacticraft.planets.mars.blocks.MarsBlocks;
import micdoodle8.mods.galacticraft.planets.mars.client.jei.cargorocket.CargoRocketRecipeCategory;
import micdoodle8.mods.galacticraft.planets.mars.client.jei.cargorocket.CargoRocketRecipeHandler;
import micdoodle8.mods.galacticraft.planets.mars.client.jei.cargorocket.CargoRocketRecipeMaker;
import micdoodle8.mods.galacticraft.planets.mars.client.jei.gasliquefier.GasLiquefierRecipeCategory;
import micdoodle8.mods.galacticraft.planets.mars.client.jei.gasliquefier.GasLiquefierRecipeHandler;
import micdoodle8.mods.galacticraft.planets.mars.client.jei.gasliquefier.GasLiquefierRecipeMaker;
import micdoodle8.mods.galacticraft.planets.mars.client.jei.methanesynthesizer.MethaneSynthesizerRecipeCategory;
import micdoodle8.mods.galacticraft.planets.mars.client.jei.methanesynthesizer.MethaneSynthesizerRecipeHandler;
import micdoodle8.mods.galacticraft.planets.mars.client.jei.methanesynthesizer.MethaneSynthesizerRecipeMaker;
import micdoodle8.mods.galacticraft.planets.mars.client.jei.tier2rocket.Tier2RocketRecipeCategory;
import micdoodle8.mods.galacticraft.planets.mars.client.jei.tier2rocket.Tier2RocketRecipeHandler;
import micdoodle8.mods.galacticraft.planets.mars.client.jei.tier2rocket.Tier2RocketRecipeMaker;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

@JEIPlugin
public class GalacticraftMarsJEI extends BlankModPlugin
{
    @Override
    public void register(@Nonnull IModRegistry registry)
    {
        IGuiHelper guiHelper = registry.getJeiHelpers().getGuiHelper();
        registry.addRecipeCategories(new Tier2RocketRecipeCategory(guiHelper),
                new GasLiquefierRecipeCategory(guiHelper),
                new CargoRocketRecipeCategory(guiHelper),
                new MethaneSynthesizerRecipeCategory(guiHelper));
        registry.addRecipeHandlers(new Tier2RocketRecipeHandler(),
                new GasLiquefierRecipeHandler(),
                new CargoRocketRecipeHandler(),
                new MethaneSynthesizerRecipeHandler());
        registry.addRecipes(Tier2RocketRecipeMaker.getRecipesList());
        registry.addRecipes(GasLiquefierRecipeMaker.getRecipesList());
        registry.addRecipes(CargoRocketRecipeMaker.getRecipesList());
        registry.addRecipes(MethaneSynthesizerRecipeMaker.getRecipesList());

        ItemStack nasaWorkbench = new ItemStack(GCBlocks.nasaWorkbench);
        registry.addRecipeCategoryCraftingItem(nasaWorkbench, RecipeCategories.ROCKET_T2_ID);
        registry.addRecipeCategoryCraftingItem(new ItemStack(MarsBlocks.machineT2), RecipeCategories.GAS_LIQUEFIER_ID);
        registry.addRecipeCategoryCraftingItem(nasaWorkbench, RecipeCategories.ROCKET_CARGO_ID);
        registry.addRecipeCategoryCraftingItem(new ItemStack(MarsBlocks.machineT2, 1, 4), RecipeCategories.METHANE_SYNTHESIZER_ID);
    }
}
