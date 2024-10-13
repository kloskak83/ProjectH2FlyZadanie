CREATE TABLE Currency (
    id INT PRIMARY KEY,
    currencyName VARCHAR(255),
    currencyCode VARCHAR(10),
    midRate NUMERIC(15, 4)  -- Poprawiony typ na odpowiedni dla pieniędzy
);

CREATE TABLE Log (
    id INT PRIMARY KEY auto_increment,
    description VARCHAR(255),
    dateStamp DATE
);
