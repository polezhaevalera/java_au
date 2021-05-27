import java.util.Arrays;
import java.util.List;


public class Sort {
    public static long WhichGenre(List<Community> communities){
        long count = communities.stream()
                .filter(x -> x.getGenre().equals(Genre.Humor)).count();
        long count2 = communities.stream()
                .filter(x -> x.getGenre().equals(Genre.Art)).count();
        long count3 = communities.stream()
                .filter(x -> x.getGenre().equals(Genre.Internet_MassMedia)).count();


        return count3;
    }

    public static List<Community> generateCommunityList() {
        return Arrays.asList(
                new Community("Scetch books", Genre.Art),
                new Community("Как я встретил столбняк", Genre.Humor),
                new Community("damn", Genre.Art),
                new Community("Настоящий лентач", Genre.Internet_MassMedia),
                new Community("Лентач", Genre.Internet_MassMedia)
                );

    }

}
