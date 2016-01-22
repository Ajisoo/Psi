/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Psi Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Psi
 * 
 * Psi is Open Source and distributed under the
 * CC-BY-NC-SA 3.0 License: https://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB
 * 
 * File Created @ [16/01/2016, 16:10:43 (GMT)]
 */
package vazkii.psi.common.spell.base;

import vazkii.psi.api.PsiAPI;
import vazkii.psi.api.spell.Spell;
import vazkii.psi.api.spell.SpellPiece;
import vazkii.psi.common.lib.LibPieceNames;
import vazkii.psi.common.spell.constant.PieceConstantNumber;
import vazkii.psi.common.spell.operator.number.PieceOperatorAbsolute;
import vazkii.psi.common.spell.operator.number.PieceOperatorDivide;
import vazkii.psi.common.spell.operator.number.PieceOperatorInverse;
import vazkii.psi.common.spell.operator.number.PieceOperatorMultiply;
import vazkii.psi.common.spell.operator.number.PieceOperatorSubtract;
import vazkii.psi.common.spell.operator.number.PieceOperatorSum;
import vazkii.psi.common.spell.operator.vector.PieceOperatorEntityLook;
import vazkii.psi.common.spell.operator.vector.PieceOperatorEntityPosition;
import vazkii.psi.common.spell.operator.vector.PieceOperatorVectorConstruct;
import vazkii.psi.common.spell.operator.vector.PieceOperatorVectorCrossProduct;
import vazkii.psi.common.spell.operator.vector.PieceOperatorVectorDivide;
import vazkii.psi.common.spell.operator.vector.PieceOperatorVectorExtractX;
import vazkii.psi.common.spell.operator.vector.PieceOperatorVectorExtractY;
import vazkii.psi.common.spell.operator.vector.PieceOperatorVectorExtractZ;
import vazkii.psi.common.spell.operator.vector.PieceOperatorVectorMagnitude;
import vazkii.psi.common.spell.operator.vector.PieceOperatorVectorMultiply;
import vazkii.psi.common.spell.operator.vector.PieceOperatorVectorNegate;
import vazkii.psi.common.spell.operator.vector.PieceOperatorVectorNormalize;
import vazkii.psi.common.spell.operator.vector.PieceOperatorVectorRaycast;
import vazkii.psi.common.spell.operator.vector.PieceOperatorVectorSubtract;
import vazkii.psi.common.spell.operator.vector.PieceOperatorVectorSum;
import vazkii.psi.common.spell.other.PieceConnector;
import vazkii.psi.common.spell.selector.PieceSelectorCaster;
import vazkii.psi.common.spell.selector.PieceSelectorFocalPoint;
import vazkii.psi.common.spell.trick.PieceTrickAddMotion;
import vazkii.psi.common.spell.trick.PieceTrickDebug;
import vazkii.psi.common.spell.trick.PieceTrickExplode;

public final class ModSpellPieces {

	public static PieceContainer selectorCaster;
	public static PieceContainer selectorFocalPoint;

	public static PieceContainer operatorSum;
	public static PieceContainer operatorSubtract;
	public static PieceContainer operatorMultiply;
	public static PieceContainer operatorDivide;
	public static PieceContainer operatorAbsolute;
	public static PieceContainer operatorInverse;
	public static PieceContainer operatorEntityPosition;
	public static PieceContainer operatorEntityLook;
	public static PieceContainer operatorVectorRaycast;
	
	public static PieceContainer operatorVectorSum;
	public static PieceContainer operatorVectorSubtract;
	public static PieceContainer operatorVectorMultiply;
	public static PieceContainer operatorVectorDivide;
	public static PieceContainer operatorVectorCrossProduct;
	public static PieceContainer operatorVectorNormalize;
	public static PieceContainer operatorVectorNegate;
	public static PieceContainer operatorVectorMagnitude;
	public static PieceContainer operatorVectorConstruct;
	public static PieceContainer operatorVectorExtractX;
	public static PieceContainer operatorVectorExtractY;
	public static PieceContainer operatorVectorExtractZ;

	public static PieceContainer constantNumber;
	
	public static PieceContainer connector;
	
	public static PieceContainer trickDebug;
	public static PieceContainer trickAddMotion;
	public static PieceContainer trickExplode;

	public static void init() {
		selectorCaster = register(PieceSelectorCaster.class, LibPieceNames.SELECTOR_CASTER);
		selectorFocalPoint = register(PieceSelectorFocalPoint.class, LibPieceNames.SELECTOR_FOCAL_POINT);
		
		operatorSum = register(PieceOperatorSum.class, LibPieceNames.OPERATOR_SUM);
		operatorSubtract = register(PieceOperatorSubtract.class, LibPieceNames.OPERATOR_SUBTRACT);
		operatorMultiply = register(PieceOperatorMultiply.class, LibPieceNames.OPERATOR_MULTIPLY);
		operatorDivide = register(PieceOperatorDivide.class, LibPieceNames.OPERATOR_DIVIDE);
		operatorAbsolute = register(PieceOperatorAbsolute.class, LibPieceNames.OPERATOR_ABSOLUTE);
		operatorInverse = register(PieceOperatorInverse.class, LibPieceNames.OPERATOR_INVERSE);
		operatorEntityPosition = register(PieceOperatorEntityPosition.class, LibPieceNames.OPERATOR_ENTITY_POSITION);
		operatorEntityLook = register(PieceOperatorEntityLook.class, LibPieceNames.OPERATOR_ENTITY_LOOK);
		operatorVectorRaycast = register(PieceOperatorVectorRaycast.class, LibPieceNames.OPERATOR_VECTOR_RAYCAST);
		operatorVectorSum = register(PieceOperatorVectorSum.class, LibPieceNames.OPERATOR_VECTOR_SUM);
		operatorVectorSubtract = register(PieceOperatorVectorSubtract.class, LibPieceNames.OPERATOR_VECTOR_SUBTRACT);
		operatorVectorMultiply = register(PieceOperatorVectorMultiply.class, LibPieceNames.OPERATOR_VECTOR_MULTIPLY);
		operatorVectorDivide = register(PieceOperatorVectorDivide.class, LibPieceNames.OPERATOR_VECTOR_DIVIDE);
		operatorVectorCrossProduct = register(PieceOperatorVectorCrossProduct.class, LibPieceNames.OPERATOR_VECTOR_CROSS_PRODUCT);
		operatorVectorNormalize = register(PieceOperatorVectorNormalize.class, LibPieceNames.OPERATOR_VECTOR_NORMALIZE);
		operatorVectorNegate = register(PieceOperatorVectorNegate.class, LibPieceNames.OPERATOR_VECTOR_NEGATE);
		operatorVectorMagnitude = register(PieceOperatorVectorMagnitude.class, LibPieceNames.OPERATOR_VECTOR_MAGNITUDE);
		operatorVectorConstruct = register(PieceOperatorVectorConstruct.class, LibPieceNames.OPERATOR_VECTOR_CONSTRUCT);
		operatorVectorExtractX = register(PieceOperatorVectorExtractX.class, LibPieceNames.OPERATOR_VECTOR_EXTRACT_X);
		operatorVectorExtractY = register(PieceOperatorVectorExtractY.class, LibPieceNames.OPERATOR_VECTOR_EXTRACT_Y);
		operatorVectorExtractZ = register(PieceOperatorVectorExtractZ.class, LibPieceNames.OPERATOR_VECTOR_EXTRACT_Z);

		constantNumber = register(PieceConstantNumber.class, LibPieceNames.CONSTANT_NUMBER);
		
		connector = register(PieceConnector.class, LibPieceNames.CONNECTOR);
		
		trickDebug = register(PieceTrickDebug.class, LibPieceNames.TRICK_DEBUG);
		trickAddMotion = register(PieceTrickAddMotion.class, LibPieceNames.TRICK_ADD_MOTION);
		trickExplode = register(PieceTrickExplode.class, LibPieceNames.TRICK_EXPLODE);
	}
	
	public static PieceContainer register(Class<? extends SpellPiece> clazz, String name) {
		PsiAPI.registerSpellPieceAndTexture(name, clazz);
		return (Spell s) -> { return SpellPiece.create(clazz, s); };
	}
	
	public static interface PieceContainer {
		public SpellPiece get(Spell s);
	}
	
}