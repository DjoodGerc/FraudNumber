alter table fraud_numbers
    alter column time_of_blocking type timestamptz using time_of_blocking::timestamptz;