// README.md
# Slots Booking Application
### Introduction
An api for booking time slots to visit a clinic or home affairs
### Getting started
* Clone this repository [here](https://github.com/JackieNomsa/clinic).
* Change into the dlotsBooking directory
* Run mvn install to install all dependancies
* Run mvn test to ensure that the project is functional, all tests should pass
### Usage
* Run BookingApplication  to start the application
* navigate to http://127.0.0.1:8080/ using an api tool like postman
### API Endpoints
| HTTP Verbs | Endpoints                 | Action                                         |
|------------|---------------------------|------------------------------------------------|
| POST       | /clinic/create            | To add a new clinic slot                       |
| POST       | /homeaffairs/create       | To add a new home affairs slot                 |
| DELETE     | /clinic/delete/{id}       | To delete an existing clinic slot              |
| DELETE     | /homeaffairs/delete/{id}  | To delete an existing home affairs slot        |
| PUT        | /clinic/update            | Add a date & time slot to booking if available |
| PUT        | /homeaffairs/update       | Add a date & time slot to booking if available |
| GET        | /clinic/getAll            | To get all available clinic slots              |
| GET        | /clinic/getById/{id}      | To get a slot by its id                        |
| GET        | /homeaffairs/getAll       | To get all available home affairs slots        |
| GET        | /homeaffairs/getById/{id} | To get a slot by its id                        |
