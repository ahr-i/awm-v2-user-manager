package com.example.user_manager.Dto;

import java.util.Random;

public enum CharacterName {
    user;

    public static String getRandomName() {
        Random random = new Random();
        CharacterName[] characterNames = CharacterName.values();
        int randomIndex = random.nextInt(characterNames.length);
        return characterNames[randomIndex].toString();
    }
}