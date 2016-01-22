/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Psi Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Psi
 * 
 * Psi is Open Source and distributed under the
 * CC-BY-NC-SA 3.0 License: https://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB
 * 
 * File Created @ [13/01/2016, 16:58:15 (GMT)]
 */
package vazkii.psi.api.internal;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import vazkii.psi.api.spell.ISpellCache;
import vazkii.psi.api.spell.ISpellCompiler;
import vazkii.psi.api.spell.Spell;

public interface IInternalMethodHandler {

	/**
	 * Gets the player data for a given player. Player Data contains info such as the
	 * player's Psi value or level.
	 */
	public IPlayerData getDataForPlayer(EntityPlayer player);
	
	/**
	 * Gets the texture for the programmer. Used for drawing the arrows in a SpellPiece's
	 * params.
	 */
	public ResourceLocation getProgrammerTexture();
	
	public ISpellCompiler getCompiler(Spell spell);
	
	public ISpellCache getSpellCache();
}