package com.myorg;

import software.amazon.awscdk.App;

public class CdkProjectApp {
    public static void main(final String[] args) {
        App app = new App();

        VpcStack vpc = new VpcStack(app, "VPC");
        ClusterStack cluster = new ClusterStack(app, "Cluster", vpc.getVpc());
        cluster.addDependency(vpc);
        app.synth();
    }
}

