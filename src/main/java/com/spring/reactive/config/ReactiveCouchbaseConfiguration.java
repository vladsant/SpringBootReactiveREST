	package com.spring.reactive.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableReactiveCouchbaseRepositories;;

@Configuration
@EnableReactiveCouchbaseRepositories("com.spring.reactive.repositories")
public class ReactiveCouchbaseConfiguration extends AbstractCouchbaseConfiguration {

    private CouchbaseProperties couchbaseProperties;

    public ReactiveCouchbaseConfiguration(CouchbaseProperties couchbaseProperties) {
        this.couchbaseProperties = couchbaseProperties;
    }

	@Override
	public String getConnectionString() {
		return couchbaseProperties.getConnectionString();
	}

	@Override
	public String getUserName() {
		return couchbaseProperties.getUserName();
	}

	@Override
	public String getPassword() {
		return couchbaseProperties.getPassword();
	}

	@Override
	public String getBucketName() {
	    return couchbaseProperties.getBucketName();
	}    
}