package com.satya.trie;

import jakarta.persistence.Entity;


public class TrieNode {
    boolean isEnd;
    String meaning;
    String phonetic;
    String partsOfSpeech;
    String example;
    TrieNode[] children;

    public TrieNode() {
        children = new TrieNode[26];
    }
}