CREATE TABLE IF NOT EXISTS exchange_rate
(
    id              identity PRIMARY KEY,
    from_currency   varchar(3) not null,
    to_currency     varchar(3) not null,
    rate            decimal not null,
    created_at      timestamp with time zone not null
);

CREATE INDEX IF NOT EXISTS exchange_rate_created_at_idx ON exchange_rate (created_at);