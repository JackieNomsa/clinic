CREATE TABLE IF NOT EXISTS slots_booking (
    patient_id varchar(50) not null,
    first_name varchar(100) not null,
    last_name varchar(100) not null,
    status varchar(10) not null,
    booking_reference varchar(20),
    primary key (patient_id)
);

