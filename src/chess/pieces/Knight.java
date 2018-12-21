package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece{

	public Knight(Board board, Color color) {
		super(board, color);
		
	}
	
	@Override
	public String toString(){
		return "N";
	}
	
	private boolean canMove(Position position) {
		ChessPiece auxChessPiece = (ChessPiece) getBoard().piece(position);
		return auxChessPiece == null || auxChessPiece.getColor() != getColor();
	}
	
	@Override
	public boolean[][] possibleMoves() {
		
		boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position auxPosition = new Position(0, 0);
		
		auxPosition.setValues(position.getRow() - 1, position.getColumn() - 2);
		if (getBoard().positionExists(auxPosition) && canMove(auxPosition)) {
			matrix[auxPosition.getRow()][auxPosition.getColumn()] = true;
		}
		
		auxPosition.setValues(position.getRow() - 2, position.getColumn() - 1);
		if (getBoard().positionExists(auxPosition) && canMove(auxPosition)) {
			matrix[auxPosition.getRow()][auxPosition.getColumn()] = true;
		}
		
		auxPosition.setValues(position.getRow() - 2, position.getColumn() + 1);
		if (getBoard().positionExists(auxPosition) && canMove(auxPosition)) {
			matrix[auxPosition.getRow()][auxPosition.getColumn()] = true;
		}
		
		auxPosition.setValues(position.getRow() - 1, position.getColumn() + 2);
		if (getBoard().positionExists(auxPosition) && canMove(auxPosition)) {
			matrix[auxPosition.getRow()][auxPosition.getColumn()] = true;
		}
		
		auxPosition.setValues(position.getRow() + 1, position.getColumn() + 2);
		if (getBoard().positionExists(auxPosition) && canMove(auxPosition)) {
			matrix[auxPosition.getRow()][auxPosition.getColumn()] = true;
		}
		
		auxPosition.setValues(position.getRow() + 2, position.getColumn() + 1);
		if (getBoard().positionExists(auxPosition) && canMove(auxPosition)) {
			matrix[auxPosition.getRow()][auxPosition.getColumn()] = true;
		}

		auxPosition.setValues(position.getRow() + 2, position.getColumn() - 1);
		if (getBoard().positionExists(auxPosition) && canMove(auxPosition)) {
			matrix[auxPosition.getRow()][auxPosition.getColumn()] = true;
		}

		auxPosition.setValues(position.getRow() + 1, position.getColumn() - 2);
		if (getBoard().positionExists(auxPosition) && canMove(auxPosition)) {
			matrix[auxPosition.getRow()][auxPosition.getColumn()] = true;
		}
		return matrix;
	}
	
}
