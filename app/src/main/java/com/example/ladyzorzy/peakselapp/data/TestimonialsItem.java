package com.example.ladyzorzy.peakselapp.data;

public class TestimonialsItem {

    private String game_id,content,author,rating;

    public TestimonialsItem() {
    }

    public TestimonialsItem(String game_id,String content, String author, String rating) {
        this.game_id= game_id;
        this.content = content;
        this.author = author;
        this.rating = rating;

    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getGame_id() {
        return game_id;
    }

    public void setGame_id(String game_id) {
        this.game_id = game_id;
    }
}
