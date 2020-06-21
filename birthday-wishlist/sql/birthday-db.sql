drop schema if exists `birthday-wishlist-db`;
create schema `birthday-wishlist-db`;
use `birthday-wishlist-db`;

drop table if exists `friend`;

create table `friend` (
	`id` int primary key not null auto_increment,
	`name` varchar(128) not null,
	`birthday` date not null, 
	`wishlist_id` varchar(13) not null,
    `amazon_domain` varchar(3) not null
)