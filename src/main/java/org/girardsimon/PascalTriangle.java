package org.girardsimon;

import org.girardsimon.exception.ExcessiveSizeException;
import org.girardsimon.exception.ZeroOrNegativeSizeException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public final class PascalTriangle {
    /*
        When a Pascal Triangle have a greater size than 67
        some of its values exceed Long type maximal value
        that leads, in our printed triangle, to inaccurate values
        or negatives ones, that would be nonsense.
     */
    private static final int MAX_PASCAL_TRIANGLE_SIZE = 67;
    private final List<PascalLine> pascalLines;

    private PascalTriangle(List<PascalLine> pascalLines) {
        this.pascalLines = List.copyOf(pascalLines);
    }

    public static PascalTriangle generate(int size) {
        checkSize(size);
        PascalLine initialLine = new PascalLine(Collections.singletonList(1L));
        List<PascalLine> pascalLines = Stream.iterate(initialLine, PascalLine::getNextLine)
                .limit(size)
                .toList();
        return new PascalTriangle(pascalLines);
    }

    private static void checkSize(int size) {
        if(size < 1)
            throw new ZeroOrNegativeSizeException();
        if(size > MAX_PASCAL_TRIANGLE_SIZE)
            throw new ExcessiveSizeException();
    }

    @Override
    public String toString() {
        StringBuilder printedTriangle = new StringBuilder();
        pascalLines.forEach( pascalLine-> printedTriangle.append(pascalLine.toString()).append("\n"));

        return printedTriangle.toString();
    }

}
