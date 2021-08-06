--
-- PostgreSQL database dump
--

-- Dumped from database version 13.3
-- Dumped by pg_dump version 13.3

-- Started on 2021-08-06 21:03:51

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 200 (class 1259 OID 16987)
-- Name: animal; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.animal (
    id_animal bigint NOT NULL,
    species_animal text NOT NULL,
    name_animal text NOT NULL
);


ALTER TABLE public.animal OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 16993)
-- Name: animal_id_animal_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.animal_id_animal_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.animal_id_animal_seq OWNER TO postgres;

--
-- TOC entry 3010 (class 0 OID 0)
-- Dependencies: 201
-- Name: animal_id_animal_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.animal_id_animal_seq OWNED BY public.animal.id_animal;


--
-- TOC entry 202 (class 1259 OID 16995)
-- Name: cage; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cage (
    id_cage bigint NOT NULL,
    cond_cage text NOT NULL,
    isvacantcage boolean NOT NULL,
    id_animal integer,
    cage_area double precision NOT NULL
);


ALTER TABLE public.cage OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 17001)
-- Name: cage_id_cage_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cage_id_cage_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cage_id_cage_seq OWNER TO postgres;

--
-- TOC entry 3011 (class 0 OID 0)
-- Dependencies: 203
-- Name: cage_id_cage_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cage_id_cage_seq OWNED BY public.cage.id_cage;


--
-- TOC entry 204 (class 1259 OID 17003)
-- Name: inhibitionLog; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."inhibitionLog" (
    id_log bigint NOT NULL,
    checkindate timestamp without time zone NOT NULL,
    checkoutdate timestamp without time zone,
    species_animal text NOT NULL,
    name_animal text NOT NULL,
    id_animal integer NOT NULL
);


ALTER TABLE public."inhibitionLog" OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 17009)
-- Name: inhibitionLog_id_log_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."inhibitionLog_id_log_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."inhibitionLog_id_log_seq" OWNER TO postgres;

--
-- TOC entry 3012 (class 0 OID 0)
-- Dependencies: 205
-- Name: inhibitionLog_id_log_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."inhibitionLog_id_log_seq" OWNED BY public."inhibitionLog".id_log;


--
-- TOC entry 2865 (class 2604 OID 17011)
-- Name: animal id_animal; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.animal ALTER COLUMN id_animal SET DEFAULT nextval('public.animal_id_animal_seq'::regclass);


--
-- TOC entry 2866 (class 2604 OID 17012)
-- Name: cage id_cage; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cage ALTER COLUMN id_cage SET DEFAULT nextval('public.cage_id_cage_seq'::regclass);


--
-- TOC entry 2867 (class 2604 OID 17013)
-- Name: inhibitionLog id_log; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."inhibitionLog" ALTER COLUMN id_log SET DEFAULT nextval('public."inhibitionLog_id_log_seq"'::regclass);


--
-- TOC entry 2869 (class 2606 OID 17015)
-- Name: animal animal_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.animal
    ADD CONSTRAINT animal_pkey PRIMARY KEY (id_animal);


--
-- TOC entry 2871 (class 2606 OID 17017)
-- Name: cage cage_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cage
    ADD CONSTRAINT cage_pkey PRIMARY KEY (id_cage);


--
-- TOC entry 2873 (class 2606 OID 17019)
-- Name: inhibitionLog inhibitionLog_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."inhibitionLog"
    ADD CONSTRAINT "inhibitionLog_pkey" PRIMARY KEY (id_log);


--
-- TOC entry 2874 (class 2606 OID 17020)
-- Name: cage fk_id_animal; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cage
    ADD CONSTRAINT fk_id_animal FOREIGN KEY (id_animal) REFERENCES public.animal(id_animal) ON UPDATE CASCADE ON DELETE SET NULL NOT VALID;


-- Completed on 2021-08-06 21:03:51

--
-- PostgreSQL database dump complete
--

