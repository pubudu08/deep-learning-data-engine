package org.rapter.core;


import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;

import java.util.ArrayList;
import java.util.Properties;

/**
 * Created by Pubudu Dissanayake on 12/8/15.
 * Project : sentiment-engine
 */
public class SentimentAnalyzerEngine {
    private ArrayList<String> positiveSentiments = new ArrayList<String>();
    private ArrayList<String> negativeSentiments = new ArrayList<String>();
    private ArrayList<String> neutralSentiments = new ArrayList<String>();
    private StanfordCoreNLP stanfordCoreNLP;

    public void init (){
         Properties props = new Properties();
         props.put("annotators", "tokenize, ssplit, pos, lemma, ner, depparse");
         props.put("ner.model", "edu/stanford/nlp/models/ner/english.all.3class.distsim.crf.ser.gz");
         props.put("ner.applyNumericClassifiers", "false");
        //Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, parse, sentiment");
        stanfordCoreNLP = new StanfordCoreNLP(props);
    }

    public ResultUnit processSentiment(String sentiment) {
        int sentimentLevel = 0;
        if (sentiment != null && sentiment.length() > 0) {
            int longest = 0;
            Annotation annotation = stanfordCoreNLP.process(sentiment);
            for (CoreMap sentence : annotation
                    .get(CoreAnnotations.SentencesAnnotation.class)) {
                Tree tree = sentence
                        .get(SentimentCoreAnnotations.AnnotatedTree.class);
                int value = RNNCoreAnnotations.getPredictedClass(tree);
                String partText = sentence.toString();
                if (partText.length() > longest) {
                    sentimentLevel = value;
                    longest = partText.length();
                }
                for (CoreLabel token: sentence.get(CoreAnnotations.TokensAnnotation.class)){
                    // this is the text of the token
                    String word = token.get(CoreAnnotations.TextAnnotation.class);
                    // this is the POS tag of the token
                    String position = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
                    //This is the NER label of the token
                    String ner = token.get(CoreAnnotations.NamedEntityTagAnnotation.class);
                }
            }
        }
        return new ResultUnit(sentiment,
                getSentimentLevelAsString(sentimentLevel,sentiment));

    }

    private String getSentimentLevelAsString(int sentimentValue, String sentiment) {
        switch (sentimentValue) {
            case 0:
                negativeSentiments.add(sentiment);
                return "very negative";
            case 1:
                negativeSentiments.add(sentiment);
                return "negative";
            case 2:
                neutralSentiments.add(sentiment);
                return "neutral";
            case 3:
                positiveSentiments.add(sentiment);
                return "positive";
            case 4:
                positiveSentiments.add(sentiment);
                return "very positive";
            default:
                return "Unclassified!";
        }
    }

    public int getPositiveSentimentsCount() {
        return positiveSentiments.size();
    }

    public int getNegativeSentimentsCount() {
        return negativeSentiments.size();
    }
    public int getNeutralSentimentsCount() {
        return neutralSentiments.size();
    }

    public void cleanData(){
        positiveSentiments.clear();
        negativeSentiments.clear();
        neutralSentiments.clear();
        System.out.println(" All the processed data has been wiped out! ");
    }
}
