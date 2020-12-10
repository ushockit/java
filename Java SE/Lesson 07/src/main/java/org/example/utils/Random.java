package org.example.utils;

public class Random {
    public int generate(int min, int max) {
        return (int)Math.floor(Math.random() * (max - min + 1) + min);
    }
}
