-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2021-03-28 00:33:58.001

DROP DATABASE IF EXISTS ecommerce;

CREATE DATABASE ecommerce;

-- Make sure we're using our `ecommerce` database
\c ecommerce;
GRANT ALL PRIVILEGES ON DATABASE ecommerce TO docker;

-- tables
-- Table: address
CREATE TABLE address (
    id int  NOT NULL,
    address_type varchar(30)  NOT NULL,
    address_usage_type varchar(20)  NOT NULL,
    address varchar(60)  NOT NULL,
    city varchar(10)  NOT NULL,
    state varchar(10)  NOT NULL,
    zipcode varchar(10)  NOT NULL,
    sytem_insertion_ts timestamp  NOT NULL,
    sytem_revision_ts timestamp  NOT NULL,   
    CONSTRAINT address_pk PRIMARY KEY (id)
);

-- Table: customer
CREATE TABLE customer (
    id int  NOT NULL,
    first_name varchar(128)  NULL,
    last_name varchar(128)  NULL,
    email_id varchar(30)  NULL,
    phone_number varchar(10)  NOT NULL,
    addressLine1 varchar(30)  NOT NULL,
    city varchar(30)  NOT NULL,
    state varchar(20)  NOT NULL,
    zipcode varchar(20)  NOT NULL,
    sytem_insertion_ts timestamp  NOT NULL,
    sytem_revision_ts timestamp  NOT NULL,
    CONSTRAINT customer_pk PRIMARY KEY (id)
);

-- Table: order
CREATE TABLE "order" (
    id int  NOT NULL,
    customer_id int  NOT NULL,
    number_of_items int  NOT NULL,
    order_shipping_charges decimal(19,2)  NOT NULL,
    order_tax decimal(19,2)  NOT NULL,
    order_total decimal(19,2)  NOT NULL,
    billing_address_id int  NOT NULL,
    shipping_address_id int  NOT NULL,
    order_status varchar(30)  NOT NULL,
    sytem_insertion_ts timestamp  NOT NULL,
    system_revision_ts timestamp  NOT NULL,
    CONSTRAINT order_ak_1 UNIQUE (billing_address_id, shipping_address_id, customer_id) NOT DEFERRABLE  INITIALLY IMMEDIATE,
    CONSTRAINT order_pk PRIMARY KEY (id)
);

-- Table: order_details
CREATE TABLE order_details (
    id int  NOT NULL,
    order_id int  NOT NULL,
    item_id int  NOT NULL,
    item_qty int  NOT NULL,
    item_price decimal(8,2)  NOT NULL,
    item_name decimal(8,2)  NOT NULL,
    sytem_insertion_ts timestamp  NOT NULL,
    sytem_revision_ts timestamp  NOT NULL,
    CONSTRAINT shipmet_details_ak_1 UNIQUE (order_id, item_id) NOT DEFERRABLE  INITIALLY IMMEDIATE,
    CONSTRAINT order_details_pk PRIMARY KEY (id)
);

-- Table: order_payment_rlt
CREATE TABLE order_payment_rlt (
    id int  NOT NULL,
    order_id int  NOT NULL,
    payment_id int  NOT NULL,
    system_revision_ts timestamp  NOT NULL,
    sytem_insertion_ts timestamp  NOT NULL,
    CONSTRAINT order_payment_rlt_pk PRIMARY KEY (id)
);

-- Table: payment
CREATE TABLE payment (
    id int  NOT NULL,
    payment_method varchar(20)  NULL,
    cardholder_name varchar(255)  NOT NULL,
    card_number varchar(255)  NOT NULL,
    expiry_date varchar(5)  NOT NULL,
    cvv int  NOT NULL,
    zipcode varchar(10)  NOT NULL,
    CONSTRAINT payment_data_ak_1 UNIQUE (cardholder_name) NOT DEFERRABLE  INITIALLY IMMEDIATE,
    CONSTRAINT payment_pk PRIMARY KEY (id)
);

-- Table: product
CREATE TABLE product (
    id int  NOT NULL,
    product_name varchar(64)  NULL,
    product_description varchar(255)  NULL,
    product_price decimal(8,2)  NULL,
    sytem_insertion_ts timestamp  NOT NULL,
    system_revision_ts timestamp  NOT NULL,
    CONSTRAINT product_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: address_order (table: address)
ALTER TABLE "order" ADD CONSTRAINT address_order_billing
    FOREIGN KEY (billing_address_id)
    REFERENCES address (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

ALTER TABLE "order" ADD CONSTRAINT address_order_shipping
    FOREIGN KEY (shipping_address_id)
    REFERENCES address (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: order_customer (table: order)
ALTER TABLE "order" ADD CONSTRAINT order_customer
    FOREIGN KEY (customer_id)
    REFERENCES customer (id) 
    ON UPDATE  CASCADE 
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: order_details (table: order_details)
ALTER TABLE order_details ADD CONSTRAINT order_details
    FOREIGN KEY (order_id)
    REFERENCES "order" (id) 
    ON UPDATE  CASCADE 
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: order_details_product (table: order_details)
ALTER TABLE order_details ADD CONSTRAINT order_details_product
    FOREIGN KEY (item_id)
    REFERENCES product (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: order_payment_rlt (table: order_payment_rlt)
ALTER TABLE order_payment_rlt ADD CONSTRAINT order_payment_rlt
    FOREIGN KEY (order_id)
    REFERENCES "order" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: payment_details_payment_data (table: order_payment_rlt)
ALTER TABLE order_payment_rlt ADD CONSTRAINT payment_details_payment_data
    FOREIGN KEY (payment_id)
    REFERENCES payment (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- sequences
-- Sequence: address_sequence
CREATE SEQUENCE address_sequence
      INCREMENT BY 1
      MINVALUE 1
      MAXVALUE 9999999999999999
      START WITH 1
      CACHE 20
      CYCLE
;

-- Sequence: customer_sequence
CREATE SEQUENCE customer_sequence
      INCREMENT BY 1
      MINVALUE 1
      MAXVALUE 9999999999999999
      START WITH 1
      CACHE 20
      CYCLE
;

-- Sequence: order_details_sequence
CREATE SEQUENCE order_details_sequence
      INCREMENT BY 1
      MINVALUE 1
      MAXVALUE 9999999999999999
      START WITH 1
      CACHE 20
      CYCLE
;

-- Sequence: order_payment_rlt_sequence
CREATE SEQUENCE order_payment_rlt_sequence
      INCREMENT BY 1
      MINVALUE 1
      MAXVALUE 9999999999999999
      START WITH 1
      CACHE 20
      CYCLE
;

-- Sequence: order_sequence
CREATE SEQUENCE order_sequence
      INCREMENT BY 1
      MINVALUE 1
      MAXVALUE 9999999999999999
      START WITH 1
      CACHE 20
      CYCLE
;

-- Sequence: payment_id
CREATE SEQUENCE payment_id
      INCREMENT BY 1
      MINVALUE 1
      MAXVALUE 9999999999999999
      START WITH 1
      CACHE 20
      CYCLE
;

-- Sequence: product_sequence
CREATE SEQUENCE product_sequence
      INCREMENT BY 1
      MINVALUE 1
      MAXVALUE 9999999999999999
      START WITH 1
      CACHE 20
      CYCLE
;

-- End of file.

