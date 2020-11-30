package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) throws ImpossibleMoveException {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException();
        }
        int size = Math.abs(dest.getX() - position().getX());
        Cell[] steps = new Cell[size];
        int deltaX = dest.getX() > position.getX() ? 1 : -1;
        int deltaY = dest.getY() > position.getY() ? 1 : -1;
        for (int i = 0; i < size; i++) {
            int x = position.getX() + deltaX * (i + 1);
            int y = position.getY() + deltaY * (i + 1);
            steps[i] = Cell.findBy(x, y);
        }
        return steps;

    }

    public boolean isDiagonal(Cell source, Cell dest) {
        int first = Math.abs(dest.getX() - source.getX());
        int second = Math.abs(dest.getY() - source.getY());
        return first == second;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
