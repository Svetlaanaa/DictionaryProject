create schema if not exists "words";
ALTER SCHEMA "words" OWNER TO dictionary_test_user;
create schema if not exists "definitions";
ALTER SCHEMA "definitions" OWNER TO dictionary_test_user;

drop table if exists "words"."word" cascade;
drop table if exists "words"."other_form";

drop table if exists "definitions"."definition" cascade;
drop table if exists "definitions"."source";
drop table if exists "definitions"."synonym";

create table "words"."word" (
	"id" bigserial primary key,
	"basic_form" varchar(255) not null
);
ALTER TABLE "words"."word" OWNER TO dictionary_test_user;

create table "words"."other_form" (
	"id" bigserial primary key,
	"word_id" bigint references "words"."word"("id") on delete cascade,
	"other_form" varchar(255) not null
);
ALTER TABLE "words"."other_form" OWNER TO dictionary_test_user;

create table "definitions"."definition" (
	"id" bigserial primary key,
	"word_id" bigint references "words"."word"("id") on delete cascade,
	"definition_text" text not null,
	"usage_example" text,
	"speech_part" varchar(100)
);
ALTER TABLE "definitions"."definition" OWNER TO dictionary_test_user;

create table "definitions"."source" (
	"id" bigserial primary key,
	"definition_id" bigint references "definitions"."definition"("id") on delete cascade,
	"source" text not null
);
ALTER TABLE "definitions"."source" OWNER TO dictionary_test_user;

CREATE TABLE "definitions"."synonym" (
    "id" bigserial primary key,
	"definition_id" bigint references "definitions"."definition"("id") on delete cascade,
	"synonym" bigint references "words"."word"("id") on delete cascade
);
ALTER TABLE "definitions"."synonym" OWNER TO dictionary_test_user;