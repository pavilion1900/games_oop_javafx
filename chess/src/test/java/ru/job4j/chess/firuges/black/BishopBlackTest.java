package ru.job4j.chess.firuges.black;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void position() {
        BishopBlack first = new BishopBlack(Cell.C8);
        Cell result = first.position();
        assertThat(result, is(Cell.C8));
    }

    @Test
    public void copy() {
        BishopBlack first = new BishopBlack(Cell.C8);
        Cell result = first.copy(Cell.G4).position();
        assertThat(result, is(Cell.G4));
    }

    @Test
    public void way() throws ImpossibleMoveException {
        BishopBlack first = new BishopBlack(Cell.C1);
        Cell[] result = first.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(result, is(expected));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void diagonalFalse() throws ImpossibleMoveException {
        BishopBlack first = new BishopBlack(Cell.C1);
        first.way(Cell.C5);
    }
}