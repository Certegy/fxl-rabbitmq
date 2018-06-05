

## Intro

This provides a small stub to demonstrate publishing to a RabbitMQ instance from a Java client.

## Dev requirements

 * Java Development Kit 
 * Gradle version 4.7 

The following PPA can be used to add the required version of Gradle to a stock Ubuntu 16.04 / 18.04 machine

    https://launchpad.net/~cwchien/+archive/ubuntu/gradle


    sudo add-apt-repository ppa:cwchien/gradle
    sudo apt-get update
    sudo apt-get install gradle


## Building 

    $ gradle build

## Execute 

    $ gradle run

## Confirmation

###  Admin portal
    
    http://23.101.219.122:15672/

### Connection details

    "host": "rabbitmq://23.101.219.122",
    "username": "guest",
    "password": "<provided>",
    "exchangeName": "dispatch.email.Incoming", // this may need to change