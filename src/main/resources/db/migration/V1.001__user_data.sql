	--
-- PostgreSQL database dump
--

-- Dumped from database version 11.6
-- Dumped by pg_dump version 11.6

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

--
-- Data for Name: user; Type: TABLE DATA; Schema: public; Owner: npm
--

INSERT INTO public."user" (id, username, fname, lname, address, city, state, zip, password, roles) VALUES (1, 'bilal1', NULL, NULL, NULL, NULL, NULL, NULL, '$2a$10$1BetRG7kz9UIlR0FbNzgXeViCKOQPRkd0sgbO78IvBKI3I4zKdJEa', NULL);
INSERT INTO public."user" (id, username, fname, lname, address, city, state, zip, password, roles) VALUES (2, 'bsiddiqui', NULL, NULL, NULL, NULL, NULL, NULL, '$2a$10$VdFPLWtjiBa3A2U1aid5z.cN29j9GqU2oC4QPz5Flix541W4YBpzq', NULL);
INSERT INTO public."user" (id, username, fname, lname, address, city, state, zip, password, roles) VALUES (3, 'bsiddiqui1', NULL, NULL, NULL, NULL, NULL, NULL, '$2a$10$HU4jZ.19s8XIBP9kChzM4.o8LFAZiNw937YbAkFCGlek1upTjpXXe', 'ADMIN_ROLE, ADMIN_USER');


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: npm
--

SELECT pg_catalog.setval('public.hibernate_sequence', 3, true);


--
-- PostgreSQL database dump complete
--

