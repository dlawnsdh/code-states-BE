![image](https://user-images.githubusercontent.com/77203609/194231601-1e9d1ff0-f188-4a20-bc0f-4674bbebf6d5.png)
<br>
<br>
Table "USERS" {
  "user_id" varchar(50) [pk, not null]
  "password" varchar(50)
  "name" varchar(50)
  "email" varchar(50)
}

Table "POSTS" {
  "post_id" INT [pk, not null, increment]
  "user_id" varchar(50) [not null]
  "post_img_url" varchar(100)
  "post_comment" varchar
  "like" INT
}

Table "COMMENTS" {
  "comment_id" INT [pk, not null, increment]
  "user_id" varchar(50)
  "comment_text" varchar
  "like" INT
}

Table "HASHTAG" {
  "post_comment" varchar
  "comment_text" varchar
}

Table "LIKE" {
  "like" INT
}

Table "FOLLOWER" {
  "user_id" varchar(50)
  "followed_id" varchar(50)
}

Table "FOLLOW" {
  "user_id" varchar(50)
  "following_id" varchar(50)
}

Ref:"USERS"."user_id" < "POSTS"."user_id"

Ref:"LIKE"."like" < "POSTS"."like"

Ref:"USERS"."user_id" < "COMMENTS"."user_id"

Ref:"LIKE"."like" < "COMMENTS"."like"

Ref:"POSTS"."post_comment" < "HASHTAG"."post_comment"

Ref:"COMMENTS"."comment_text" < "HASHTAG"."comment_text"

Ref:"USERS"."user_id" < "FOLLOWER"."user_id"

Ref:"USERS"."user_id" < "FOLLOW"."user_id"
