create schema "definitions"

create table "definitions"."definition" (
	"id" bigserial primary key,
	"word_id" bigint references "words"."word"(id) on delete cascade,
	"definition_text" text not null,
	"usage_example" text
);

create table "definitions"."source" (
	"id" bigserial primary key,
	"definition_id" bigint references "definitions"."definition"(id) on delete cascade,
	"word_id" bigint references "words"."word"(id) on delete cascade,
	"source" text not null 
);

CREATE TABLE "definitions"."synonym" (
    "id" bigserial primary key,
	"definition_id" bigint references "definitions"."definition"(id) on delete cascade,
	"word_id" bigint references "words"."word"(id) on delete cascade,
	"synonym" bigint references "words"."word"(id)
);
