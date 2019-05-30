package com.learn.mongo.transactions.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Configuration
public class MongoDBConfig extends AbstractMongoConfiguration {
    
    @Value( "${spring.data.mongodb.database}" )
    private String mongoDBDatabaseName;
    
    @Value( "${spring.data.mongodb.uri}" )
    private String mongoDBURI;
    
    @Bean
    MongoTransactionManager transactionManager(MongoDbFactory dbFactory) {
        return new MongoTransactionManager(dbFactory);
    }

    @Override
    public MongoClient mongoClient() {
        return new MongoClient(new MongoClientURI(mongoDBURI));
    }

    @Override
    protected String getDatabaseName() {
        return mongoDBDatabaseName;
    }
}
