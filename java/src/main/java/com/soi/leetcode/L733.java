package com.soi.leetcode;

public class L733 {
    public int originalColor;
    public int newColor;
    public int[][] image;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]== newColor){
            return image;
        }
        this.originalColor = image[sr][sc];
        this.newColor = newColor;
        this.image = image;
        fill(sr,sc);
        return image;
    }
    public void fill(int s, int g){
        if(s<0||g<0||s>=image.length||g>=image[0].length||image[s][g]!=originalColor) return;
        image[s][g] = newColor;
        fill(s+1, g);
        fill(s-1, g);
        fill(s, g+1);
        fill(s, g-1);
    }
}
