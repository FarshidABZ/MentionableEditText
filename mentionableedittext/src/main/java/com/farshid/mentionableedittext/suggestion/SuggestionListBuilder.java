package com.farshid.mentionableedittext.suggestion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.farshid.mentionableedittext.view.MainView;

/**
 * @author FarshidAbz
 * @version 1.0
 * @since 8/24/2016
 */
public class SuggestionListBuilder {

    ArrayList<String> suggestionList;
    ArrayList<String> inputList;
    MainView mainView;

    public SuggestionListBuilder(ArrayList<String> inputList, MainView mainView) {
        this.inputList = inputList;
        this.mainView = mainView;

        suggestionList = new ArrayList<>();
    }

    public void suggest(ArrayList<String> tokens) {
        searchWordsInInputList(tokens);
        showSuggestion();
    }

    private void searchWordsInInputList(ArrayList<String> tokens) {
        suggestionList.clear();
        for (String suggestionInput : inputList) {
            for (String token : tokens) {
                token = token.replaceAll("\\s", "");  //remove all spaces from current token (exp: " @java" | "  @java ")
                if (suggestionInput.toLowerCase().contains(token.substring(1).toLowerCase())) // remove first @ character from token to search in input list
                {
                    suggestionList.add(suggestionInput);
                }
            }
        }
    }

    private void showSuggestion() {
        if (mainView != null) {
            removeDuplicatedSuggestions();
            mainView.setSuggestionList(suggestionList);
        }
    }

    private void removeDuplicatedSuggestions() {
        Set<String> tempList = new HashSet<>();
        tempList.addAll(suggestionList);
        suggestionList.clear();
        suggestionList.addAll(tempList);
    }
}
