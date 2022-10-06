create table USERS (
  user_id varchar(50) not null primary key,
  password varchar(50),
  name varchar(50),
  email varchar(50)
);

create table POSTS (
  post_id INT not null auto_increment primary key, 
  user_id varchar(50) not null,
  post_img_url varchar(100),
  post_comment varchar(1000),
  liked INT,
  foreign key (user_id) references USERS (user_id),
  foreign key (liked) references LIKED (liked)
);

create table COMMENTS (
  comment_id INT not null auto_increment primary key, 
  user_id varchar(50),
  comment_text varchar(1000),
  liked INT,
  foreign key (user_id) references USERS (user_id),
  foreign key (liked) references LIKED (liked)
);

create table HASHTAG (
  post_comment varchar(1000),
  comment_text varchar(1000),
  foreign key (post_comment) references POSTS (post_comment),
  foreign key (comment_text) references COMMENTS (comment_text)
);

create table LIKED (
  liked INT
);

create table FOLLOWER (
  user_id varchar(50),
  followed_id varchar(50),
  foreign key (user_id) references USERS (user_id)
);

create table FOLLOW (
  user_id varchar(50),
  following_id varchar(50),
  foreign key (user_id) references USERS (user_id)
);