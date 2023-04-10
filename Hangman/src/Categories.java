public class Categories {
    private String categoryName;
    private String[] options = new String[10];

    Categories(String categoryId) {
        if (categoryId.equals("1") || categoryId.equalsIgnoreCase("Animals")) {
            categoryName = "Animals";
            options[0] = "Tiger";
            options[1] = "Ostrich";
            options[2] = "Panda";
            options[3] = "Monkey";
            options[4] = "Rhino";
            options[5] = "Eagle";
            options[6] = "Bear";
            options[7] = "Dolphin";
            options[8] = "Turtle";
            options[9] = "Cheetah";
        } else if (categoryId.equals("2") || categoryId.equalsIgnoreCase("Countries")) {
            categoryName = "Countries";
            options[0] = "England";
            options[1] = "Japan";
            options[2] = "France";
            options[3] = "Brazil";
            options[4] = "Nigeria";
            options[5] = "Germany";
            options[6] = "Canada";
            options[7] = "India";
            options[8] = "Ukraine";
            options[9] = "Somalia";
        } else if (categoryId.equals("3") || categoryId.equalsIgnoreCase("Capital Cities")) {
            categoryName = "Capital Cities";
            options[0] = "London";
            options[1] = "Paris";
            options[2] = "Washington";
            options[3] = "Berlin";
            options[4] = "Budapest";
            options[5] = "Moscow";
            options[6] = "Minsk";
            options[7] = "Brussels";
            options[8] = "Beijing";
            options[9] = "Prague";

        }
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public String[] getCategoryOptions() {
        return this.options;
    }

}
