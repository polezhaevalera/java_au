public enum Genre {

    Art("art"),
    Humor("humor"),
    Internet_MassMedia("Internet_MassMedia");

    private String name;

    public String getName() {
        return name;
    }

    Genre(String name) {
        this.name = name;
    }


}


