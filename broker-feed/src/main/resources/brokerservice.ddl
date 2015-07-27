set search_path=web_iws;

CREATE ROLE brokerservice LOGIN
  NOSUPERUSER INHERIT NOCREATEDB NOCREATEROLE NOREPLICATION;

ALTER ROLE brokerservice
  SET search_path = web_iws;
GRANT sleyzerzon TO brokerservice;

ALTER ROLE brokerservice WITH PASSWORD 'Brokerserv!ce836!'

GRANT ALL ON DATABASE web_db TO brokerservice;

DROP TABLE IF EXISTS broker CASCADE;
DROP SEQUENCE IF EXISTS broker_id_seq CASCADE;

CREATE SEQUENCE broker_id_seq START 1;

GRANT ALL ON SEQUENCE web_iws.broker_id_seq TO dbadmin;
GRANT ALL ON SEQUENCE web_iws.broker_id_seq TO filehandler_app;
GRANT ALL ON SEQUENCE web_iws.broker_id_seq TO qa_webtolead;
GRANT ALL ON SEQUENCE web_iws.broker_id_seq TO es_web;
GRANT SELECT ON SEQUENCE web_iws.broker_id_seq TO mchernyak;
GRANT SELECT ON SEQUENCE web_iws.broker_id_seq TO js_ny;
GRANT SELECT ON SEQUENCE web_iws.broker_id_seq TO js_nj;
GRANT SELECT ON SEQUENCE web_iws.broker_id_seq TO js_or;
GRANT SELECT ON SEQUENCE web_iws.broker_id_seq TO niyantd;
GRANT SELECT ON SEQUENCE web_iws.broker_id_seq TO khannan;
GRANT ALL ON SEQUENCE web_iws.broker_id_seq TO yweinstock;
GRANT SELECT ON SEQUENCE web_iws.broker_id_seq TO dsmolensky;
GRANT ALL ON SEQUENCE web_iws.broker_id_seq TO arud;
GRANT ALL ON SEQUENCE web_iws.broker_id_seq TO mtietze;
GRANT ALL ON SEQUENCE web_iws.broker_id_seq TO moviedo;
GRANT ALL ON SEQUENCE web_iws.broker_id_seq TO sleyzerzon;
GRANT ALL ON SEQUENCE web_iws.broker_id_seq TO brokerservice;

CREATE TABLE broker (
    id bigint NOT NULL DEFAULT nextval('broker_id_seq'),
    create_timestamp timestamp without time zone DEFAULT now(),
    update_timestamp timestamp without time zone DEFAULT now(),
    
    sfid text,
    deleted boolean,
    account_name text,
    first_name text,
    last_name text,
    title text,
    ssn text,
    phone text,
    mobile_phone text,
    fax text,
    email text,
    mailing_street text,
    mailing_city text,
    mailing_state text,
    mailing_postal_code text,
    mailing_country text,
    broker_number text,
    npn text,
    ga text,
    ga_number text,
    birthdate date,
    appointed text, --status
    indor_corp text --legaEntity

);

ALTER TABLE ONLY broker ADD CONSTRAINT broker_pkey PRIMARY KEY (id);


GRANT ALL ON TABLE web_iws.broker TO dbadmin;
GRANT SELECT, UPDATE, INSERT, DELETE, REFERENCES ON TABLE web_iws.broker TO es_web;
GRANT ALL ON TABLE web_iws.broker TO appservices;
GRANT SELECT, UPDATE, INSERT, DELETE, REFERENCES ON TABLE web_iws.broker TO chrisc;
GRANT SELECT, UPDATE, INSERT, DELETE, REFERENCES ON TABLE web_iws.broker TO niyantd;
GRANT SELECT, UPDATE, INSERT, DELETE, REFERENCES ON TABLE web_iws.broker TO khannan;
GRANT SELECT, UPDATE, INSERT, DELETE, REFERENCES ON TABLE web_iws.broker TO yweinstock;
GRANT SELECT ON TABLE web_iws.broker TO dsmolensky;
GRANT ALL ON TABLE web_iws.broker TO rsivanand;
GRANT ALL ON TABLE web_iws.broker TO sleyzerzon;
GRANT ALL ON TABLE web_iws.broker TO arud;
GRANT ALL ON TABLE web_iws.broker TO moviedo;
GRANT ALL ON TABLE web_iws.broker TO mtietze;
GRANT SELECT ON TABLE web_iws.broker TO ssoservices;
GRANT ALL ON TABLE web_iws.broker TO gorozco;
GRANT SELECT ON TABLE web_iws.broker TO pkochar;
GRANT SELECT ON TABLE web_iws.broker TO brokerservice;
GRANT ALL ON TABLE web_iws.broker TO brokerservice;