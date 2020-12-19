public enum Subscribers {

    Quantity_Of_Followers("follow"),
    Quantity_Of_Likes("likes");


    private String name;

    public String getName(){
        return name;
    }

    Subscribers(String name){
        this.name = name;
    }


}

