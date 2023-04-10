public class SelectedWord {
    private String selectedWord;

    SelectedWord(Categories selectedCategory) {
        //Math.floor(Math.random() * (maxNum - minNum) + 1)
        //Math.floor isn't needed as we are casting to int and our lowest num is 0 so its pointless doing (9 - 0) +1
        int randomNum = (int)(Math.random() * 10);
        String[] options = selectedCategory.getCategoryOptions();
        this.selectedWord = options[randomNum];
    }

    public String getSelectedWord(){
        return this.selectedWord;
    }
}
