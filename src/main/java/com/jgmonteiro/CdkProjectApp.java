package com.jgmonteiro;

import software.amazon.awscdk.App;

public class CdkProjectApp {  public static void main(final String[] args) {
    App app = new App();

    VpcStack vpc = new VpcStack(app, "VPC");

    ClusterStack cluster = new ClusterStack(app, "Cluster", vpc.getVpc());
    cluster.addDependency(vpc);

    RdsStack rdsStack = new RdsStack(app, "Rds", vpc.getVpc());
    rdsStack.addDependency(vpc);

    SnsStack snsStack = new SnsStack(app, "SNS");


    Service01Stack serviceStack = new Service01Stack(app, "Service01", cluster.getCluster());
    serviceStack.addDependency(cluster);
    serviceStack.addDependency(rdsStack);

    app.synth();
}

}

