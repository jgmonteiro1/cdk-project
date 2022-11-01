package com.myorg;

import software.amazon.awscdk.App;

public class CdkProjectApp {
    public static void main(final String[] args) {
        App app = new App();

        new VpcStack(app, "VPC");
        app.synth();
    }
}

