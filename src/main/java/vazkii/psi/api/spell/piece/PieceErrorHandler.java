/*
 * This class is distributed as a part of the Psi Mod.
 * Get the Source Code on GitHub:
 * https://github.com/Vazkii/Psi
 *
 * Psi is Open Source and distributed under the
 * Psi License: https://psi.vazkii.net/license.php
 */
package vazkii.psi.api.spell.piece;

import vazkii.psi.api.spell.EnumPieceType;
import vazkii.psi.api.spell.EnumSpellStat;
import vazkii.psi.api.spell.IErrorCatcher;
import vazkii.psi.api.spell.Spell;
import vazkii.psi.api.spell.SpellContext;
import vazkii.psi.api.spell.SpellMetadata;
import vazkii.psi.api.spell.SpellParam;
import vazkii.psi.api.spell.SpellPiece;
import vazkii.psi.api.spell.param.ParamAny;

public abstract class PieceErrorHandler extends SpellPiece implements IErrorCatcher {

	protected SpellParam<SpellParam.Any> piece;

	public PieceErrorHandler(Spell spell) {
		super(spell);
	}

	@Override
	public EnumPieceType getPieceType() {
		return EnumPieceType.ERROR_HANDLER;
	}

	@Override
	public void initParams() {
		addParam(piece = new ParamAny(paramName(), SpellParam.BROWN, false));
	}

	@Override
	public void addToMetadata(SpellMetadata meta) {
		meta.addStat(EnumSpellStat.COMPLEXITY, 1);
	}

	@Override
	public Object evaluate() {
		return null;
	}

	@Override
	public Object execute(SpellContext context) {
		return null;
	}

	@Override
	public Class<?> getEvaluationType() {
		return Void.class;
	}

	protected abstract String paramName();
}
