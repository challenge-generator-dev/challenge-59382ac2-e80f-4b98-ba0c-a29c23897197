package com.orderservice.infrastructure.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsConfig {

    @Value("${aws.region}")
    private String awsRegion;

    @Value("${aws.sqs.endpoint:}")
    private String sqsEndpoint;

    @Value("${aws.sns.endpoint:}")
    private String snsEndpoint;

    @Value("${AWS_ACCESS_KEY_ID:}")
    private String accessKeyId;

    @Value("${AWS_SECRET_ACCESS_KEY:}")
    private String secretAccessKey;

    @Bean
    public AmazonSQS amazonSQS() {
        AmazonSQSClientBuilder builder = AmazonSQSClientBuilder.standard();

        if (sqsEndpoint != null && !sqsEndpoint.isEmpty()) {
            builder.withEndpointConfiguration(
                    new AwsClientBuilder.EndpointConfiguration(sqsEndpoint, awsRegion));
        } else {
            builder.withRegion(awsRegion);
        }

        if (accessKeyId != null && !accessKeyId.isEmpty() && secretAccessKey != null && !secretAccessKey.isEmpty()) {
            BasicAWSCredentials credentials = new BasicAWSCredentials(accessKeyId, secretAccessKey);
            builder.withCredentials(new AWSStaticCredentialsProvider(credentials));
        }

        return builder.build();
    }

    @Bean
    public AmazonSNS amazonSNS() {
        AmazonSNSClientBuilder builder = AmazonSNSClientBuilder.standard();

        if (snsEndpoint != null && !snsEndpoint.isEmpty()) {
            builder.withEndpointConfiguration(
                    new AwsClientBuilder.EndpointConfiguration(snsEndpoint, awsRegion));
        } else {
            builder.withRegion(awsRegion);
        }

        if (accessKeyId != null && !accessKeyId.isEmpty() && secretAccessKey != null && !secretAccessKey.isEmpty()) {
            BasicAWSCredentials credentials = new BasicAWSCredentials(accessKeyId, secretAccessKey);
            builder.withCredentials(new AWSStaticCredentialsProvider(credentials));
        }

        return builder.build();
    }
}