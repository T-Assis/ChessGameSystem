package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	private ChessMatch chessMatch;
	
	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}
	
	@Override
	public String toString(){
		return "K";
	}

	private boolean canMove(Position position) {
		ChessPiece auxChessPiece = (ChessPiece) getBoard().piece(position);
		return auxChessPiece == null || auxChessPiece.getColor() != getColor();
	}
	
	private boolean testeRookCastling(Position position) {
		ChessPiece piece = (ChessPiece)getBoard().piece(position);
		return piece != null && piece instanceof Rook && piece.getColor() == getColor() && piece.getMoveCount() == 0;
		
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position auxPosition = new Position(0, 0);

		// above
		auxPosition.setValues(position.getRow() - 1, position.getColumn());
		if (getBoard().positionExists(auxPosition) && canMove(auxPosition)) {
			matrix[auxPosition.getRow()][auxPosition.getColumn()] = true;
		}

		// below
		auxPosition.setValues(position.getRow() + 1, position.getColumn());
		if (getBoard().positionExists(auxPosition) && canMove(auxPosition)) {
			matrix[auxPosition.getRow()][auxPosition.getColumn()] = true;
		}

		// left
		auxPosition.setValues(position.getRow(), position.getColumn() - 1);
		if (getBoard().positionExists(auxPosition) && canMove(auxPosition)) {
			matrix[auxPosition.getRow()][auxPosition.getColumn()] = true;
		}

		// right
		auxPosition.setValues(position.getRow(), position.getColumn() + 1);
		if (getBoard().positionExists(auxPosition) && canMove(auxPosition)) {
			matrix[auxPosition.getRow()][auxPosition.getColumn()] = true;
		}

		// northwest
		auxPosition.setValues(position.getRow() - 1, position.getColumn() - 1);
		if (getBoard().positionExists(auxPosition) && canMove(auxPosition)) {
			matrix[auxPosition.getRow()][auxPosition.getColumn()] = true;
		}

		// northeast
		auxPosition.setValues(position.getRow() - 1, position.getColumn() + 1);
		if (getBoard().positionExists(auxPosition) && canMove(auxPosition)) {
			matrix[auxPosition.getRow()][auxPosition.getColumn()] = true;
		}

		// southwest
		auxPosition.setValues(position.getRow() + 1, position.getColumn() - 1);
		if (getBoard().positionExists(auxPosition) && canMove(auxPosition)) {
			matrix[auxPosition.getRow()][auxPosition.getColumn()] = true;
		}

		// southeast
		auxPosition.setValues(position.getRow() + 1, position.getColumn() + 1);
		if (getBoard().positionExists(auxPosition) && canMove(auxPosition)) {
			matrix[auxPosition.getRow()][auxPosition.getColumn()] = true;
		}

		
		// Special move Castling
		if (getMoveCount() == 0 && !chessMatch.getCheck()) {
			
			// Special move Castling Kingside Rook
			Position positionRook = new Position(position.getRow(), position.getColumn() + 3);
			if (testeRookCastling(positionRook)) {
				Position position1 = new Position(position.getRow(), position.getColumn() + 1);
				Position position2 = new Position(position.getRow(), position.getColumn() + 2);
				if (getBoard().piece(position1) == null && getBoard().piece(position2) == null) {
					matrix[position.getRow()][position.getColumn() + 2] = true;
				}
			}
			
			// Special move Castling Queenside Rook
			Position positionRook2 = new Position(position.getRow(), position.getColumn() - 4);
			if (testeRookCastling(positionRook2)) {
				Position position1 = new Position(position.getRow(), position.getColumn() - 1);
				Position position2 = new Position(position.getRow(), position.getColumn() - 2);
				Position position3 = new Position(position.getRow(), position.getColumn() - 3);
				if (getBoard().piece(position1) == null && getBoard().piece(position2) == null && getBoard().piece(position3) == null) {
					matrix[position.getRow()][position.getColumn() - 2] = true;
				}
			}	
		}
		
		return matrix;
	}

}
