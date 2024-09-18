create table if not exists fraud_numbers
(
    id                  bigserial primary key   not null,
    number              bigint                  not null,
    flag_of_blocking    boolean,
    time_of_blocking    timestamp
);
CREATE INDEX if not exists index1 ON fraud_numbers (number);



