CREATE TABLE "account" (
  "id" SERIAL NOT NULL,
  "login" varchar NOT NULL,
  "password" varchar NOT NULL,
  "first_name" varchar NOT NULL,
  "middle_name" varchar NOT NULL,
  "last_name" varchar NOT NULL,
  "email" varchar NOT NULL,
  "phone" varchar NOT NULL,
  "role" varchar NOT NULL,
  PRIMARY KEY ("id")
);

CREATE TABLE "service" (
  "id" SERIAL NOT NULL,
  "name" varchar NOT NULL,
  PRIMARY KEY ("id")
);

CREATE TABLE "order" (
  "id" SERIAL NOT NULL,
  "account_id" int NOT NULL,
  "service_id" int NOT NULL,
  "address" varchar NOT NULL,
  "contacts" varchar NOT NULL,
  "delivery_date" timestamp NOT NULL,
  "payment_type" varchar NOT NULL,
  "status" varchar NOT NULL,
  PRIMARY KEY ("id")
);

ALTER TABLE "order" ADD FOREIGN KEY ("account_id") REFERENCES "account" ("id");

ALTER TABLE "order" ADD FOREIGN KEY ("service_id") REFERENCES "service" ("id");
