package org.girardsimon;

import java.util.ArrayList;
import java.util.List;

public record PascalLine(List<Long> numbers) {
    public PascalLine getNextLine() {
        if(numbers.size() == 1)
            return new PascalLine(List.of(1L,1L));
        else {
            List<Long> nextLineNumbers = new ArrayList<>();
            nextLineNumbers.add(1L);

            for(int i = 0; i < numbers.size() -1 ; i++) {
                Long number = numbers.get(i) + numbers.get(i+1);
                nextLineNumbers.add(number);
            }

            nextLineNumbers.add(1L);

            return new PascalLine(nextLineNumbers);
        }
    }

    @Override
    public String toString() {
        StringBuilder printedLine = new StringBuilder(" ");

        numbers.forEach( i-> printedLine.append(i).append(" "));

        return printedLine.toString();
    }
}
