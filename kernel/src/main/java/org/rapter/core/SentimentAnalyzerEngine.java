package org.rapter.core;


import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;

import java.util.Properties;

/**
 * Created by Pubudu Dissanayake on 12/8/15.
 * Project : sentiment-engine
 */
public class SentimentAnalyzerEngine {

    public ResultUnit processSentiment(String sentiment, Properties properties){
//         Properties props = new Properties();
//         props.put("annotators", "tokenize, ssplit, pos, lemma, ner, depparse");
//         props.put("ner.model", "edu/stanford/nlp/models/ner/english.all.3class.distsim.crf.ser.gz");
//         props.put("ner.applyNumericClassifiers", "false");
         StanfordCoreNLP stanfordCoreNLP = new StanfordCoreNLP(properties);
        int sentimentLevel = 0;
        if(sentiment != null && sentiment.length() > 0){
            int longest = 0;
            Annotation annotation = stanfordCoreNLP.process(sentiment);
            for (CoreMap sentence : annotation
                    .get(CoreAnnotations.SentencesAnnotation.class)) {
                Tree tree = sentence
                        .get(SentimentCoreAnnotations.SentimentAnnotatedTree.class);
                int value = RNNCoreAnnotations.getPredictedClass(tree);
                String partText = sentence.toString();
                if (partText.length() > longest) {
                    sentimentLevel = value;
                    longest = partText.length();
                }
            }
        }
        if (sentimentLevel == 2 || sentimentLevel > 4 || sentimentLevel < 0) {
            return null;
        }
        return new ResultUnit(sentiment,
                getSentimentLevelAsString(sentimentLevel));

    }

    private String getSentimentLevelAsString(int sentiment) {
        switch (sentiment) {
            case 0:
                return "very negative";
            case 1:
                return "negative";
            case 2:
                return "neutral";
            case 3:
                return "positive";
            case 4:
                return "very positive";
            default:
                return "Unclassified!";
        }
    }


}
