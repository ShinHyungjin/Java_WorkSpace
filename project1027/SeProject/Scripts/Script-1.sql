UPDATE sub_interests SET sub_img = 'c_plus2.png' WHERE sub_id = 1;
UPDATE sub_interests SET sub_img = 'c.png' WHERE sub_id = 2;
UPDATE sub_interests SET sub_img = 'java.png' WHERE sub_id = 3;
UPDATE sub_interests SET sub_img = 'py.png' WHERE sub_id = 4;
UPDATE sub_interests SET sub_img = 'html.png' WHERE sub_id = 5;
UPDATE sub_interests SET sub_img = 'jsp.png' WHERE sub_id = 6;
UPDATE sub_interests SET sub_img = 'react.png' WHERE sub_id = 7;
UPDATE sub_interests SET sub_img = 'nodejs.png' WHERE sub_id = 8;
UPDATE sub_interests SET sub_img = 'android.png' WHERE sub_id = 9;
UPDATE sub_interests SET sub_img = 'yoga.png' WHERE sub_id = 10;
UPDATE sub_interests SET sub_img = 'pilates.png' WHERE sub_id = 11;
UPDATE sub_interests SET sub_img = 'health.png' WHERE sub_id = 12;
UPDATE sub_interests SET sub_img = 'swim.png' WHERE sub_id = 13;
UPDATE sub_interests SET sub_img = 'golf.png' WHERE sub_id = 14;
UPDATE sub_interests SET sub_img = 'ski.png' WHERE sub_id = 15;
UPDATE sub_interests SET sub_img = 'vocal.png' WHERE sub_id = 16;
UPDATE sub_interests SET sub_img = 'drum.png' WHERE sub_id = 17;
UPDATE sub_interests SET sub_img = 'guitar.png' WHERE sub_id = 18;
UPDATE sub_interests SET sub_img = 'action.png' WHERE sub_id = 19;
UPDATE sub_interests SET sub_img = 'dance.png' WHERE sub_id = 20;
UPDATE sub_interests SET sub_img = 'art.png' WHERE sub_id = 21;
UPDATE sub_interests SET sub_img = 'interior.png' WHERE sub_id = 22;
UPDATE sub_interests SET sub_img = 'paint.png' WHERE sub_id = 23;
UPDATE sub_interests SET sub_img = 'bathroom.png' WHERE sub_id = 24;
UPDATE sub_interests SET sub_img = 'tile.png' WHERE sub_id = 25;
UPDATE sub_interests SET sub_img = 'wallpaper.png' WHERE sub_id = 26;
UPDATE sub_interests SET sub_img = 'light.png' WHERE sub_id = 27;
UPDATE sub_interests SET sub_img = 'korea.png' WHERE sub_id = 28;
UPDATE sub_interests SET sub_img = 'china.png' WHERE sub_id = 29;
UPDATE sub_interests SET sub_img = 'japanese.png' WHERE sub_id = 30;
UPDATE sub_interests SET sub_img = 'western.png' WHERE sub_id = 31;
UPDATE sub_interests SET sub_img = 'fusion.png' WHERE sub_id = 32;
UPDATE sub_interests SET sub_img = 'bread.png' WHERE sub_id = 33;
UPDATE sub_interests SET sub_img = 'japanes.png' WHERE sub_id = 34;
UPDATE sub_interests SET sub_img = 'Chinese.png' WHERE sub_id = 35;
UPDATE sub_interests SET sub_img = 'Thai.png' WHERE sub_id = 36;
UPDATE sub_interests SET sub_img = 'Russian.png' WHERE sub_id = 37;
UPDATE sub_interests SET sub_img = 'Italian.png' WHERE sub_id = 38;
UPDATE sub_interests SET sub_img = 'German.png' WHERE sub_id = 39;
UPDATE sub_interests SET sub_img = 'Spanish.png' WHERE sub_id = 40;
UPDATE sub_interests SET sub_img = 'French.png' WHERE sub_id = 41;
UPDATE sub_interests SET sub_img = 'English.png' WHERE sub_id = 42;
UPDATE sub_interests SET sub_img = 'Math.png' WHERE sub_id = 43;
UPDATE sub_interests SET sub_img = 'korean.png' WHERE sub_id = 44;
UPDATE sub_interests SET sub_img = 'Sience.png' WHERE sub_id = 45;
UPDATE sub_interests SET sub_img = 'Korean_history.png' WHERE sub_id = 46;
UPDATE sub_interests SET sub_img = 'Chinese_characters.png' WHERE sub_id = 47;
UPDATE sub_interests SET sub_img = 'Toeic.png' WHERE sub_id = 48;
UPDATE sub_interests SET sub_img = 'makeup.png' WHERE sub_id = 49;
UPDATE sub_interests SET sub_img = 'hair.png' WHERE sub_id = 50;
UPDATE sub_interests SET sub_img = 'nailart.png' WHERE sub_id = 51;
UPDATE sub_interests SET sub_img = 'special_makeup.png' WHERE sub_id = 52;
UPDATE sub_interests SET sub_img = 'wedding.png' WHERE sub_id = 53;
UPDATE sub_interests SET sub_img = 'tatoo.png' WHERE sub_id = 54;

select sub_name from sub_interests where top_id=(select top_id from top_interests where top_name='운동');

INSERT INTO member(m_seq, m_id, m_password, m_name, m_location, m_mail, m_gender, m_position, m_introduce, m_image, m_top_interests, m_sub_interests, m_status, m_matching_count, m_deadline) VALUES(seq_member.nextval, 'hello', 1234, '강동원', '경기도','hello@naver.com', '남자','고수','전문적인 레슨이 가능합니다 ^^','https://pbs.twimg.com/profile_images/962934262369419266/nTpN_f_a.jpg','Programming','Java','true',NULL,NULL);

alter table member add m_matching varchar2(5 char) DEFAULT 'false' not null;