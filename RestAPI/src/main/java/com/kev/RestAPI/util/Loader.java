package com.kev.RestAPI.util;

import com.kev.RestAPI.simulation.SimulationInputDTO;
import weka.classifiers.Classifier;
import weka.core.Instance;
import weka.core.Instances;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Loader {
    Classifier classifier;
    Instances testInstances;

    public ArrayList<String> load8(SimulationInputDTO simulationInputDTO) throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("RF_8xvars_SMOTE.model").getFile());
        classifier = (Classifier) weka.core.SerializationHelper.read(file.getAbsolutePath());

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
        String severityClass;
        String estimatedProbability;
        ArrayList<String> result = new ArrayList<>();

        Instance testInstance = testInstances.instance(0);
        double prediction = classifier.classifyInstance(testInstance);
        double[] probabilities = classifier.distributionForInstance(testInstance);

        severityClass = "Predicted severity class for simulation: " + testInstances.classAttribute().value((int) prediction);
        result.add(severityClass);
        double max = 0.0;
        for (double probability : probabilities) {
            if(probability > max){
                max = probability;
            }
        }
        max = Math.round(max * 1000);
        max = max/1000;
        estimatedProbability = "Estimated membership probability of the simulation for predicted severity class: " + max;
        result.add(estimatedProbability);
        return result;
    }

    public ArrayList<String> load9(SimulationInputDTO simulationInputDTO) throws Exception {
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
        String severityClass;
        String estimatedProbability;
        ArrayList<String> result = new ArrayList<>();

        Instance testInstance = testInstances.instance(0);
        double prediction = classifier.classifyInstance(testInstance);
        double[] probabilities = classifier.distributionForInstance(testInstance);

        severityClass = "Predicted severity class for simulation: " + testInstances.classAttribute().value((int) prediction);
        result.add(severityClass);
        double max = 0.0;
        for (double probability : probabilities) {
            if(probability > max){
                max = probability;
            }
        }
        max = Math.round(max * 1000);
        max = max/1000;
        estimatedProbability = "Estimated membership probability of the simulation for predicted severity class: " + max;
        result.add(estimatedProbability);
        return result;
    }



}