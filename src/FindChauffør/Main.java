package FindChauffør;

public class Main {
    public static void main(String[] args) {
        RickshawService r = new RickshawService();
        int[] districts = {0, 1, 2};
        r.createDriver("Mads", new int[]{1});
        r.createDriver("Marcus", new int[]{1});
        r.createDriver("Kreiner", new int[]{0,1});

        r.bookDriver();
    }
}

