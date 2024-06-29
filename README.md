# Asynchronous Communication Services with RabbitMQ

This project demonstrates the creation of two microservices that communicate asynchronously using RabbitMQ. The microservices are built using Spring Cloud Function and Spring Cloud Stream. They are containerized with Docker and can be easily run using Docker Compose.

## Table of Contents

- [Overview](#overview)
- [Technologies Used](#technologies-used)
- [Setup and Installation](#setup-and-installation)
- [Usage](#usage)


## Overview

This repository contains two microservices designed to communicate with each other asynchronously via RabbitMQ. The services are built using:

- **Spring Cloud Function**: To create cloud-agnostic functions that can be deployed on various cloud platforms.
- **Spring Cloud Stream**: To simplify the development of message-driven microservices by connecting them to messaging systems like RabbitMQ.

The microservices are packaged into Docker containers and pushed to Docker Hub for easy deployment.

**Note:** This project does not include actual implementations for user registration or sending emails to users. Successful communication between services is indicated using logging.

## Technologies Used

- **Spring Cloud Function**: Enables writing business logic as a function which can be deployed to various cloud platforms.
- **Spring Cloud Stream**: Simplifies the connection of microservices to messaging systems.
- **RabbitMQ**: Acts as the message broker facilitating communication between the services.
- **Docker**: Containerizes the microservices for consistent and isolated environments.
- **Docker Compose**: Orchestrates multi-container Docker applications.

## Setup and Installation

To run this project, you need to have Docker and Docker Compose installed on your machine. Follow the steps below to set up and run the services:

1. Clone the repository:
    ```sh
    git clone git@github.com:Salma158/Spring_RabbitMQ.git
    cd Spring_RabbitMQ
    ```

2. Run the services using Docker Compose:
    ```sh
    docker-compose up -d
    ```

## Usage

Once the services are up and running, they will communicate with each other asynchronously through RabbitMQ. You can monitor the services and their interactions through the RabbitMQ management console, which is accessible at `http://localhost:15672` (default credentials are `guest`/`guest`).
