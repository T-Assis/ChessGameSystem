package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	public Pawn(Board board, Color color) {
		super(board, color);
		
	}

	@Override
	public boolean[][] possibleMoves() {
		
		boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position auxPosition = new Position(0, 0);

		if (getColor() == Color.WHITE) {
			auxPosition.setValues(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
				matrix[auxPosition.getRow()][auxPosition.getColumn()] = true;
			}
			auxPosition.setValues(position.getRow() - 2, position.getColumn());
			Position auxPosition2 = new Position(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition) && getBoard().positionExists(auxPosition2) && !getBoard().thereIsAPiece(auxPosition2) && getMoveCount() == 0) {
				matrix[auxPosition.getRow()][auxPosition.getColumn()] = true;
			}
			auxPosition.setValues(position.getRow() - 1, position.getColumn() - 1);
			if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)) {
				matrix[auxPosition.getRow()][auxPosition.getColumn()] = true;
			}			
			auxPosition.setValues(position.getRow() - 1, position.getColumn() + 1);
			if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)) {
				matrix[auxPosition.getRow()][auxPosition.getColumn()] = true;
			}			
		}
		else {
			auxPosition.setValues(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
				matrix[auxPosition.getRow()][auxPosition.getColumn()] = true;
			}
			auxPosition.setValues(position.getRow() + 2, position.getColumn());
			Position auxPosition2 = new Position(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition) && getBoard().positionExists(auxPosition2) && !getBoard().thereIsAPiece(auxPosition2) && getMoveCount() == 0) {
				matrix[auxPosition.getRow()][auxPosition.getColumn()] = true;
			}
			auxPosition.setValues(position.getRow() + 1, position.getColumn() - 1);
			if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)) {
				matrix[auxPosition.getRow()][auxPosition.getColumn()] = true;
			}			
			auxPosition.setValues(position.getRow() + 1, position.getColumn() + 1);
			if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)) {
				matrix[auxPosition.getRow()][auxPosition.getColumn()] = true;
			}	
		}
		return matrix;
	}
	
	@Override
	public String toString(){
		return "P";
	}

}
