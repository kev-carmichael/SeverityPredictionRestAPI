package com.kev.RestApp.util;

import weka.classifiers.Classifier;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

import java.util.ArrayList;

public class Loader {
    Classifier classifier;
    Instances testInstances;

    public String load(ArrayList<String> data) throws Exception {
        if(data.size()==8) {
            classifier = (Classifier) weka.core.SerializationHelper.read("C://Users/KC135/DissertationJava/datasets/3_random_forest/ACCIDENT severity data and results/RF_8xvars.model");
            testInstances = new Converter().convert8(data);
        } else if(data.size()==9) {
            classifier = (Classifier) weka.core.SerializationHelper.read("C://Users/KC135/DissertationJava/datasets/2_decision_tree/INJURY severity data and results/DT_9xvars_v2.model");
            testInstances = new Converter().convert9(data);
        } else System.out.println("Incorrect Input Size");//change this to error/IncorrectInputSizeException

        testInstances.setClassIndex(testInstances.numAttributes() - 1);
        String result = "";

        for (int i = 0; i < testInstances.numInstances(); i++) {
            Instance testInstance = testInstances.instance(i);
            double prediction = classifier.classifyInstance(testInstance);
            double[] probabilities = classifier.distributionForInstance(testInstance);

            /*result += "Instance " + (i+1) + " - ";
            result += "Actual class: " + testInstance.stringValue(testInstance.classIndex());
            result += " Predicted class: " + testInstances.classAttribute().value((int) prediction);
            result += ". Class probabilities: ";
            for (double probability : probabilities) {
                result += probability + " ";
            }
            result += "\n";*/
            result = testInstances.classAttribute().value((int) prediction);
        }
        return result;
    }
}