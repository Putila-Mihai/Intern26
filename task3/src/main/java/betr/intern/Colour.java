package betr.intern;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public record Colour(List<String> colours) {

    public List<String> toUpperCase() {
        return colours.stream().map(String::toUpperCase).toList();
    }

    public List<String> changeColour(final String existingColour, final String newColour) {
        return colours.stream()
                .map(colour -> colour.equals(existingColour) ? newColour : colour)
                .toList();
    }

    public String getFirstColour() {
        return colours.getFirst();
    }

    public String getColourGivenAnIndex(final int index) {
        return colours.get(index);
    }

    public List<String> sortColoursDescending() {
        final List<String> list = new ArrayList<>(List.copyOf(colours));
        list.sort(Comparator.reverseOrder());
        return list.stream().toList();
    }

    public List<String> removeLastColour() {
        return colours.stream()
                .filter(colour -> !colours.getLast().equals(colour))
                .toList();
    }

    public List<String> mumboJumboOperationOnList() {
        final List<String> halfList = colours.subList(0, colours.size() / 2 + 1);
        final int mid = halfList.size() / 2;
        final Stream<String> firstHalf = halfList.subList(0, mid + 1).reversed().stream();
        final Stream<String> secondHalf = halfList.subList(mid + 1, halfList.size()).stream();
        return Stream.concat(firstHalf, secondHalf).toList();
    }
}
