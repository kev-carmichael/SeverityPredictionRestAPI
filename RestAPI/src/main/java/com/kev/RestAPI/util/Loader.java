package com.kev.RestAPI.util;

import com.kev.RestAPI.simulation.SimulationInputDTO;
import weka.classifiers.Classifier;
import weka.core.Instance;
import weka.core.Instances;

import java.util.ArrayList;

public class Loader {
    Classifier classifier;
    Instances testInstances;

    public String load8(SimulationInputDTO simulationInputDTO) throws Exception {
        classifier = (Classifier) weka.core.SerializationHelper.read("C://Users/KC135/DissertationJava/datasets/3_random_forest/ACCIDENT severity data and results/RF_8xvars.model");
        ArrayList<String> data = new ArrayList<>();
        data.add(Integer.toString(simulationInputDTO.getAgeAircraft()));
        data.add(Integer.toString(simulationInputDTO.getNoOfPassengers()));
        data.add(simulationInputDTO.getPicLicence());
        data.add(Integer.toString(simulationInputDTO.getPicAge()));
        data.add(Integer.toString(simulationInputDTO.getTotalHrs()));
        data.add(Integer.toString(simulationInputDTO.getTypeHrs()));
        data.add(Integer.toString(simulationInputDTO.getNinetyDayHrs()));
        data.add(Integer.toString(simulationInputDTO.getTwentyEightDayHrs()));

        testInstances = new Converter().convert8(data);

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
            result += testInstances.classAttribute().value((int) prediction);
        }
        return result;
    }

    public String load9(SimulationInputDTO simulationInputDTO) throws Exception {
        classifier = (Classifier) weka.core.SerializationHelper.read("C://Users/KC135/DissertationJava/datasets/2_decision_tree/INJURY severity data and results/DT_9xvars_v2.model");
        ArrayList<String> data = new ArrayList<>();
        data.add(Integer.toString(simulationInputDTO.getAgeAircraft()));
        data.add(Integer.toString(simulationInputDTO.getNoOfPassengers()));
        data.add(simulationInputDTO.getPicLicence());
        data.add(Integer.toString(simulationInputDTO.getPicAge()));
        data.add(Integer.toString(simulationInputDTO.getTotalHrs()));
        data.add(Integer.toString(simulationInputDTO.getTypeHrs()));
        data.add(Integer.toString(simulationInputDTO.getNinetyDayHrs()));
        data.add(Integer.toString(simulationInputDTO.getTwentyEightDayHrs()));
        data.add(simulationInputDTO.getDayOfWeek());
        testInstances = new Converter().convert9(data);

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
            result += testInstances.classAttribute().value((int) prediction);
        }
        return result;
    }



}