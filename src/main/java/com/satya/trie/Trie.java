package com.satya.trie;

import org.springframework.stereotype.Component;

import com.satya.model.dictionary;

import java.util.ArrayList;
import java.util.List;

@Component
public class Trie {
    

    private TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public boolean insertWord(String word, String meaning, String phonetic, String partsOfSpeech, String example){
        System.out.println(root);
        TrieNode temp = root;
        word=word.toLowerCase();
        for(int i = 0; i < word.length(); i++){
            int idx = word.charAt(i)-'a';
            if(temp.children[idx] == null){
                temp.children[idx] = new TrieNode();
            }
            temp = temp.children[idx];
        }
        if(temp.isEnd == true)
            return false;
        temp.meaning = meaning;
        temp.phonetic = phonetic;
        temp.partsOfSpeech = partsOfSpeech;
        temp.example = example;
        return temp.isEnd = true;
    }

    public boolean hasWord(String word){
        TrieNode temp = root;
        for(int i = 0; i < word.length(); i++){
            int idx = word.charAt(i)-'a';
            if(temp.children[idx] == null)
                return false;
            temp = temp.children[idx];
        }
        return temp.isEnd;
    }
    public dictionary getMeaning(String word){ // similar to hasword

        TrieNode temp = root;
        for(int i = 0; i < word.length(); i++){
            int idx = word.charAt(i)-'a';
            if(temp.children[idx] == null)
                return null;
            temp = temp.children[idx];
        }

        dictionary w = new dictionary();
        w.setWord(word);
        w.setMeaning(temp.meaning);
        w.setExample(temp.example);
        w.setPos(temp.partsOfSpeech);
        return w;
    }

    public List<dictionary> getAllWordsAndMeanings(){
        List<dictionary> ans = new ArrayList<>();
        getAllWordsHelper(root, "", ans);
        return ans;
    }

    private void getAllWordsHelper(TrieNode root, String cur, List<dictionary> ans){
        if(root == null)
            return;
        if(root.isEnd == true){
        	dictionary w = new dictionary();
            w.setWord(cur);
            w.setMeaning(root.meaning);
            w.setExample(root.example);
            w.setPos(root.partsOfSpeech);
            ans.add(w);
        }

        for(int i = 0; i < 26; i++){
            char ch = (char)('a'+i);
            getAllWordsHelper(root.children[i], cur + ch, ans);
        }
    }

    public List<String> getAllWordsStartsWith(String prefix){
        List<String> ans = new ArrayList<>();
        TrieNode temp = root;
        for(int i = 0; i < prefix.length(); i++){
            int idx = prefix.charAt(i)-'a';       
            if(temp.children[idx] == null)
                return ans;
            temp = temp.children[idx];
        }
        startsWithHelper(temp, prefix, ans);
        return ans;
    }

    private void startsWithHelper(TrieNode root, String cur, List<String> ans){
        if(root == null)
            return;
        if(root.isEnd){	
            ans.add(cur);
        }
        for(int i = 0; i < 26; i++){
            char ch = (char)('a'+i);
            startsWithHelper(root.children[i], cur+ch, ans);
        }
    }
}