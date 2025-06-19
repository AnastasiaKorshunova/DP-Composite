package com.esdc.task2.service;

import com.esdc.task2.composite.TextComponent;
import com.esdc.task2.composite.TextComponentType;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class TextService {

    private static final String VOWELS = "aeiouаеёиоуыэюяAEIOUАЕЁИОУЫЭЮЯ";

    List<TextComponent> paragraphSort(List<TextComponent> paragraphs, Comparator<TextComponent> comparator) {
        paragraphs.sort(comparator);
        return paragraphs;
    }

    List<TextComponent> getSentencesWithTheLongestWord(List<TextComponent> paragraphs) {
        List<TextComponent> resultSentences = new ArrayList<>();
        List<TextComponent> allSentences = paragraphs.stream()
                .flatMap(paragraph -> paragraph.getChildren().stream())
                .toList();

        Integer longestWordSize = allSentences.stream().flatMap(this::getAllWordsFromSentence)
                .map(word -> word.getChildren().size())
                .max(Comparator.naturalOrder())
                .get();

        for (TextComponent sentence : allSentences) {
            Optional<TextComponent> anyMatch = getAllWordsFromSentence(sentence)
                    .filter(word -> word.getChildren().size() == longestWordSize)
                    .findAny();
            if (anyMatch.isPresent()) {
                resultSentences.add(sentence);
            }
        }
        return resultSentences;
    }

    List<TextComponent> removeSentencesWithWordsLessThanThreshold(List<TextComponent> paragraphs, int threshold) {
        List<TextComponent> sentencesToRemove = new ArrayList<>();
        List<TextComponent> allSentences = paragraphs.stream()
                .flatMap(paragraph -> paragraph.getChildren().stream())
                .toList();

        for (TextComponent sentence : allSentences) {
            int size = getAllWordsFromSentence(sentence)
                    .toList()
                    .size();
            if (size < threshold) {
                sentencesToRemove.add(sentence);
            }
        }
        paragraphs.forEach(paragraph -> sentencesToRemove.forEach(paragraph::removeComponent));
        return paragraphs.stream().filter(paragraph -> !paragraph.getChildren().isEmpty()).toList();
    }

    Map<String, Integer> getTheSameWordsAndCount(List<TextComponent> paragraphs) {
        Map<String, Integer> result = new HashMap<>();
        List<TextComponent> allWords = paragraphs.stream()
                .flatMap(paragraph -> paragraph.getChildren().stream())
                .flatMap(this::getAllWordsFromSentence)
                .toList();

        for (TextComponent word : allWords) {
            result.merge(word.toString().toLowerCase(), 1, Integer::sum);
        }
        return result;
    }

    public VowelConsonant countVowelConsonant(TextComponent sentence) {
        validateSentence(sentence);
        int vowelCount = 0;
        int consonantCount = 0;
        List<TextComponent> letters = getAllWordsFromSentence(sentence)
                .flatMap(word -> word.getChildren().stream())
                .toList();
        for (TextComponent letter : letters) {
            if (VOWELS.contains(letter.toString())) {
                vowelCount++;
            } else {
                consonantCount++;
            }
        }
        return new VowelConsonant(vowelCount, consonantCount);
    }

    private Stream<TextComponent> getAllWordsFromSentence(TextComponent sentence) {
        validateSentence(sentence);
        return sentence.getChildren().stream()
                .flatMap(lexeme -> lexeme.getChildren().stream())
                .filter(textComponent -> textComponent.getType() == TextComponentType.WORD);
    }

    private void validateSentence(TextComponent textComponent) {
        if (textComponent.getType() != TextComponentType.SENTENCE) {
            throw new IllegalArgumentException("Text component is not a Sentence");
        }
    }

    public record VowelConsonant(int vowelCount, int consonantCount) {

    }
}
