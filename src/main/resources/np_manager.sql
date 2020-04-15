--
-- PostgreSQL database dump
--

-- Dumped from database version 12.2
-- Dumped by pg_dump version 12.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

ALTER TABLE ONLY public."user" DROP CONSTRAINT username_unique;
ALTER TABLE ONLY public."user" DROP CONSTRAINT user_pkey;
DROP TABLE public."user";
DROP SEQUENCE public.hibernate_sequence;
DROP EXTENSION adminpack;
--
-- Name: adminpack; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION adminpack; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';


--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: npm
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO npm;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: user; Type: TABLE; Schema: public; Owner: npm
--

CREATE TABLE public."user" (
    id bigint NOT NULL,
    username character varying(255),
    fname character varying(255),
    lname character varying(255),
    address character varying(255),
    city character varying(255),
    state character varying(255),
    zip character varying(255),
    password text,
    roles text
);


ALTER TABLE public."user" OWNER TO npm;

--
-- Data for Name: user; Type: TABLE DATA; Schema: public; Owner: npm
--

COPY public."user" (id, username, fname, lname, address, city, state, zip, password, roles) FROM stdin;
0	hhb450@gmail.com	Haris	Siddiqui			\N		admin	ROLE_USER,ROLE_ADMIN
1	bilal	Bilal	Siddiqui	\N	\N	\N	\N	$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6	ROLE_ADMIN,ROLE_USER
3	hhb450	\N	\N	\N	\N	\N	\N	$2a$10$.m9VTlKKFPyLUk6nTZnRG.cxZifqGl3IeQVMocHqNf9GBtsX8svB.	ROLE_USER,ROLE_ADMIN
\.


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: npm
--

SELECT pg_catalog.setval('public.hibernate_sequence', 4, true);


--
-- Name: user user_pkey; Type: CONSTRAINT; Schema: public; Owner: npm
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);


--
-- Name: user username_unique; Type: CONSTRAINT; Schema: public; Owner: npm
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT username_unique UNIQUE (username);


--
-- PostgreSQL database dump complete
--

