package com.example;

import java.util.List;

public class LionAlex extends Lion{
    private List<String> alexFriends = List.of("зебра Марти", "бегемотиха Глория", "жираф Мелман");
    private String placeOfLiving = "Зоопарк Нью-Йорка";

    public LionAlex(FelineBehavior felineBehavior) throws Exception{
        super("Самец", felineBehavior);
    }

    public List<String> getFriends(){
        return alexFriends;
    }

    public String getPlaceOfLiving(){
        return placeOfLiving;
    }

    @Override
    public int getKittens() {
        return 0;
    }
}
