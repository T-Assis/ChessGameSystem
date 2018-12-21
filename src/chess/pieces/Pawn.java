package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	private ChessMatch chessMatch;

	public Pawn(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}
	
	@Override
	public String toString() {
		return "P";
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
			if (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)
					&& getBoard().positionExists(auxPosition2) && !getBoard().thereIsAPiece(auxPosition2)
					&& getMoveCount() == 0) {
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

			// Special Move - En Passant
			if (position.getRow() == 3) {
				Position left = new Position(position.getRow(), position.getColumn() - 1);
				if (getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
					matrix[left.getRow() - 1][left.getColumn()] = true;
				}
				Position right = new Position(position.getRow(), position.getColumn() + 1);
				if (getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
					matrix[right.getRow() - 1][right.getColumn()] = true;
				}
			}

		} else {
			auxPosition.setValues(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
				matrix[auxPosition.getRow()][auxPosition.getColumn()] = true;
			}
			auxPosition.setValues(position.getRow() + 2, position.getColumn());
			Position auxPosition2 = new Position(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)
					&& getBoard().positionExists(auxPosition2) && !getBoard().thereIsAPiece(auxPosition2)
					&& getMoveCount() == 0) {
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

			// Special Move - En Passant
			if (position.getRow() == 4) {
				Position left = new Position(position.getRow(), position.getColumn() - 1);
				if (getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
					matrix[left.getRow() + 1][left.getColumn()] = true;
				}
				Position right = new Position(position.getRow(), position.getColumn() + 1);
				if (getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
					matrix[right.getRow() + 1][right.getColumn()] = true;
				}
			}
		}
		return matrix;
	}

}
