
-- 일련번호관리객체
create sequence seq_photo_p_idx;


--Photo table
create table photo
(
	 p_idx 				int							-- 일련번호
	,p_subject 			varchar2(200) not null		-- 제목
	,p_content 			clob 		  not null		-- 내용
	,p_filenavme 		varchar2(200) not null		-- 사진파일명
	,p_ip 				varchar2(200) not null		-- 아이피
	,p_regdate			varchar2(200) not null		-- 등록일자
	,p_lastmodifydate 	varchar2(200) not null		-- 최근수정일자
	,mem_idx			int					  		-- 회원번호
);

-- 기본키설정
alter table photo
	add constraint pk_photo_p_idx primary key(p_idx);

-- 외래키 설정
alter table photo
	add constraint fk_photo_mem_idx foreign key(mem_idx)
									references member(mem_idx); -- member에 있는 mem_idx를 참조한다.
	
	
select * from photo
