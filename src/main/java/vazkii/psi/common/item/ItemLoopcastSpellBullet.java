/*
 * This class is distributed as part of the Psi Mod.
 * Get the Source Code in github:
 * https://github.com/Vazkii/Psi
 *
 * Psi is Open Source and distributed under the
 * Psi License: https://psi.vazkii.net/license.php
 */
package vazkii.psi.common.item;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import vazkii.psi.api.internal.TooltipHelper;
import vazkii.psi.api.spell.ISpellAcceptor;
import vazkii.psi.api.spell.SpellContext;
import vazkii.psi.common.core.handler.LoopcastTrackingHandler;
import vazkii.psi.common.core.handler.PlayerDataHandler;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class ItemLoopcastSpellBullet extends ItemSpellBullet {

	int loopcastCooldown;

	public ItemLoopcastSpellBullet(Properties properties, int loopcastCooldown) {
		super(properties);
		this.loopcastCooldown = loopcastCooldown;
	}

	@Override
	public ArrayList<Entity> castSpell(ItemStack stack, SpellContext context) {
		PlayerDataHandler.PlayerData data = PlayerDataHandler.get(context.caster);
		if (!data.loopcasting || context.castFrom != data.loopcastHand) {
			context.cspell.safeExecute(context);
			data.loopcasting = true;
			data.loopcastCooldown = loopcastCooldown;
			data.loopcastHand = context.castFrom;
			data.lastTickLoopcastStack = null;
			if (context.caster instanceof ServerPlayerEntity) {
				LoopcastTrackingHandler.syncForTrackersAndSelf((ServerPlayerEntity) context.caster);
			}
		}
		return new ArrayList<>();
	}

	@Override
	public boolean loopcastSpell(ItemStack stack, SpellContext context) {
		context.cspell.safeExecute(context);
		PlayerDataHandler.PlayerData data = PlayerDataHandler.get(context.caster);
		data.loopcastCooldown = loopcastCooldown;
		return true;
	}

	@Override
	public String getBulletType() {
		return "loopcast";
	}

	@Override
	public boolean isCADOnlyContainer(ItemStack stack) {
		return true;
	}

	@Override
	public double getCostModifier(ItemStack stack) {
		return 1.0;
	}

	@Override
	public void addInformation(ItemStack stack, @Nullable World playerIn, List<ITextComponent> tooltip, ITooltipFlag advanced) {
		TooltipHelper.tooltipIfShift(tooltip, () -> {
			tooltip.add(new TranslationTextComponent("psimisc.bullet_type", new TranslationTextComponent("psi.bullet_type_" + getBulletType())));
			tooltip.add(new TranslationTextComponent("psimisc.bullet_cost", (int) (ISpellAcceptor.acceptor(stack).getCostModifier() * 100)));
			tooltip.add(new TranslationTextComponent("psimisc.loopcast_cooldown", this.loopcastCooldown));
		});
	}
}
