package MatchMaking;

public class PersonImpl implements Person {
    private String name;
    private String gender;
    private String interests;
    private int rating;
    private int ratingCount = 0;

    public PersonImpl(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getInterests() {
        return interests;
    }

    public int getGeekRating() {
        if (ratingCount == 0)
            return 0;
        return (rating / ratingCount);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public void setGeekRating(int rating) {
        this.rating += rating;
        ratingCount++;
    }
}