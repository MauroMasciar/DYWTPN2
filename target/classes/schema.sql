CREATE TABLE "achievements" (
	"id"	INTEGER UNIQUE,
	"game_name"	TEXT NOT NULL,
	"game_id"	INTEGER NOT NULL,
	"description"	TEXT NOT NULL UNIQUE,
	"date"	TEXT NOT NULL,
	PRIMARY KEY("id" AUTOINCREMENT)
)

CREATE TABLE "category" (
	"id"	INTEGER UNIQUE,
	"name"	INTEGER NOT NULL,
	"time_played"	INTEGER NOT NULL DEFAULT 0,
	"total_sessions"	INTEGER NOT NULL DEFAULT 0,
	PRIMARY KEY("id" AUTOINCREMENT)
)

CREATE TABLE "games" (
	"id"	INTEGER UNIQUE,
	"name"	TEXT NOT NULL DEFAULT 0 UNIQUE,
	"category"	INTEGER DEFAULT 0,
	"library"	INTEGER DEFAULT 0,
	"score"	INTEGER DEFAULT 0,
	"time_played"	INTEGER DEFAULT 0,
	"play_count"	INTEGER DEFAULT 0,
	"completed"	INTEGER DEFAULT 0,
	"completed_date"	TEXT,
	"hidden"	INTEGER DEFAULT 0,
	"path"	TEXT,
	"release_date"	TEXT,
	"developer"	TEXT,
	"series"	TEXT,
	"play_mode"	TEXT,
	"status"	TEXT,
	"last_played"	TEXT,
	"rating"	TEXT DEFAULT 'RP - Rating Pending',
	"platform"	INTEGER DEFAULT 0,
	"publisher"	TEXT,
	"region"	TEXT,
	"version"	TEXT,
	"added"	TEXT,
	"modified"	TEXT,
	"favorite"	INTEGER DEFAULT 0,
	"statistic"	INTEGER DEFAULT 1,
	"portable"	INTEGER DEFAULT 0,
	"image"	TEXT,
	"notes"	TEXT,
	"ghost"	INTEGER,
	PRIMARY KEY("id" AUTOINCREMENT)
)

CREATE TABLE "games_session_backup" (
	"id"	INTEGER UNIQUE,
	"game_id"	INTEGER NOT NULL,
	"date_time"	TEXT,
	"seconds"	INTEGER NOT NULL,
	PRIMARY KEY("id" AUTOINCREMENT)
)

CREATE TABLE "games_sessions_history" (
	"id"	INTEGER UNIQUE,
	"token"	TEXT NOT NULL DEFAULT 'NO',
	"game_id"	INTEGER NOT NULL,
	"game_name"	TEXT NOT NULL,
	"library_id"	INTEGER NOT NULL DEFAULT 0,
	"platform_id"	INTEGER NOT NULL DEFAULT 0,
	"datetime_start"	TEXT,
	"datetime_end"	TEXT,
	"seconds"	INTEGER NOT NULL DEFAULT 0,
	PRIMARY KEY("id" AUTOINCREMENT)
)

CREATE TABLE "library" (
	"id"	INTEGER UNIQUE,
	"name"	TEXT NOT NULL UNIQUE,
	"time_played"	INTEGER NOT NULL DEFAULT 0,
	"total_sessions"	INTEGER NOT NULL DEFAULT 0,
	PRIMARY KEY("id" AUTOINCREMENT)
)

CREATE TABLE "platforms" (
	"id"	INTEGER UNIQUE,
	"name"	TEXT NOT NULL UNIQUE,
	"time_played"	INTEGER DEFAULT 0,
	"total_sessions"	INTEGER DEFAULT 0,
	PRIMARY KEY("id" AUTOINCREMENT)
)

CREATE TABLE "players" (
	"id"	INTEGER UNIQUE,
	"name"	TEXT,
	"last_game"	INTEGER,
	"last_session_time"	INTEGER,
	PRIMARY KEY("id" AUTOINCREMENT)
)

CREATE TABLE "wishlist" (
	"id"	INTEGER UNIQUE,
	"game_name"	TEXT NOT NULL UNIQUE,
	PRIMARY KEY("id" AUTOINCREMENT)
)