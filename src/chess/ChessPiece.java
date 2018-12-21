package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {
	
	private Color color;
	private int moveCount;
	
	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
	public int getMoveCount() {
		return moveCount;
	}
	
	protected boolean isThereOpponentPiece(Position position) {
		ChessPiece auxChessPiece = (ChessPiece) getBoard().piece(position);
		return auxChessPiece != null && auxChessPiece.getColor() != color;
	}
	
	public ChessPosition getChessPosition() {
		return ChessPosition.fromPosition(position);
	}
	
	protected void increaseMoveCount(){
		moveCount++;
	}
	
	protected void decreaseMoveCount(){
		moveCount--;
	}

}
