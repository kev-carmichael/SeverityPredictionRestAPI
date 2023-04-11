package com.kev.RestApp.util;

import weka.core.*;

import java.util.ArrayList;

public class Converter {
    public Instances convert8(ArrayList<String> simulationData) throws Exception  {
        ArrayList<Attribute> atts;
        ArrayList<String>    attVals4;
        ArrayList<String>    attVals5;
        Instances            data;
        double[]             vals;

        atts = new ArrayList<Attribute>();
        // - numeric
        atts.add(new Attribute("AgeAircraft"));
        // - numeric
        atts.add(new Attribute("No of passengers"));
        // - nominal
        attVals4 = new ArrayList<String>();
        attVals4.add("airline transport pilot licence");
        attVals4.add("private pilot licence");
        attVals4.add("student");
        atts.add(new Attribute("pic licence", attVals4));
        // - numeric
        atts.add(new Attribute("pic age"));
        // - numeric
        atts.add(new Attribute("Total hrs"));
        // - numeric
        atts.add(new Attribute("Type Hrs"));
        // - numeric
        atts.add(new Attribute("90 day Hrs"));
        // - numeric
        atts.add(new Attribute("28 day Hrs"));
        // - nominal
        attVals5 = new ArrayList<String>();
        attVals5.add("non-severe");
        attVals5.add("severe");
        atts.add(new Attribute("ACCIDENT_SEVERITY_SEVERE_OR_NON-SEVERE_TEXT", attVals5));


        data = new Instances("Temp_Simulation", atts, 0);

        vals = new double[data.numAttributes()];
        // - numeric
        vals[0] = Double.valueOf(simulationData.get(0));
        // - numeric
        vals[1] = Double.valueOf(simulationData.get(1));
        // - nominal
        vals[2] = attVals4.indexOf(simulationData.get(2));
        // - numeric
        vals[3] = Double.valueOf(simulationData.get(3));
        // - numeric
        vals[4] = Double.valueOf(simulationData.get(4));
        // - numeric
        vals[5] = Double.valueOf(simulationData.get(5));
        // - numeric
        vals[6] = Double.valueOf(simulationData.get(6));
        // - numeric
        vals[7] = Double.valueOf(simulationData.get(7));
        // - nominal (missing)
        vals[8] = Utils.missingValue();


        Instance instance = new DenseInstance(1.0, vals);
        instance.setMissing(8);
        data.add(instance);

        return data;
    }

    public Instances convert9(ArrayList<String> simulationData) throws Exception  {
        ArrayList<Attribute> atts;
        ArrayList<String>    attVals4;
        ArrayList<String>    attVals5;
        ArrayList<String>    attVals6;
        Instances            data;
        double[]             vals;

        atts = new ArrayList<Attribute>();
        // - numeric
        atts.add(new Attribute("AgeAircraft"));
        // - numeric
        atts.add(new Attribute("No of passengers"));
        // - nominal
        attVals4 = new ArrayList<String>();
        attVals4.add("airline transport pilot licence");
        attVals4.add("private pilot licence");
        attVals4.add("student");
        atts.add(new Attribute("pic licence", attVals4));
        // - numeric
        atts.add(new Attribute("pic age"));
        // - numeric
        atts.add(new Attribute("Total hrs"));
        // - numeric
        atts.add(new Attribute("Type Hrs"));
        // - numeric
        atts.add(new Attribute("90 day Hrs"));
        // - numeric
        atts.add(new Attribute("28 day Hrs"));
        // - nominal
        attVals5 = new ArrayList<String>();
        attVals5.add("Mon");
        attVals5.add("Tue");
        attVals5.add("Wed");
        attVals5.add("Thu");
        attVals5.add("Fri");
        attVals5.add("Sat");
        attVals5.add("Sun");
        atts.add(new Attribute("DAY OF WK", attVals5));
        // - nominal
        attVals6 = new ArrayList<String>();
        attVals6.add("minor/no injury");
        attVals6.add("fatal/serious");
        atts.add(new Attribute("INJURY CLASS", attVals6));


        data = new Instances("Temp_Simulation", atts, 0);

        vals = new double[data.numAttributes()];
        // - numeric
        vals[0] = Double.valueOf(simulationData.get(0));
        // - numeric
        vals[1] = Double.valueOf(simulationData.get(1));
        // - nominal
        vals[2] = attVals4.indexOf(simulationData.get(2));
        // - numeric
        vals[3] = Double.valueOf(simulationData.get(3));
        // - numeric
        vals[4] = Double.valueOf(simulationData.get(4));
        // - numeric
        vals[5] = Double.valueOf(simulationData.get(5));
        // - numeric
        vals[6] = Double.valueOf(simulationData.get(6));
        // - numeric
        vals[7] = Double.valueOf(simulationData.get(7));
        // - nominal
        vals[8] = attVals5.indexOf(simulationData.get(8));
        // - nominal (missing)
        vals[9] = Utils.missingValue();


        Instance instance = new DenseInstance(1.0, vals);
        instance.setMissing(9);
        data.add(instance);

        return data;
    }

}