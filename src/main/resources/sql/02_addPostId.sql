alter table comment add column post_id INTEGER not null;
alter table comment add constraint fk_post_comment foreign key (post_id) references post(id);