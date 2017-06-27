# Configuration Service

Spring Cloud Microservice used to centralise other services' configuration.

# Dependencies

* Configuration Service
  * This microservice depends on the Configuration Service in order to retrieve its settings. It means that before starting this server,
    please make sure that the one it depends on is already running.
  * You can find out how to run the Configuration Service here: [Configuration Service](https://github.com/ekholabs/configuration-service)
* Eureka Service
  * As a second note, this microservice also dependes on the Eureka Service in order to register for service discovery. However,
    the Eureka Service does not need to be running before this one can be started.
  * You can find out how to run the Configuration Service here: [Eureka Service](https://github.com/ekholabs/eureka-service)

In a dependency order priority, the Configuration Service should be started before everything else.

# Pulling the Docker Image

* ```docker pull ekholabs/configuration-service```

# Running the Docker Container

* ```docker run -d -p 8080:8080 --link configuration-service --link eureka-service --name=elsie-deetect ekholabs/elsie-deetect```
