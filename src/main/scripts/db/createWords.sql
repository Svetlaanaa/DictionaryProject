create schema "words" 

create table "words"."word" (
	"id" bigserial primary key,
	"basic_form" varchar(255) not null,
	"speech_part" varchar(100)
);

create table "words"."other_form" (
	"id" bigserial primary key,
	"word_id" bigint references "words"."word"(id) on delete cascade,
	"other_form" varchar(255) not null
)

